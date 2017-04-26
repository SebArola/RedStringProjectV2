package controleur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.DescripteurTexte;

public class ControleurGenerationDescripteurTexte {

	// Va lire dans le fichier indiqu� par le chemin, puis s�pare les
	// descripteur et cr�e
	// pour chaque descripteur un objet descripteurTexte qui met ensuite dans
	// une arraylist qu'il renvoie

	public ArrayList<DescripteurTexte> creationDescripteurTexte(String chemin) throws IOException {
		ArrayList<DescripteurTexte> listeDescripteurTexte = new ArrayList<DescripteurTexte>();
		String lecture = "";

		try {
			FileInputStream fis = new FileInputStream(chemin);
			byte[] buf =  new byte[1];
		    int n = 0;
		    while ((n = fis.read(buf)) >= 0) {
		    	for (byte bit : buf) {
		            lecture += (char) bit ;
		        }
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		int nombre = (" " + lecture + " ").split(";").length - 1;
		String[] decoupe = lecture.split(";");

		for (int i = 0; i < nombre; i++) {
			DescripteurTexte dt = new DescripteurTexte(decoupe[i]);
			listeDescripteurTexte.add(dt);
		}

		return (listeDescripteurTexte);
	}

	public void afficherArraylistTexte(ArrayList<DescripteurTexte> liste) {

		for (int i = 0; i < liste.size(); i++) {
			DescripteurTexte dt = liste.get(i);
			System.out.println("NOUVEAU DESCRPTEUR");
			System.out.println(dt.toString());

		}

	}
}
