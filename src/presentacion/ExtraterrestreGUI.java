package presentacion;

/**
 * Esta clase permite dibujar los invasores.
 * @author Palacios
 * @version (9/12/2018)
 */

public class ExtraterrestreGUI {
	
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	private int tamX;
	private int tamY;
	private int[] posiciones;
	private String image;
	private boolean vivo;

	/**
	 * Constructor del invasor.
	 * @param pos, posicion en donde hay que dibujar el invasor.
	 * @param estado, estado del invasor.
	 * @param id, indica que tipo de invasor es para dibujarlo.
	 * @param vivo, indica si el invasor esta vivo.
	 */
	public ExtraterrestreGUI(int[] pos, int estado, char id, boolean vivo) {
		this.vivo = vivo;
		posiciones = new int[2];
		posiciones[0] = pos[0] * cuadroX;
		posiciones[1] = pos[1] * cuadroY;
		tamX = cuadroX * 4;
		tamY = cuadroY * 2;
		String est = Integer.toString(estado);
		if(id == 'p') {
			image = "ImagenesPulpo/Pulpo" + est +".png";
		}else if(id == 'k') {
			image = "ImagenesCangrejo/Cangrejo" + est +".png";
		}else if(id == 'c') {
			image = "ImagenesCalamar/Calamar" + est +".png";
		}
	}

	/**
	 * Indica el ancho del invasor.
	 * @return ancho.
	 */
	public int getTamX() {
		return tamX;
	}

	/**
	 * Cambia el ancho del invasor.
	 * @param tamX, nuevo ancho.
	 */
	public void setTamX(int tamX) {
		this.tamX = tamX;
	}

	/**
	 * Indica el alto del invasor.
	 * @return alto.
	 */
	public int getTamY() {
		return tamY;
	}

	/**
	 * Cambia el alto del invasor.
	 * @param tamY, nuevo alto.
	 */
	public void setTamY(int tamY) {
		this.tamY = tamY;
	}

	/**
	 * Indica la posicion donde se encuentra el extraterrestre.
	 * @return posicion del extraterrestre.
	 */
	public int[] getPosiciones() {
		return posiciones;
	}

	/**
	 * Cambia la posicion del invasor.
	 * @param posiciones, nueva posicion
	 */
	public void setPosiciones(int[] posiciones) {
		this.posiciones = posiciones;
	}

	/**
	 * Indica la ruta de la imagen del invasor.
	 * @return la ruta.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Cambia la ruta de la imagen del invasor.
	 * @param image, nueva ruta.
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Indica si el invasor esta vivo.
	 * @return si esta vivo.
	 */
	public boolean isVivo() {
		return vivo;
	}
	
}
