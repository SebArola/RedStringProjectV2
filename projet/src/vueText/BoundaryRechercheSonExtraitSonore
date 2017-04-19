package vue;

import java.util.Scanner;

import control.ControleurRechercheSonExtraitSonore;
import model.DescripteurSon;

public class BoundaryRechercheSonExtraitSonore {
	public ControleurRechercheSonExtraitSonore crses;
	int nombreOccurence;
	DescripteurSon resultat;
	String nom;
	String descripteur = "";
	DescripteurSon choixEnregistrement;
	Scanner clavier = new Scanner(System.in);

	public void rechercheSon() {
		System.out.println("Veuliiez choisir un extrait sonore (le nom de son descripteur) :");
		nom = clavier.nextLine();

		DescripteurSon extrait = new DescripteurSon(nom);

		System.out.println("Veuliiez choisir le nombre d'occurences minimum");
		nombreOccurence = clavier.nextInt();

		resultat = crses.rechercheEnregistrementAudio(extrait);

		if (resultat.nombreOccurence < nombreOccurence) {
			System.out.println("Aucun resultat n'as été trouvé");
		} else {
			System.out.println(
					"L'extrait est joué " + resultat.nombreOccurence + " fois dans le corpus nommé " + resultat.nom);
		}
	}
}
