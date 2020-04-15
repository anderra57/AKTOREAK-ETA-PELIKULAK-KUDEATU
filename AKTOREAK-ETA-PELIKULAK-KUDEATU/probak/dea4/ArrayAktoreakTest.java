
package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayAktoreakTest {
	
	ArrayAktoreak lista;
	Aktore aktor1,aktor2,aktor3;
	Pelikula peli1;

	@Before
	public void setUp() throws Exception {
		lista = new ArrayAktoreak();
		aktor1 = new Aktore("AdeiArias");
		aktor2 = new Aktore("JonBarbero");
		aktor3 = new Aktore("AnderPrieto");
	}

	@After
	public void tearDown() throws Exception {
		lista=null;
		aktor1=null;
		aktor2=null;
		aktor3=null;
	}

	@Test
	public void testBadagoAktorea()throws FileNotFoundException, IOException  {
		lista.erreseteatu();
		lista.gehituAktorea(aktor1);
		assertEquals(lista.badagoAktorea("AdeiArias"), true);
		assertEquals(lista.badagoAktorea("JonBarbero"), false);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		peli1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("The Ghost of the Castle");
		lista = peli1.getListaAktoreak();
		assertTrue(lista.badagoAktorea("Foti, Leo"));
		assertFalse(lista.badagoAktorea("Tejada, Beatriz"));
	}

	@Test
	public void testGehituAktorea() throws FileNotFoundException, IOException {
		lista.erreseteatu();
		assertEquals(lista.aktoreKopurua(), 0);
		lista.gehituAktorea(aktor2);
		assertEquals(lista.aktoreKopurua(), 1);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		peli1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("The Ghost of the Castle");
		lista = peli1.getListaAktoreak();
		assertEquals(lista.aktoreKopurua(), 17);
		lista.gehituAktorea(aktor1);
		assertEquals(lista.aktoreKopurua(), 18);
	}

	@Test
	public void testAktoreKopurua() throws FileNotFoundException, IOException {
		lista.erreseteatu();
		assertEquals(lista.aktoreKopurua(), 0);
		lista.gehituAktorea(aktor2);
		assertEquals(lista.aktoreKopurua(), 1);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		peli1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("The Ghost of the Castle");
		lista = peli1.getListaAktoreak();
		assertEquals(lista.aktoreKopurua(), 17);
	}

	@Test
	public void testErreseteatu() throws FileNotFoundException, IOException {
		lista.erreseteatu();
		assertEquals(lista.aktoreKopurua(), 0);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		peli1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("The Ghost of the Castle");
		lista = peli1.getListaAktoreak();
		lista.erreseteatu();
		assertEquals(lista.aktoreKopurua(), 0);
	}

}
