package controleur;

import java.util.ArrayList;
import java.util.HashMap;

import model.DescripteurTexte;

public class ControlleurRechercheParMotsCles {
	public ArrayList<String> listeMotsPlus = new ArrayList<String>();
	public ArrayList<String> listeMotsMoins = new ArrayList<String>();
	public ArrayList<DescripteurTexte> listeDescripteurTexte = new ArrayList<DescripteurTexte>();

	public boolean verifierMotsCles(String lecture) {
		// todo petit probleme je sais pas comment
		return (true);
	}

	public void afficherArray() {

		System.out.println("Les mots en moins sont =>");
		for (int i = 0; i < listeMotsMoins.size(); i++)
			System.out.println("=" + listeMotsMoins.get(i) + "=");
		System.out.println("Les mots en plus sont =>");
		for (int i = 0; i < listeMotsPlus.size(); i++)
			System.out.println("=" + listeMotsPlus.get(i) + "=");
	}

	public HashMap<String, Integer> rechercheTexte(String lecture) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

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

		ArrayList<String> listeTexte = new ArrayList<String>();
		ArrayList<String> listeTexteARemove = new ArrayList<String>();
		for (int i = 0; i < listeDescripteurTexte.size(); i++) {
			String Texte = listeDescripteurTexte.get(i).texte;
			for (int j = 0; j < listeMotsPlus.size(); j++) {
				String mot = listeMotsPlus.get(j);
				nombre = (" " + Texte + " ").split(mot).length - 1;
				if (nombre != 0)
					if (!listeTexte.contains(listeDescripteurTexte.get(i).nom))
						listeTexte.add(listeDescripteurTexte.get(i).nom);
			}
			for (int j = 0; j < listeMotsMoins.size(); j++) {
				String mot = listeMotsMoins.get(j);
				nombre = (" " + Texte + " ").split(mot).length - 1;
				if (nombre != 0) {
					if (!listeTexteARemove.contains(listeDescripteurTexte.get(i).nom))
						listeTexteARemove.add(listeDescripteurTexte.get(i).nom);
				}
			}
		}

		for (int i = 0; i < listeTexteARemove.size(); i++) {
			while (listeTexte.contains(listeTexteARemove.get(i))) {
				int numero = listeTexte.indexOf(listeTexteARemove.get(i));
				listeTexte.remove(numero);
			}

		}
		for (int i = 0; i < listeTexte.size(); i++){
			map.put(listeTexte.get(i),i+1 );
			System.out.println(listeTexte.get(i));
			System.out.println(map.get(listeTexte.get(i)));
		}
		System.out.println("HEY");
		return map;
	}

	public void ajouterDescripteurListe(ArrayList<DescripteurTexte> liste) {
		this.listeDescripteurTexte = liste;
	}

	public void afficherListe() {
		for (int i = 0; i < listeDescripteurTexte.size(); i++) {
			DescripteurTexte lecture = listeDescripteurTexte.get(i);
			System.out.println(lecture.toString());
		}
	}
}
