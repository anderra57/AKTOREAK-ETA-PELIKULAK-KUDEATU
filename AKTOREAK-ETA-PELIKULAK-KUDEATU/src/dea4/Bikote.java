package dea4;

public class Bikote implements Comparable<Bikote> {
	
	String aktoreaEdoPelikula;
	Double pageRank;
	
	public Bikote(String unekoStr, Double unekoDou) {
		this.aktoreaEdoPelikula=unekoStr;
		this.pageRank=unekoDou;
	}
	
	public Double getPage(){
		return this.pageRank;
	}

	@Override
	public int compareTo(Bikote arg0) {
		// TODO Auto-generated method stub
		if((arg0.getPage() - this.pageRank)>0){return 1;}
		else if((arg0.getPage() - this.pageRank)<0){return -1;}
		else if((arg0.getPage() - this.pageRank)>0){return 0;}
		return 1;
	}       

}
