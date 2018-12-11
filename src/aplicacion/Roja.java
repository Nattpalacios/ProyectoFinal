package aplicacion;

/**
 * Clase que contiene toda la informacion de las barreras rojas.
 * Esta barrera puede ser destruida por los canones.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Roja extends Barrera{
	
	/**
	 * Constructor de la barrera
	 * @param i, primera posicion en x de la barrera
	 * @param j, primera posicion en y de la barrera
	 */
	public Roja(int i, int j) {
		super(i, j);
		vida = 1;
	}

	/**
	 * Indica si las balas impactaron a la barrera.
	 * @param x, posicion x del impacto.
	 * @param y, posicion y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	@Override
	public int impacto(int x, int y, char d) {
		int impacto = 0;
		if(estoy(x,y,d)) {
			if(d == 'u') {
				vida--;
				if(vida == 0) {
					vivo = false;	
				}
			}				
			impacto = -1;
		}else {
			impacto = 0;
		}
		return impacto;
	}

	/**
	 * Indica si la barrera esta en el lugar del impacto.
	 * @param i, posicion x del impacto.
	 * @param j, posicion y del impacto.
	 * @param d, direccion en que va la bala.
	 */
	@Override
	public boolean estoy(int i, int j, char d) {
		boolean flag = false;
		for(int k = 0; k < posiciones.size() && !flag; k++) {
			if(posiciones.get(k)[0] == i && posiciones.get(k)[1] == j) {
				flag = true;
				if(d =='u') {
					posiciones.clear();
				}
			}
		}
		return flag;
	}

	/**
	 * Retorna el identificador de la barrera en la matriz.
	 * @return el identificador.
	 */
	@Override
	public char getIdentificador() {
		return 'r';
	}

}
