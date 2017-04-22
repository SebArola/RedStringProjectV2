package test;

import model.BDDescripteurImage;
import vueText.VueRechercheImage;

public class TestRechercheImage {
	public static void main(String[] args) {
		BDDescripteurImage.getInstance().genBaseDescripteurImage();
		VueRechercheImage vue = new VueRechercheImage();
		vue.rechercheImage();
	}
}
