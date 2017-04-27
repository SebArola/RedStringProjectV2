package test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import controleur.ControleurConnexionAdmin;
import controleur.ControleurCreerProfil;
import controleur.ControleurGenerationDescripteurSon;
import controleur.ControleurGenerationDescripteurTexte;
import controleur.ControleurRechercheSonExtraitSonore;
import controleur.ControlleurRechercheParMotsCles;
import model.BDDescripteurImage;
import model.DescripteurTexte;
import model.fichierConfig;
import vueGraphique.Fenetre;
import vueGraphique.FrameHistorique;
import vueText.BoundaryRechercheParMotsCles;

public class TestComplet {

	public TestComplet() {
		ControleurCreerProfil controleuCreerProfil = new ControleurCreerProfil();
		ControleurConnexionAdmin controleurConnexionAdmin = new ControleurConnexionAdmin();

		controleuCreerProfil.creerProfilAdmin("Nengwe", "Roger", "rog");
		controleuCreerProfil.creerProfilAdmin("Leguillou", "Aurelien", "aur");
		controleuCreerProfil.creerProfilAdmin("Delarue", "Etienne", "eti");
		controleuCreerProfil.creerProfilAdmin("Arola", "Sebastien", "seb");
		controleuCreerProfil.creerProfilAdmin("Lemaire", "Tara", "tar");
		controleuCreerProfil.creerProfilAdmin("admin", "admin", "0");

		ControlleurRechercheParMotsCles controlrpmc = ControlleurRechercheParMotsCles.getInstance();
		ControleurGenerationDescripteurTexte cgdt = ControleurGenerationDescripteurTexte.getInstance();

		fichierConfig.getInstance().loadFichierConfig();
		try {
			BDDescripteurImage.getInstance().genBaseDescripteurImage();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			cgdt.creationDescripteurTexte();
			controlrpmc.ajouterDescripteurListe(cgdt.getListeDescripteurTexte());
			//LOL
			ControleurRechercheSonExtraitSonore.getInstance()
					.ajouterDescripteurListe(new ControleurGenerationDescripteurSon().creationDescripteurSon());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Fenetre fen = new Fenetre();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fen.setLocation(dim.width / 2 - fen.getWidth() / 2, dim.height / 2 - fen.getHeight() / 2);
		fen.setVisible(true);

	}

	public static void main(String args[]) {
		TestComplet testComplet = new TestComplet();
	}

}
