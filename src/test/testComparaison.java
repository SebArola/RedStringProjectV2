package test;

import controlleur.ControlleurFichier;
import vueText.VueComparaisonFichier;

public class testComparaison {
	
	public static void main(String args[]){
		VueComparaisonFichier vue = new VueComparaisonFichier();
		ControlleurFichier ctrl_fic = ControlleurFichier.getInstance();
		//Image 1
		ctrl_fic.addFichier("cheminIM195", "image", "descIM195");
		ctrl_fic.addFichier("cheminIM185", "image", "descIM185");
		
		//Image 2
		ctrl_fic.addFichier("cheminIM295", "image", "descIM295");
		ctrl_fic.addFichier("cheminIM285", "image", "descIM285");
		
		//Texte 1
		ctrl_fic.addFichier("cheminTXT175", "texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT165", "texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT195", "texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT185", "texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT17", "texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT16", "texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT19", "texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT18", "texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT151", "texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT152", "texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT153", "texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT154", "texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT11", "texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT12", "texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT13", "texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT14", "texte", "descTXT185");
		
		//Texte 2
		ctrl_fic.addFichier("cheminTXT295", "texte", "descTXT295");
		ctrl_fic.addFichier("cheminTXT285", "texte", "descTXT285");

		vue.vueComparaisonFichier();
	}

}
