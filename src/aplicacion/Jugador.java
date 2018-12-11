package aplicacion;

/**
 * Clase que contiene toda la informacion del canon.
 * Este canon es controlado por el usuario.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Jugador extends Canon{
	
	private int[][] posiciones;

	/**
	 * Constructor de un canon.
	 * @param i, primera posicion en x del canon en la matriz.
	 * @param j, primera posicion en y del canon en la matriz.
	 */
	public Jugador(int i, int j) {
		super(i,j);
	}
	
	
	
}
