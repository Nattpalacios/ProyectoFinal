package aplicacion;

import java.util.Random;

/**
 * Clase que contiene toda la informacion del invasor de tipo calamar.
 * @author (Palacios)
 * @version (9/12/2018)
 */
public class Calamar extends Extraterrestre{
	
	/**
	 * Constructor de un calamar
	 * @param i, primera posicion en x del calamar en la matriz.
	 * @param j, primera posicion en y del calamar en la matriz.
	 */
	public Calamar(int i, int j) {
		super(i, j);
		Random r = new Random();
		vida = r.nextInt(3);
		while(vida == 0) {
			vida = r.nextInt(3);
		}
		score = 50;
	}
	
	/**
	 * Indica el identificador del calamar en la matriz
	 * @return el identificador
	 */
	public char getIdentificador() {
		return 'c';
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
