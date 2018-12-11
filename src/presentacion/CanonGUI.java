package presentacion;

import java.awt.Color;
import java.awt.Component;

/**
 * Esta clase permite dibujar los canones.
 * @author Palacios
 * @version (9/12/2018)
 */

public class CanonGUI extends Component{
	
	private int posXCanon;
	private int posYCanon;
	private int posXBase;
	private int posYBase;
	private int wBase;
	private int hBase;
	private int wCanon;
	private int hCanon;
	private int vida;
	private int puntaje;
	private Color color;
	private String tipoBala;
	public static final int cuadroX = 1175/84;
	public static final int cuadroY = 838/30;
	
	/**
	 * Constructor del canon.
	 * @param pos, posicion en donde hay que dibujar el canon.
	 * @param col, color del canon.
	 * @param vid, cantidad de vidas del canon.
	 * @param pun, puntaje del canon.
	 */
	public CanonGUI(int[] pos,Color col,int vid,int pun) {
		posXCanon = cuadroX * pos[0];
		posXBase= cuadroX * pos[0] - 2*cuadroX;
		posYCanon = cuadroY * pos[1];
		posYBase= cuadroY * pos[1] + cuadroY;
		wBase = cuadroX * 7;
		wCanon = cuadroX * 3;
		hBase = cuadroY;
		hCanon = cuadroY;
		color = col;
		vida = vid;
		puntaje = pun;
	}

	/**
	 * Indica la posicion x del canon.
	 * @return posicion en x.
	 */
	public int getPosXCanon() {
		return posXCanon;
	}

	/**
	 * Cambia la posicion x del canon.
	 * @param posXCanon, nueva posicion.
	 */
	public void setPosXCanon(int posXCanon) {
		this.posXCanon = posXCanon;
	}

	/**
	 * Indica la posicion y del canon.
	 * @return posicion en y.
	 */
	public int getPosYCanon() {
		return posYCanon;
	}

	/**
	 * Cambia la posicion y del canon.
	 * @param posYCanon, nueva posicion.
	 */
	public void setPosYCanon(int posYCanon) {
		this.posYCanon = posYCanon;
	}

	/**
	 * Indica la posicion x de la base del canon.
	 * @return posicion en x.
	 */
	public int getPosXBase() {
		return posXBase;
	}

	/**
	 * Cambia la posicion x de la base del canon.
	 * @param posXCanon, nueva posicion.
	 */
	public void setPosXBase(int posXBase) {
		this.posXBase = posXBase;
	}

	/**
	 * Indica la posicion y de la base del canon.
	 * @return posicion en y.
	 */
	public int getPosYBase() {
		return posYBase;
	}

	/**
	 * Cambia la posicion y de la base del canon.
	 * @param posYCanon, nueva posicion.
	 */
	public void setPosYBase(int posYBase) {
		this.posYBase = posYBase;
	}

	/**
	 * Indica el ancho de la base del canon.
	 * @return ancho.
	 */
	public int getwBase() {
		return wBase;
	}

	/**
	 * Cambia el ancho de la base del canon.
	 * @param wBase, nuevo ancho.
	 */
	public void setwBase(int wBase) {
		this.wBase = wBase;
	}

	/**
	 * Indica el alto de la base del canon.
	 * @return alto.
	 */
	public int gethBase() {
		return hBase;
	}

	/**
	 * Cambia el alto de la base del canon.
	 * @param hBase, nuevo alto.
	 */
	public void sethBase(int hBase) {
		this.hBase = hBase;
	}

	/**
	 * Indica el ancho del canon.
	 * @return ancho del canon.
	 */
	public int getwCanon() {
		return wCanon;
	}

	/**
	 * Cambiar el ancho del canon.
	 * @param wCanon, nuevo ancho.
	 */
	public void setwCanon(int wCanon) {
		this.wCanon = wCanon;
	}

	/**
	 * Indica el alto del canon.
	 * @return el alto.
	 */
	public int gethCanon() {
		return hCanon;
	}

	/**
	 * Cambia al alto del canon.
	 * @param hCanon, nuevo alto.
	 */
	public void sethCanon(int hCanon) {
		this.hCanon = hCanon;
	}

	/**
	 * Indica las vidas del canon.
	 * @return vidas del canon.
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Cambia la cantidad de vidas del canon.
	 * @param vida, nueva cantidad de vidas.
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Indica el puntaje obtenido por el jugador.
	 * @return puntaje.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Cambia el puntaje del jugador.
	 * @param puntaje, nuevo puntaje.
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * Indica el color del canon.
	 * @return color.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Cambia el color del canon.
	 * @param color, nuevo color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Indica el tipo de bala.
	 * @return tipo de bala.
	 */
	public String getTipoBala() {
		return tipoBala;
	}

	/**
	 * Cambia el tipo de bala.
	 * @param tipoBala, nuevo tipo de bala.
	 */
	public void setTipoBala(String tipoBala) {
		this.tipoBala = tipoBala;
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
