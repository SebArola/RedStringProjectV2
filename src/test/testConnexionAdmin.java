package test;

import controleur.ControleurConnexionAdmin;
import controleur.ControleurCreerProfil;
import vueText.BoundaryConnexionAdmin;

public class testConnexionAdmin {
	
	public static void main(String args[]){
		int numeroProfil;
		ControleurCreerProfil controleuCreerProfil=new ControleurCreerProfil();
		ControleurConnexionAdmin controleurConnexionAdmin=new ControleurConnexionAdmin();
		BoundaryConnexionAdmin vueConnexionAdmin=new BoundaryConnexionAdmin(controleurConnexionAdmin);
		
		controleuCreerProfil.creerProfilAdmin("Nengwe", "Roger", "ntaf");
		controleuCreerProfil.creerProfilAdmin("Leguillou", "Aurelien", "aur");
		controleuCreerProfil.creerProfilAdmin("Delarue", "Etienne", "Der");
		controleuCreerProfil.creerProfilAdmin("Arola", "Sebastien", "seb");
		controleuCreerProfil.creerProfilAdmin("Tara", "Lemaire", "Lem");
		
		numeroProfil= vueConnexionAdmin.connexionAdmin();
		System.out.println("numero profil: "+numeroProfil);
		
	}
}
