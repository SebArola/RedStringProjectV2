package controlleur;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.DescripteurSon;

public class ControleurRechercheSonExtraitSonore {

	public ArrayList<DescripteurSon> listeDescripteur = new ArrayList<DescripteurSon>();
	// je fais un test
	public DescripteurSon rechercheEnregistrementAudio(DescripteurSon extrait) throws FileNotFoundException{

		int nombreRetenue = -1;
		int nombre = 0;
		String Texte;
		String Partie = "";

		Partie = extrait.descripteur.substring(0, extrait.descripteur.length() - 1);
		DescripteurSon descripteurRetenue = new DescripteurSon(listeDescripteur.get(0));

		for (int i = 0; i < listeDescripteur.size(); i++) {
			DescripteurSon lecture = listeDescripteur.get(i);
			Texte = lecture.descripteur.substring(0, lecture.descripteur.length() - 1);

			nombre = 0;
			nombre = (" " + Texte + " ").split(Partie).length - 1;

			if (nombre > nombreRetenue) {
				nombreRetenue = nombre;
				descripteurRetenue = lecture;
				descripteurRetenue.nombreOccurence = nombre;
			}
		}

		return (descripteurRetenue);
	}

	public void ajouterDescripteurListe(String nom) {
		DescripteurSon nouveau = new DescripteurSon(nom);
		listeDescripteur.add(nouveau);
	}

	public void afficherListe() {
		for (int i = 0; i < listeDescripteur.size(); i++) {
			DescripteurSon lecture = listeDescripteur.get(i);
			System.out.println(lecture.toString());
		}
	}
}
