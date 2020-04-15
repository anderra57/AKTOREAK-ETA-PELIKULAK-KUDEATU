package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaAktoreakTest {
	ListaAktoreak lista1 = ListaAktoreak.getNireListaAktoreak();	
	ListaPelikula lista2=ListaPelikula.getNireListaPelikula();
	Aktore aktor1,aktor2;
	
	@Before
	public void setUp() throws Exception {
		aktor1 = new Aktore("AdeiArias");
		aktor2 = new Aktore("AnderPrieto");
		lista2.fitxeroaErakutsi("./FilmsActors20162017.txt");
	}

	@After
	public void tearDown() throws Exception {
		aktor1=null;
		aktor2=null;
		lista1.erreseteatu();
		lista2=null;
	}

	@Test
	public void testEzabatuAktorea() throws FileNotFoundException, IOException {
		assertEquals(lista1.aktoreKopurua(), 1283445);
		lista1.ezabatuAktorea("AdeiArias");
		assertEquals(lista1.aktoreKopurua(),1283445);
		lista1.ezabatuAktorea("Devon, Tony");
		assertEquals(lista1.aktoreKopurua(),1283444);
	}

	@Test
	public void testGehituAKtorea() throws FileNotFoundException, IOException {
		assertEquals(lista1.aktoreKopurua(), 1283445);
		lista1.gehituAKtorea("AnderPrieto", aktor2);
		assertEquals(lista1.aktoreKopurua(),1283446);
	}

	@Test
	public void testBilatuAktorea() {
		lista1.gehituAKtorea("AdeiArias", aktor1);
		assertEquals(lista1.bilatuAktorea("AdeiArias"), aktor1);
		assertEquals(lista1.bilatuAktorea("AnderPrieto"), null);
		assertNotEquals(lista1.bilatuAktorea("Tarantino, Quentin"), aktor1);
	}

	@Test
	public void testgetLista(){
		lista1.getLista();
		assertNotNull(lista1);
	}
	
	@Test
	public void testAktoreKopurua() {
		assertEquals(lista1.aktoreKopurua(), 1283445);
	}

	@Test
	public void testErreseteatu() {
		assertEquals(lista1.aktoreKopurua(), 1283445);
		lista1.erreseteatu();
		assertEquals((lista1.aktoreKopurua()), 0);
	}

	@Test
	public void testListaOrdenatua() {
		lista1.listaOrdenatua();
		assertNotNull(lista1);	
	}
}
