package controleur;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import model.DescripteurSon;

public class ControleurRechercheSonExtraitSonore {

	public ArrayList<DescripteurSon> listeDescripteur = new ArrayList<DescripteurSon>();

	public HashMap<String, Integer> rechercheEnregistrementAudio(DescripteurSon extrait) throws FileNotFoundException {
		HashMap<String, Integer> mapSon = new HashMap<String, Integer>();
		int nombre = 0;
		String Texte;
		String Partie = "";

		Partie = extrait.descripteur.substring(0, extrait.descripteur.length() - 1);

		for (int i = 0; i < listeDescripteur.size(); i++) {
			DescripteurSon lecture = listeDescripteur.get(i);
			if(!(extrait.getNom().equals(lecture.getNom()))){
				Texte = lecture.getDescripteur();//descripteur.substring(0, lecture.descripteur.length() - 1);
	
				nombre = 0;
				nombre = (" " + Texte + " ").split(Partie).length - 1;
				System.out.println("Liste SIZE = "+listeDescripteur.size()+ "  NOMBRE = "+nombre);
				if (nombre > 0) {
					mapSon.put(lecture.getNom() ,nombre);
				}
			}
		}

		return (mapSon);
	}

	public void ajouterDescripteurListe(ArrayList<DescripteurSon> liste) {
		this.listeDescripteur = liste;
	}

	public void afficherListe() {
		for (int i = 0; i < listeDescripteur.size(); i++) {
			DescripteurSon lecture = listeDescripteur.get(i);
			System.out.println(lecture.toString());
		}
	}
}
