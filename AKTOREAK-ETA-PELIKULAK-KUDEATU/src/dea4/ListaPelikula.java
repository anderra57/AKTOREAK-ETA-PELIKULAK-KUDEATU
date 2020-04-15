package dea4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListaPelikula {
	
	private static ListaPelikula nireListaPelikula = null;
	private HashMap<String,Pelikula> map;
	
	private ListaPelikula(){
		this.map = new HashMap<String,Pelikula>();
	}
	
	public static ListaPelikula getNireListaPelikula(){
		if(nireListaPelikula == null){
			nireListaPelikula = new ListaPelikula();
		}
		return nireListaPelikula;
	}

	public void gehituDirua(String pIzenburua, double pDirua){
		Pelikula pelik = null;
		if(this.map.containsKey(pIzenburua)){
			pelik=this.map.get(pIzenburua);
			pelik.gehituDirua(pDirua);
		}
	}
	
	public int pelikulaKopurua() {
		return this.map.size();
	}
	
	public void erreseteatu() {
		this.map.clear();
	}
	
	public HashMap<String,Pelikula> getLista(){
		return this.map;
	}
	
	public void gehituPelikula(Pelikula pPelikula){
		if(this.bilatuPelikula(pPelikula.getIzenburua())==null){
			this.map.put(pPelikula.getIzenburua(),pPelikula);
		}
	}
	
	public Pelikula bilatuPelikula(String pIzenburua){
		Pelikula pelikula = null;
		if (this.map.containsKey(pIzenburua)){
			pelikula=this.map.get(pIzenburua);
		}
		return pelikula;
	}
	
	public ArrayAktoreak pelikulaBatenListaAktore(String pPeli){
		Pelikula peli = this.bilatuPelikula(pPeli);
		if(peli == null){
			return null;
		}else{
			return peli.getListaAktoreak();
		}
	}
	
	public void fitxeroaErakutsi(String pFitxeroa) throws FileNotFoundException, IOException{
				try{      
					Scanner entrada = new Scanner(new FileReader(pFitxeroa));     
					String linea; 
					Aktore aktor;
					Pelikula peli = null;
					while (entrada.hasNext()) { 
						linea = entrada.nextLine();
						String[] datuak = linea.split("\\s+--->\\s+");
						peli = new Pelikula(datuak[0],45.00);
						ListaPelikula.getNireListaPelikula().gehituPelikula(peli);
						//System.out.println(datuak[0]);
						String[] aktoreak = datuak[1].split("\\s+&&&\\s+");
						int i=0;
						while (i < aktoreak.length){//sartu aktoreak eta pelikulak
							aktor = ListaAktoreak.getNireListaAktoreak().bilatuAktorea(aktoreak[i]);
							if(aktor==null){
								aktor = new Aktore(aktoreak[i]);
								ListaAktoreak.getNireListaAktoreak().gehituAKtorea(aktoreak[i], aktor);														
							}
							//System.out.println(aktoreak[i]);
							peli.listaAktoreanGehitu(aktor);//Hemen, pelikulari aktore hau sartuko diogu bere listaAktorean
							aktor.listaPelikulanGehitu(peli);//Hemen, aktore honi sartuko diogu pelikula hau bere listaPelikulan
							i++;
						}
				      }      
					entrada.close();
				}   catch(IOException e) {e.printStackTrace();}
	}
	
	public void pagerankproba(){
		Aktore aktor;
		Pelikula peli;
		
		//A
		aktor = new Aktore("A");
		ListaAktoreak.getNireListaAktoreak().gehituAKtorea("A", aktor);
		aktor.listaPelikulanGehitu(new Pelikula("B",45.00));
		aktor.listaPelikulanGehitu(new Pelikula("C",45.00));
		aktor.listaPelikulanGehitu(new Pelikula("D",45.00));
		
		//B
		peli=new Pelikula("B",45.00);
		ListaPelikula.getNireListaPelikula().gehituPelikula(peli);
		peli.listaAktoreanGehitu(new Aktore("F"));
		
		//C
		peli=new Pelikula("C",45.00);
		ListaPelikula.getNireListaPelikula().gehituPelikula(peli);
		peli.listaAktoreanGehitu(new Aktore("E"));
		
		//D
		peli=new Pelikula("D",45.00);
		ListaPelikula.getNireListaPelikula().gehituPelikula(peli);
		peli.listaAktoreanGehitu(new Aktore("H"));
		
		//E
		aktor = new Aktore("E");
		ListaAktoreak.getNireListaAktoreak().gehituAKtorea("E", aktor);
		aktor.listaPelikulanGehitu(new Pelikula("G",45.00));
		
		//F
		aktor = new Aktore("F");
		ListaAktoreak.getNireListaAktoreak().gehituAKtorea("F", aktor);
		aktor.listaPelikulanGehitu(new Pelikula("G",45.00));
		
		//G
		peli=new Pelikula("G",45.00);
		ListaPelikula.getNireListaPelikula().gehituPelikula(peli);
		peli.listaAktoreanGehitu(new Aktore("H"));
		peli.listaAktoreanGehitu(new Aktore("A"));
		
		//H
		aktor = new Aktore("H");
		ListaAktoreak.getNireListaAktoreak().gehituAKtorea("H", aktor);
		//aktor.listaPelikulanGehitu(new Pelikula("B",45.00));
		
		
	}
}
