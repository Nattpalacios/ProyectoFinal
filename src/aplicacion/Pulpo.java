package aplicacion;

/**
 * Clase que contiene toda la informacion del invasor de tipo pulpo.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Pulpo extends Extraterrestre{
	
	/**
	 * Constructor de un pulpo
	 * @param i, primera posicion en x del pulpo en la matriz.
	 * @param j, primera posicion en y del pulpo en la matriz.
	 */
	public Pulpo(int i, int j) {
		super(i,j);
		vida = 1;
		score = 10;
	}
	
	/**
	 * Indica el identificador del pulpo en la matriz
	 * @return el identificador
	 */
	public char getIdentificador() {
		return 'p';
	}

	/**
	 * Hace que el invasor se mueva.
	 * @param app, clase principal de la aplicacion.
	 */
	@Override
	public void move(SPOOBceInvaders app) {
		if(velocidad - restante == 0) {
			if(vivo) {
				if(estado == 1) {
					estado = 2;
				}else {
					estado = 1;
				}
				if(direccion == 1) {
					y--;
					asignePosiciones(x, y);
				}else if(direccion == 0){
					y++;
					asignePosiciones(x, y);
				}else if(direccion == 2){
					if(x+3 < 30) {
						x++;
						asignePosiciones(x, y);
					}				
					
				}else {
					if(x-3 > 0) {
						x--;
						asignePosiciones(x, y);
					}	
				}
				if(app.movermeArriba(x,y)) {
					x-=3;
					asignePosiciones(x, y);
				}
				restante = 0;
			}
		}else {
			if(direccion == 2){
				if(x+3 < 30) {
					x++;
					asignePosiciones(x, y);
				}				
				
			}if(direccion == 3){
				if(x-3 > 0) {
					x--;
					asignePosiciones(x, y);
				}	
			}
			restante++;
		}	
	}

}
