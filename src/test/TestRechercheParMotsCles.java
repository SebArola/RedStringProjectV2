package test;

import java.io.IOException;
import java.util.ArrayList;

import controleur.ControleurGenerationDescripteurTexte;
import controleur.ControlleurRechercheParMotsCles;
import model.DescripteurTexte;
import vueText.BoundaryRechercheParMotsCles;

public class TestRechercheParMotsCles {
	public static void main(String[] args) throws IOException {
		ControlleurRechercheParMotsCles controlrpmc = ControlleurRechercheParMotsCles.getInstance();
		BoundaryRechercheParMotsCles brpmc = new BoundaryRechercheParMotsCles(controlrpmc);

		ControleurGenerationDescripteurTexte cgdt = new ControleurGenerationDescripteurTexte();
		ArrayList<DescripteurTexte> liste = cgdt.creationDescripteurTexte("C:\\Users\\alegu\\git\\RedStringProjectV2\\Data\\base_descripteur_texte.txt");
		controlrpmc.ajouterDescripteurListe(liste);
		brpmc.rechercheParMotsCles();
	}
}
