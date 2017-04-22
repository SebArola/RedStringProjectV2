package vueText;

import java.io.IOException;
import java.util.Scanner;

import controlleur.ControleurModifierSeuilComparaison;
import controlleur.ControleurVerifIdentification;
import model.TypeFichier;;

public class BoundaryModifierSeuilComparaison {
	
	ControleurModifierSeuilComparaison cmsc = new ControleurModifierSeuilComparaison();
	ControleurVerifIdentification cvi = new ControleurVerifIdentification();
	boolean verifOk;
	boolean ecritureOK;
	int choix;
	int seuil;
	Scanner clavier = new Scanner(System.in);
	

	public void modifierSeuilComparaison(int numProfil) throws IOException{
		
		verifOk=cvi.verifierIdentification(numProfil);
		
		if (verifOk){
			do{
				System.out.println("===Modification parametre indexation=====\n\n");
				System.out.println("Choisir un choix : ");
				System.out.println("1.Modifier parametre indexation son");
				System.out.println("2.Modifier parametre indexation image");
				System.out.println("3.Modifier parametre indexation texte");
				System.out.println("Votre choix (1,2 ou 3) => ");	
				choix = clavier.nextInt();
				System.out.println("CHOIX : "+choix+" => ");	
			}while((choix !=1)  && (choix !=2) && (choix!=3));
			
			System.out.println("Veuillez rentrer le seuil voulu");	
			seuil = clavier.nextInt();
			
			switch (choix)
			{
				case 1: 
					ecritureOK = cmsc.modificationSeuil(TypeFichier.SON, seuil);
					break;
				case 2: 
					ecritureOK = cmsc.modificationSeuil(TypeFichier.IMAGE, seuil);
					break;
				case 3:	
					ecritureOK = cmsc.modificationSeuil(TypeFichier.TEXTE, seuil);
					break;	
				default : System.out.println("Une erreur a été detectée lors de la lecture.");
			}
			
			if (ecritureOK)
				System.out.println("Changement reussie !");
			else
				System.out.println("Erreur lors de la modification");		
		}
		else{
			System.out.println("Probleme d'identification");
		}
	}
}
