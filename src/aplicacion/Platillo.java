package aplicacion;

/**
 * Clase que contiene toda la informacion del invasor de tipo platillo.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Platillo extends Extraterrestre{
	
	/**
	 * Constructor de un platillo
	 * @param i, primera posicion en x del platillo en la matriz.
	 * @param j, primera posicion en y del platillo en la matriz.
	 */
	public Platillo(int i, int j) {
		super(i, j);
		vida = 1;
		score = 200;
	}
	
	/**
	 * Indica el identificador del platillo en la matriz.
	 * @return el identificador.
	 */
	public char getIdentificador() {
		return 't';
	}

	/**
	 * Permite al platillo disparar.
	 * @param posX, posicion x del disparo.
	 * @param posY, posicion y del disparo.
	 */
	@Override
	public void disparar(int posX, int posY) {
		
	}

	/**
	 * Hace que el invasor se mueva.
	 * @param app, clase principal de la aplicacion.
	 */
	@Override
	public void move(SPOOBceInvaders app) {
		// TODO Auto-generated method stub
		
	}

}
