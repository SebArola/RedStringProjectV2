package vueText;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.Descripteur;
import model.TypeFichier;
import controleur.ControleurIndexation;
import controleur.ControleurVerifIdentification;

public class BoundaryLancerIndexation implements Observer{
	private ControleurIndexation ctrlIndexation;
	private ControleurVerifIdentification ctrlVerifIdentification;
	Scanner readScanner=new Scanner(System.in);
	
	private String baseDescripteurImage;
	private String baseDescripteurSon;
	private String baseDescripteurTexte;
	
	public BoundaryLancerIndexation(ControleurIndexation ctrlIndexation, ControleurVerifIdentification ctrlVerifIdentif){
		this.ctrlIndexation=ctrlIndexation;
		this.ctrlVerifIdentification=ctrlVerifIdentif;
		this.ctrlIndexation.connectObservers(this);
	}
	
	
	public void lancerIndexation(int numProfil){
		boolean verificationOK=ctrlVerifIdentification.verifierIdentification(numProfil);
		int continuerPartie=1;
		int choixUser, nbMots=1;
		do {
			if(verificationOK){
				System.out.println("=======Mode administrateur========\n\n");
				System.out.println("\n===Lancement des indexations=====\n\n");
				System.out.println("1. Indexation Image\n2. Indexation Texte\n3.Indexation Sonore");
				choixUser=readScanner.nextInt();
				
				switch (choixUser) {
				case 1:					
					ctrlIndexation.getDescripteur(TypeFichier.IMAGE, nbMots);
					System.out.println(baseDescripteurImage);
					break;
				case 2:
					System.out.println("Entrer le nombre de mot récurrent maximum (0<nbMot<6)");
					nbMots=readScanner.nextInt();
					ctrlIndexation.getDescripteur(TypeFichier.TEXTE, nbMots); //TODO test
					System.out.println(baseDescripteurTexte);
					break;
				case 3:
					ctrlIndexation.getDescripteur(TypeFichier.SON, nbMots);//TODO test, il est possible de l'enlever
					System.out.println(baseDescripteurSon);
					break;
				default:
					break;
				}
				System.out.println("Voulez-vous continuer les indexations?(1, si oui)");
				continuerPartie=readScanner.nextInt();
			}
		} while (continuerPartie==1);
		
			
	}


	@Override
	public void update(Observable descripteur, Object baseDescripteur) { 
		//base Descripteur est un String contenant tous le contenu de la base descripteur
		
		if(descripteur instanceof Descripteur){
			if(baseDescripteur instanceof String[]){
				String labels[]=(String[])baseDescripteur;
				int numLabel=Integer.valueOf(labels[0]);
				
				switch (numLabel) {
				case 1:
					//System.out.println("update image");
					baseDescripteurImage=labels[1];
					break;
				case 2:
					baseDescripteurTexte=labels[1];
					break;
				case 3:
					baseDescripteurSon=labels[1];
					break;
				default:
					break;
				}
			}
		}
		
	}

}
