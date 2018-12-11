package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;

/**
 * Esta clase permite mostrar las opciones del menu multijugador.
 * @version (9/12/2018)
 * @author Palacios
 */

public class Multijugador extends JDialog{
	
	private Container contentPane;
	private Jugar juego;
	private Dimension pantalla;
	private JPanel botones;
	private JButton ia;
	private JButton jugador2;
	private JButton volver;
	private Color colorFuente = Color.BLACK;
	private Color colorBoton = new Color(232, 232, 232);
	private URL fondoo = this.getClass().getResource("MenuJugar.png");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private SPOOBceInvadersGUI principal;
	private Detalle detalle;
	
	/**
	 * Inicia la ventana del menu de multijugador.
	 * @param gui. Tablero de juego.
	 * @param jug. Menu de jugar.
	 */
	public Multijugador(Jugar jug, SPOOBceInvadersGUI gui) {
		principal = gui;
		juego = jug;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
		
	}

	/**
	 * Prepara los elementos necesarios para mostrar el menu.
	 */
	private void prepareElementos() {
		setTitle("Multijugador");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareElementosMenu();
	}
	
	
	/**
	 * Prepara y ajusta los botones a mostrar en el menu.
	 */
	private void prepareElementosMenu() {
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		botones.setLayout(null);
		ia = new JButton("Jugador vs Maquina");
		jugador2 = new JButton("Jugador vs Jugador");
		volver = new JButton("Regresar");
		tamanoMenu();
		tamanoBotones();
		centre();
		diseno();
		contentPane.add(botones);
		botones.add(ia);
		botones.add(jugador2);
		botones.add(volver);
	}
	
	/**
	 * Ubica la ventana en el centro de la pantalla.
	 */
	private void centre() {
		int esquinaX = (pantalla.width - getSize().width)/2;
		int esquinaY = (pantalla.height - getSize().height)/2;
		this.setLocation(esquinaX,esquinaY);
	}

	/**
	 * Ajusta el tamano y la ubicacion de los botones del menu.
	 */
	private void tamanoBotones() {
		int y = this.getHeight();
		int x = this.getWidth();
		int j = (y - (y/70)) / 3;
		int i = j + y/9 + y/17;
		int k = (y - (y/70)) / 17;
		jugador2.setSize(x / 3 + 200 , y / 11);
		ia.setSize(x / 3 + 200, y / 11);
		volver.setSize(x / 6 , y / 11);
		jugador2.setLocation((x - (x / 3 + 200))/2, j);
		ia.setLocation((x - (x / 3 + 200))/2,i);
		volver.setLocation((x - 1100)/2, k);
	}

	/**
	 * Ajusta el tamano de la ventana del menu.
	 */
	private void tamanoMenu() {
		int y = pantalla.height;
		int x = pantalla.width;
		setSize(x * 61/100, y * 41/50);
		
	}
	
	/**
	 * Arregla los botones del menu.
	 */
	private void diseno() {
		bordes();
		colorcitoBoton();
		fuente();
	}
	
	/**
	 * Ajusta la animaciones de los botones del menu.
	 */
	private void bordes() {
		ia.setBorder(null);
		jugador2.setBorder(null);
		volver.setBorder(null);
		ia.setFocusable(false);
		jugador2.setFocusable(false);
		volver.setFocusable(false);
	}
	
	/**
	 * Asigna el color a los botones del menu
	 */
	private void colorcitoBoton() {
		jugador2.setBackground(colorBoton);
		ia.setBackground(colorBoton);
		volver.setBackground(colorBoton);
	}
	
	/**
	 * Asigna el tipo de letra de los textos del menu.
	 */
	private void fuente() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 23);
		Font fuenteVolver = new Font("Gill Sans Ultra Bold",0,y / 35);
		jugador2.setForeground(colorFuente); 
		ia.setForeground(colorFuente);
		volver.setForeground(colorFuente);
		jugador2.setFont(fuente); 
		ia.setFont(fuente); 
		volver.setFont(fuenteVolver); 
	}
	
	/**
	 * Asigna las funcionalidades a los botones del menu.
	 */
	private void prepareAcciones() {
		WindowAdapter cerrarVentana = new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				salir();
			}
		};
		
		ActionListener botonJugador2 = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				jugador();
			}
		};
		
		ActionListener botonMaquina = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				maquina();
			}
		};
		
		ActionListener botonVolver = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				volver();
			}
		};
		
		addWindowListener(cerrarVentana);
		jugador2.addActionListener(botonJugador2);
		ia.addActionListener(botonMaquina);
		volver.addActionListener(botonVolver);
	}
	
	/**
	 * Abre una ventana con otras opciones.
	 */
	private void jugador() {
		detalle = new Detalle(juego,'m',principal);
		this.setVisible(false);
	}
	
	/**
	 * Abre una ventana con otras opciones.
	 */
	private void maquina() {
		detalle = new Detalle(juego,'m',principal);
		this.setVisible(false);
	}
	
	/**
	 * Permite volver al menu de juego.
	 */
	private void volver() {
		juego.setVisible(true);
		this.setVisible(false);
	}
	
	/**
	 * Cierra la ventana en caso de que el usuario lo indique.
	 */
	private void salir() {
		juego.setVisible(true);
		this.setVisible(false);
	}

}
