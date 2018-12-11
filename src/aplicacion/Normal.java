package aplicacion;

/**
 * Esta clase contiene toda la informacion necesaria de una bala.
 * Esta bala solo impacta a un invasor a la vez.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Normal extends Bala{

	/**
	 * Constructor de la bala
	 * @param i, posicion en x de la bala
	 * @param j, posicion en y de la bala
	 * @param direccion, indica si la bala va hacia arriba 'u' o hacia abajo 'd'
	 */
	public Normal(int i, int j, char direccion) {
		super(i, j, direccion);
	}
	
	/**
	 * Indica el identificador de la bala en la matriz
	 * @return el identificador de la bala en la matriz
	 */
	public char getIdentificador() {
		return '|';
	}

	/**
	 * Permite el movimiento de la bala.
	 * @param app, clase principal de la aplicacion.
	 */
	@Override
	public void move(SPOOBceInvaders app) {
		if(dir == 'u') {
			int sc = app.impacto(posX-1,posY,dir);
			if(sc == 0) {
				if(posX > 0) {
					posX--;
				}else {
					score = -1;
				}				
			}else {
				score = sc;	
			}			
		}else {
			int p = app.impacto(posX+1, posY, dir);
			if(p == 0) {
				if(posX < 29) {
					posX++;
				}else {
					score = -1;
				}
			}else {
				score = p;
			}
		}
		
	}
	
}
