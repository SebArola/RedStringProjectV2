package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.BDDescripteurImage;
import model.DescripteurImage;
import model.DescripteurTexte;
import model.Fichier;
import model.TypeFichier;
import model.fichierConfig;

/**
 * Controlleur du cas comparaison de fichier. Cette classe contient les méthodes
 * permettant de comparer un fichier donné avec ceux de la base de fichier.
 * 
 * @author sebastien
 *
 */

public class ControlleurComparaisonFichier {
	/**
	 * Méthode principal calculant le pourcentage de similaritée entre le
	 * fichier donne et les fichiers de la base du même type.
	 * 
	 * @param chemin
	 * @param type
	 * @return resultat
	 * @throws IOException 
	 */
	public HashMap<String, Integer> comparaisonFichier(String nom, TypeFichier type) throws IOException {
		//Fichier fic = new Fichier(chemin, type, ControlleurFichier.getInstance().genDescripteur(chemin, type));
		int pourcentage = 0;
		HashMap<String, Integer> resultat = new HashMap<String, Integer>();// <pourcentage,
		String chemin = "";													// chemin>
		switch (type) {
		case TEXTE:
			chemin = fichierConfig.getInstance().getCheminBD()+"/Textes/"+nom;
			ControleurGenerationDescripteurTexte cgdt = new ControleurGenerationDescripteurTexte();
			ArrayList<DescripteurTexte> listeDonne = cgdt.creationDescripteurTexte(chemin);
			ArrayList<DescripteurTexte> listeBaseDeDonnee = cgdt.creationDescripteurTexte("C:\\Users\\alegu\\git\\RedStringProjectV2\\Data\\base_descripteur_texte.txt"); // todo a changer crée class BDDescripteur texte
			DescripteurTexte descTextDonne = listeDonne.get(0);
			for (int i=0 ; i < listeBaseDeDonnee.size(); i++)
			{
				DescripteurTexte desCompare = listeBaseDeDonnee.get(i);
				pourcentage = compareFichierTexte(descTextDonne, desCompare);
				
				if(pourcentage >= fichierConfig.getInstance().getSeuilComparaisonTexte()){
					resultat.put(desCompare.getnom(), pourcentage);
				}
			}
				
			break;
		case IMAGE:
			if(nom.contains(".jpg")){
				chemin = fichierConfig.getInstance().getCheminBD()+"/IMG_RGB/"+nom;
			}else if(nom.contains(".bmp")){
				chemin = fichierConfig.getInstance().getCheminBD()+"/IMG_NB/"+nom;
			}
			DescripteurImage descDonne = BDDescripteurImage.getInstance().getAllDescripteursImage().get(chemin);
			for(DescripteurImage d : BDDescripteurImage.getInstance().getAllDescripteursImage().values()){
				if(!chemin.equals(d.getChemin())){
					pourcentage = compareFichierImage(descDonne, d);
				}
				if(pourcentage >= fichierConfig.getInstance().getSeuilComparaisonImage()){
					resultat.put(d.getChemin(), pourcentage);
				}
			}
			break;
		case SON:
			int cpt=0;
				int nb_random = (int)(Math.random()*3)+1;
				if(nb_random == 1){
					resultat.put("corpus_m6.wav", (int)(Math.random()*100));
				}
				else if(nb_random == 2){
					resultat.put("jingle_fi.wav", (int)(Math.random()*100));
					resultat.put("corpus_m6.wav", (int)(Math.random()*100));
				}
				else if(nb_random == 3){
					resultat.put("corpus_fi.wav", (int)(Math.random()*100));
					resultat.put("corpus_m6.wav", (int)(Math.random()*100));
					resultat.put("jingle_fi.wav", (int)(Math.random()*100));
				}
			break;
		}
			/*if (pourcentage >= fichierConfig.getInstance().getSeuilComparaisonFichier()) {
			resultat.put(f.getChemin(), pourcentage);
		}*/ //TODO enlever ça
			return resultat;
		}

	

	/**
	 * Méthodes permettant de comparer deux fixhier image entre eux Pour
	 * l'instant ces méthodes retourne des résultats prédéfini
	 * 
	 * @param descripteur image n°1
	 * @param descripteur image n°2
	 * @return pourcentage
	 */
	private int compareFichierImage(DescripteurImage desc1, DescripteurImage desc2) {
		List<Integer> histo1 = desc1.getHistogramme();
		List<Integer> histo2 = desc2.getHistogramme();
		float diff = 0;
		float total = 0;
		float pourcentage = 0;
		if (desc1.getNbCouleurs() == desc2.getNbCouleurs()) {
			for (int i = 0; i < histo1.size(); i++) {
				diff = diff + Math.abs(histo1.get(i) - histo2.get(i));
				total = total + histo1.get(i);
			}
		} else {
			return -1;
		}
		pourcentage =  (100 -((diff*50) / total));
		if (pourcentage > 0) {
			return (int) pourcentage;
		} else {
			return 0;
		}
	}

	/**
	 * Méthodes permettant de comparer deux fixhier image entre eux Pour
	 * l'instant ces méthodes retourne des résultats prédéfini
	 * 
	 * @param fichierCompare//
	 * @param descripteur
	 * @return pourcentage
	 */
	private int compareFichierTexte(DescripteurTexte desDonne, DescripteurTexte desCompare) {
		String texteCompare = desCompare.gettexte();
		String texteDonne = desDonne.gettexte();
		String[] decoupeCompare = texteCompare.split(" ");
		String[] decoupeDonne = texteDonne.split(" ");
		int nbCompare = (" " + texteCompare + " ").split(" ").length - 1;
		int nbDonne  = (" " + texteDonne + " ").split(" ").length - 1;
		int pourcentage = 0;
		fichierConfig f = fichierConfig.getInstance();
		int nbMots = f.getNbMots();
		for ( int i=nbDonne-nbMots-1; i< nbDonne ;i++)
		{
			for ( int j=nbCompare-nbMots-1 ; j<nbCompare-1;j++)
			{
				if(decoupeDonne[i].equals(decoupeCompare[j]))
				{
					pourcentage = pourcentage+(int)100/nbMots;
					System.out.println("Pourcentage actu ="+pourcentage);
					System.out.println("If ="+decoupeDonne[i]+"=ET="+decoupeCompare[j]+"=");
				}
			}
		}
		if(pourcentage >100)
			pourcentage =100;
		return(pourcentage);
	}

}
