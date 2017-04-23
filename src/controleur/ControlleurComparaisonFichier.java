package controleur;


import java.util.HashMap;
import java.util.List;

import model.DescripteurImage;
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
			case "Texte":
				pourcentage = compareFichierTexte(fic, f.getDescripteur());

				break;
			case "Image":
				if(!chemin.equals(f.getChemin())){
					pourcentage = compareFichierImage(BDDescripteurImage.getInstance().getAllDescripteursImage().get(chemin), 
							BDDescripteurImage.getInstance().getAllDescripteursImage().get(f.getChemin()));
				}
				if(pourcentage >= fichierConfig.getInstance().getSeuilComparaisonImage()){
					resultat.put(f.getChemin(), pourcentage);
				}
				break;
			case "Son":
				pourcentage = compareFichierSon(fic, f.getDescripteur());

				break;
			}
			/*if (pourcentage >= fichierConfig.getInstance().getSeuilComparaisonFichier()) {
			resultat.put(f.getChemin(), pourcentage);
		}*/ //TODO enlever ça
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
private int compareFichierImage(DescripteurImage desc1, DescripteurImage desc2) {
	List<Integer> histo1 = desc1.getHistogramme();
	List<Integer> histo2 = desc2.getHistogramme();
	int diff = 0; int total = 0; int pourcentage = 0;
	if(desc1.getNbCouleurs() == desc2.getNbCouleurs()){
		for(int i=0; i<histo1.size(); i++){
			diff = diff + Math.abs(histo1.get(i) - histo2.get(i));
			total = total + histo1.get(i);
		}
	}else{
		return -1;
	}
	pourcentage=(1-((diff*100)/total));
	if(pourcentage > 0){
		return pourcentage;
	}else{
		return 0;
	}
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
