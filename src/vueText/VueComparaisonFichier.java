package vueText;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import controleur.ControlleurComparaisonFichier;
import model.TypeFichier;

public class VueComparaisonFichier {

	private ControlleurComparaisonFichier ctrl_compareFichier;
	private HashMap<String, Integer> resultat;

	public VueComparaisonFichier() {
		this.ctrl_compareFichier = new ControlleurComparaisonFichier();
		this.resultat = new HashMap<>();
	}

	private int partitionner(Object[] tab, int premier, int dernier) {
		int j = premier;
		Object temp;
		int pivot = premier;
		for (int i = premier + 1; i <= dernier; i++) {
			if (this.resultat.get(tab[i]) >= this.resultat.get(tab[pivot])) {
				temp = tab[i];
				tab[i] = tab[j];
				tab[j] = temp;
				j++;
			}

		}

		return j;
	}

	private Object[] quickSort(Object[] tab, int premier, int dernier) {
		int pivot = 0;
		if (premier < dernier) {
			pivot = partitionner(tab, premier, dernier);
			tab = this.quickSort(tab, premier, pivot - 1);
			tab = this.quickSort(tab, pivot + 1, dernier);
		}
		return tab;
	}

	public void comparaisonFichier() throws IOException {
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		String nomFic;
		boolean choixBon = false;
		int choix;
		System.out.println("Entrez le nom du fichier :");
		nomFic = clavier.nextLine();
		do {
			System.out.println("Type de fichier\n1: Texte\n2: Image\n3: Son");
			choix = clavier.nextInt();
			switch (choix) {
			case 1:
				choixBon = true;
				resultat = ctrl_compareFichier.comparaisonFichier(nomFic, TypeFichier.TEXTE);
				break;
			case 2:
				choixBon = true;
				resultat = ctrl_compareFichier.comparaisonFichier(nomFic, TypeFichier.IMAGE);
				break;
			case 3:
				choixBon = true;
				resultat = ctrl_compareFichier.comparaisonFichier(nomFic, TypeFichier.SON);
				break;
			default:
				choixBon = false;
				System.out.println("Attention, entrez 1, 2 ou 3");
			}
		} while (!choixBon);
		int i = 1;
		Object tabPourcentage[] = resultat.keySet().toArray();
		tabPourcentage = this.quickSort(tabPourcentage, 0, tabPourcentage.length - 1);
		for (Object chemin : tabPourcentage) {
			System.out.println("Resultat n°" + i + " :\n	- Fichier : " + chemin + "\n	- Similaritée : "
					+ resultat.get(chemin) + "%");
			i++;
		}
	}

}
