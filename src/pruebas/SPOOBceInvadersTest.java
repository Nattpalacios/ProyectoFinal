package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import aplicacion.*;

/**
 * The test class SPOOBceInvadersTest.
 * 
 * @author (Palacios Natalia)
 * @version (7/12/2018)
 *
 */
class SPOOBceInvadersTest {

	@Test
	void deberianCrearseVivosLosCalamares() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Calamar(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Calamar(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosPulpos() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Pulpo(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Pulpo(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosCangrejos() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>(); 
		Extraterrestre ca = new Cangrejo(1000, 1000);
		extraterrestres.add(ca);
		Extraterrestre pu = new Cangrejo(800,1000);
		extraterrestres.add(pu);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).isVivo());
			assertFalse(!extraterrestres.get(i).isVivo());
		}
	}
	
	@Test
	void deberianCrearseVivosLosCanones() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador1 = new Canon(1000, 1000);
		canones.add(jugador1);
		Canon jugador2 = new Canon(600, 1000);
		canones.add(jugador2);
		Canon jugador3 = new Canon(1000, 600);
		canones.add(jugador3);
		for(int i = 0; i < canones.size(); i++) {
			assertTrue(canones.get(i).isVivo());
			assertFalse(!canones.get(i).isVivo());
		}
	}
	
	@Test
	void noDeberiaUnPulpoTenerMasDeUnaVida() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Pulpo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Pulpo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Pulpo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 1);
			assertFalse(extraterrestres.get(i).getVida() > 1);
			assertEquals(extraterrestres.get(i).getVida(), 1);
		}
	}
	
	@Test
	void noDeberiaUnCangrejoTenerMasDeDosVidas() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Cangrejo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Cangrejo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Cangrejo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 2);
			assertFalse(extraterrestres.get(i).getVida() > 2);
			assertEquals(extraterrestres.get(i).getVida(), 2);
		}
	}
	
	@Test
	void noDeberiaUnCangrejoNacerConMenosDeDosVidas() {
		ArrayList<Extraterrestre> extraterrestres = new ArrayList<Extraterrestre>();
		Extraterrestre invasor1 = new Cangrejo(1000, 1000);
		extraterrestres.add(invasor1);
		Extraterrestre invasor2 = new Cangrejo(500, 1000);
		extraterrestres.add(invasor2);
		Extraterrestre invasor3 = new Cangrejo(1000, 500);
		extraterrestres.add(invasor3);
		for(int i = 0; i < extraterrestres.size(); i++) {
			assertTrue(extraterrestres.get(i).getVida() == 2);
			assertFalse(extraterrestres.get(i).getVida() < 2);
			assertEquals(extraterrestres.get(i).getVida(), 2);
		}
	}
	
	@Test
	void noDeberiaUnCanonTenerMasDeTresVidas() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(1000, 1000);
		canones.add(jugador);
		assertTrue(canones.get(0).getVida() == 3);
		assertFalse(canones.get(0).getVida() > 3);
	}
	
	@Test
	void noDeberiaUnCanonCrearseConMenosDeTresVidas() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(1000, 1000);
		canones.add(jugador);
		assertTrue(canones.get(0).getVida() == 3);
		assertFalse(canones.get(0).getVida() < 3);
	}
	
	@Test
	void deberiaElCanonCrearseEnLaPosicionEspecificada() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(10, 80);
		canones.add(jugador);
		assertEquals(canones.get(0).getPosY(),80);
		assertTrue(canones.get(0).getPosY() == 80);
		assertTrue(canones.get(0).getPosX() == 10);
		assertEquals(canones.get(0).getPosX(),10);
	}
	
	@Test
	void deberiaElCanonMoverseHaciaLaDerecha() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(27, 41);
		canones.add(jugador);
		assertEquals(canones.get(0).getPosY(),41);
		assertTrue(canones.get(0).getPosY() == 41);
		assertTrue(canones.get(0).getPosX() == 27);
		canones.get(0).derecha();
		assertTrue(canones.get(0).getPosY() == 42);
		assertEquals(canones.get(0).getPosY(),42);
		assertFalse(canones.get(0).getPosY() == 41);
	}
	
	@Test
	void deberiaElCanonMoverseHaciaLaIzquierda() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(20, 35);
		canones.add(jugador);
		assertTrue(canones.get(0).getPosX() == 20);
		assertEquals(canones.get(0).getPosY(),35);
		assertTrue(canones.get(0).getPosY() == 35);
		canones.get(0).izquierda();
		assertTrue(canones.get(0).getPosY() == 34);
		assertEquals(canones.get(0).getPosY(),34);
		assertFalse(canones.get(0).getPosY() == 35);
	}
	
	@Test
	void deberiaElCanonDisparar() {
		ArrayList<Canon> canones = new ArrayList<Canon>();
		Canon jugador = new Canon(20, 35);
		canones.add(jugador);
		canones.get(0).disparar(19, 36);
		Bala balita = canones.get(0).getUltimoDisparo();
		assertEquals(balita.getPosX(),19);
		assertTrue(balita.getPosY() == 36);
	}
	
	@Test
	void noDeberiaCrearseMasDeUnCanonEnModoUnJugador() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<ArrayList<Character>> tablero = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> tablerito1 = new ArrayList<Character>();
		ArrayList<Character> tablerito2 = new ArrayList<Character>();
		tablerito1.add('c');
		tablerito1.add('p');
		tablerito1.add('k');
		tablerito1.add('p');
		tablerito1.add('c');
		tablerito2.add('r');
		tablerito2.add('v');
		tablerito2.add('v');
		tablerito2.add('r');
		tablero.add(tablerito1);
		tablero.add(tablerito2);
		sp.iniciarJuego(Color.BLACK,tablero);
		ArrayList<Integer> tam2 = sp.getTamanos();
		System.out.println(tam2);
		assertTrue(tam2.get(0) == 1);
		assertFalse(tam2.get(0) > 1);
	}
	
	@Test
	void deberianCrearseDosCanonesEnModoMultijugador() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<ArrayList<Character>> tablero = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> tablerito1 = new ArrayList<Character>();
		ArrayList<Character> tablerito2 = new ArrayList<Character>();
		tablerito1.add('c');
		tablerito1.add('p');
		tablerito1.add('k');
		tablerito1.add('p');
		tablerito1.add('c');
		tablerito2.add('r');
		tablerito2.add('v');
		tablerito2.add('v');
		tablerito2.add('r');
		tablero.add(tablerito1);
		tablero.add(tablerito2);
		sp.iniciarJuego('m',Color.BLACK,Color.BLACK,tablero);
		ArrayList<Integer> tam = sp.getTamanos();
		assertTrue(tam.get(0) == 2);
		assertFalse(tam.get(0) < 2);
	}
	
	@Test
	void noDeberianCrearseMasDeDosCanonesEnModoMultijugador() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		ArrayList<ArrayList<Character>> tablero = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> tablerito1 = new ArrayList<Character>();
		ArrayList<Character> tablerito2 = new ArrayList<Character>();
		tablerito1.add('c');
		tablerito1.add('p');
		tablerito1.add('k');
		tablerito1.add('p');
		tablerito1.add('c');
		tablerito2.add('r');
		tablerito2.add('v');
		tablerito2.add('v');
		tablerito2.add('r');
		tablero.add(tablerito1);
		tablero.add(tablerito2);
		sp.iniciarJuego('m',Color.BLACK,Color.BLACK,tablero);
		ArrayList<Integer> tam = sp.getTamanos();
		assertFalse(tam.get(0) > 2);
		assertTrue(tam.get(0) == 2);
	}
	
	/**@Test
	void deberiaMorirUnInvasorPulpoLuegoDeUnDisparo() {
		SPOOBceInvaders sp = new SPOOBceInvaders();
		Extraterrestre pulpo = new Pulpo(15, 35);
		sp.actualice();
	}*/
	
	/**@Test
	void deberiaMorirUnInvasorCangrejoLuegoDeDosDisparos() {
		
	}*/
	
	

}