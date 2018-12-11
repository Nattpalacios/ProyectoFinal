package aplicacion;

/**
 * Clase que contiene toda la informacion del canon cuidadoso.
 * Este tipo de canon evita destruir las barreras.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Cuidadoso extends IA{

	/**
	 * Constructor de un canon cuidadoso.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public Cuidadoso(int i, int j) {
		super(i, j);
	}

}
