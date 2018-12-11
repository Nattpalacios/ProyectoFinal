package aplicacion;

import java.awt.Color;
import java.util.*;

/**
 * Clase principal de aplicacion
 * @version (2/12/2018)
 * @author (Natalia Palacios)
 */

public class SPOOBceInvaders {
	
	private ArrayList<Barrera> escudos;
	private Platillo plat;
	private char mode;
	private int direccion;
	private int filas;
	private ArrayList<ArrayList<Extraterrestre>> extraterrestres;
	private ArrayList<Canon> canones;
	private char[][] tablero;
	private char[][] tableroVacio;
	
	/**
	 * Constructor de la clase
	 */
	public SPOOBceInvaders() {	
		direccion = 1;
		tablero = new char[30][84];
		tableroInicial();
	}

	/**
	 * Llena el tablero inicialmente de asteriscos
	 */
	private void tableroInicial() {
		tableroVacio =  new char[30][84];
		for(int i = 0; i<30; i++) {
			for(int j=0; j<84; j++) {
				tableroVacio[i][j] = '*';
			}
		}
	}

	/**
	 * Inicia el juego en modo Un Jugador con las caracteristicas indicadas.
	 * @param col, color del jugador.
	 * @param tablero, matriz con los caracteres de los elementos del tablero.
	 */
	public void iniciarJuego(Color col, ArrayList<ArrayList<Character>> tablero) {
		escudos = new ArrayList<Barrera>();
		mode = 'u';
		extraterrestres = new ArrayList<ArrayList<Extraterrestre>>();
		filas = tablero.get(0).size();
		canones = new ArrayList<Canon>();
		Canon c = new Canon(27,41);
		c.setColor(col);
		canones.add(c);
		limpiarTablero();
		crearElementos(tablero);
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		
	}
	
	/**
	 * Inicia el juego en modo Multijugador con las caracteristicas indicadas.
	 * @param modo, modo de la IA.
	 * @param col, color del jugador 1.
	 * @param col2, color del jugador 2.
	 * @param tablero, matriz con los caracteres de los elementos del tablero.
	 */
	public void iniciarJuego(char modo,Color col,Color col2,ArrayList<ArrayList<Character>> tablero) {
		escudos = new ArrayList<Barrera>();
		mode = modo;
		extraterrestres = new ArrayList<ArrayList<Extraterrestre>>();
		canones = new ArrayList<Canon>();
		//filas = tablero.get(0).size();
		Canon c = new Canon(27,55);
		c.setColor(col);
		Canon c2 = new Canon(27,26);
		c2.setColor(col2);
		canones.add(c);
		canones.add(c2);
		limpiarTablero();
		crearElementos(tablero);
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		
	}
	
