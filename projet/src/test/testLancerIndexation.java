package test;

import controlleur.ControleurConnexionAdmin;
import controlleur.ControleurCreerProfil;
import controlleur.ControleurIndexation;
import controlleur.ControleurVerifIdentification;
import vueText.BoundaryConnexionAdmin;
import vueText.BoundaryLancerIndexation;

public class testLancerIndexation {
		public static void main(String[] args){
			int numeroProfil;
			ControleurVerifIdentification controlVerifId=new ControleurVerifIdentification();
			ControleurCreerProfil controleuCreerProfil=new ControleurCreerProfil();
			ControleurConnexionAdmin controleurConnexionAdmin=new ControleurConnexionAdmin();
			ControleurIndexation ctrlIndexation=new ControleurIndexation();
			BoundaryConnexionAdmin vueConnexionAdmin=new BoundaryConnexionAdmin(controleurConnexionAdmin);
			BoundaryLancerIndexation vueLancerIndexation=new BoundaryLancerIndexation(ctrlIndexation, controlVerifId);
			
			controleuCreerProfil.creerProfilAdmin("Nengwe", "Roger", "ntaf");
			controleuCreerProfil.creerProfilAdmin("Leguillou", "Aurelien", "aur");
			controleuCreerProfil.creerProfilAdmin("Delarue", "Etienne", "Der");
			controleuCreerProfil.creerProfilAdmin("Arola", "Sebastien", "seb");
			controleuCreerProfil.creerProfilAdmin("Tara", "Lemaire", "Lem");
			
			numeroProfil= vueConnexionAdmin.connexionAdmin();
			
			vueLancerIndexation.lancerIndexation(numeroProfil);
			
		}
}
