package dea4;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayPelikulak {
	
	private ArrayList<Pelikula> lista;
	
	public ArrayPelikulak(){
		this.setLista(new ArrayList<Pelikula>());
	}
	
	private Iterator<Pelikula> getNireIteradorea(){
		return this.getLista().iterator();
	}
	
	public boolean badagoPelikula(String pIzenburua){//Pelikula bat emanda, listan dagoen esango digu
		boolean dago = false;
		Pelikula pelikula = null;
		Iterator<Pelikula> itr = this.getNireIteradorea();
		while(itr.hasNext() && !dago){
			pelikula = itr.next();
			if(pelikula.getIzenburua().equals(pIzenburua)){
				dago = true;
			}
		}
		return dago;
	}
	
	public Iterator<Pelikula> getIteradorea(){
		return this.getLista().iterator();
	}
	
	public void gehituPelikula(Pelikula pPeli){
			this.getLista().add(pPeli);
	}
	
	public int pelikulaKopurua() {
		return this.getLista().size();
	}
	
	public void erreseteatu() {
		this.getLista().clear();
	}
	
	public void ezabatuAktorea(Aktore pAktore) {
		Pelikula peli = null;
		ArrayAktoreak lista=null;
		Iterator<Pelikula> itr = this.getNireIteradorea();
		while(itr.hasNext()) {
			peli = itr.next();
			lista=peli.getListaAktoreak();
			lista.ezabatuAktorea(pAktore);
		}
	}
	
	public ArrayList<String> pasaString(){
		Iterator<Pelikula> itr = this.getNireIteradorea();
		Pelikula peli = null;
		ArrayList<String> lista = new ArrayList<String>();
		while(itr.hasNext()){
			peli = itr.next();
			lista.add(peli.getIzenburua());
		}
		return lista;
	}

	public ArrayList<Pelikula> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Pelikula> lista) {
		this.lista = lista;
	}
}

