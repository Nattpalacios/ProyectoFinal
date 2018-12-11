package presentacion;

import java.awt.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

/**
 * Esta clase permite dibujar en el tablero de juego.
 * @version (9/12/2018)
 * @author Palacios
 */

public class Printer extends Component{
	
	private ArrayList<BarreraGUI> barreras;
	private ArrayList<ExtraterrestreGUI> invasores;
	private ArrayList<CanonGUI> canones;
	private ArrayList<BalaGUI> balas;
	private URL fondoo = this.getClass().getResource("Tablero.jpg");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private JPanel tablero;
	
	/**
	 * Constructor de la clase.
	 * @param tablero, tablero del juego.
	 */
	public Printer(JPanel tablero) {
		this.tablero = tablero;
		barreras = new ArrayList<BarreraGUI>();
		invasores = new ArrayList<ExtraterrestreGUI>();
		canones = new ArrayList<CanonGUI>();
		balas = new ArrayList<BalaGUI>();
	}
	
	/**
	 * Hace visibles los elementos en el tablero
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(),tablero);
		for(int i = 0; i < canones.size();i++) {
			CanonGUI c = canones.get(i);
			g.setColor(c.getColor());
			if(canones.get(i).getVida() > 0) {
				g.fillRect(c.getPosXBase(), c.getPosYBase(), c.getwBase(), c.gethBase());
				g.fillRect(c.getPosXCanon(), c.getPosYCanon(), c.getwCanon(), c.gethCanon());
			}
			g.setFont(new Font("Gill Sans Ultra Bold",0, 30));
			g.drawString("Score",30,30*(1+i));
			g.drawString(Integer.toString(c.getPuntaje()), 150, 30*(1+i));
			g.drawString("Lives", 500, 30*(1+i));
			for(int j = 0; j < c.getVida(); j++) {
				g.fillRect(650 + (50*j), 25+(25*i), 35, 10);
				g.fillRect(660 + (50*j), 17+(25*i) , 15, 8);
			}
		}
		for(int i = 0; i < barreras.size(); i ++) {
			BarreraGUI b = barreras.get(i);
			String barrera = b.getImage();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(barrera)).getImage());
			ArrayList<Integer[]> pos = b.getPosiciones();
			int tamX = b.getCuadrox();
			int tamY = b.getCuadroy();
			for(int j = 0; j < pos.size(); j++) {
				
				g.drawImage(image.getImage(), pos.get(j)[0], pos.get(j)[1], tamX, tamY, null);
			}
		}
		for(int i = 0; i < invasores.size(); i++) {
			ExtraterrestreGUI e = invasores.get(i);
			String invasor = e.getImage();
			int[] pos = e.getPosiciones();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(invasor)).getImage());
			int tamX = e.getTamX();
			int tamY = e.getTamY();
			if(invasores.get(i).isVivo()) {
				g.drawImage(image.getImage(), pos[0], pos[1], tamX, tamY, null);
			}
		}
		for(int i = 0; i < balas.size(); i++) {
			BalaGUI  b = balas.get(i);
			String bala = b.getImage();
			int[] pos = b.getPosi();
			ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource(bala)).getImage());
			int tamX = b.getCuadrox();
			int tamY = b.getCuadroy();
			g.drawImage(image.getImage(), pos[0], pos[1], tamX, tamY, null);
		}
	}

	/**
	 * Agrega los canones creados en aplicacion, para dibujarlos.
	 * @param canones, canones de la aplicacion.
	 */
	public void agregarCanones(ArrayList<CanonGUI> canones) {
		this.canones = canones;
	}

	/**
	 * Agrega las barreras creadas en aplicacion, para dibujarlas.
	 * @param barreras, barreras de la aplicacion.
	 */
	public void agregarBarreras(ArrayList<BarreraGUI> barreras) {
		this.barreras = barreras;
	}

	/**
	 * Agrega los invasores creados en aplicacion, para dibujarlos.
	 * @param invasores, invasores de la aplicacion.
	 */
	public void agregarInvasores(ArrayList<ExtraterrestreGUI> invasores) {
		this.invasores = invasores;
	}

	/**
	 * Agrega las balas creadas en aplicacion, para dibujarlas.
	 * @param balas, balas de la aplicacion.
	 */
	public void agregarBalas(ArrayList<BalaGUI> balas) {
		this.balas = balas;
	}
	
}
