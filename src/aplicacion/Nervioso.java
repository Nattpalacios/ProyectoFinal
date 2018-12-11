package aplicacion;

/**
 * Clase que contiene toda la informacion del canon nervioso.
 * Este tipo de canon realiza cualquier movimiento sin estrategia.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Nervioso extends IA{

	/**
	 * Constructor de un canon nervioso.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public Nervioso(int i, int j) {
		super(i, j);
	}

}
