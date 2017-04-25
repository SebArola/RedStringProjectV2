package model;

public class DescripteurSon {
	public String descripteur;
	public String nom;
	public int nbOccurence;

	public DescripteurSon(DescripteurSon ds) {
		this.descripteur = ds.descripteur;
		this.nom = ds.nom;
		this.nbOccurence = ds.nbOccurence;
	}

	public DescripteurSon(String lecture) {
		String[] decoupe = lecture.split(";");
		String[] decoupe2 = decoupe[0].split("<descripteur>");
		this.nom = decoupe2[1];
		this.descripteur = decoupe[1];
		this.nbOccurence = 0;
	}

	public String toString() {
		return ("Nom :" + this.nom + " Descripteur :" + this.descripteur);
	}
	public String getDescripteur(){
		return descripteur;
	}
	public String getNom(){
		return nom;
	}
}
