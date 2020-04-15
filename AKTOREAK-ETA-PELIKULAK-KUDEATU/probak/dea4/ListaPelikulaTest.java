package dea4;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ListaPelikulaTest {
	ListaPelikula lista1 = ListaPelikula.getNireListaPelikula();
	Pelikula peli1,peli2,peli3,peli4;
	
	@Before
	public void setUp() throws Exception {
		peli1 = new Pelikula("Batman",345.00);
		peli2 = new Pelikula("Joker",355.00);
		peli3 = new Pelikula("WonderWoman",365.00);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGehituDirua() throws FileNotFoundException, IOException {
		lista1.erreseteatu();
		lista1.gehituPelikula(peli3);
		lista1.gehituDirua("WonderWoman", 20.00);
		assertEquals(peli3.getDirua(), 385.00, 2);//listako elementu bakarrari dirua gehitu
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		peli4 = ListaPelikula.getNireListaPelikula().bilatuPelikula("Eager to Die");
		lista1.gehituDirua("Eager to Die", 20.00);
		assertEquals(peli4.getDirua(), 65.00, 2);//listako edozein elementuri dirua gehitu
	}

	@Test
	public void testPelikulaKopurua() throws FileNotFoundException, IOException {
		lista1.erreseteatu();
		assertEquals(lista1.pelikulaKopurua(), 0);//lista hutsaren pelikula kopurua
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		assertEquals(lista1.pelikulaKopurua(), 10412);
		lista1.gehituPelikula(peli2);
		assertEquals(lista1.pelikulaKopurua(), 10413);//lista ez hutsaren pelikula kopurua
	}

	@Test
	public void testErreseteatu() throws FileNotFoundException, IOException {
		lista1.erreseteatu();
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		assertEquals(lista1.pelikulaKopurua(), 10412);
		lista1.erreseteatu();
		assertEquals(lista1.pelikulaKopurua(), 0);
	}

	@Test
	public void testGehituPelikula() throws FileNotFoundException, IOException {
		lista1.erreseteatu();
		assertEquals(ListaPelikula.getNireListaPelikula().pelikulaKopurua(), 0);
		lista1.gehituPelikula(peli2);
		assertEquals(ListaPelikula.getNireListaPelikula().pelikulaKopurua(), 1);//gehitu elementua lista hutsean
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		assertEquals(ListaPelikula.getNireListaPelikula().pelikulaKopurua(), 10413);
		lista1.gehituPelikula(peli3);
		assertEquals(ListaPelikula.getNireListaPelikula().pelikulaKopurua(), 10414);//gehitu elementua lista ez hutsean
		
	}

	@Test
	public void testBilatuPelikula() throws FileNotFoundException, IOException {
		lista1.erreseteatu();
		assertEquals(ListaPelikula.getNireListaPelikula().bilatuPelikula("Eager to Die"), null);//lista hutsean bilatu
		lista1.gehituPelikula(peli3);
		assertEquals(ListaPelikula.getNireListaPelikula().bilatuPelikula("WonderWoman"), peli3);//lista elementu bakarra
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
		lista1.gehituPelikula(peli1);
		assertEquals(lista1.bilatuPelikula("Batman"), peli1);//elementua listan dago
		assertNotEquals(lista1.bilatuPelikula("Joker"), peli1);//elementua ez dago listan
	}

	@Test
	public void testFitxeroaErakutsi() throws FileNotFoundException, IOException {
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./FilmsActors20162017.txt");
	
	}

}
