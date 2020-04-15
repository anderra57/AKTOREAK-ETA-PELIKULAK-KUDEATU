package dea4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PraktikaHasieratu {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		//ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("./probatxiki.txt");
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("res/FilmsActors20162017.txt");
		//ListaPelikula.getNireListaPelikula().pagerankproba();
		//System.out.println(page.hurrengoPageRank.get("Devon, Tony"));
		
		
		GraphHash grafo = new GraphHash();
		grafo.grafoaSortu(ListaAktoreak.getNireListaAktoreak());
		grafo.hasieratuPageRank();		
		grafo.pageRank();
		//grafo.printPageRank(emaitza);
		ArrayList<Bikote> ordena = grafo.bilatzailea("McGregor, Ewan");
		System.out.println();
		grafo.printOrdenean(ordena,"McGregor, Ewan");
		
		
	}
}