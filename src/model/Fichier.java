package model;

public class Fichier {

	private String chemin;
	private String type;
	private String descripteur;
	public Fichier(String chemin, String type, String descripteur) {
		this.chemin = chemin;
		this.type = type;
		this.descripteur = descripteur;
	}

	public String getChemin() {
		return chemin;
	}

	public String getType() {
		return type;
	}
	
	public String getDescripteur(){
		return this.descripteur;
	}
}
