package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayPelikulakTest {
	
	ArrayPelikulak lista, lista2;
	Pelikula peli1,peli2,peli3,peli4;
	Aktore aktor1;
	ArrayAktoreak lista3;
	@Before
	public void setUp() throws Exception {
		lista2 = new ArrayPelikulak();
		peli1 = new Pelikula("300",245.00);
		peli2 = new Pelikula("Annabelle",47.99);
		peli3 = new Pelikula("Jurassic Park",45.00);
		lista2.gehituPelikula(peli2);
		lista2.gehituPelikula(peli3);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	/*@Test
	public void testBadagoPelikula() throws FileNotFoundException, IOException {
		assertTrue(lista2.badagoPelikula("Annabelle"));
		assertFalse(lista2.badagoPelikula("Eager to Die"));
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Devon, Tony");
		lista = aktor1.getListaPelikula();
		assertTrue(lista.badagoPelikula("Eager to Die"));
		assertFalse(lista.badagoPelikula("The Cold Shoulder"));
	}

	@Test
	public void testGehituPelikula() throws FileNotFoundException, IOException {
		assertEquals(lista2.pelikulaKopurua(), 2);
		lista2.gehituPelikula(peli3);
		assertEquals(lista2.pelikulaKopurua(), 3);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Devon, Tony");
		lista = aktor1.getListaPelikula();
		lista.erreseteatu();
		assertEquals(lista.pelikulaKopurua(), 0);
		lista.gehituPelikula(peli1);
		assertEquals(lista.pelikulaKopurua(), 1);
	}
	
	@Test
	public void testPelikulaKopurua() throws FileNotFoundException, IOException {
		assertEquals(lista2.pelikulaKopurua(), 2);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Devon, Tony");
		lista = aktor1.getListaPelikula();
		assertEquals(lista.pelikulaKopurua(), 4);
		
	}*/
	
	@Test
	public void testErreseteatu() throws FileNotFoundException, IOException {
		assertEquals(lista2.pelikulaKopurua(), 2);
		lista2.erreseteatu();
		assertEquals(lista2.pelikulaKopurua(), 0);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./f.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Devon, Tony");
		lista = aktor1.getListaPelikula();
		lista.erreseteatu();
		assertEquals(lista.pelikulaKopurua(), 0);
	}
	
	/*@Test
	public void testEzabatuAktorea() throws FileNotFoundException, IOException {
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Devon, Tony");
		lista = aktor1.getListaPelikula();
		peli4 = ListaPelikula.getNireListaPelikula().bilatuPelikula("The Wire");
		lista3 = peli4.getListaAktoreak();
		assertEquals(lista3.aktoreKopurua(), 702);
		lista.ezabatuAktorea(aktor1);
		assertEquals(lista3.aktoreKopurua(), 701);
		
	}*/

}
