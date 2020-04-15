package dea4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphHashTest {
	GraphHash grafoa;
	ListaAktoreak lista1 = ListaAktoreak.getNireListaAktoreak();	
	ListaPelikula lista2=ListaPelikula.getNireListaPelikula();
	HashMap<String,Double> aurrekoPageRank = new HashMap<String,Double>();
	HashMap<String,Double> unekoPageRank = new HashMap<String,Double>();
	
	@Before
	public void setUp() throws Exception {
		grafoa=new GraphHash();
		lista2.fitxeroaErakutsi("./probatxiki.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGrafoaSortu() {
		grafoa.grafoaSortu(ListaAktoreak.getNireListaAktoreak());
		assertNotNull(grafoa);
	}

	@Test
	public void testPrint() {
		grafoa.print();
	}

	@Test
	public void testKonektatuta() {
		grafoa.grafoaSortu(ListaAktoreak.getNireListaAktoreak());
		assertTrue(grafoa.konektatuta("Devon, Tony","Nutcher, Greg"));
		assertFalse(grafoa.konektatuta("Devon, Tony","Malas, Javi"));
		assertFalse(grafoa.konektatuta("Pearson, Liam","Bardem, Javier"));
		assertFalse(grafoa.konektatuta("Neeson, Liem","Pit, Brad"));
		assertFalse(grafoa.konektatuta("Aho, Miina","Pitt, Brad"));
	}

	@Test
	public void testErlazionatuta() {
		grafoa.grafoaSortu(ListaAktoreak.getNireListaAktoreak());
		assertNotNull(grafoa.erlazionatuta("Devon, Tony","O'Toole, Peter (I)"));
		assertEquals(grafoa.erlazionatuta("Devon, Tony","Maalas, Javii"),null);
		assertEquals(grafoa.erlazionatuta("Peaarson, Liiam","Bardem, Javier"),null);
		assertEquals(grafoa.erlazionatuta("Neeson, Liem","Pit, Brad"),null);
		assertEquals(grafoa.erlazionatuta("Aho, Miina","Pitt, Brad"),null);
	}

	@Test
	public void testHasieratuPageRank() {
		grafoa.hasieratuPageRank();		
	}

	@Test
	public void testPageRank() {
		grafoa.pageRank();
	}

	@Test
	public void testPrintPageRank() {
		grafoa.printPageRank(unekoPageRank);
	}

	@Test
	public void testBilatzailea() {
		assertNotNull(grafoa.bilatzailea("McGregor, Ewan"));
		assertNull(grafoa.bilatzailea("Peppe, Bootiijoo"));
	}

	@Test
	public void testPrintOrdenean() {
		ArrayList<Bikote> ordena = grafoa.bilatzailea("McGregor, Ewan");
		if (ordena!=null){
		grafoa.printOrdenean(ordena,"McGregor, Ewan");
		}
		else{
			System.out.println("Ez dago grafoan");
		}
		ArrayList<Bikote> bilatu = grafoa.bilatzailea("Juanra, Giimeeeneez");
		if (bilatu!=null){
			grafoa.printOrdenean(ordena,"Juanra, Giimeeeneez");
		}
		else{
			System.out.println("Ez dago grafoan");
		}
	}

}