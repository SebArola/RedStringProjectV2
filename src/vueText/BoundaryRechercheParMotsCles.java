package vueText;

import java.util.ArrayList;
import java.util.Scanner;

import controlleur.ControlleurRechercheParMotsCles;

public class BoundaryRechercheParMotsCles {

	Scanner clavier = new Scanner(System.in);
	private ControlleurRechercheParMotsCles crpmc;// = new ControlleurRechercheParMotsCles();

	public BoundaryRechercheParMotsCles(ControlleurRechercheParMotsCles controlrpmc) {
		crpmc=controlrpmc;
	}

	public void rechercheParMotsCles() {
		ArrayList<String> listeTexte = new ArrayList<String>();
		boolean isCorrect;

		do {
			System.out.println("Veulliez rentrez les mots cles : ");
			String lecture = clavier.nextLine();
			//System.out.println("LOL =" + lecture + "=");
			isCorrect = crpmc.verifierMotsCles(lecture);
			if (!isCorrect)
				System.out.println("Erreur de saisie Veuillez recommencer.");
			else
				System.out.println("Saisie Validée !");
		} while (!isCorrect);
		
		
		listeTexte=crpmc.rechercheTexte();
		if (listeTexte.size() > 0)
			for(int i=0;i< listeTexte.size();i++)
				System.out.println("Resultat "+(i+1)+" = "+listeTexte.get(i));
		else
			System.out.println("La recherche n'as rien donné");
			
	}

}
