package test;

import model.fichierConfig;
import vueText.VueChangerParametresIndexation;

public class TestFichierConfig {
	
	public static void main(String[] args) {
		VueChangerParametresIndexation vue = new VueChangerParametresIndexation();
		vue.changerParametresIndexation();
		System.out.println("NBQUANTIF: " + fichierConfig.getInstance().getNbQuantif());
		System.out.println("NBMOTS: " + fichierConfig.getInstance().getNbMots());
	}
	
}
