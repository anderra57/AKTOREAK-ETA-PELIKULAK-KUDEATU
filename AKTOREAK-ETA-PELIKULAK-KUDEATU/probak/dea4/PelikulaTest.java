package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PelikulaTest {
	Pelikula pelikula1,pelikula2,pelikula3;
	ArrayAktoreak lista,lista2;
	Aktore aktor1,aktor2;
	@Before
	public void setUp() throws Exception {
		pelikula3 = new Pelikula("La isla", 30.00);
		pelikula2 = new Pelikula("Spiderman", 40.00);
		lista2 = new ArrayAktoreak();
		aktor1 = new Aktore("Arias, Adei");
		aktor2 = new Aktore("Prieto, Ander");
		lista2.gehituAktorea(aktor1);
		lista2.gehituAktorea(aktor2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIzenburua() throws FileNotFoundException, IOException {
		assertEquals(pelikula2.getIzenburua(), "Spiderman");
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		pelikula1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("Mind Stroll");
		assertEquals(pelikula1.getIzenburua(), "Mind Stroll");
	}

	@Test
	public void testGetDirua() throws FileNotFoundException, IOException {
		assertEquals(pelikula3.getDirua(), 30.00, 2);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		pelikula1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("Mind Stroll");
		assertEquals(pelikula1.getDirua(), 45.00, 2);
	}

	@Test
	public void testGetListaAktoreak() throws FileNotFoundException, IOException {
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		pelikula1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("Mind Stroll");
		lista = pelikula1.getListaAktoreak();
		assertNotNull(lista);
	}

	@Test
	public void testGehituDirua() throws FileNotFoundException, IOException {
		pelikula3.gehituDirua(30.00);
		assertEquals(pelikula3.getDirua(), 60.00, 2);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		pelikula1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("La sala");
		pelikula1.gehituDirua(10.00);
		assertEquals(pelikula1.getDirua(), 55.00, 2);
	}
	
	@Test
	public void testListaAktoreanGehitu() throws FileNotFoundException, IOException {
		lista2.erreseteatu();
		assertEquals(lista2.aktoreKopurua(), 0);
		lista2.gehituAktorea(aktor1);
		assertEquals(lista2.aktoreKopurua(), 1);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		pelikula1 = ListaPelikula.getNireListaPelikula().bilatuPelikula("Mind Stroll");
		lista = pelikula1.getListaAktoreak();
		assertEquals(lista.aktoreKopurua(), 6);
		lista.gehituAktorea(aktor1);
		assertEquals(lista.aktoreKopurua(), 7);
	}

}
