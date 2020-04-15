package dea4;

public class Pelikula {
	
	private String izenburua;
	private double dirua;
	private ArrayAktoreak lista;
	
	public Pelikula(String pIzenburua, double pDirua){
		this.izenburua = pIzenburua;
		this.dirua = pDirua;
		this.lista = new ArrayAktoreak();
	}
	
	public String getIzenburua(){
		return this.izenburua;
	}
	
	public double getDirua(){
		return this.dirua;
	}
	
	public ArrayAktoreak getListaAktoreak(){
		return this.lista;
	}
	
	public void gehituDirua(double pDirua){
		this.dirua = this.dirua + pDirua;
	}
	public void listaAktoreanGehitu(Aktore pAktor){//Hemen, aktore bat sartuko dugu pelikularen listaAktorean
		this.lista.gehituAktorea(pAktor);
	 }
}
