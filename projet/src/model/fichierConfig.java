package model;

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
	private int seuilComparaisonFichier;
	private int nbQuantif;
	private int nbMots;
	private String cheminBD;

	/**
	 * Dans le constructeur les attributs seront initialisé en fonction du
	 * fichier de configuration.
	 */
	private fichierConfig() {
		this.seuilComparaisonFichier = 80;
		this.nbQuantif = 3;
		this.nbMots = 5;
	}
	
	public static fichierConfig getInstance() {
		if (instance == null) {
			instance = new fichierConfig();
		}
		return instance;
	}

	public int getSeuilComparaisonFichier() {
		return seuilComparaisonFichier;
	}

	public void setSeuilComparaisonFichier(int seuilComparaisonFichier) {
		this.seuilComparaisonFichier = seuilComparaisonFichier;
	}
	
	public String getCheminBD(){
		return this.cheminBD;
	}
	
	public void setCheminBD(String c){
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

}