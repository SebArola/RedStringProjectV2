package model;

import java.util.ArrayList;
import java.util.List;

public class DescripteurImage {
	private String chemin;
	private int pourcentageRouge;
	private int pourcentageVert;
	private int pourcentageBleu;
	private List<Integer> histogramme = new ArrayList<>(); 
	
	public DescripteurImage(){}
	
	public DescripteurImage(String c, int r, int v, int b){
		this.chemin = c;
		this.pourcentageRouge = r;
		this.pourcentageVert = v;
		this.pourcentageBleu = b;
	}
	
	public Couleur couleurDominante(){
		if (this.pourcentageRouge > this.pourcentageVert && this.pourcentageRouge > this.pourcentageVert)
			return Couleur.ROUGE;
		if (this.pourcentageVert > this.pourcentageRouge && this.pourcentageVert > this.pourcentageBleu)
			return Couleur.VERT;
		if (this.pourcentageBleu > this.pourcentageRouge && this.pourcentageBleu > this.pourcentageVert)
			return Couleur.BLEU;
		return null;
	}
	
	public String getChemin(){
		return this.chemin;
	}
	
	public int getPourcentageRouge(){
		return this.pourcentageRouge;
	}
	public int getPourcentageVert(){
		return this.pourcentageVert;
	}
	public int getPourcentageBleu(){
		return this.pourcentageBleu;
	}
}
