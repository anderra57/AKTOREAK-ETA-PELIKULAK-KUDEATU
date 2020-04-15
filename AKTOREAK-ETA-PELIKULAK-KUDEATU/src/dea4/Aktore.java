package dea4;

public class Aktore {
	
	private String izenAbizena;
	private ArrayPelikulak lista;
	
	public Aktore(String pIzenAbizena){
		this.izenAbizena = pIzenAbizena;
		this.lista = new ArrayPelikulak();
	}
	
	public String getIzenAbizena(){
		return this.izenAbizena;
	}
	
	public ArrayPelikulak getListaPelikula(){
		return this.lista;
	}
	
	public void listaPelikulanGehitu(Pelikula pPeli){//Hemen, pelikula bat sartuko dugu aktorearen listaPelikulan
		this.lista.gehituPelikula(pPeli);	
	}
}
