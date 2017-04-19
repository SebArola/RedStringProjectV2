package test;

import java.io.IOException;

import control.ControleurRechercheSonExtraitSonore;
import vue.BoundaryRechercheSonExtraitSonore;

public class TesteRechercheExtraitSonore {

	public static void main(String[] args) throws IOException {

		ControleurRechercheSonExtraitSonore controlrses = new ControleurRechercheSonExtraitSonore();
		BoundaryRechercheSonExtraitSonore brses = new BoundaryRechercheSonExtraitSonore();
		controlrses.ajouterDescripteurListe("Descripteur1.txt");
		controlrses.ajouterDescripteurListe("Descripteur2.txt");
		controlrses.ajouterDescripteurListe("Descripteur3.txt");
		controlrses.ajouterDescripteurListe("Descripteur4.txt");
		brses.crses=controlrses;
		brses.crses.afficherListe();
		brses.rechercheSon();
	}
}
