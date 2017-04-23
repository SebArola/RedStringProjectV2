package test;

import java.awt.Dimension;
import java.awt.Toolkit;

import controleur.ControlleurFichier;
import vueGraphique.Fenetre;
import vueText.VueComparaisonFichier;

public class testComparaison {

	public static void main(String args[]) {
		// VueComparaisonFichier vue = new VueComparaisonFichier();
		ControlleurFichier ctrl_fic = ControlleurFichier.getInstance();
		// Image 1
		ctrl_fic.addFichier("cheminIM195", "Image", "descIM195");
		ctrl_fic.addFichier("cheminIM185", "Image", "descIM185");
		ctrl_fic.addFichier("cheminIM195", "Image", "descIM195");
		ctrl_fic.addFichier("cheminIM185", "Image", "descIM185");
		ctrl_fic.addFichier("cheminIM195", "Image", "descIM195");
		ctrl_fic.addFichier("cheminIM185", "Image", "descIM185");

		// Image 2
		ctrl_fic.addFichier("cheminIM295", "Image", "descIM295");
		ctrl_fic.addFichier("cheminIM285", "Image", "descIM285");

		// Texte 1
		ctrl_fic.addFichier("cheminTXT175", "Texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT165", "Texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT195", "Texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT185", "Texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT17", "Texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT16", "Texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT19", "Texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT18", "Texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT151", "Texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT152", "Texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT153", "Texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT154", "Texte", "descTXT185");
		ctrl_fic.addFichier("cheminTXT11", "Texte", "descTXT175");
		ctrl_fic.addFichier("cheminTXT12", "Texte", "descTXT165");
		ctrl_fic.addFichier("cheminTXT13", "Texte", "descTXT195");
		ctrl_fic.addFichier("cheminTXT14", "Texte", "descTXT185");

		// Texte 2
		ctrl_fic.addFichier("cheminTXT295", "Texte", "descTXT295");
		ctrl_fic.addFichier("cheminTXT285", "Texte", "descTXT285");

		// vue.vueComparaisonFichier();
		Fenetre fen = new Fenetre();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fen.setLocation(dim.width / 2 - fen.getWidth() / 2, dim.height / 2 - fen.getHeight() / 2);
		fen.setVisible(true);
	}

}
