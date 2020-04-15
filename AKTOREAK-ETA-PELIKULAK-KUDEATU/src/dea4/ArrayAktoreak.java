package dea4;

import java.util.*;

public class ArrayAktoreak {
	
	private ArrayList<Aktore> lista;
	
	public ArrayAktoreak(){
		this.lista = new ArrayList<Aktore>();
	}
	
	private Iterator<Aktore> getNireIteradorea(){
		return this.lista.iterator();
	}
	
	public boolean badagoAktorea(String pIzenAbizena){//Aktore bat pasata, listan dagoen esango digu
		boolean dago = false;
		Aktore aktor = null;
		Iterator<Aktore> itr = this.getNireIteradorea();
		while(itr.hasNext() && !dago){
			aktor = itr.next();
			if(aktor.getIzenAbizena().equals(pIzenAbizena)){
				dago = true;
			}
		}
		return dago;
	}
	public Iterator <Aktore> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void gehituAktorea(Aktore pAktore){
		if(!(this.badagoAktorea(pAktore.getIzenAbizena()))){
			this.lista.add(pAktore);
		}
	}
	
	public void ezabatuAktorea(Aktore pAktore) {
		this.lista.remove(pAktore);	
	}
	
	public int aktoreKopurua() {
		return this.lista.size();
	}
	
	public void erreseteatu() {
		this.lista.clear();
	}
	
	public ArrayList<String> pasaString(){
		Iterator<Aktore> itr = this.getNireIteradorea();
		Aktore aktore = null;
		ArrayList<String> lista = new ArrayList<String>();
		while(itr.hasNext()){
			aktore = itr.next();
			lista.add(aktore.getIzenAbizena());
		}
		return lista;
	}

	public ArrayList<Aktore> getLista() {
		return lista;
	}

}
