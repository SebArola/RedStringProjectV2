package controleur;

import java.util.ArrayList;

import model.TexteMotsCles;

public class ControlleurRechercheParMotsCles {
	public ArrayList<String> listeMotsPlus = new ArrayList<String>();
	public ArrayList<String> listeMotsMoins = new ArrayList<String>();
	public ArrayList<TexteMotsCles> listeTexteMotCles = new ArrayList<TexteMotsCles>();

	public boolean verifierMotsCles(String lecture) {

		int nombre = (" " + lecture + " ").split(" ").length - 1;
		String[] decoupe = lecture.split(" ");
		for (int i = 0; i < nombre; i++) {
			char lettre = decoupe[i].charAt(0);
			if (lettre == '-') {
				decoupe[i] = decoupe[i].substring(1);
				listeMotsMoins.add(decoupe[i]);
			} else {
				listeMotsPlus.add(decoupe[i]);
			}
		}

		return (true);
	}

	public void affciherArray() {

		System.out.println("Les mots en moins sont =>");
		for (int i = 0; i < listeMotsMoins.size(); i++)
			System.out.println("=" + listeMotsMoins.get(i) + "=");
		System.out.println("Les mots en plus sont =>");
		for (int i = 0; i < listeMotsPlus.size(); i++)
			System.out.println("=" + listeMotsPlus.get(i) + "=");
	}

	public ArrayList<String> rechercheTexte() {
		ArrayList<String> listeTexte = new ArrayList<String>();
		ArrayList<String> listeTexteARemove = new ArrayList<String>();
		for (int i = 0; i < listeTexteMotCles.size(); i++) {
			String Texte = listeTexteMotCles.get(i).texte;
			for (int j = 0; j < listeMotsPlus.size(); j++) {
				String mot = listeMotsPlus.get(j);
				int nombre = (" " + Texte + " ").split(mot).length - 1;
				if (nombre != 0)
					if( !listeTexte.contains(listeTexteMotCles.get(i).nom))
						listeTexte.add(listeTexteMotCles.get(i).nom);
			}
			for (int j = 0; j < listeMotsMoins.size(); j++) {
				String mot = listeMotsMoins.get(j);
				int nombre = (" " + Texte + " ").split(mot).length - 1;
				if (nombre != 0){
					if( !listeTexteARemove.contains(listeTexteMotCles.get(i).nom))
						listeTexteARemove.add(listeTexteMotCles.get(i).nom);
				}
			}
		}
		
		for (int i=0 ; i < listeTexteARemove.size() ; i++)
		{
			while(listeTexte.contains(listeTexteARemove.get(i))){
				int numero = listeTexte.indexOf(listeTexteARemove.get(i));
				listeTexte.remove(numero);
			}
										
		}
		return listeTexte;
	}

	public void ajouterDescripteurListe(String nom) {
		TexteMotsCles nouveau = new TexteMotsCles(nom);
		listeTexteMotCles.add(nouveau);
	}

	public void afficherListe() {
		for (int i = 0; i < listeTexteMotCles.size(); i++) {
			TexteMotsCles lecture = listeTexteMotCles.get(i);
			System.out.println(lecture.toString());
		}
	}
}
