package dea4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main_Interaktiboa {

	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		//----------
		
		Stopwatch programa = new Stopwatch();
		Stopwatch ekintza = new Stopwatch();
		int num;
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Linea;
		Pelikula peli1;
		Aktore akt1;
		String a1;
		String a2;
		boolean amaitu=false;
		//----------

		
//----------------------------------------------------------------------------------------
		
		apk2();
		System.out.println("");
		
		//----------
		System.out.println("Kaixo! Sakatu enter programa hasieratzeko");
		Linea=br.readLine();
		
//----------------------------------------------------------------------------------------
		
		ekintza=new Stopwatch();
		//----------
		
		System.out.println("Aktore eta pelikulen datuak kargatzen...");
		ListaPelikula.getNireListaPelikula().fitxeroaErakutsi("res/FilmsActors20162017.txt");
		
		//----------
		System.out.println("Kargatuta! Iraupena: " + ekintza.elapsedTime() +" segundu");
		System.out.println();
		
//----------------------------------------------------------------------------------------
		
	do{
		System.out.println("Zer egin nahi duzu?");
		System.out.println("> 1) Aktore kopurua inprimatu");
		System.out.println("> 2) Pelikula kopurua inprimatu");
		System.out.println("> 3) Pelikula baten dirua inprimatu");
		System.out.println("> 4) Aktore bat gehitu");
		System.out.println("> 5) Pelikula bat gehitu");
		System.out.println("> 6) Pelikula bati dirua gehitu");
		System.out.println("> 7) Aktore bat kendu");
		System.out.println("> 8) Aktore lista ordenatuta inprimatu");
		System.out.println("> 9) Aktore lista fitxategi berri batean sartu");
		System.out.println("> 10) Bi aktore konektatuta daude?");
		System.out.println("> 11) Bi aktoreen arteko lotura inprimatu");
		System.out.println("> 12) Aktore edo pelikula baten pelikula edo aktore lista ordenatua inprimatu PageRank-aren arabera");
		System.out.println("> ... ");
		System.out.println("> 0) Menutik atera");
		Linea = br.readLine();
		try{
		num = Integer.parseInt(Linea);
		}catch(Exception e){num=-1;}
		
		switch(num){

//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc		
		case 10:
			ekintza=new Stopwatch();
		//----------
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Lehen aktorearen izen-abizenak sartu");
			System.out.println("Formatua: ABIZENA, IZENA");
			a1= br.readLine();
			System.out.println("Bigarren aktorearen izen-abizenak sartu");
			System.out.println("Formatua: ABIZENA, IZENA");
			a2= br.readLine();
			
			GraphHash grafok = new GraphHash();
			grafok.grafoaSortu(ListaAktoreak.getNireListaAktoreak());
			System.out.println("Konexioa bilatzen...");

			boolean dago = grafok.konektatuta(a1,a2);
			if(dago){
				System.out.println("");
				System.out.println("BAI, konektatuta daude.");
			}else{
				System.out.println("");
				System.out.println("EZ, ez daude konektatuta.");
			}
		
		//----------
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
		
		break;		
		
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc		
		
		case 11:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Lehen aktorearen izen-abizenak sartu");
			System.out.println("Formatua: ABIZENA, IZENA");
			a1= br.readLine();
			System.out.println("Bigarren aktorearen izen-abizenak sartu");
			System.out.println("Formatua: ABIZENA, IZENA");
			a2= br.readLine();
		
			GraphHash grafoe = new GraphHash();
			grafoe.grafoaSortu(ListaAktoreak.getNireListaAktoreak());			
			
			System.out.println("Erlazioa bilatzen...");
			ArrayList<String> listaErl = grafoe.erlazionatuta(a1,a2);
			if (listaErl==null){
				System.out.println("EZ daude erlazionatuta.");
			}
			else{
				Iterator<String> itr = listaErl.iterator();
				while(itr.hasNext()){
					String izena = itr.next();
					System.out.println(izena);
				}
			}
			
				
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 12:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Aktorearen izen-abizenak edo pelikularen izenburua sartu");
			System.out.println("Formatua: ABIZENA, IZENA");
			input= br.readLine();
		
			GraphHash grafopr = new GraphHash();
			grafopr.grafoaSortu(ListaAktoreak.getNireListaAktoreak());

			
			
			System.out.println("PageRank-ak kalkulatzen...");
			
			grafopr.hasieratuPageRank();		
			grafopr.pageRank();

			System.out.println("Lista ordenatua kalkulatzen...");
			
			ArrayList<Bikote> ordena = grafopr.bilatzailea(input);
			System.out.println();
			grafopr.printOrdenean(ordena,input);
			
				
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 1:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Guztira, "+ListaAktoreak.getNireListaAktoreak().aktoreKopurua()+" aktore daude gure datu basean");
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 2:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("Guztira, "+ListaPelikula.getNireListaPelikula().pelikulaKopurua()+" pelikula daude gure datu basean");
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 3:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Pelikularen izenburua sartu:");
			System.out.println("");
			input= br.readLine();
			peli1 = ListaPelikula.getNireListaPelikula().bilatuPelikula(input);
			double diru=peli1.getDirua();
			System.out.println(input+" pelikulak " + diru+ "$-ko aurrekontua dauka.");			
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
		
		case 4:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Aktorearen izena sartu:");
			System.out.println("Formatua: ABIZENA, IZENA");
			System.out.println("");
			input= br.readLine();
			akt1=new Aktore(input);
			if(ListaAktoreak.getNireListaAktoreak().bilatuAktorea(input)==null){
				ListaAktoreak.getNireListaAktoreak().gehituAKtorea(input,akt1);
				System.out.println("Aktorea datu basera gehitu da.");
			}
			else{System.out.println("Aktorea datu basean bazegoen jada.");}
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 5:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Pelikularen izenburua sartu:");
			System.out.println("");
			input= br.readLine();
			peli1=new Pelikula(input,999999.99);
			if(ListaPelikula.getNireListaPelikula().bilatuPelikula(input)==null){
				ListaPelikula.getNireListaPelikula().gehituPelikula(peli1);
				System.out.println("Pelikula datu basera gehitu da.");
			}
			else{System.out.println("Pelikula datu basean bazegoen jada.");}
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 6:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Pelikularen izenburua sartu:");
			input= br.readLine();
			String izen=input;
			peli1=new Pelikula(input,999999.99);
			if(ListaPelikula.getNireListaPelikula().bilatuPelikula(input)==null){
				
				System.out.println("Pelikula ez dago datu basean, saiatu berriz.");
			}
			else{
				System.out.println("Pelikularen aurrekontua sartu:");
				System.out.println("");
				input= br.readLine();
				double diruplus=Double.parseDouble(input);
				ListaPelikula.getNireListaPelikula().gehituDirua(izen, diruplus);
				System.out.println("Pelikularen aurrekontua datu basera gehitu da.");	
			}
			
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 7:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Aktorearen izena sartu:");
			System.out.println("Formatua: ABIZENA, IZENA");
			System.out.println("");
			input= br.readLine();
			akt1=new Aktore(input);
			if(ListaAktoreak.getNireListaAktoreak().bilatuAktorea(input)!=null){
				ListaAktoreak.getNireListaAktoreak().ezabatuAktorea(input);
				System.out.println("Aktorea datu basetik ezabatu da.");
			}
			else{System.out.println("Aktorea datu basean ez zegoen jada.");}
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 8:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			ListaAktoreak.getNireListaAktoreak().listaOrdenatua();
			System.out.println("Aktoreen lista ordenatu da.");
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
			
		case 9:
			ekintza=new Stopwatch();
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			System.out.println("Fitxategiaren izena sartu:");
			System.out.println("");
			input= br.readLine();				
			ListaAktoreak.getNireListaAktoreak().aktoreakFitxategianSartu(input);
			System.out.println("Aktoreekin fitxategia sortu da.");
			
			//----------
			
			System.out.println("");
			System.out.println("Ekintzaren iraupena: " + ekintza.elapsedTime() +" segundu");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			
			break;
			
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc	
			
		case 0:
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			amaitu=true;
		    long tiempo=(long)programa.elapsedTime();
		    System.out.println("");
		    System.out.println("Agur!");
		    System.out.println("");
		    System.out.println("Sesioaren iraupen totala:");
		    if  (tiempo>59){
		    	System.out.println(tiempo/60 +" min " + tiempo % 60 + " s");
		    }
		    else{
		    System.out.println(tiempo +" segundu");}
		    System.out.println("");
		    System.out.println("-----------------------------------------------------------");
		    System.out.println();
			
		    break;
		    
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc		
		    
		default:
			System.out.println("");
			System.out.println("Ongi sartu digitua!");
			System.out.println("");
			System.out.println("-----------------------------------------------------------");
			System.out.println("");
			break;
		}	
//cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc		
	  
		
		//----------
			if(!amaitu){
				System.out.println("Sakatu enter jarraitzeko");
				Linea=br.readLine();
			}
	}while(num!=0);
		
		
//----------------------------------------------------------------------------------------			
	}
	
	private static void apk2(){
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+                                                                                                                                     +");  		
		System.out.println("+                  █████╗ ██╗  ██╗████████╗ ██████╗ ██████╗ ███████╗ █████╗ ██╗  ██╗    ███████╗████████╗ █████╗                      +");
		System.out.println("+                 ██╔══██╗██║ ██╔╝╚══██╔══╝██╔═══██╗██╔══██╗██╔════╝██╔══██╗██║ ██╔╝    ██╔════╝╚══██╔══╝██╔══██╗                     +");
		System.out.println("+                 ███████║█████╔╝    ██║   ██║   ██║██████╔╝█████╗  ███████║█████╔╝     █████╗     ██║   ███████║                     +");
		System.out.println("+                 ██╔══██║██╔═██╗    ██║   ██║   ██║██╔══██╗██╔══╝  ██╔══██║██╔═██╗     ██╔══╝     ██║   ██╔══██║                     +");
		System.out.println("+                 ██║  ██║██║  ██╗   ██║   ╚██████╔╝██║  ██║███████╗██║  ██║██║  ██╗    ███████╗   ██║   ██║  ██║                     +");
		System.out.println("+                 ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝                     +");
		System.out.println("+                                                                                                                                     +");  
		System.out.println("+ ██████╗ ███████╗██╗     ██╗██╗  ██╗██╗   ██╗██╗      █████╗ ██╗  ██╗    ██╗  ██╗██╗   ██╗██████╗ ███████╗ █████╗ ████████╗██╗   ██╗ +");
		System.out.println("+ ██╔══██╗██╔════╝██║     ██║██║ ██╔╝██║   ██║██║     ██╔══██╗██║ ██╔╝    ██║ ██╔╝██║   ██║██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██║   ██║ +");
		System.out.println("+ ██████╔╝█████╗  ██║     ██║█████╔╝ ██║   ██║██║     ███████║█████╔╝     █████╔╝ ██║   ██║██║  ██║█████╗  ███████║   ██║   ██║   ██║ +");
		System.out.println("+ ██╔═══╝ ██╔══╝  ██║     ██║██╔═██╗ ██║   ██║██║     ██╔══██║██╔═██╗     ██╔═██╗ ██║   ██║██║  ██║██╔══╝  ██╔══██║   ██║   ██║   ██║ +");
		System.out.println("+ ██║     ███████╗███████╗██║██║  ██╗╚██████╔╝███████╗██║  ██║██║  ██╗    ██║  ██╗╚██████╔╝██████╔╝███████╗██║  ██║   ██║   ╚██████╔╝ +");
		System.out.println("+ ╚═╝     ╚══════╝╚══════╝╚═╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝    ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝  +");
		System.out.println("+                                                                                                                                     +");  
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");		
	}
}
