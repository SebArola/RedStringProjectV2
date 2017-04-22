package controleur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.DescripteurSon;

public class ControleurGenerationDescripteurSon {
	// Va lire dans le fichier indiqué par le chemin, puis sépare les
	// descripteur et crée
	// pour chaque descripteur un objet descripteurTexte qui met ensuite dans
	// une arraylist qu'il renvoie

	public ArrayList<DescripteurSon> creationDescripteurSon(String chemin) throws IOException {
		ArrayList<DescripteurSon> listeDescripteurSon = new ArrayList<DescripteurSon>();
		String lecture = "";

		try {
			InputStream ips = new FileInputStream(chemin);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				lecture += ligne + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		int nombre = (" " + lecture + " ").split(";").length - 1;
		String[] decoupe = lecture.split(";");

		for (int i = 0; i < nombre; i++) {
			DescripteurSon ds = new DescripteurSon(decoupe[i]);
			listeDescripteurSon.add(ds);
		}

		return (listeDescripteurSon);
	}

	public void afficherArraylistSon(ArrayList<DescripteurSon> liste) {

		for (int i = 0; i < liste.size(); i++) {
			DescripteurSon ds = liste.get(i);
			System.out.println("NOUVEAU DESCRPTEUR");
			System.out.println(ds.toString());

		}

	}
}
