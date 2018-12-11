package aplicacion;

import java.util.Random;

/**
 * Clase que contiene toda la informacion del invasor de tipo cangrejo.
 * @author (Palacios)
 * @version (9/12/2018)
 */

public class Cangrejo extends Extraterrestre{
	
	/**
	 * Constructor de un cangrejo
	 * @param i, primera posicion en x del cangrejo en la matriz.
	 * @param j, primera posicion en y del cangrejo en la matriz.
	 */
	public Cangrejo(int i, int j) {
		super(i, j);
		vida = 2;
		score = 30;
	}
	
	/**
	 * Indica el identificador del cangrejo en la matriz
	 * @return el identificador
	 */
	public char getIdentificador() {
		return 'k';
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
				if(app.movermeAbajo(x,y)) {
					x+=3;
					asignePosiciones(x, y);
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
	
	/**
	 * Crea la bala y da la orden del ataque.
	 */
	protected void dispare() {
		int posX = x+2; 
		int posY1 = y;
		int posY2 = y+3;
		Bala b1 = new Normal(posX, posY1, 'd');
		Bala b2 = new Normal(posX, posY2, 'd');
		municiones.add(b1);
		municiones.add(b2);
	}

}
