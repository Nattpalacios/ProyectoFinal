package presentacion;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Esta clase permite dibujar las barreras.
 * @author Palacios
 * @version (9/12/2018)
 */

public class BarreraGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private ArrayList<Integer[]> posiciones;
	private String image;
	
	/**
	 * Constructor de la barrera.
	 * @param pos, posiciones en donde hay que dibujar la barrera.
	 * @param id, identificador de la barrera, para saber cual barrera dibujar.
	 */
	public BarreraGUI(ArrayList<Integer[]> pos, char id) {
		posiciones = new ArrayList<Integer[]>();
		if(id == 'r') {
			image = "ImagenesBarrera/Roja.png";
		}else {
			image = "ImagenesBarrera/Verde.png";
		}
		for(int i = 0; i < pos.size(); i++) {
			Integer[] posi = new Integer[2];
			posi[0] = pos.get(i)[1] * cuadroX;
			posi[1] = pos.get(i)[0] * cuadroY;
			posiciones.add(posi);
		}
	}

	/**
	 * Indica las posiciones de la barrera.
	 * @return posiciones de la barrera.
	 */
	public ArrayList<Integer[]> getPosiciones() {
		return posiciones;
	}

	/**
	 * Cambia la posicion de la barrera.
	 * @param posiciones, posiciones nuevas.
	 */
	public void setPosiciones(ArrayList<Integer[]> posiciones) {
		this.posiciones = posiciones;
	}

	/**
	 * Indica la ruta donde se encuentra la imagen de la barrera.
	 * @return la ruta.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Cambia la ruta de la imagen de la barrera.
	 * @param image, nueva ruta.
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Indica el ancho del canvas dimensionado segun la matriz.
	 * @return ancho.
	 */
	public static int getCuadrox() {
		return cuadroX;
	}

	/**
	 * Indica el alto del canvas dimensionado segun la matriz.
	 * @return alto.
	 */
	public static int getCuadroy() {
		return cuadroY;
	}

}
