package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BDDescripteurImage {
	// avec hashmap
	// private List<DescripteurImage> listeDescripteurImage = new ArrayList<>();
	private HashMap<String, DescripteurImage> listeDescripteurImage = new HashMap();

	private BDDescripteurImage() {
		/*
		 * listeDescripteurImage.put("imageRVB/testDomineRouge1.jpg", new
		 * DescripteurImage("imageRVB/testDomineRouge1.jpg", 47, 30, 23));
		 * listeDescripteurImage.put("imageRVB/testDomineRouge2.jpg", new
		 * DescripteurImage("imageRVB/testDomineRouge2.jpg", 35, 31, 34));
		 * listeDescripteurImage.put("imageRVB/testDomineVert1.jpg", new
		 * DescripteurImage("imageRVB/testDomineVert1.jpg", 12, 56, 32));
		 * listeDescripteurImage.put("imageRVB/testDomineVert2.jpg", new
		 * DescripteurImage("imageRVB/testDomineVert2.jpg", 17, 58, 25));
		 */
	}

	private static class BDDescripteurImageHolder {
		private final static BDDescripteurImage instance = new BDDescripteurImage();
	}

	public static BDDescripteurImage getInstance() {
		return BDDescripteurImageHolder.instance;
	}

	public HashMap<String, DescripteurImage> getAllDescripteursImage() {
		return this.listeDescripteurImage;
	}

	public void genBaseDescripteurImage() throws FileNotFoundException {
		String lecture = "";
		String[] descSplit;
		String[] ligneDesc;
		String[] ligneHisto;
		int debutHistogramme = 0;
		
			InputStream ips = new FileInputStream(fichierConfig.getInstance().getCheminBD()+"/base_descripteur_image.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			try {
				while ((ligne = br.readLine()) != null) {
					lecture += ligne + "\n";
				}
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		descSplit = lecture.split("\n;\n"); // on sépare les différents
											// descripteurs
		for (String s : descSplit) {
			List<Integer> histo = new ArrayList<>();
			ligneDesc = s.split("\n"); // on sépare les lignes du descripteur
			
			int nbCouleurs = Integer.parseInt(ligneDesc[1]);
			String chemin ="";
			if (nbCouleurs == 3) { // on écrit les pourcentages de dominance
				chemin = fichierConfig.getInstance().getCheminBD()+"/IMG_RGB"
						+ ligneDesc[0].substring(ligneDesc[0].lastIndexOf("/"));
				int r = Integer.parseInt(ligneDesc[2]);
				int v = Integer.parseInt(ligneDesc[3]);
				int b = Integer.parseInt(ligneDesc[4]);
				debutHistogramme = 5;
				this.listeDescripteurImage.put(chemin, new DescripteurImage(chemin, r, v, b)); // on
																								// crée
																								// le
																								// descripteur
			} else if (nbCouleurs == 1) {
				 chemin = fichierConfig.getInstance().getCheminBD()+"/IMG_NG"
						+ ligneDesc[0].substring(ligneDesc[0].lastIndexOf("/"));
				debutHistogramme = 2;
				this.listeDescripteurImage.put(chemin, new DescripteurImage(chemin)); // on
																						// crée
																						// le
																						// descripteur
			}
			int i = 0;
			for (String ligneHistogramme : ligneDesc) {
				if (i >= debutHistogramme) {
					ligneHisto = ligneHistogramme.split(" ");
					histo.add(Integer.parseInt(ligneHisto[1])); // on crée
																// l'histogramme
				}
				i++;
			}
			this.listeDescripteurImage.get(chemin).setHistogramme(histo); // on
																			// ajoute
																			// l'histogramme
		}
	}
}