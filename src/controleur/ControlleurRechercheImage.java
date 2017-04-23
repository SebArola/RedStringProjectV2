package controleur;

import java.util.HashMap;

import model.BDDescripteurImage;
import model.Couleur;
import model.DescripteurImage;

public class ControlleurRechercheImage {
	
	public ControlleurRechercheImage(){
		
	}
	
	public String rechercheImage(Couleur c){
		HashMap<String, Integer> resultat = new HashMap();
		String stringResultat = "";
		for(DescripteurImage d : BDDescripteurImage.getInstance().getAllDescripteursImage().values()){
			switch (c){
			case ROUGE:
				if(d.couleurDominante().equals(Couleur.ROUGE))
					resultat.put(d.getChemin(), d.getPourcentageRouge());
				break;
			case VERT:
				if(d.couleurDominante().equals(Couleur.VERT))
					resultat.put(d.getChemin(), d.getPourcentageVert());
				break;
			case BLEU:
				if(d.couleurDominante().equals(Couleur.BLEU))
					resultat.put(d.getChemin(), d.getPourcentageBleu());
				break;
			}
		}
		if(resultat.isEmpty()){
			stringResultat = "Aucune correspondance.";
		}
		else{
			for(String chemin : resultat.keySet()){
				stringResultat = stringResultat + chemin + " : ";
				switch (c){
				case ROUGE:
					stringResultat = stringResultat + "Le rouge domine à " + resultat.get(chemin) + "%\n";
					break;
				case VERT:
					stringResultat = stringResultat + "Le vert domine à " + resultat.get(chemin) + "%\n";
					break;
				case BLEU:
					stringResultat = stringResultat + "Le bleu domine à " + resultat.get(chemin) + "%\n";
					break;
				}
			}
		}
		return stringResultat;	
	}
		
	
}
