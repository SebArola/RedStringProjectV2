package model;

import java.util.ArrayList;
import java.util.List;

public class DescripteurImage {
	private String chemin;
	private int nbCouleurs;
	private int pourcentageRouge;
	private int pourcentageVert;
	private int pourcentageBleu;
	private List<Integer> histogramme = new ArrayList<>(); 
	
	public DescripteurImage(String c){
		this.chemin = c;
		this.nbCouleurs = 1;
	}
	
	public DescripteurImage(String c, int r, int v, int b){
		this.chemin = c;
		this.nbCouleurs = 3;
		this.pourcentageRouge = r;
		this.pourcentageVert = v;
		this.pourcentageBleu = b;
	}
	
	public Couleur couleurDominante(){
		if (this.pourcentageRouge > this.pourcentageVert && this.pourcentageRouge > this.pourcentageBleu)
			return Couleur.ROUGE;
		if (this.pourcentageVert > this.pourcentageRouge && this.pourcentageVert > this.pourcentageBleu)
			return Couleur.VERT;
		if (this.pourcentageBleu > this.pourcentageRouge && this.pourcentageBleu > this.pourcentageVert)
			return Couleur.BLEU;
		return Couleur.GRIS;
		
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
	
	public int getNbCouleurs() {
		return nbCouleurs;
	}

	public void setNbCouleurs(int nbCouleurs) {
		this.nbCouleurs = nbCouleurs;
	}

	public List<Integer> getHistogramme() {
		return histogramme;
	}

	public void setHistogramme(List<Integer> histogramme) {
		this.histogramme = histogramme;
	}
	
	public String toString(){
		String s = "";
		s = s + this.chemin + "\n" + this.nbCouleurs + "\n";
		if(this.nbCouleurs == 3){
			s = s + this.pourcentageRouge + "\n" + this.pourcentageVert + "\n" + this.pourcentageBleu + "\n";
		}
		s = s + this.histogramme + "\n";
		return s;
	}
}
