package controleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import model.DescripteurTexte;
import model.fichierConfig;

public class ControleurGenerationDescripteurTexte {

	// Va lire dans le fichier indiqu� par le chemin, puis s�pare les
	// descripteur et cr�e
	// pour chaque descripteur un objet descripteurTexte qui met ensuite dans
	// une arraylist qu'il renvoie

	private ArrayList<DescripteurTexte> listeDescripteurTexte;
	private static ControleurGenerationDescripteurTexte instance;

	private ControleurGenerationDescripteurTexte() {
		this.listeDescripteurTexte = new ArrayList<DescripteurTexte>();
	}

	public static ControleurGenerationDescripteurTexte getInstance() {
		if (instance == null) {
			instance = new ControleurGenerationDescripteurTexte();
		}
		return instance;
	}

	public ArrayList<DescripteurTexte> getListeDescripteurTexte() {
		return this.listeDescripteurTexte;
	}

	public DescripteurTexte getADescripteurTexte(String nomFic) {
		for (DescripteurTexte desc : this.listeDescripteurTexte) {

			String temp = desc.nom + ".xml";
			
			if (temp.equals(nomFic)) {
				return desc;
			}
		}
		return null;
	}

	public void creationDescripteurTexte() throws IOException {

		String lecture = "";
		try {
			File fileDir = new File(fichierConfig.getInstance().getCheminBD() + "/base_descripteur_texte.txt");

			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String str;

			while ((str = in.readLine()) != null) {
				lecture += str;
			}
			in.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int nombre = (" " + lecture + " ").split(";").length - 1;
		String[] decoupe = lecture.split(";");

		for (int i = 0; i < nombre; i++) {
			DescripteurTexte dt = new DescripteurTexte(decoupe[i]);
			this.listeDescripteurTexte.add(dt);
		}
	}

	public void afficherArraylistTexte(ArrayList<DescripteurTexte> liste) {

		for (int i = 0; i < liste.size(); i++) {
			DescripteurTexte dt = liste.get(i);
			System.out.println("NOUVEAU DESCRPTEUR");
			System.out.println(dt.toString());

		}

	}
}
