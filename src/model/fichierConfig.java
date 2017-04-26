package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import controleur.ControlleurRechercheImage;

/**
 * Dans cette classe sont réunis tous les attributs midifiable dans le fichier
 * de configuration. Fichier config etant un singleton ils sont accessible
 * depuis n'importe qu'elle classe du programme.
 * 
 * @author sebastien
 *
 */
public class fichierConfig {

	private static fichierConfig instance;
	// private int seuilComparaisonFichier;
	private int nbQuantif;
	private int nbMots;
	private String cheminBD;
	private int seuilComparaisonImage;
	private int seuilComparaisonTexte;
	private int seuilComparaisonSon;

	/**
	 * Dans le constructeur les attributs seront initialisé en fonction du
	 * fichier de configuration.
	 */
	private fichierConfig() {
		//loadFichierConfig();
		this.seuilComparaisonImage = 50;
		this.cheminBD = "/home/etienne/RedStringProject/Data";
	}

	public static fichierConfig getInstance() {
		if (instance == null) {
			instance = new fichierConfig();
		}
		return instance;
	}

	public boolean saveFichierConfig() {
		String fic = this.seuilComparaisonImage + ";" + this.seuilComparaisonTexte + ";" + this.seuilComparaisonSon
				+ ";" + this.nbQuantif + ";" + this.nbMots + ";" + this.cheminBD;
		try {
			FileOutputStream fos = new FileOutputStream(new File(this.cheminBD + "/Data/config.txt"));
			fos.write(fic.getBytes());
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		BDDescripteurImage.getInstance().genBaseDescripteurImage();
		return true;
	}

	public void loadFichierConfig(){
		String load= "";
		try {
			FileInputStream fis = new FileInputStream("Data/config.txt");

			byte[] buf = new byte[1];  
		    int n = 0;
		    while ((n = fis.read(buf)) >= 0) {
		    	for (byte bit : buf) {
		            load += (char) bit ;
		        }
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String split[] = load.split(";");
		this.seuilComparaisonImage = Integer.parseInt(split[0]);
		this.seuilComparaisonTexte = Integer.parseInt(split[1]);
		this.seuilComparaisonSon = Integer.parseInt(split[2]);
		this.nbQuantif = Integer.parseInt(split[3]);
		this.nbMots = Integer.parseInt(split[4]);
		this.cheminBD = split[5];
	}

	public void setSeuilComparaisonSon(int seuil) {
		this.seuilComparaisonSon = seuil;
	}

	public int getSeuilComparaisonSon(){
		return this.seuilComparaisonSon;
	}
	
	public String getCheminBD() {
		return this.cheminBD;
	}

	public void setCheminBD(String c) {
		this.cheminBD = c;
	}

	public int getNbQuantif() {
		return nbQuantif;
	}

	public void setNbQuantif(int nbQuantif) {
		this.nbQuantif = nbQuantif;
	}

	public int getNbMots() {
		return nbMots;
	}

	public void setNbMots(int nbMots) {
		this.nbMots = nbMots;
	}

	public int getSeuilComparaisonImage() {
		return seuilComparaisonImage;
	}

	public void setSeuilComparaisonImage(int seuilComparaisonImage) {
		this.seuilComparaisonImage = seuilComparaisonImage;
	}

	public int getSeuilComparaisonTexte() {
		return seuilComparaisonTexte;
	}

	public void setSeuilComparaisonTexte(int seuilComparaisonTexte) {
		this.seuilComparaisonTexte = seuilComparaisonTexte;
	}

}