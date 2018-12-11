package presentacion;

import aplicacion.SPOOBceInvaders;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.event.*;

/**
 * Clase principal de presentacion.
 * Esta clase se comunica con la clase principal de aplicacion.
 * @version (9/12/2018)
 * @author (Natalia Palacios)
 */

public class SPOOBceInvadersGUI extends JFrame{
	
	private MenuPrincipal menu;
	private SPOOBceInvaders juego;
	private JPanel tablero;
	private Dimension pantalla;
	private URL fondoo = this.getClass().getResource("Tablero.jpg");
	private Image fondo = new ImageIcon(fondoo).getImage();
	private Printer dibujante;
	private Timer tiempoJuego;
	private JDialog canvas;
	private Persistencia guardar;
	
	/**
	 * Constructor
	 */
	private SPOOBceInvadersGUI(){
		guardar = new Persistencia();
		juego = new SPOOBceInvaders();
		prepareElementos();		
	}
	
	/**
	 * Activa el modo Un Jugador.
	 * @param col, color del jugador.
	 * @param tablero, archivo a interpretar.
	 * @throws IOException 
	 */
	public void empieceUnJugador(Color col,File tablero) throws IOException {
		canvas.setTitle("Un Jugador");
		prepareTablero();
		prepareAcciones();
		prepareAccionesUnJugador();
		ArrayList<ArrayList<Character>> a = guardar.interpretaTablero(tablero);
		juego.iniciarJuego(col,a);
		canvas.setVisible(true);
		iniciarJuego();
	}
	
	/**
	 * Activa el modo Multijugador de jugador vs jugador
	 * @param col, color del jugador 1.
	 * @param col2, color del jugador 2.
	 * @param tablero, archivo a interpretar.
	 * @throws IOException 
	 */
	public void empieceMultijugadorJJ(Color col,Color col2,File tablero) throws IOException {
		canvas.setTitle("Jugador VS Jugador");
		prepareTablero();
		prepareAcciones();
		prepareAccionesMultiJJ();
		ArrayList<ArrayList<Character>> a = guardar.interpretaTablero(tablero);
		juego.iniciarJuego('m',col,col2,a);
		canvas.setVisible(true);
		iniciarJuego();
	}
	
	/**
	 * Activa el modo Multijugador de jugador vs maquina
	 * @param col, color del jugador 1.
	 * @param col2, color del jugador 2.
	 * @param tablero, archivo a interpretar.
	 * @param modo, modo de la maquina.
	 * @throws IOException 
	 */
	public void empieceMultijugadorJM(Color col,Color col2,File tablero,char modo) throws IOException {
		canvas.setTitle("Jugador VS Maquina");
		prepareTablero();
		prepareAcciones();
		prepareAccionesMultiJJ();
		ArrayList<ArrayList<Character>> a = guardar.interpretaTablero(tablero);
		juego.iniciarJuego('m',col,col2,a);
		canvas.setVisible(true);
		iniciarJuego();
	}
	
	/**
	 * Prepara el tablero de juego.
	 */
	private void prepareTablero() {
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		tablero = new JPanel();
		tablero.setLayout(new GridLayout(1, 1));
		int y = pantalla.height;
		int x = pantalla.width;
		canvas.setSize(x * 61/100, y * 41/50);
		centreTablero();
		dibujante = new Printer(tablero);
		tablero.add(dibujante);
		canvas.add(tablero);
	}

	/**
	 * Inicia el juego.
	 */
	private void iniciarJuego() {
		tiempoJuego = new Timer();
		TimerTask task = new TimerTask() {
			
			public void run() {
				char[][] tabler = juego.actualice();
				for(int i = 0; i < tabler.length; i++) {
					System.out.println(tabler[i]);
				}
				muestreTablero();
			}
		};		
		tiempoJuego.schedule(task,1,100);
	}

