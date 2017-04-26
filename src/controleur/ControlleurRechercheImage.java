package controleur;

import java.util.HashMap;

import model.BDDescripteurImage;
import model.Couleur;
import model.DescripteurImage;

public class ControlleurRechercheImage {
	
	public ControlleurRechercheImage(){
		
	}
	
	public HashMap<String, Integer> rechercheImage(Couleur c){
		HashMap<String, Integer> resultat = new HashMap<String, Integer>();
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
		return resultat;	
	}
		
	
}
