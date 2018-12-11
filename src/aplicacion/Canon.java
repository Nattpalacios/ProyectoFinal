package aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que contiene toda la informacion del canon.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Canon implements Impactable, Movible, Dispara{
	
	private int[][] posiciones;
	private int x;
	private int y;
	private ArrayList<Bala> municiones;
	private int vida;
	private boolean vivo;
	private Color color;
	
	/**
	 * Constructor de un canon.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public Canon(int i, int j) {
		vivo = true;
		vida = 3;
		x = i; y = j;
		posiciones = new int[10][2];
		municiones = new ArrayList<Bala>();
		asignePosiciones(x, y);
	}
	
	/**
	 * Asigna las posiciones que va a ocupar el canon en la matriz
	 * @param i, primera posicion en x
	 * @param j, primera posicion en y
	 */
	protected void asignePosiciones(int i, int j) {
		int[] pos = new int[2];
		pos[0] = i; pos[1] = j; posiciones[0] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[1] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[2] = Arrays.copyOfRange(pos, 0, 2);
		pos[0] = i+1; pos[1] = j-2; posiciones[3] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j-1; posiciones[4] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j; posiciones[5] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[6] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[7] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[8] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+4; posiciones[9] = Arrays.copyOfRange(pos, 0, 2);
		
	}

	/**
	 * Indica el identificador del canon en la matriz.
	 * @return el identificador.
	 */
	public char getIdentificador() {
		return 'j';
	}
	
	/**
	 * Indica las posiciones que ocupa el canon en la matriz.
	 * @return la matriz con las posiciones.
	 */
	public int[][] getPos(){
		return posiciones;
	}
	
	/**
	 * Permite que el canon se mueva hacia la izquierda.
	 */
	public void izquierda() {
		if(vivo) {
			if(y-3 >= 0) {
				y--;
				asignePosiciones(x, y);
			}
		}
	}

	/**
	 * Permite que el canon se mueva hacia la derecha.
	 */
	public void derecha() {
		if(vivo) {
			if(y+5 <= 83) {
				y++;
				asignePosiciones(x, y);
			}
		}
	}

	/**
	 * Permite que el canon dispare en una posicion especifica.
	 * @param posX, posicion en x del disparo.
	 * @param posY, posicion en y del disparo.
	 */
	@Override
	public void disparar(int posX, int posY) {
		if(vivo) {
			Bala balita = new Normal(posX,posY, 'u');
			municiones.add(balita);
		}
	}
	
	/**
	 * Indica la posicion x del canon en la matriz.
	 * @return posicion x.
	 */
	public int getPosX() {
		return x;
	}
	
	/**
	 * Indica la posicion y del canon en la matriz.
	 * @return posicion y.
	 */
	public int getPosY() {
		return y;
	}

	/**
	 * Retorna la ultima bala que fue disparada, con toda su informacion.
	 * @return el ultimo disparo.
	 */
	public Bala getUltimoDisparo() {
		return municiones.get(municiones.size()-1);
	}
	
	/**
	 * Retorna todos los disparos que se han hecho.
	 * @return todos los disparos.
	 */
	public ArrayList<Bala> getBalas(){
		return municiones;
	}
	
	/**
	 * Indica si el canon aun esta vivo.
	 * @return si esta vivo.
	 */
	public boolean isVivo() {
		return vivo;
	}

	/**
	 * Hace que el canon se mueva.
	 * @param app, clase principal de la aplicacion.
	 */
	@Override
	public void move(SPOOBceInvaders app) {		
	}

	/**
	 * Indica si el canon esta en el lugar del impacto de la bala.
	 * @param i, posicion en x del impacto.
	 * @param j, posicion en y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	public boolean estoy(int i, int j, char d) {
		boolean flag = false;
		if(vivo) {
			for(int k = 0; k < posiciones.length && !flag; k++) {
				if(posiciones[k][0] == i && posiciones[k][1] == j) {
					flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * Indica si la bala impacto al canon.
	 * @param x, posicion en x del impacto.
	 * @param y, posicion en y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	@Override
	public int impacto(int x, int y, char d) {
		if(estoy(x,y,d) && d == 'd') {
			vida--;
			if(vida == 0) {
				vivo = false;
				return -1;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}

	/**
	 * Indica la cantidad de vidas que tienen el canon.
	 * @return cantidad de vidas.
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Indica el puntaje que lleva el jugador.
	 * @return puntaje del jugador.
	 */
	public int getPuntaje() {
		int pun = 0;
		for(int i = 0; i < municiones.size(); i++) {
			Bala b = municiones.get(i);
			if(b.getScore() != -1) {
				pun += b.getScore();
			}
		}
		return pun;
	}

	/**
	 * Retorna una lista con los tipos de balas que se han disparado.
	 * @return los tipos de balas.
	 */
	public ArrayList<Character> getBal() {
		ArrayList<Character> bal = new ArrayList<Character>();
		for(int i = 0; i < municiones.size(); i++) {
			if(municiones.get(i).getScore() == 0) {
				bal.add(municiones.get(i).getIdentificador());
			}
		}
		return bal;
	}
	
	/**
	 * Retorna las posiciones de las balas que se han disparado.
	 * @return posiciones de las balas.
	 */
	public ArrayList<Integer[]> getBalPos() {
		ArrayList<Integer[]> bal = new ArrayList<Integer[]>();
		for(int i = 0; i < municiones.size(); i++) {
			if(municiones.get(i).getScore() == 0) {
				Integer[] pos = new Integer[2];
				pos[1] = municiones.get(i).getPosX();
				pos[0] = municiones.get(i).getPosY();
				bal.add(pos);
			}
		}
		return bal;
	}

	/**
	 * Cambia el color del canon.
	 * @param col, nuevo color.
	 */
	public void setColor(Color col) {
		this.color = col;
		
	}

	/**
	 * Obtiene el color del canon.
	 * @return color del canon.
	 */
	public Color getColor() {
		return color;
	}

}
