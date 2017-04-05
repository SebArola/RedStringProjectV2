package vueText;

import java.util.Scanner;

import controlleur.ControlleurComparaisonFichier;

public class VueComparaisonFichier {

	private ControlleurComparaisonFichier ctrl_compareFichier;
	public VueComparaisonFichier() {
		this.ctrl_compareFichier = new ControlleurComparaisonFichier();
	}
	
	public void vueComparaisonFichier(){
		Scanner clavier = new Scanner(System.in);
		String cheminFic, type;
		System.out.println("Entrez le chemin vers le fichier :");
		cheminFic = clavier.nextLine();
		System.out.println("Entrez le type de fichier :");
		type = clavier.nextLine();
		this.ctrl_compareFichier.comparaisonFichier(cheminFic, type);
	}

}
