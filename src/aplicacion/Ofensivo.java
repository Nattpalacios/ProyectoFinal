package aplicacion;

/**
 * Clase que contiene toda la informacion del canon ofensivo.
 * Este tipo de canon busca eliminar los invasores lo antes posible.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Ofensivo extends IA{

	/**
	 * Constructor de un canon ofensivo.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public Ofensivo(int i, int j) {
		super(i, j);
	}

}
