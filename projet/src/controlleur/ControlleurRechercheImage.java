package controlleur;

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
				stringResultat = stringResultat + chemin + " : "  + resultat.get(chemin) + "% de dominance\n";
			}
		}
		return stringResultat;
	}
	
}
