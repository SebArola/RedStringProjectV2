package test;

import java.io.IOException;

import control.ControlleurRechercheParMotsCles;
import vue.BoundaryRechercheParMotsCles;

public class TestRechercheParMotsCles {
	public static void main(String[] args) throws IOException {
		BoundaryRechercheParMotsCles brpmc = new BoundaryRechercheParMotsCles();
		ControlleurRechercheParMotsCles controlrpmc = new ControlleurRechercheParMotsCles();
		controlrpmc.ajouterDescripteurListe("Texte1.txt");
		controlrpmc.ajouterDescripteurListe("Texte2.txt");
		controlrpmc.ajouterDescripteurListe("Texte3.txt");
		controlrpmc.ajouterDescripteurListe("Texte4.txt");

		brpmc.crpmc = controlrpmc;
		brpmc.rechercheParMotsCles();
	}

}
