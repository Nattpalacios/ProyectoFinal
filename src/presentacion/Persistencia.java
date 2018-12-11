package presentacion;

import java.util.*;
import java.io.*;

/**
 * Esta clase permite hacer la persistencia del juego.
 * @author Palacios
 * @version (9/12/2018)
 */

public class Persistencia {
	
	private String rutaTablero;
	
	/**
	 * Constructor
	 */
	public Persistencia() {
		rutaTablero = "tableros";
	}
	
	/**
	 * Permite interpretar el archivo de texto.
	 * @param tablero, archivo a interpretar.
	 * @return los elementos que se van a anadir al tablero.
	 * @throws IOException
	 */
	public ArrayList<ArrayList<Character>> interpretaTablero(File tablero) throws IOException {
		ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		if(tablero != null) {			
	    	FileReader fis = new FileReader(tablero);
	    	BufferedReader is = new BufferedReader(fis);
	    	String s = is.readLine();	    	
	    	String[] st = s.trim().split(" ");
	    	ArrayList<Character> c = new ArrayList<Character>();
	    	for(int i = 0; i < Integer.parseInt(st[3]);i++) {
	    		String g = is.readLine().trim();
	    		if(g.equals("Calamar")) {
	    			c.add('c');
	    		}else if(g.equals("Cangrejo")){
	    			c.add('k');
	    		}else if(g.equals("Pulpo")){
	    			c.add('p');
	    		}else {
	    			c.add('t');
	    		}
	    	}
	    	a.add(c);
	    	String s2 = is.readLine();
	    	String[] st2 = s2.trim().split(" ");
	    	ArrayList<Character> b = new ArrayList<Character>();
	    	for(int i = 0; i < Integer.parseInt(st2[3]);i++) {
	    		String g = is.readLine().trim();
	    		if(g.equals("Verde")) {
	    			b.add('v');
	    		}else {
	    			b.add('r');
	    		}
	    	}
	    	a.add(b);
	    	fis.close();
    	}
		return a;
	}

}
