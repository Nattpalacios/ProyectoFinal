package presentacion;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

/**
 * Detalles del tablero de juego.
 * @version (9/12/2018)
 * @author Palacios
 */

public class Detalle extends JDialog{
	
	private Container contentPane;
	private Dimension pantalla;
	private Jugar jugar;
	private JPanel panel;
	private JButton color1;
	private JButton color2;
	private JButton defecto;
	private JButton personalizado;
	private URL fondoo = this.getClass().getResource("MenuJugar.png");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private Color col1;
	private Color col2;
	private Color colorFuente = Color.BLACK;
	private Color colorBoton = new Color(232, 232, 232);
	private char tipo;
	private SPOOBceInvadersGUI principal;

	/**
	 * Constructor de la clase.
	 * @param jugar, menu de Juego.
	 * @param tipo, tipo de juego.
	 * @param gui, clase principal.
	 */
	public Detalle(Jugar jugar, char tipo,SPOOBceInvadersGUI gui) {
		principal = gui;
		this.tipo = tipo;
		this.jugar = jugar;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		col1 = Color.BLACK;
		col2 = Color.GRAY;
		prepareElementos();
		prepareAcciones();
	}
	
	/**
	 * Prepara los elementos necesarios para mostrar el menu.
	 */
	private void prepareElementos() {
		setTitle("Ajusta Detalles");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareElementosMenu();
	}
	
	/**
	 * Prepara y ajusta los botones a mostrar en el menu de detalle.
	 */
	private void prepareElementosMenu() {
		panel = new JPanel() {@Override
		public void paint(Graphics g) {
				g.setColor(Color.BLACK);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
				if(tipo == 'u') {
					g.setFont(new Font("Gill Sans Ultra Bold",0, 50));
					g.drawString("Jugador 1", getWidth()/2-160, getHeight()/2-150);
					g.drawString("Seleccionar Mapa", getWidth()/2-270, getHeight()/2+150);
					g.setColor(col1);
					g.fillRect(getWidth()/2-80, getHeight()/2-60, 120, 30);
					g.fillRect(getWidth()/2-55, getHeight()/2-90, 70, 30);
				}else {
					g.setFont(new Font("Gill Sans Ultra Bold",0, 50));
					g.drawString("Jugador 1", getWidth()/3-160, getHeight()/2-150);
					g.drawString("Jugador 2", getWidth()/2+50, getHeight()/2-150);
					g.drawString("Seleccionar Mapa", getWidth()/2-270, getHeight()/2+150);
					g.setColor(col1);
					g.fillRect(getWidth()/3-80, getHeight()/2-60, 120, 30);
					g.fillRect(getWidth()/3-55, getHeight()/2-90, 70, 30);
					g.setColor(col2);
					g.fillRect(getWidth()/2+140, getHeight()/2-60, 120, 30);
					g.fillRect(getWidth()/2+165, getHeight()/2-90, 70, 30);
				}
			}
		};
		panel.setLayout(null);
		if(tipo == 'u') {
			color1 = new JButton("Elige Un Color");
			defecto = new JButton("Por defecto");
			personalizado = new JButton("Personalizado");
			tamanoMenu();
			tamanoBotones();
			centre();
			diseno();
			contentPane.add(panel);		
			panel.add(color1);
		}else {
			color1 = new JButton("Elige Un Color");
			color2 = new JButton("Elige Un Color");
			defecto = new JButton("Por defecto");
			personalizado = new JButton("Personalizado");
			tamanoMenu();
			tamanoBotones();
			centre();
			diseno();
			contentPane.add(panel);		
			panel.add(color1);
			panel.add(color2);
		}
		panel.add(defecto);
		panel.add(personalizado);
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
		color1.setSize(230 , 30);
		color1.setLocation(getWidth()/2-140, getHeight()/2-10);
		if(tipo == 'm') {
			color1.setSize(230 , 30);
			color1.setLocation(getWidth()/3-140, getHeight()/2-10);
			color2.setSize(230 , 30);
			color2.setLocation(getWidth()/2+75, getHeight()/2-10);
		}
		defecto.setSize(230 , 30);
		defecto.setLocation(getWidth()/3-140, getHeight()/2+200);
		personalizado.setSize(230 , 30);
		personalizado.setLocation(getWidth()/2+75, getHeight()/2+200);
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
		color1.setBorder(null);
		color1.setFocusable(false);	
		if(tipo == 'm') {
			color2.setBorder(null);
			color2.setFocusable(false);
		}
		defecto.setBorder(null);
		defecto.setFocusable(false);	
		personalizado.setBorder(null);
		personalizado.setFocusable(false);	
	}
	
