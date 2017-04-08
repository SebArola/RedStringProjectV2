package vueText;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import model.Descripteur;
import model.TypeFichier;
import controlleur.ControleurIndexation;
import controlleur.ControleurVerifIdentification;

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
		int choixUser;
		if(verificationOK){
			System.out.println("=======Mode administrateur========\n\n");
			System.out.println("\n===Lancement des indexations=====\n\n");
			System.out.println("1. Indexation Image\n2. Indexation Texte\n3.Indexation Sonore");
			choixUser=readScanner.nextInt();
			
			switch (choixUser) {
			case 1:
				ctrlIndexation.getDescripteur(TypeFichier.IMAGE);
				System.out.println(baseDescripteurImage);
				break;
			case 2:
				ctrlIndexation.getDescripteur(TypeFichier.TEXTE);
				System.out.println(baseDescripteurTexte);
				break;
			case 3:
				ctrlIndexation.getDescripteur(TypeFichier.SON);
				System.out.println(baseDescripteurSon);
				break;
			default:
				break;
			}
		}
			
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
