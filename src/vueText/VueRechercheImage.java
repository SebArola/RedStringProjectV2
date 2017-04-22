package vueText;

import java.util.HashMap;
import java.util.Scanner;

import controlleur.ControlleurRechercheImage;
import model.Couleur;

public class VueRechercheImage {
	private ControlleurRechercheImage controlleurRechercheImage;
	
	public VueRechercheImage(){
		controlleurRechercheImage = new ControlleurRechercheImage();
	}
	
	public void rechercheImage(){
		int choix;
		boolean choixBon;
		String resultat = new String();
		Scanner clavier = new Scanner(System.in);
		do{
			System.out.println("Quelle couleur recherchez-vous ?\n1: Rouge\n2: Vert\n3: Bleu");
			choix = clavier.nextInt();
			switch(choix){
			case 1:
				choixBon = true;
				resultat = controlleurRechercheImage.rechercheImage(Couleur.ROUGE);
				break;
			case 2:
				choixBon = true;
				resultat = controlleurRechercheImage.rechercheImage(Couleur.VERT);
				break;
			case 3:
				choixBon = true;
				resultat = controlleurRechercheImage.rechercheImage(Couleur.BLEU);
				break;
			default:
				choixBon = false;//TODO enleve �a
				System.out.println("Attention, entrez 1, 2 ou 3");
			}
		}while(!choixBon);
		System.out.println(resultat.toString());
	}
}
