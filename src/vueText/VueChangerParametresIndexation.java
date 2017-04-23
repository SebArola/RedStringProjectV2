package vueText;

import java.util.Scanner;

import controleur.ControlleurChangerParametresIndexation;

public class VueChangerParametresIndexation {
	private ControlleurChangerParametresIndexation controlleurChangerParametresIndexation;
	
	public VueChangerParametresIndexation(){
		controlleurChangerParametresIndexation = new ControlleurChangerParametresIndexation();
	}
	
	public void changerParametresIndexation(){
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		int choix;
		int param;
		boolean choixBon;
		do{
			System.out.println("Quelle parametre souhaitez-vous modifier ?"
					+ "\n1: Nombres de bits de quantifications (image)"
					+ "\n2: Nombres de mots-cles par descripteur (texte)");
			choix = clavier.nextInt();
			switch(choix){
			case 1:
				choixBon = true;
				System.out.println("Combien de bits de quantifications lors de l'indexation image ?");
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
