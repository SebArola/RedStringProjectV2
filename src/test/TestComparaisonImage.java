package test;

import java.io.IOException;

import model.BDDescripteurImage;
import vueText.VueComparaisonFichier;

public class TestComparaisonImage {
	
	
	public static void main(String[] args) throws IOException {
		BDDescripteurImage.getInstance().genBaseDescripteurImage();
		VueComparaisonFichier vue = new VueComparaisonFichier();
		vue.comparaisonFichier();
	}
}
