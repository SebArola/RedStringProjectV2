package test;

import model.BDDescripteurImage;
import vueText.VueComparaisonFichier;

public class TestComparaisonImage {
	
	
	public static void main(String[] args) {
		BDDescripteurImage.getInstance().genBaseDescripteurImage();
		VueComparaisonFichier vue = new VueComparaisonFichier();
		vue.comparaisonFichier();
	}
}
