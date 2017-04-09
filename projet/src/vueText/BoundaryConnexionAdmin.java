package vueText;

import java.util.Scanner;

import controlleur.ControleurConnexionAdmin;

public class BoundaryConnexionAdmin {
	private ControleurConnexionAdmin controleurConnexionAdmin;
	Scanner readScanner=new Scanner(System.in);
	int numProfil;
	
	/*Constructeur*/
	public BoundaryConnexionAdmin(ControleurConnexionAdmin controleConnexionAdmin){
		this.controleurConnexionAdmin=controleConnexionAdmin;
	}
	
	/*methodes*/
	public int connexionAdmin(){//methode pour la saisie des infos de l'user
		String mdpAdmin;
		String loginAdmin;
		
		System.out.println("Entrez votre login!");
		loginAdmin=readScanner.nextLine();
		
		System.out.println("Entrer votre mot de passe!");
		mdpAdmin=readScanner.nextLine();
		
		numProfil=controleurConnexionAdmin.connexionAdministrateur(loginAdmin, mdpAdmin);
		//System.out.println("numero Profil:"+numProfil);
		return numProfil;
	}

}