	/**
	 * Pinta los invasores en la matriz
	 */
	private void actualiceInvasores() {
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				if(e.isVivo()) {
					char id = e.getIdentificador();
					int[][] pos = e.getPos();
					for(int k = 0; k < pos.length; k++) {
						tablero[pos[k][0]][pos[k][1]] = id;
					}
				}
			}
		}
	}
	
	/**
	 * Pinta las barreras en la matriz
	 */
	private void actualiceBarreras() {
		for(int i = 0; i < escudos.size(); i++) {
			char id = escudos.get(i).getIdentificador();
			ArrayList<Integer[]> pos = escudos.get(i).getPos();			
			for(int j = 0; j < pos.size(); j++) {
				tablero[pos.get(j)[0]][pos.get(j)[1]] = id;
			}
		}
	}
	
	/**
	 * Pinta los canones en la matriz
	 */
	private void actualiceCanones() {
		for(int i = 0; i < canones.size(); i++) {
			if(canones.get(i).isVivo()) {
				char id = canones.get(i).getIdentificador();
				int[][] pos = canones.get(i).getPos();
				for(int j = 0; j < pos.length; j++) {
					tablero[pos[j][0]][pos[j][1]] = id;
				}
			}
		}
	}
	
	/**
	 * Pinta las balas en la matriz
	 */
	private void actualiceBalas() {
		for(int i = 0; i < canones.size(); i++) {
			ArrayList<Bala> balas = canones.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					char id = balas.get(j).getIdentificador();
					int posx = balas.get(j).getPosX();
					int posy = balas.get(j).getPosY();
					tablero[posx][posy]	= id;
				}
				
			}
		}
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				if(e.isVivo()) {
					ArrayList<Bala> balas = e.getBalas();
					for(int k = 0; k < balas.size(); k++) {
						Bala b = balas.get(k);
						if(b.getScore() == 0) {
							char id = b.getIdentificador();
							int posx = b.getPosX();
							int posy =b.getPosY();
							tablero[posx][posy]	= id;
						}
					}						
				}
			}
		}
	}
	
	/**
	 * Llena el tablero del juego con lo que tenga el tablero inicial
	 */
	public void limpiarTablero() {
		for(int i = 0; i < 30; i++) {
			tablero[i] = Arrays.copyOfRange(tableroVacio[i], 0, 84);
		}
	}
	
	public void crearElementos(ArrayList<ArrayList<Character>> tablero) {
		int[] barre = posicionesBarreras(tablero.get(1).size());
		int cont = 0;
		plat = null;
		int[] inicial = {5,10,5,16,5,22,5,28,5,34,5,40,5,46,5,52,5,58,5,64,5,70};	
		int[] cangrejo = {8,10,8,16,8,22,8,28,8,34,8,40,8,46,8,52,8,58,8,64,8,70};
		int[] pulpo = {11,10,11,16,11,22,11,28,11,34,11,40,11,46,11,52,11,58,11,64,11,70};
		for(int i = 0; i < barre.length-1; i+=2) {
			if(tablero.get(1).get(cont) == 'r') {
				escudos.add(new Roja(barre[i],barre[i+1]));
			}else {
				escudos.add(new Verde(barre[i],barre[i+1]));
			}
			cont++;
		}
		for(int i = 0; i < filas; i++) {
			ArrayList<Extraterrestre> arreglo = new ArrayList<Extraterrestre>();
			for(int j = 0; j < 21; j+=2) {
				if(tablero.get(0).get(i) == 'c') {
					arreglo.add(new Calamar(inicial[j]+(3*i),inicial[j+1]));
				}else if(tablero.get(0).get(i) == 'k'){
					arreglo.add(new Cangrejo(inicial[j]+(3*i),inicial[j+1]));
				}else if(tablero.get(0).get(i) == 'p') {
					arreglo.add(new Pulpo(inicial[j]+(3*i),inicial[j+1]));
				}else {
					arreglo.add(new Platillo(inicial[j]+(3*i),inicial[j+1]));
				}				
			}
			extraterrestres.add(arreglo);
		}
	}
	
	/**
	 * Indica las posiciones donde se ubican las barreras, segun la cantidad.
	 * @param cantidad, cantidad de barreras.
	 * @return posiciones.
	 */
	private int[] posicionesBarreras(int cantidad) {
		if(cantidad == 1) {
			int[] barre = {21,39};
			return barre;
		}else if(cantidad == 2) {
			int[] barre = {21,23,21,54};
			return barre;
		}else if(cantidad == 3) {
			int[] barre = {21,16,21,39,21,62};
			return barre;
		}else if(cantidad == 4) {
			int[] barre = {21,7,21,28,21,49,21,70};
			return barre;
		}else if(cantidad == 5) {
			int[] barre = {21,9,21,24,21,39,21,54,21,69};
			return barre;
		}else if(cantidad == 6) {
			int[] barre = {21,7,21,20,21,33,21,46,21,59,21,72};
			return barre;
		}else if(cantidad == 7) {
			int[] barre = {21,4,21,16,21,28,21,40,21,52,21,64,21,76};
			return barre;
		}else {
			int[] barre = {21,0,21,10,21,21,21,32,21,43,21,54,21,65,21,75};
			return barre;
		}
	}
	
	/**
	 * Mueve el canon a la derecha
	 * @param jugador, indica cual jugador hizo el movimiento
	 */
	public void derecha(int jugador) {
		canones.get(jugador-1).derecha();
		limpiarTablero();
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		actualiceBalas();
	}
	
	/**
	 * Mueve el canon a la izquierda
	 * @param jugador, indica cual jugador hizo el movimiento
	 */
	public void izquierda(int jugador) {
		canones.get(jugador-1).izquierda();
		limpiarTablero();
		actualiceInvasores();
		actualiceBarreras();
		actualiceCanones();
		actualiceBalas();
	}

	/**
	 * Realiza un disparo
	 * @param jugador, indica cual jugador disparo
	 */
	public void dispare(int jugador) {
		int posX = canones.get(jugador-1).getPosX();
		int posY = canones.get(jugador-1).getPosY();
		canones.get(jugador-1).disparar(posX-1, posY+1);		
	}
	
	/**
	 * Actualiza la matriz
	 * @return el tablero
	 */
	public char[][] actualice() {
		for(int i = 0; i < filas;i++ ) {
			for(int j = 0; j < 11;j++ ) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				e.disparar(0, 0);
			}			
		}		
		for(int i = 0; i < canones.size(); i++) {
			ArrayList<Bala> balas = canones.get(i).getBalas();
			for(int j = 0; j < balas.size(); j++) {
				if(balas.get(j).getScore() == 0) {
					balas.get(j).move(this);
				}				
			}
		}
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < 11; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				ArrayList<Bala> balas = e.getBalas();
				for(int k = 0; k < balas.size(); k++) {
					if(balas.get(k).getScore() == 0) {
						balas.get(k).move(this);
					}				
				}
			}				
		}
		
		limpiarTablero();
		actualiceBarreras();
		moverExtraterrestres();
		actualiceInvasores();
		actualiceBalas();		
		actualiceCanones();
		//reviseFilas();
		return tablero;
	}

	/**
	 * Indica cuantos puntos se ganan al chocar una bala
	 * @param posX, posicion x del impacto
	 * @param posY, posicion y del impacto
	 * @param d, indica la direccion de la bala 
	 * @return puntaje
	 */
	public int impacto(int posX, int posY, char d) {
		int score = 0;
		int ext=-1;int bar=-1;int can=-1;
		for(int i = 0; i < filas && score == 0; i++) {
			for(int j = 0; j < 11 && score == 0; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				score = e.impacto(posX, posY,d);
				if(!e.isVivo()) {
					ext=i;
				}
			}
		}
		for(int i = 0; i < escudos.size() && score == 0; i++) {
			Barrera b = escudos.get(i);
			score = b.impacto(posX, posY,d);
			if(!b.isVivo()) {
				bar=i;
			}
			
		}
		for(int i = 0; i < canones.size() && score == 0; i++) {
			Canon c = canones.get(i);
			score = c.impacto(posX, posY,d);
			if(!c.isVivo()) {
				can=i;
			}
		}
		if(bar!=-1) {escudos.remove(bar);}
		
		return score;
	}

	/**
	 * Indica los tamanos de los elementos presentes en el juego.
	 * @return tamanos.
	 */
	public ArrayList<Integer> getTamanos() {
		ArrayList<Integer> tamanos = new ArrayList<Integer>();
		tamanos.add(canones.size());
		tamanos.add(escudos.size());
		tamanos.add(filas*11);
		return tamanos;
	}

	/**
	 * Indica las posiciones de un canon indicado.
	 * @param i, numero de canon.
	 * @return posiciones.
	 */
	public int[] getPosicionesCanon(int i) {
		int[] a = new int[2];
		a[1] = canones.get(i).getPosX();
		a[0] = canones.get(i).getPosY();
		return a;
	}

	/**
	 * Indica el color del canon.
	 * @param i, numero de canon.
	 * @return color.
	 */
	public Color getColorCanon(int i) {
		return canones.get(i).getColor();
	}

	/**
	 * Indica la cantidad de vida del canon.
	 * @param i, numero de canon.
	 * @return vidas.
	 */
	public int getVidaCanon(int i) {
		return canones.get(i).getVida();
	}

	/**
	 * Indica el puntaje actual de un canon.
	 * @param i, numero de canon.
	 * @return puntaje.
	 */
	public int getPuntajeCanon(int i) {
		return canones.get(i).getPuntaje();
	}
	
	/**
	 * Indica las posiciones de una barrera especifica.
	 * @param i, numero de barrera.
	 * @return posiciones de la barrera.
	 */
	public ArrayList<Integer[]> getPosicionesBarrera(int i) {
		return escudos.get(i).getPos();
	}

	/**
	 * Indica el identificador de una barrera.
	 * @param i, numero de barrera.
	 * @return identificador de la barrera.
	 */
	public char getIdBarrera(int i) {
		return escudos.get(i).getIdentificador();
	}

	/**
	 * Indica la posicion actual de un invasor.
	 * @param n, numero de invasor.
	 * @return posicion.
	 */
	public int[] getPosicionInvasor(int n) {
		int x = 0;
		int[] pos = new int[2];
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					pos=extraterrestres.get(i).get(j).getPosIni();
				}
				x++;
			}
		}
		return pos;
	}

	/**
	 * Indica el estado de un invasor.
	 * @param n, numero de invasor.
	 * @return estado.
	 */
	public int getEstadoInvasor(int n) {
		int x = 0;
		int est = -1;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					est=extraterrestres.get(i).get(j).getEstado();
				}
				x++;
			}
		}
		return est;
	}

	/**
	 * Indica el identificador de un invasor.
	 * @param n, numero de invasor.
	 * @return identificador.
	 */
	public char getIdInvasor(int n) {
		int x = 0;
		char id = ' ';
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					id=extraterrestres.get(i).get(j).getIdentificador();
				}
				x++;
			}
		}
		return id;
	}
	
	/**
	 * Retorna las balas de un canon.
	 * @param i, numero de canon.
	 * @return balas.
	 */
	public ArrayList<Character> getBalasCanon(int i) {
		return canones.get(i).getBal();
	}
	
	/**
	 * Retorna las posiciones de las balas de un canon.
	 * @param i, numero de canon.
	 * @return posiciones de las balas.
	 */
	public ArrayList<Integer[]> getBalasCanonPos(int i){
		return canones.get(i).getBalPos();
	}
	
	/**
	 * Retorna las balas de un invasor.
	 * @param n, numero de invasor.
	 * @return balas del invasor.
	 */
	public ArrayList<Character> getBalasInvasor(int n) {
		int x = 0;
		ArrayList<Character> bal = null;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					bal=extraterrestres.get(i).get(j).getBal();
				}
				x++;
			}
		}
		return bal;
	}
	
	/**
	 * Retorna las posiciones de las balas de un invasor
	 * @param n. numero de invasor
	 * @return bal.
	 */
	public ArrayList<Integer[]> getBalasInvasorPos(int n){
		int x = 0;
		ArrayList<Integer[]> bal = null;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					bal=extraterrestres.get(i).get(j).getBalPos();
				}
				x++;
			}
		}
		return bal;
	}
	
	/**
	 * indica si un invasor esta vivo
	 * @param n, numero de invasor
	 * @return viv.
	 */
	public boolean invasorIsVivo(int n) {
		int x = 0;
		boolean viv = false;
		for(int i = 0; i < filas && x <= n; i++) {
			for(int j = 0; j < 11 && x <= n; j++) {
				if(x == n) {
					viv=extraterrestres.get(i).get(j).isVivo();
				}
				x++;
			}
		}
		return viv;
	}
	
	/**
	 * Mueve los extraterrestres.
	 */
	private void moverExtraterrestres() {
		Extraterrestre lider = null;
		if(direccion == 1) {
			for(int i = 0; i < 11 && lider == null; i++) {
				for(int j = 0; j < filas && lider == null; j++) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					if(e.isVivo() && !e.puedeI()) {
						lider = e;
					}
				}
			}
		}else {
			for(int i = 10; i > -1 && lider == null; i--) {
				for(int j = 0; j < filas && lider == null; j++) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					if(e.isVivo() && !e.puedeD()) {
						lider = e;
					}
				}
			}
		}
		if(lider != null) {
			direccion = Math.abs(direccion - 1);
			for(int i = 10; i > -1; i--) {
				for(int j = 0; j < filas; j++) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					e.choque();
				}
			}
		}else {
			for(int i = 10; i > -1; i--) {
				for(int j = 0; j < filas; j++) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					e.noChoque(direccion);
				}
			}
		}
		if(direccion == 1) {
			for(int i = 0; i < 11; i++) {
				for(int j = filas - 1; j > -1; j--) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					e.move(this);
				}
			}
		}else {
			for(int i = 10; i > -1; i--) {
				for(int j = filas - 1; j > -1; j--) {
					Extraterrestre e = extraterrestres.get(j).get(i);
					e.move(this);
				}
			}
		}
	}

	/**
	 * le indica a un pulpo si se puede mover de forma especial
	 * @param x. posicion x del pulpo
	 * @param y. posicion y del pulpo
	 * @return. booleano con la aprobacion o no del movimiento
	 */
	public boolean movermeArriba(int x, int y) {
		boolean flag = false;
		int fil = 0;
		int col = 0;
		for(int i = 0; i < filas && !flag; i++) {
			for(int j = 0; j < 11 && !flag; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				int[] posicion = e.getPosIni();
				if(posicion[1] == x && posicion[0] == y) {
					fil = i;
					col = j;
					flag = true;
				}
			}
		}
		if(fil != 0) {
			Extraterrestre ex = extraterrestres.get(fil-1).get(col);
			if(!ex.isVivo()) {
				Extraterrestre e = extraterrestres.get(fil).get(col);
				extraterrestres.get(fil-1).set(col, e);
				extraterrestres.get(fil).set(col, ex);
				return true;
			}else {
				return false;
			}	
		}else {
			return false;
		}
			
	}
	
	/**
	 * le indica a un cangrejo si se puede mover de forma especial
	 * @param x. posicion x del pulpo
	 * @param y. posicion y del pulpo
	 * @return. booleano con la aprobacion o no del movimiento
	 */
	public boolean movermeAbajo(int x, int y) {
		boolean flag = false;
		int fil = 0;
		int col = 0;
		for(int i = 0; i < filas && !flag; i++) {
			for(int j = 0; j < 11 && !flag; j++) {
				Extraterrestre e = extraterrestres.get(i).get(j);
				int[] posicion = e.getPosIni();
				if(posicion[1] == x && posicion[0] == y) {
					fil = i;
					col = j;
					flag = true;
				}
			}
		}
		if(fil != filas-1) {
			Extraterrestre ex = extraterrestres.get(fil+1).get(col);
			if(!ex.isVivo()) {
				Extraterrestre e = extraterrestres.get(fil).get(col);
				extraterrestres.get(fil+1).set(col, e);
				extraterrestres.get(fil).set(col, ex);
				return true;
			}else {
				return false;
			}	
		}else {
			return false;
		}
			
	}
	
}
