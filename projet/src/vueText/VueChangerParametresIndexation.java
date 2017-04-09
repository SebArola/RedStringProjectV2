package vueText;

import java.util.Scanner;

import controlleur.ControlleurChangerParametresIndexation;

public class VueChangerParametresIndexation {
	private ControlleurChangerParametresIndexation controlleurChangerParametresIndexation;
	
	public VueChangerParametresIndexation(){
		controlleurChangerParametresIndexation = new ControlleurChangerParametresIndexation();
	}
	
	public void changerParametresIndexation(){
		Scanner clavier = new Scanner(System.in);
		int choix;
		int param;
		boolean choixBon;
		do{
			System.out.println("Quelle paramètre souhaitez-vous modifier ?"
					+ "\n1: Nombres de quantifications (image)"
					+ "\n2: Nombres de mots-clés par descripteur (texte)");
			choix = clavier.nextInt();
			switch(choix){
			case 1:
				choixBon = true;
				System.out.println("Combien de quantifications lors de l'indexation image ?");
				param = clavier.nextInt();
				controlleurChangerParametresIndexation.changerNbQuantif(param);
				break;
			case 2:
				choixBon = true;
				System.out.println("Combien de mots-clé par descripteur ?");
				param = clavier.nextInt();
				controlleurChangerParametresIndexation.changerNbMots(param);
				break;
			default:
				choixBon = false;
				System.out.println("Attention, entrez 1 ou 2.");
				break;
			}
		}while(!choixBon);
		
	}
}
