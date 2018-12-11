package aplicacion;

import java.util.*;
import java.math.*;

/**
 * Clase que contiene toda la informacion del invasor.
 * @author (Palacios)
 * @version (9/12/2018)
 */
public abstract class Extraterrestre implements Impactable, Movible, Dispara{
	
	protected int[][] posiciones;
	protected int direccion;
	protected int rate;
	protected int x;
	protected int y;
	protected boolean vivo;
	protected int velocidad;
	protected int restante;
	protected int vida;
	protected int score;
	protected ArrayList<Bala> municiones;
	protected int estado;
	
	/**
	 * Constructor de un invasor.
	 * @param i, primera posicion en x del invasor en la matriz.
	 * @param j, primera posicion en y del invasor en la matriz.
	 */
	public Extraterrestre(int i, int j) {
		rate = 3;
		velocidad = 8;
		restante = 0;
		estado = 1;
		direccion = 1;// 1 -> izq | 0 -> der | 2 -> aba | 3 -> arr		
		municiones = new ArrayList<Bala>();
		vivo = true;
		x = i; y = j;
		posiciones = new int[8][2];
		asignePosiciones(i, j);
	}
	
	/**
	 * Asigna las posiciones al invasor en la matriz.
	 * @param i, posicion inicial en x del invasor.
	 * @param j, posicion inicial en y del invasor.
	 */
	public void asignePosiciones(int i, int j) {
		int[] pos = new int[2];
		pos[0] = i; pos[1] = j; posiciones[0] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[1] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[2] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[3] = Arrays.copyOfRange(pos, 0, 2);
		pos[0] = i+1; pos[1] = j; posiciones[4] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+1; posiciones[5] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+2; posiciones[6] = Arrays.copyOfRange(pos, 0, 2);
		pos[1] = j+3; posiciones[7] = Arrays.copyOfRange(pos, 0, 2);
	}
	
	/**
	 * Indica el identificador del invasor en la matriz
	 * @return el identificador
	 */
	public abstract char getIdentificador();
	
	/**
	 * Retorna las posiciones que esta ocupando el invasor en la matriz.
	 * @return posiciones del invasor.
	 */
	public int[][] getPos(){
		return posiciones;
	}
	
	/**
	 * Permite al invasor disparar.
	 * @param posX, posicion x del disparo.
	 * @param posY, posicion y del disparo.
	 */
	@Override
	public void disparar(int posX, int posY) {
		if(vivo) {
			Random r = new Random();
			boolean prob;
			int val = Math.abs(r.nextInt(1000));		
			if(val <= rate) {
				prob = true;
			}else {
				prob = false;
			}
			if(prob) {
				dispare();
			}
		}
	}	
	
	/**
	 * Crea la bala y da la orden del ataque.
	 */
	protected void dispare() {
		Random r = new Random();
		int suma = r.nextInt(4);
		int posX = x+2; 
		int posY = y + suma;
		Bala b = new Normal(posX, posY, 'd');
		municiones.add(b);
	}

	/**
	 * Indica si el invasor esta en la posicion del impacto.
	 * @param i, posicion x del disparo.
	 * @param j, posicion y del disparo.
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
	 * Indica si el invasor fue impactado por una bala.
	 * @param x, posicion x del impacto.
	 * @param y, posicion y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	@Override
	public int impacto(int x, int y, char d) {
		if(estoy(x,y,d) && d == 'u') {
			vida--;
			if(vida == 0) {
				vivo = false;
				return score;
			}else {
				return -1;
			}
		}else {
			return 0;
		}
	}
	
	/**
	 * Indica si el invasor aun existe.
	 * @return si esta vivo.
	 */
	public boolean isVivo() {
		return vivo;
	}
	
	/**
	 * Indica cuantas vidas tiene el invasor.
	 * @return la cantidad de vidas.
	 */
	public int getVida() {
		return vida;
	}
	
	/**
	 * Retorna el ultimo disparo del invasor.
	 * @return la ultima bala.
	 */
	public Bala getUltimoDisparo() {
		return municiones.get(municiones.size()-1);
	}

	/**
	 * Retorna todas las balas que han sido disparadas por el invasor.
	 * @return las balas del invasor.
	 */
	public ArrayList<Bala> getBalas() {
		return municiones;
	}

	/**
	 * Indica la posicion actual de invasor.
	 * @return posicion x & y.
	 */
	public int[] getPosIni() {
		int[] pos = new int[2];
		pos[1] = x;
		pos[0] = y;
		return pos;
	}

	/**
	 * Indica el estado del invasor.
	 * @return estado.
	 */
	public int getEstado() {
		return estado;
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
	 * Indica si los invasores pueden moverse a la izquierda.
	 * @return un booleano indicando si el extraterrestre se puede mover a la izquierda
	 */
	public boolean puedeI() {
		boolean flag = false;
		if(y - 1 >= 0) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * Indica si los invasores pueden moverse a la derecha.
	 * @return un booleano indicando si el extraterrestre se puede mover a la derecha
	 */
	public boolean puedeD() {
		boolean flag = false;
		if(y + 3 < 83) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Le indica al invasor que se encontro un muro.
	 */
	public void choque() {
		direccion = 2;		
	}

	/**
	 * Le indica al invasor que puede seguirse moviendo.
	 * @param direccion2, direccion en la que deberia moverse.
	 */
	public void noChoque(int direccion2) {
		direccion = direccion2;		
	}
}
