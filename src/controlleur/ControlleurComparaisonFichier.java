package controlleur;

import java.util.HashMap;

import model.Fichier;

public class ControlleurComparaisonFichier {

	public ControlleurComparaisonFichier() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, String> comparaisonFichier(String chemin, String type) {
		Fichier fic = new Fichier(chemin, type, ControlleurFichier.getInstance().genDescripteur(chemin, type));
		int pourcentage;
		HashMap<Integer, String> resultat = new HashMap();//<pourcentage, chemin>
		//pourcentage = compareFichierImage  // C'est la fonction C
		for(Fichier f : ControlleurFichier.getInstance().getAllFichier(type) ){
			//pourcentage = compareFichierImage (fic, f.getDescripteur);
			pourcentage = 81;
			if(pourcentage >=80){
				resultat.put(pourcentage, f.getChemin());
			}
		}
		
		return resultat;
	}

}
