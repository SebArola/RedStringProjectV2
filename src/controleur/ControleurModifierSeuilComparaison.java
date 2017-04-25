package controleur;

//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;

import model.TypeFichier;
import model.fichierConfig;

public class ControleurModifierSeuilComparaison { // je fais un test
	
	public boolean modificationSeuil(TypeFichier typeFichier, int seuil) throws IOException {
		switch (typeFichier) {
		case TEXTE:
			fichierConfig.getInstance().setSeuilComparaisonTexte(seuil);
			break;

		case SON:
			fichierConfig.getInstance().setSeuilComparaisonSon(seuil);
			break;
		case IMAGE:
			fichierConfig.getInstance().setSeuilComparaisonImage(seuil);			
			break;
			 
		}
		return true; // todo acjouter un peu
	}
}
