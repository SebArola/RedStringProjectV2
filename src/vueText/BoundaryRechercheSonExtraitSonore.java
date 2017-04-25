package vueText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controleur.ControleurGenerationDescripteurSon;
import controleur.ControleurRechercheSonExtraitSonore;
import model.DescripteurSon;

public class BoundaryRechercheSonExtraitSonore {
	private ControleurRechercheSonExtraitSonore crses;
	int nombreOccurence;
	String nom;
	String descripteur = "";
	DescripteurSon choixEnregistrement;
	Scanner clavier = new Scanner(System.in);

	public BoundaryRechercheSonExtraitSonore(ControleurRechercheSonExtraitSonore controlrses) {
		crses = controlrses;
	}

	public void rechercheSon() throws IOException {
		HashMap<String, Integer> mapSon = new HashMap<String, Integer>();
		System.out.println("Veuliiez choisir un extrait sonore (le chemin du fihcier):");
		nom = clavier.nextLine();

		ControleurGenerationDescripteurSon cgds = new ControleurGenerationDescripteurSon();
		ArrayList<DescripteurSon> list = cgds.creationDescripteurSon(nom);
		DescripteurSon extrait = list.get(0);

		System.out.println("Veuliiez choisir le nombre d'occurences minimum");
		nombreOccurence = clavier.nextInt();

		mapSon = crses.rechercheEnregistrementAudio(extrait);
       // System.out.println("NUMERO : "+mapSon.size());
		for (Map.Entry<String, Integer> entry : mapSon.entrySet()) {
			String nom = entry.getKey();
			Integer valeur = entry.getValue();

			if (valeur < nombreOccurence) {
				System.out.println("Aucun resultat n'as été trouvé");
			} else {
				System.out.println("L'extrait est joué " + valeur + " fois dans le corpus nommé " + nom);
			}
		}
	}
}
