package aplicacion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que contiene toda la informacion de las barreras
 * @author (Palacios)
 * @version (9/12/2018)
 */

public abstract class Barrera implements Impactable{
	
	protected ArrayList<Integer[]> posiciones;
	protected boolean vivo;
	protected int vida;
	protected int x;
	protected int y;
	
	/**
	 * Constructor de la barrera
	 * @param i, primera posicion en x de la barrera
	 * @param j, primera posicion en y de la barrera
	 */
	public Barrera(int i, int j) {
		vivo = true;
		x = i; y = j;
		posiciones = new ArrayList<Integer[]>();
		asignePosiciones(i, j);
	}
	
	/**
	 * Indica el identificador de una barrera
	 * @return el identificador de la barrera
	 */
	public abstract char getIdentificador();
	
	/**
	 * Indica las posiciones de la matriz que ocupa la barrera
	 * @return posiciones de la barrera
	 */
	public ArrayList<Integer[]> getPos() {
		return posiciones;
	}
	
	/**
	 * Asigna las posiciones que va a ocupar la barrera en la matriz
	 * @param i, primera posicion en x
	 * @param j, primera posicion en y
	 */
	public void asignePosiciones(int i, int j) {
		Integer[] pos = new Integer[2];
		pos[0] = i; pos[1] = j; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+2; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+3; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+4; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+5; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+6; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[0] = i+1; pos[1] = j-1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+2; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+3; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+4; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+5; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+6; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+7; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[0] = i+2; pos[1] = j-1;posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+2; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+4; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+5; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+6; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+7; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[0] = i+3; pos[1] = j-1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+1; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+5; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+6; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
		pos[1] = j+7; posiciones.add(Arrays.copyOfRange(pos, 0, 2));
	}
	
	/**
	 * Indica si la barrera esta en el lugar del impacto de la bala.
	 * @param i, posicion en x del impacto.
	 * @param j, posicion en y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	public abstract boolean estoy(int i, int j, char d);
	
	/**
	 * Indica si la barrera aun existe.
	 * @return si esta viva.
	 */
	public boolean isVivo() {
		return vivo;
	}
	
	

}
