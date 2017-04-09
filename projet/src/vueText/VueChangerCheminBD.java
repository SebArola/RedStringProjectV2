package vueText;

import java.util.Scanner;

import controlleur.ControlleurChangerCheminBD;

public class VueChangerCheminBD {
	private ControlleurChangerCheminBD controlleurChangerCheminBD;
	
	public VueChangerCheminBD(){
		this.controlleurChangerCheminBD = new ControlleurChangerCheminBD();
	}
	
	public void changerCheminBD(){
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez le chemin de votre base de donnée:");
		String chemin = clavier.nextLine();
		controlleurChangerCheminBD.changerCheminBD(chemin);
	}
}
