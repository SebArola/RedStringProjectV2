package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Descripteur {
	//ICI sera généré tous les descripteurs, ie, la classe modele, qui interagira plus tard avec le C, pour recuperer les fonctions d'indexation.
	
	//On doit pourvoir lire dans les differents fichiers descripteurs genéres par le C.
	
	//Création du lecteur de buffer
	BufferedReader lectureImage;
	BufferedReader lectureSon;
	BufferedReader lectureTexte;

	
	public String getDescripteurGenere(TypeFichier typeFichier ){
		String descripteur="";
		try{

			lectureImage=new BufferedReader(new FileReader("./Data/base_descripteur_image.txt"));
			lectureSon=new BufferedReader(new FileReader("./Data/base_descripteur_son.txt"));
			lectureTexte=new BufferedReader(new FileReader("./Data/base_descripteur_texte.txt"));
			
			switch (typeFichier) {
			case IMAGE:
				do {
					descripteur=lectureImage.readLine();
				} while (descripteur!=null);
				break;
			case TEXTE:
				do {
					descripteur=lectureTexte.readLine();
				} while (descripteur!=null);
				break;
			case SON:
				do {
					descripteur=lectureSon.readLine();
				} while (descripteur!=null);
				break;
			default:
				break;
			}
		}
		catch(IOException e)
		{
			
		}
		return descripteur;
	}
}
