package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;

/**
 * Esta clase permite mostrar las opciones del menu principal.
 * @author Palacios
 * @version (9/12/2018)
 */

public class MenuPrincipal extends JDialog{
	
	private Container contentPane;
	private SPOOBceInvadersGUI juego;
	private Dimension pantalla;
	private JPanel botones;
	private JButton jugar;
	private JButton instrucciones;
	private Jugar opcionJugar;
	private Instrucciones opcionInstrucciones;
	private Color colorFuente = Color.BLACK;
	private Color colorBoton = new Color(232, 232, 232);
	private URL fondoo = this.getClass().getResource("MenuInicialFondo.png");
	private Image fondo = new ImageIcon(fondoo).getImage();
	
	/**
	 * Inicia la ventana del menu inicial.
	 * @param gui. Tablero de juego.
	 */
	public MenuPrincipal(SPOOBceInvadersGUI gui) {
		juego = gui;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
		
	}

	/**
	 * Prepara los elementos necesarios para mostrar el menu.
	 */
	private void prepareElementos() {
		setTitle("Menu Principal");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareElementosMenu();
	}
	
	
	/**
	 * Prepara y ajusta los botones a mostrar en el menu principal.
	 */
	private void prepareElementosMenu() {
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		botones.setLayout(null);
		jugar = new JButton("Jugar");
		instrucciones = new JButton("Instrucciones");
		tamanoMenu();
		tamanoBotones();
		centre();
		diseno();
		contentPane.add(botones);
		botones.add(jugar);
		botones.add(instrucciones);
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
		int j = (y - (y/70)) / 2;
		int i = j + y/9 + y/17;
		jugar.setSize(x / 5 , y / 11);
		instrucciones.setSize(x / 3 + 120, y / 11);
		jugar.setLocation((x - (x / 5 + 5))/2, j);
		instrucciones.setLocation((x - (x / 3 + 120))/2,i);
	}

	/**
	 * Ajusta el tamano de la ventana del menu principal.
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
		jugar.setBorder(null);
		instrucciones.setBorder(null);
		jugar.setFocusable(false);
		instrucciones.setFocusable(false);
	}
	
	/**
	 * Asigna el color a los botones del menu
	 */
	private void colorcitoBoton() {
		jugar.setBackground(colorBoton);
		instrucciones.setBackground(colorBoton);
	}
	
	/**
	 * Asigna el tipo de letra de los textos del menu.
	 */
	private void fuente() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 20);
		jugar.setForeground(colorFuente); 
		instrucciones.setForeground(colorFuente);		
		jugar.setFont(fuente); 
		instrucciones.setFont(fuente); 
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
		
		ActionListener botonJugar = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				jugar();
			}
		};
		
		ActionListener botonInstrucciones = new ActionListener() {
			public void actionPerformed(ActionEvent we) {
				instrucciones();
			}
		};
		
		addWindowListener(cerrarVentana);
		jugar.addActionListener(botonJugar);
		instrucciones.addActionListener(botonInstrucciones);
	}
	
	/**
	 * Abre una ventana con las instrucciones
	 */
	private void jugar() {
		opcionJugar = new Jugar(this,juego);
		this.setVisible(false);
	}
	
	/**
	 * Abre una ventanas con otras opciones.
	 */
	private void instrucciones() {
		opcionInstrucciones = new Instrucciones(this);
		this.setVisible(false);
	}
	
	/**
	 * Cierra el juego en caso de que el usuario lo indique.
	 */
	private void salir() {
		int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}else {
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}

}
