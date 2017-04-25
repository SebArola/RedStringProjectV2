package test;

import java.io.IOException;
import java.util.ArrayList;

import controleur.ControleurGenerationDescripteurSon;
import controleur.ControleurRechercheSonExtraitSonore;
import model.DescripteurSon;
import vueText.BoundaryRechercheSonExtraitSonore;

public class TesteRechercheExtraitSonore {

	public static void main(String[] args) throws IOException {

		ControleurRechercheSonExtraitSonore controlrses = new ControleurRechercheSonExtraitSonore();
		BoundaryRechercheSonExtraitSonore brses = new BoundaryRechercheSonExtraitSonore(controlrses);

		ControleurGenerationDescripteurSon cgds = new ControleurGenerationDescripteurSon();
		ArrayList<DescripteurSon> liste =cgds.creationDescripteurSon("C:\\Users\\alegu\\git\\loloed\\Data\\base_descripteur_son.txt");
		controlrses.ajouterDescripteurListe(liste);
		brses.rechercheSon();
//"C:\\Users\\alegu\\git\\loloed\\Data\\des.txt
	}
}
