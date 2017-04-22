package vueText;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controlleur.ControleurRechercheSonExtraitSonore;
import model.DescripteurSon;

public class BoundaryRechercheSonExtraitSonore {
	private ControleurRechercheSonExtraitSonore crses;
	int nombreOccurence;
	DescripteurSon resultat;
	String nom;
	String descripteur = "";
	DescripteurSon choixEnregistrement;
	Scanner clavier = new Scanner(System.in);

	public BoundaryRechercheSonExtraitSonore(ControleurRechercheSonExtraitSonore controlrses) {
		crses=controlrses;
	}

	public void rechercheSon() throws FileNotFoundException{
		System.out.println("Veuliiez choisir un extrait sonore (le nom de son descripteur. e.g:./Data/Descripteur1.txt) :");
		nom = clavier.nextLine();

		DescripteurSon extrait = new DescripteurSon(nom);

		System.out.println("Veuliiez choisir le nombre d'occurences minimum");
		nombreOccurence = clavier.nextInt();

		//System.out.println("resultat de vueRecchercheSon: "+resultat+"  extrait:"+extrait);
		resultat = crses.rechercheEnregistrementAudio(extrait);
		//System.out.println("resultat de vueRecchercheSon: "+resultat+"  extrait:"+extrait); //TODO test Vue recherche son
		if (resultat.nombreOccurence < nombreOccurence) {
			System.out.println("Aucun resultat n'as été trouvé");
		} else {
			System.out.println(
					"L'extrait est joué " + resultat.nombreOccurence + " fois dans le corpus nommé " + resultat.nom);
		}
	}
}
