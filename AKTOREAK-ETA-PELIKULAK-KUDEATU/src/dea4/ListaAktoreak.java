package dea4;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ListaAktoreak {
	
	private static ListaAktoreak nireListaAktoreak = null;
	private HashMap<String,Aktore> map;
	
	
	private ListaAktoreak(){
		this.map = new HashMap<String,Aktore>();
	}
	
	public static ListaAktoreak getNireListaAktoreak(){
		if(nireListaAktoreak == null){
			nireListaAktoreak = new ListaAktoreak();
		}
		return nireListaAktoreak;
	}
	
	public void ezabatuAktorea(String pIzenAbizena){
		Aktore aktor=this.bilatuAktorea(pIzenAbizena);
		ArrayPelikulak lista=null;
		if(aktor!=null){
			lista=aktor.getListaPelikula();
			lista.ezabatuAktorea(aktor);
			this.map.remove(pIzenAbizena);
		}
	}
	
	public void gehituAKtorea(String pIzenAbizena, Aktore pAktore){
		if(!this.map.containsKey(pIzenAbizena)){
			this.map.put(pIzenAbizena, pAktore);
		}
	}
	
	public Aktore bilatuAktorea(String pIzenAbizena){
		Aktore aktor = null;
		if(this.map.containsKey(pIzenAbizena)){
			aktor = this.map.get(pIzenAbizena);
		}
		return aktor;
	}
	
	public Iterator<String> getIteradorea(){
		return this.map.keySet().iterator();
	}
	
	public HashMap<String,Aktore> getLista(){
		return this.map;
	}
	
	public int aktoreKopurua() {
		return this.map.size();
	}
	
	public void erreseteatu() {
		this.map.clear();
	}
	
	
	private String[] pasaArray(){
		String[] lista = new String[this.aktoreKopurua()];
		int i = 0;
		Iterator<String> it = map.keySet().iterator();
		String izena = null;
		while (it.hasNext()){
			izena = it.next();
			lista[i]=izena;
			i=i+1;
		}
		return lista;
	}
	
	public String[] listaOrdenatua(){
		String[] lista = this.pasaArray();
		quickSort(lista, 0, lista.length-1);
		return lista;
	}

	
	private void quickSort(String[ ] lista, int hasiera, int bukaera){
		 if ( bukaera - hasiera> 0 ) { // taulan elementu bat baino gehiago
		 int indizeaZatiketa = zatiketa(lista, hasiera, bukaera);
		 quickSort(lista, hasiera, indizeaZatiketa - 1);
		 quickSort(lista, indizeaZatiketa + 1, bukaera);
		 }
	}
		
	private int zatiketa(String[] lista, int i, int f){

		 String lag = lista[i];
		 int ezker = i;
		 int eskuin = f;
		 while ( ezker < eskuin ){
		 lag.toUpperCase();
		 lista[ezker].toUpperCase();
		 lista[eskuin].toUpperCase();
		 while ( lista[ezker].compareTo(lag) <= 0 && ezker < eskuin)
		 ezker++;
		 while ( lista[eskuin].compareTo(lag) > 0 )
		 eskuin--;
		 if ( ezker < eskuin )
		 swap(lista, ezker, eskuin);
		 }
		 lista[i] = lista[eskuin];
		 lista[eskuin] = lag;

		 return eskuin;
	}

	private void swap(String[] lista, int one, int two) {
		 String temp = lista[one];
		 lista[one] = lista[two];
		 lista[two] = temp;
		 }
	
	
	public ArrayPelikulak aktoreBatenListaPelikulak(String pAktore){
		Aktore aktor = this.bilatuAktorea(pAktore);
		if(aktor == null){
			return null;
		}else{
			return aktor.getListaPelikula();
		}
	}
	
	public void aktoreakFitxategianSartu(String input){
		FileWriter fitxategia1 = null;	
		try {

			fitxategia1 = new FileWriter("res/"+input+".txt");
			Iterator<String> it = ListaAktoreak.getNireListaAktoreak().getLista().keySet().iterator();
			String lerroa = null;
			// Lerro bakoitza fitxategian idazten dugu
			while (it.hasNext()) {
				lerroa = it.next();
				if(it.hasNext()){
					fitxategia1.write(lerroa + " &&& " + "\n");
				}else{
					fitxategia1.write(lerroa + "\n");
				}
			}

			fitxategia1.close();

		} 
		catch (FileNotFoundException e) {
            System.out.println("Fitxeroa ez da existitzen. ");
        } catch (IOException e) {
            System.out.println("Fitxategiaren idazketak huts egin du. ");
        }
	}
}
