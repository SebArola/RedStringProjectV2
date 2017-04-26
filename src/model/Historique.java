package model;

import java.util.ArrayList;
import java.util.Observable;

public class Historique extends Observable{
	private ArrayList<String[]> historique;
	//recherche;type de fichier;nombre de résultat
	private static Historique instance;
	private Historique() {
		this.historique = new ArrayList<>();
	}
	
	public static Historique getInstance(){
		if(instance == null){
			instance = new Historique();
		}
		return instance;
	}
	
	/**
	 * recherche;type de fichier;nombre de résultat
	 * @param recherche
	 */
	public void addRecherche(String ... recherche){
		if(recherche.length == 3){
			historique.add(recherche);
			this.setChanged();
			this.notifyObservers(recherche);
		}
	}	 

}
