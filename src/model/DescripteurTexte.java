package model;

public class DescripteurTexte {
	public String texte;
	public String nom;

	public DescripteurTexte(DescripteurTexte ds) {
		this.texte = ds.texte;
		this.nom = ds.nom;
	}

	public DescripteurTexte(String lecture) {

		String[] decoupe = lecture.split(".xml");
		String[] decoupe2 = decoupe[0].split("<descripteur>");
		String[] decoupe3 = decoupe[1].split("</descripteur>");
		this.nom = decoupe2[1];
		this.texte = decoupe3[0].replaceAll("[\\d]", "");
	}
	
	public String getnom() {
		return nom;
	}
	
	public String gettexte() {
		return texte;
	}
	
	public String toString() {
		return ("Nom :" + this.nom + " \nDescripteur :" + this.texte);
	}
}
