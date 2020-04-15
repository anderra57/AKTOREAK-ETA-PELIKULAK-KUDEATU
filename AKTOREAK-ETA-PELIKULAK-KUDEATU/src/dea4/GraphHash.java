package dea4;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class GraphHash {
	HashMap<String, ArrayList<String>> g = new HashMap<String, ArrayList<String>>();
	

	HashMap<String,Double> aurrekoPageRank = new HashMap<String,Double>();//elementu bakoitzaren pagerank-a sartzeko lista
	HashMap<String,Double> unekoPageRank = new HashMap<String,Double>();//elementu bakoitzaren pagerank-a sartzeko lista
	
	double d = 0.85;
	double n = 1/((double)g.size());
	double errorea = 0.0001;
	double ada=0.0;
	double dife=0.0;

	
	public void grafoaSortu(ListaAktoreak lAktoreak){
		// Post: aktoreen zerrendatik grafoa sortzen du
		// Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		// KODEA OSATU
		Aktore aktor = null;
		Pelikula peli = null;
		Iterator<Aktore> itrAktor = lAktoreak.getLista().values().iterator();
		//Lehenengo akoreak eta ondoren pelikulak sartuko ditugu hashmap-ean
		while(itrAktor.hasNext()){
			aktor = itrAktor.next();
			String izenaAktor = aktor.getIzenAbizena();
			g.put(izenaAktor, aktor.getListaPelikula().pasaString());
			//pasaString() metodoa erabili dugu, arrayList-a(bai aktoreak gordetzen dituena eta bai pelikulak gordetzen dituena)
			//string-era pasatzeko eta hashmapean sartzeko
		}
		Iterator<Pelikula> itrPeli = ListaPelikula.getNireListaPelikula().getLista().values().iterator();
		while(itrPeli.hasNext()){
			peli = itrPeli.next();
			String izenaPeli = peli.getIzenburua();
			g.put(izenaPeli, peli.getListaAktoreak().pasaString());
		}
	}
	public void print(){
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)){
				System.out.print(k + " ### ");
			} System.out.println();
		}
	}
	
	public boolean konektatuta(String a1, String a2){
		Queue<String> aztGabe = new LinkedList<String>();
		HashSet<String> aztertuak = new HashSet<String>();
		aztGabe.add(a1);
		aztertuak.add(a1);
		//lehenengo elementua sartuko dugu, geroago agertzen bada, berriro ere ez sartzeko
		boolean konek = false;
		if(ListaAktoreak.getNireListaAktoreak().bilatuAktorea(a1)==null && ListaAktoreak.getNireListaAktoreak().bilatuAktorea(a2)==null){
			System.out.println("Sartutako bi aktoreak ez daude grafoan sartuta");
		}else if(ListaAktoreak.getNireListaAktoreak().bilatuAktorea(a1)==null){
			System.out.println("Sartutako lehenengo aktorea ez dago grafoan sartuta");
		}else if(ListaAktoreak.getNireListaAktoreak().bilatuAktorea(a2)==null){
			System.out.println("Sartutako bigarren aktorea ez dago grafoan sartuta");
		}else{
			while(!aztGabe.isEmpty() && !konek){
				String eg= aztGabe.remove();
				if(eg.equals(a2)){
					konek=true; 
				}else{
					ArrayList<String> array = g.get(eg);
					Iterator<String> itr = array.iterator();
					while(itr.hasNext()){//ilaratik hartutako elementuaren arrayList-a iteratuko dugu honen elementuak pilan sartzeko
						String izena = itr.next();
						if(!aztertuak.contains(izena)){
							aztGabe.add(izena);
							aztertuak.add(izena);
							//bai ilaran eta bai hashSet-ean sartuko ditugu, bi datu egituretan elementuak ez errepikatzeko
						}
					}
				}
			}
		}
		return konek;
	}
	
	public ArrayList<String> erlazionatuta(String a1, String a2){
		boolean aux=konektatuta(a1,a2);
		boolean atera=false;
		Queue<String> aztGabe = new LinkedList<String>();
		HashSet<String> aztertuak = new HashSet<String>();
		Stack<String> nondik = new Stack<String>();//pila honen helburua, grafoaren elementu bakoitza nondik etorri den jakitea da
		Stack<String> adabegia = new Stack<String>();//pila honetan, grafoaren elementu guztiak sartuko ditugu
		aztGabe.add(a1);
		aztertuak.add(a1);
		adabegia.add(a1);
		//lehenengo elementua sartuko dugu, geroago aterako balitz, berriro ez sartzeko
		ArrayList<String> emaitza=new ArrayList<String>();
		if(aux){//bi aktoreak konektatuta badaude sartuko da
			while(!aztGabe.isEmpty() && !atera){ 
				String lag= aztGabe.remove();
				if(lag.equals(a2)){
					atera=true; 
				}else{
					ArrayList<String> array = g.get(lag);
					Iterator<String> itr = array.iterator();
					while(itr.hasNext()){
						String izena = itr.next();
						if(!aztertuak.contains(izena)){
							aztGabe.add(izena);
							aztertuak.add(izena);
							nondik.add(lag);//hemen, lehen esan den bezala, beste datu egituretan sartzen ari garen elementuaren
							//gurasoak sartuko ditugu
							adabegia.add(izena);
							//aurreko metodoan egin den bezala, datu egitura guztietan sartuko da, berriro ere ateratzen bada
							//elementu berdina, ez sartzeko
						}
					}
				}
			}//ARRAYLIST-A BETETZEN HASI
			String aurrekoa=a2;//Lehenengo elementua sartuko dugu pilan
			Stack<String> emaitza2 = new Stack<String>();
			emaitza2.push(a2);
			while(!adabegia.isEmpty() && !aurrekoa.equals(a1)){
				while(!adabegia.peek().equals(aurrekoa) && !nondik.isEmpty()){
					//while honetan, aurrekoa atributuan daukagun balioa aurkitu beharko dugu adabegia pilan, eta hau egiten dugun
					//bitartean, nondik pilan elementuak ateratzen joango gara.
					//Elementua aurkitzean, nondik pilan dagoen azken String-a, elementuaren gurasoa izango da, eta hau pilan
					//sartuko dugu. Nondik, hutsa denean, azken-aurreko elementura iritsi gara(azken elementua metodoaren parametroko
					//string bat da)
					nondik.pop();
					adabegia.pop();
				}
				aurrekoa = nondik.pop();
				emaitza2.push(aurrekoa);
				adabegia.pop();
			}
			//momentu honetan, bi aktoreen arteko erlazioaren bidea pilan dago, eta orain arrayListera pasako dugu
			while(!emaitza2.isEmpty()){
				emaitza.add(emaitza2.pop());
			}
			
		}
		else{
			System.out.println("Aktoreak ez daude konektatuta");
		}
		return emaitza;
	}
	
	public void hasieratuPageRank(){
		n= 1.0/((double)g.size());
		double balioa=n;
		String elem="";
		Iterator<String> itr= g.keySet().iterator();
		while(itr.hasNext()){
			elem = itr.next();
			aurrekoPageRank.put(elem, balioa);
			unekoPageRank.put(elem, 0.0);
		}
	}
	
	public HashMap<String, Double> pageRank(){
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setMaximumFractionDigits(340);
		double diferentzia=9.9;
		int j=1;
		while(diferentzia>errorea){
			diferentzia=0.0;
			
			Iterator<String> itr = g.keySet().iterator();
			
			while(itr.hasNext()){
				String elem= itr.next();
				int listaLuzera = g.get(elem).size();
				for(int i=0;i<listaLuzera ; i++){
					String listakoElem = g.get(elem).get(i);
					Double listakoElemListaLuzera = (double)g.get(listakoElem).size();
					Double listakoElemPR = aurrekoPageRank.get(listakoElem);
					//System.out.println(listakoElemPR);
					Double elemPR = unekoPageRank.get(elem);
					//System.out.println(elemPR);
					unekoPageRank.put(elem,elemPR+(listakoElemPR/listakoElemListaLuzera));
					unekoPageRank.get(elem);
				}
			}
			
			Iterator<String> itrMap = unekoPageRank.keySet().iterator();	
			
			while (itrMap.hasNext()) {
				String elemMap = itrMap.next();
				double val1=unekoPageRank.get(elemMap);
				double pr= ((1-d)/(1/n)) + (d*val1);
				unekoPageRank.put(elemMap, pr);
			
				double val2=aurrekoPageRank.get(elemMap);
		
				double dif=Math.abs(pr-val2);
				diferentzia=diferentzia+dif;
				aurrekoPageRank.put(elemMap, 0.0);
			}
			
			HashMap<String, Double> temp = aurrekoPageRank;
			aurrekoPageRank=unekoPageRank;
			unekoPageRank=temp;
			System.out.println(j+". iterazioa bukatuta, diferentzia " + df.format(diferentzia) + " da (errorea = 0.0001)");
			j++;
			
		}
		dife=diferentzia;
		return aurrekoPageRank;
	}
	
	public void printPageRank(HashMap<String,Double> gg){
		int i = 1;
		System.out.println("PAGERANK LISTA:");
		for (String s: gg.keySet()){
			System.out.println(i++ + ". elementua: " + s + ";  PageRank balioa: " + gg.get(s));
		}
		System.out.println("Diferentzia finala: " + dife);
	}	

	public ArrayList<Bikote> bilatzailea(String gakoHitz){
		ArrayList<String> al = this.g.get(gakoHitz);
		if (al==null) return null;
		else{
		ArrayList<Bikote> emaitza= new ArrayList<Bikote>();
		SortedSet<Bikote> set = new TreeSet<Bikote>();
		for(int i=0;i<al.size();i++){
			String unekoStr=al.get(i);
			Double unekoDou=this.aurrekoPageRank.get(unekoStr);
			set.add(new Bikote(unekoStr,unekoDou));
		}
		Iterator<Bikote> it = set.iterator();
        while (it.hasNext()) {
            Bikote bik = it.next();
            emaitza.add(bik);
        }
		return emaitza;
		}
	}
	
	public void printOrdenean(ArrayList<Bikote> ordena, String s){
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setMaximumFractionDigits(340);
		
		System.out.println(s+"-(r)ekin erlazionatutako PageRank lista ordenatua:");
		
		for (int i=0;i<ordena.size();i++){
			System.out.println(i+1 + ") "+ordena.get(i).aktoreaEdoPelikula+" –– PageRank balioa: "+df.format(ordena.get(i).pageRank));

		}
	}
	
}			