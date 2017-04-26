package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;

public class Descripteur extends Observable{
	//ICI sera généré tous les descripteurs, ie, la classe modele, qui interagira plus tard avec le C, pour recuperer les fonctions d'indexation.
	
	//On doit pourvoir lire dans les differents fichiers descripteurs genéres par le C.
	
	//Création du lecteur de buffer
	BufferedReader lectureImage;
	BufferedReader lectureSon;
	BufferedReader lectureTexte;

	
	public synchronized String getDescripteurGenere(TypeFichier typeFichier,int nbMots ){
		String descripteurParcours=""; //permet denregistrer ligne a ligne le fichier
		String descripteurFichier=" ";
		//int nbMot;
		try{

			lectureImage=new BufferedReader(new FileReader(fichierConfig.getInstance().getCheminBD()+"/Data/base_descripteur_image.txt"));
			lectureSon=new BufferedReader(new FileReader(fichierConfig.getInstance().getCheminBD()+"/Data/base_descripteur_son.txt"));
			lectureTexte=new BufferedReader(new FileReader(fichierConfig.getInstance().getCheminBD()+"/Data/base_descripteur_texte.txt"));
			
			switch (typeFichier) {
			case IMAGE:
				
				do {
					
					super.setChanged();
						//permet d'enregistrer le fichier descripteur
					 //le label contient le numéro correspondant au typeFichier, et la base
					//labels[]={"",""};new String[2]
					String labels[]={"",""};
					descripteurParcours=lectureImage.readLine();
					if(descripteurParcours!=null)
						descripteurFichier+=descripteurParcours+"\n";
					
					//System.out.println(descripteurFichier); 	//TODO test descripteurs
					
					labels[0]="1";
					labels[1]=descripteurFichier;
					
						super.notifyObservers(labels); //descripteur ici est un toString, qui contiet tout mon descripteur
						//System.out.println(labels[1]);
					//}
				} while (descripteurParcours!=null);
				break;
			case TEXTE:
				//nbMot=nbMots; //ceci correspond au nombre d'occurence de mots sera considéré lors de l'indexation
				do {
					super.setChanged();
					//String descripteurFichier=" ";	//permet d'enregistrer le fichier descripteur
					String labels[]=new String[2]; //le label contient le numéro correspondant au typeFichier, et la base
					descripteurParcours=lectureTexte.readLine();
					if(descripteurParcours!=null)
						descripteurFichier+=descripteurParcours+"\n";
					
					labels[0]="2";
					labels[1]=descripteurFichier;
					if(descripteurParcours!=null){
						super.notifyObservers(labels);
					}
				} while (descripteurParcours!=null);
				break;
			case SON:
				do {
					super.setChanged();
					//String descripteurFichier=" ";	//permet d'enregistrer le fichier descripteur
					String labels2[]=new String[2]; //le label contient le numéro correspondant au typeFichier, et la base
					descripteurParcours+=lectureSon.readLine();
					descripteurFichier+=descripteurParcours+"\n";
					
					labels2[0]="3";
					labels2[1]=descripteurFichier;
					if(descripteurParcours!=null)		//pour eviter d'afficher le null, marquant la fin du fichier
						super.notifyObservers(labels2);
				} while (descripteurParcours!=null);
				break;
			default:
				break;
			}			
		}
		catch(IOException e)
		{
			
		}
		return descripteurFichier;
	}	

}
