package controlleur;

import java.util.ArrayList;

import model.Fichier;

public class ControlleurFichier {

	private ArrayList<Fichier> al_fichierTxt;
	private ArrayList<Fichier> al_fichierIm;
	private ArrayList<Fichier> al_fichierSon;

	private static ControlleurFichier instance;

	private ControlleurFichier() {
		this.al_fichierTxt = new ArrayList<Fichier>();
		this.al_fichierIm = new ArrayList<Fichier>();
		this.al_fichierSon = new ArrayList<Fichier>();

	}

	public static ControlleurFichier getInstance() {
		if (instance == null) {
			instance = new ControlleurFichier();
		}
		return instance;
	}

	public void addFichier(String chemin, String type, String descripteur) {
		switch (type) {
		case "Texte":
			this.al_fichierTxt.add(new Fichier(chemin, type, descripteur));
			break;
		case "Image":
			this.al_fichierIm.add(new Fichier(chemin, type, descripteur));
			break;
		case "Son":
			this.al_fichierSon.add(new Fichier(chemin, type, descripteur));
			break;
		}
	}
	
	//Appelle la méthode en C permettant de générer un descripteur pour un fichier donné.
	public String genDescripteur(String chemin, String type){
		return "desc";
	}

	public ArrayList<Fichier> getAllFichier(String type){
		switch (type) {
		case "Texte":
			return this.al_fichierTxt;
		case "Image":
			return this.al_fichierIm;
		case "Son":
			return this.al_fichierSon;
		}
		return null;
	}
}
