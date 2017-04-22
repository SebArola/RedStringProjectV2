package controlleur;

//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;

import model.ModifierSeuilComparaison;
import model.TypeFichier;

public class ControleurModifierSeuilComparaison {
	private ModifierSeuilComparaison modifiSeuilComparaison =new ModifierSeuilComparaison();
	public boolean modificationSeuil(TypeFichier nomFichier, int seuil) throws IOException {
		boolean modifOk;
		switch (nomFichier) {
		case TEXTE:
			modifOk=modifiSeuilComparaison.modifierSeuilComparaison(nomFichier, seuil);
			break;

		case SON:
			modifOk=modifiSeuilComparaison.modifierSeuilComparaison(nomFichier, seuil);
			break;
		case IMAGE:
			modifOk=modifiSeuilComparaison.modifierSeuilComparaison(nomFichier, seuil);
			break;
		default:
			System.out.println("Erreur ecriture fichier"); return(false);

		}
		return modifOk;
	}	
}
