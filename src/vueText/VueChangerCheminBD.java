package vueText;

import java.util.Scanner;

import controleur.ControlleurChangerCheminBD;

public class VueChangerCheminBD {
	private ControlleurChangerCheminBD controlleurChangerCheminBD;
	
	public VueChangerCheminBD(){
		this.controlleurChangerCheminBD = new ControlleurChangerCheminBD();
	}
	
	public void changerCheminBD(){
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez le chemin de votre base de donn�e:");
		String chemin = clavier.nextLine();
		controlleurChangerCheminBD.changerCheminBD(chemin);
	}
}
