package aplicacion;

/**
 * Clase que contiene toda la informacion del canon.
 * Este canon no es controlado por el usuario.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class IA extends Canon{
	
	private int[][] posiciones;

	/**
	 * Constructor del canon.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public IA(int i, int j) {
		super(i,j);
	}

}
