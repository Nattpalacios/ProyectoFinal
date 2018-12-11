package presentacion;

import java.util.*;

/**
 * Esta clase permite dibujar las balas.
 * @author Palacios
 * @version (9/12/2018)
 */

public class BalaGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private int[] posi;
	private String image;

	/**
	 * Constructor de la clase.
	 * @param id, identificador de la bala, para saber cual bala dibujar.
	 * @param pos, posiciones en donde hay que dibujar la bala.
	 */
	public BalaGUI(Character id, Integer[] pos) {
		posi = new int[2];
		posi[0] = pos[0] * cuadroX;
		posi[1] = pos[1] * cuadroY;	
		if(id == '|') {
			image = "ImagenesBalas/Normal.png";
		}else if(id == ':'){
			image = "ImagenesBalas/Especial.png";
		}
	}

	/**
	 * Indica las posiciones de la bala.
	 * @return posiciones de la bala.
	 */
	public int[] getPosi() {
		return posi;
	}

	/**
	 * Cambia la posicion de la bala.
	 * @param posi, posicion nueva.
	 */
	public void setPosi(int[] posi) {
		this.posi = posi;
	}

	/**
	 * Indica la ruta donde se encuentra la imagen de la bala.
	 * @return la ruta.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Cambia la ruta de la imagen de la bala.
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
