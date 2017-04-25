package vueText;

import java.util.HashMap;
import java.util.Scanner;

import controleur.ControlleurRechercheParMotsCles;

public class BoundaryRechercheParMotsCles {

	Scanner clavier = new Scanner(System.in);
	private ControlleurRechercheParMotsCles crpmc;// = new
													// ControlleurRechercheParMotsCles();

	public BoundaryRechercheParMotsCles(ControlleurRechercheParMotsCles controlrpmc) {
		crpmc = controlrpmc;
	}

	public void rechercheParMotsCles() {
		HashMap<String, Integer> mapTxt = new HashMap<String, Integer>();
		boolean isCorrect;
		String lecture;

		do {
			System.out.println("Veulliez rentrez les mots cles : ");
			lecture = clavier.nextLine();
			// System.out.println("LOL =" + lecture + "=");
			isCorrect = crpmc.verifierMotsCles(lecture);
			if (!isCorrect)
				System.out.println("Erreur de saisie Veuillez recommencer.");
			else
				System.out.println("Saisie Validée !");
		} while (!isCorrect);

		mapTxt = crpmc.rechercheTexte(lecture);
		if (mapTxt.size() > 0)
			for (int i = 0; i < mapTxt.size(); i++)
				System.out.println("Resultat " + (i + 1) + " = " + mapTxt.get(i));
		else
			System.out.println("La recherche n'as rien donné");

	}

}
