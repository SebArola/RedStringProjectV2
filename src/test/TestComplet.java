package test;

import java.awt.Dimension;
import java.awt.Toolkit;

import controleur.ControleurConnexionAdmin;
import controleur.ControleurCreerProfil;
import model.BDDescripteurImage;
import model.fichierConfig;
import vueGraphique.Fenetre;
import vueText.BoundaryConnexionAdmin;

public class TestComplet {

	public TestComplet() {
		ControleurCreerProfil controleuCreerProfil=new ControleurCreerProfil();
		ControleurConnexionAdmin controleurConnexionAdmin=new ControleurConnexionAdmin();
		
		controleuCreerProfil.creerProfilAdmin("Nengwe", "Roger", "rog");
		controleuCreerProfil.creerProfilAdmin("Leguillou", "Aurelien", "aur");
		controleuCreerProfil.creerProfilAdmin("Delarue", "Etienne", "eti");
		controleuCreerProfil.creerProfilAdmin("Arola", "Sebastien", "seb");
		controleuCreerProfil.creerProfilAdmin("Lemaire", "Tara", "tar");
		controleuCreerProfil.creerProfilAdmin("admin", "admin", "0");

		fichierConfig.getInstance().loadFichierConfig();
		BDDescripteurImage.getInstance().genBaseDescripteurImage();
			
		Fenetre fen = new Fenetre();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fen.setLocation(dim.width / 2 - fen.getWidth() / 2, dim.height / 2 - fen.getHeight() / 2);
		fen.setVisible(true);
	}
	
	public static void main(String args[]){
		TestComplet testComplet = new TestComplet();
	}

}
