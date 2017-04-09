package controlleur;

import java.util.HashMap;

import model.Fichier;
import model.fichierConfig;

/**
 * Controlleur du cas comparaison de fichier. Cette classe contient les méthodes
 * permettant de comparer un fichier donné avec ceux de la base de fichier.
 * 
 * @author sebastien
 *
 */
public class ControlleurComparaisonFichier {

	public ControlleurComparaisonFichier() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode principal calculant le pourcentage de similaritée entre le
	 * fichier donne et les fichiers de la base du même type.
	 * 
	 * @param chemin
	 * @param type
	 * @return resultat
	 */
	public HashMap<String, Integer> comparaisonFichier(String chemin, String type) {
		Fichier fic = new Fichier(chemin, type, ControlleurFichier.getInstance().genDescripteur(chemin, type));
		int pourcentage = 0;
		HashMap<String, Integer> resultat = new HashMap();// <pourcentage,
															// chemin>
		for (Fichier f : ControlleurFichier.getInstance().getAllFichier(type)) {
			switch (type) {
			case "texte":
				pourcentage = compareFichierTexte(fic, f.getDescripteur());

				break;
			case "image":
				pourcentage = compareFichierImage(fic, f.getDescripteur());
				break;
			case "son":
				pourcentage = compareFichierSon(fic, f.getDescripteur());

				break;
			}
			if (pourcentage >= fichierConfig.getInstance().getSeuilComparaisonFichier()) {
				resultat.put(f.getChemin(), pourcentage);
			}
		}

		return resultat;
	}

	/**
	 * Méthodes permettant de comparer deux fixhier image entre eux Pour
	 * l'instant ces méthodes retourne des résultats prédéfini
	 * 
	 * @param fichierCompare
	 * @param descripteur
	 * @return pourcentage
	 */
	private int compareFichierImage(Fichier fichierCompare, String descripteur) {
		switch (fichierCompare.getChemin()) {
		case "im1":
			if (descripteur.equals("descIM195")) {
				return 95;
			} else if (descripteur.equals("descIM185")) {
				return 85;
			} else {
				return 0;
			}
		case "im2":
			if (descripteur.equals("descIM295")) {
				return 95;
			} else if (descripteur.equals("descIM285")) {
				return 85;
			} else {
				return 0;
			}
		case "im3":
			if (descripteur.equals("descIM295")) {
				return 95;
			} else if (descripteur.equals("descIM285")) {
				return 85;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * Méthodes permettant de comparer deux fixhier image entre eux Pour
	 * l'instant ces méthodes retourne des résultats prédéfini
	 * 
	 * @param fichierCompare
	 * @param descripteur
	 * @return pourcentage
	 */
	private int compareFichierTexte(Fichier fichierCompare, String descripteur) {
		switch (fichierCompare.getChemin()) {
		case "txt1":
			if (descripteur.equals("descTXT195")) {
				return 95;
			} else if (descripteur.equals("descTXT185")) {
				return 85;
			} else if (descripteur.equals("descTXT175")) {
				return 75;
			} else if (descripteur.equals("descTXT165")) {
				return 65;
			} else {
				return 0;
			}
		case "txt2":
			if (descripteur.equals("descTXT295")) {
				return 95;
			} else if (descripteur.equals("descTXT285")) {
				return 85;
			} else {
				return 0;
			}
		case "im3":
			if (descripteur.equals("descTXT295")) {
				return 95;
			} else if (descripteur.equals("descTXT285")) {
				return 85;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * Méthodes permettant de comparer deux fixhier image entre eux Pour
	 * l'instant ces méthodes retourne des résultats prédéfini
	 * 
	 * @param fichierCompare
	 * @param descripteur
	 * @return pourcentage
	 */
	private int compareFichierSon(Fichier fichierCompare, String descripteur) {
		return 0;
	}

}