	/**
	 * Asigna el color a los botones del menu
	 */
	private void colorcitoBoton() {
		color1.setBackground(colorBoton);
		if(tipo == 'm') {
			color2.setBackground(colorBoton);
		}
		defecto.setBackground(colorBoton);
		personalizado.setBackground(colorBoton);
	}
	
	/**
	 * Asigna el tipo de letra de los textos del menu.
	 */
	private void fuente() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 45);
		color1.setForeground(colorFuente); 
		color1.setFont(fuente); 
		if(tipo == 'm') {
			color2.setForeground(colorFuente); 
			color2.setFont(fuente); 
		}
		defecto.setForeground(colorFuente); 
		defecto.setFont(fuente); 
		personalizado.setForeground(colorFuente); 
		personalizado.setFont(fuente); 
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
		
		ActionListener cambiarColor1 = new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				cambieColor1();
				
			}
		};
		
		ActionListener cambiarColor2 = new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				cambieColor2();
				
			}
		};
		
		ActionListener porDefecto = new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				try {
					defecto();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		ActionListener personalizad = new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				try {
					personal();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		addWindowListener(cerrarVentana);
		color1.addActionListener(cambiarColor1);
		if(tipo == 'm') {
			color2.addActionListener(cambiarColor2);
		}
		defecto.addActionListener(porDefecto);
		personalizado.addActionListener(personalizad);
	}
	
	/**
	 * Permite preparar el tablero personalizado.
	 * @throws IOException
	 */
	protected void personal() throws IOException {
		File f = null;
		JFileChooser j = new JFileChooser();
		j.setDialogTitle("Escoja su tablero");
		int selection = j.showSaveDialog(this);
		if(JFileChooser.APPROVE_OPTION == selection) {
			f = j.getSelectedFile();
			if(tipo == 'u') {
				this.setVisible(false);
				principal.empieceUnJugador(col1, f);
			}else if(tipo == 'm') {
				this.setVisible(false);
				principal.empieceMultijugadorJJ(col1, col2, f);
			}
		}
	}

	/**
	 * Permite preparar el tablero por defecto.
	 * @throws IOException
	 */
	protected void defecto() throws IOException {
		File f = new File("src/tableros/defecto.txt");
		if(tipo == 'u') {
			this.setVisible(false);
			principal.empieceUnJugador(col1, f);
		}else if(tipo == 'm') {
			this.setVisible(false);
			principal.empieceMultijugadorJJ(col1, col2, f);
		}
		
	}

	/**
	 * Cambia el color del primer jugador.
	 */
	private void cambieColor1() {
		Color coloor = JColorChooser.showDialog(null, "Change color", col1);
		if(coloor != null && coloor != Color.BLACK) {
			col1 = coloor;
			repaint();
		}
	}
	
	/**
	 * Cambia el color del segundo jugador.
	 */
	private void cambieColor2() {
		Color coloor = JColorChooser.showDialog(null, "Change color", col1);
		if(coloor != null && coloor != Color.GRAY) {
			col2 = coloor;
			repaint();
		}
	}
	
	/**
	 * Cierra la ventana en caso de que el usuario lo indique.
	 */
	private void salir() {
		jugar.setVisible(true);
		this.setVisible(false);
	}

}
