package vueText;

import java.util.HashMap;
import java.util.Scanner;

import controlleur.ControlleurComparaisonFichier;

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
		for (int i = premier+1; i <= dernier; i++) {
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

	public void vueComparaisonFichier(){
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		String cheminFic, type;
		System.out.println("Entrez le chemin vers le fichier :");
		cheminFic = clavier.nextLine();
		System.out.println("Entrez le type de fichier :");
		type = clavier.nextLine();
		resultat = this.ctrl_compareFichier.comparaisonFichier(cheminFic, type);
		int i = 1;
		Object tabPourcentage[] = resultat.keySet().toArray();
		tabPourcentage = this.quickSort(tabPourcentage, 0, tabPourcentage.length - 1);
		for (Object chemin : tabPourcentage) {
			System.out.println("Resultat n°" + i + " :\n	- Fichier : " + chemin + "\n	- Similaritée : "
					+ resultat.get(chemin));
			i++;
		}
	}

}
