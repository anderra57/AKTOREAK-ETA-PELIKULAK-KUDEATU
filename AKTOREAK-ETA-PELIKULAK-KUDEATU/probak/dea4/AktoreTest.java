package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AktoreTest {
	Aktore aktore1,aktor1;
	ArrayPelikulak lista,lista1;
	Pelikula peli1;
	Pelikula peli2;
	@Before
	public void setUp() throws Exception {
		aktore1 = new Aktore("Adeiarias");
		lista = new ArrayPelikulak();
		peli1=new Pelikula("El Guason",45.00);
		peli2=new Pelikula ("El Joker", 60.00);
	}

	@After
	public void tearDown() throws Exception {
		aktore1=null;
		lista=null;
		peli1=null;
		peli2=null;
	}

	@Test
	public void testGetIzenAbizena() throws FileNotFoundException, IOException {
		assertEquals(aktore1.getIzenAbizena(), "Adeiarias");
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Baskin, Cezmi");
		assertEquals(aktor1.getIzenAbizena(), "Baskin, Cezmi");
		
	}

	@Test
	public void testGetListaPelikula() throws FileNotFoundException, IOException {
		lista=aktore1.getListaPelikula();
		assertNotNull(lista);
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		aktor1 = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Baskin, Cezmi");
		lista1 = aktor1.getListaPelikula();
		assertNotNull(lista1);
		
	}

	@Test
	public void testListaPelikulanGehitu() throws FileNotFoundException, IOException {
		aktore1.listaPelikulanGehitu(peli1);
		aktore1.listaPelikulanGehitu(peli2);
		lista=aktore1.getListaPelikula();
		assertTrue(lista.badagoPelikula(peli1.getIzenburua()));
		assertTrue(lista.badagoPelikula(peli1.getIzenburua()));
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		Aktore aktor = ListaAktoreak.getNireListaAktoreak().bilatuAktorea("Baskin, Cezmi");
		lista = aktor.getListaPelikula();
		assertEquals(lista.pelikulaKopurua(), 29);
		lista.gehituPelikula(peli1);
		assertEquals(lista.pelikulaKopurua(), 30);
		
	}
	
}