	/**
	 * Manda los elementos del tablero a la clase Printer para dibujarlos.
	 */
	private void muestreTablero() {
		ArrayList<CanonGUI> canones = new ArrayList<CanonGUI>();
		ArrayList<BarreraGUI> barreras = new ArrayList<BarreraGUI>();
		ArrayList<ExtraterrestreGUI> invasores = new ArrayList<ExtraterrestreGUI>();
		ArrayList<BalaGUI> balas = new ArrayList<BalaGUI>();
		ArrayList<Integer> tamanos = juego.getTamanos();
		//construir canones
		for(int i = 0; i < tamanos.get(0); i++) {
			int[]  pos = juego.getPosicionesCanon(i);
			Color col = juego.getColorCanon(i);
			int vid = juego.getVidaCanon(i);
			int pun = juego.getPuntajeCanon(i);
			CanonGUI c = new CanonGUI(pos,col,vid,pun);
			ArrayList<Character> mun = juego.getBalasCanon(i);
			ArrayList<Integer[]> posB = juego.getBalasCanonPos(i);
			for(int j = 0; j < mun.size(); j++) {
				balas.add(new BalaGUI(mun.get(j),posB.get(j)));
			}
			canones.add(c);
		}//construir barreras
		for(int i = 0; i < tamanos.get(1); i++) {
			ArrayList<Integer[]> pos = juego.getPosicionesBarrera(i);
			char id = juego.getIdBarrera(i);
			BarreraGUI b = new BarreraGUI(pos,id);
			barreras.add(b);
		}//construir invasores
		for(int i = 0; i < tamanos.get(2); i++) {
			int[] pos = juego.getPosicionInvasor(i);
			int estado = juego.getEstadoInvasor(i);
			char id = juego.getIdInvasor(i);
			boolean vivo = juego.invasorIsVivo(i);
			ExtraterrestreGUI e = new ExtraterrestreGUI(pos,estado,id,vivo);
			ArrayList<Character> mun = juego.getBalasInvasor(i);
			ArrayList<Integer[]> posB = juego.getBalasInvasorPos(i);
			for(int j = 0; j < mun.size(); j++) {
				balas.add(new BalaGUI(mun.get(j),posB.get(j)));
			}
			invasores.add(e);
		}
		dibujante.agregarBalas(balas);
		dibujante.agregarInvasores(invasores);
		dibujante.agregarBarreras(barreras);
		dibujante.agregarCanones(canones);
		dibujante.repaint();
	}

	
	
	/**
	 * Prepara los elementos que se van a mostrar
	 */
	private void prepareElementos(){
		canvas = new JDialog(this);
		menu = new MenuPrincipal(this);
	}
	
	 /**
	  * Prepara los listeners necesarios para el funcionamiento
	  */
	public void prepareAcciones(){
		WindowAdapter cerrarVentana = new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				salir();
			}
		};
		
		canvas.addWindowListener(cerrarVentana);
		
	}
	
	/**
	 * Prepara los listeners necesarios para el modo Un Jugador
	 */
	public void prepareAccionesUnJugador() {
		
		KeyListener mover = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					disparar(1);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					moverIzquierda(1);
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moverDerecha(1);
				}
			}
		};
		
		canvas.addKeyListener(mover);
		
	}
	
	/**
	 * Da la  orden de disparar
	 * @param jugador, indica el jugador que ha disparado
	 */
	protected void disparar(int jugador) {
		juego.dispare(jugador);
	}

	/**
	 * Da la  orden de moverse a la derecha
	 * @param jugador, indica el jugador que se va a mover a la derecha
	 */
	protected void moverDerecha(int jugador) {
		juego.derecha(jugador);
	}

	/**
	 * Da la  orden de moverse a la izquierda
	 * @param jugador, indica el jugador que se va a mover a la izquierda
	 */
	protected void moverIzquierda(int jugador) {
		juego.izquierda(jugador);
	}
	
	/**
	 * Prepara los listeners del modo Multijugador
	 */
	public void prepareAccionesMultiJJ() {
		KeyListener moverJ1 = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					disparar(1);
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					moverIzquierda(1);
				}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					moverDerecha(1);
				}
			}
		};
		
		KeyListener moverJ2 = new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W) {
					disparar(2);
				}else if(e.getKeyCode() == KeyEvent.VK_A) {
					moverIzquierda(2);
				}else if(e.getKeyCode() == KeyEvent.VK_D) {
					moverDerecha(2);
				}
			}
		};
		
		canvas.addKeyListener(moverJ1);
		canvas.addKeyListener(moverJ2);
	}	
	
	/**
	 * Da la orden de que se cierre una ventana
	 */
	private void salir() {
		int respuesta = JOptionPane.showConfirmDialog(canvas, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION) {
			tiempoJuego.cancel();
			menu.setVisible(true);	
			canvas.setVisible(false);	
		}
		canvas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	
	/**
	 * Ubica la ventana en el centro de la pantalla.
	 */
	private void centreTablero() {
		int esquinaX = (pantalla.width - canvas.getSize().width)/2;
		int esquinaY = (pantalla.height - canvas.getSize().height)/2;
		canvas.setLocation(esquinaX,esquinaY);
	}
	
	/**
	 * Metodo principal de la clase SPOOBceInvadersGUI
	 * @param args
	 */
	public static void main(String[] args){
		SPOOBceInvadersGUI invaders = new SPOOBceInvadersGUI();		
	}
	
}



