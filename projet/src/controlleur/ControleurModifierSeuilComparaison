package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControleurModifierSeuilComparaison {

	public boolean modificationSeuil(String nomFichier, int seuil) throws IOException {

		switch (nomFichier) {
		case "texte":
			System.out.println("Modification Seuil Texte");
		    try{
		    	File ff = new File("SeuilTexte.txt");
		    	FileWriter ffw=new FileWriter(ff);
		    	ffw.write(String.valueOf( seuil ));
		    	ffw.write("\n"); 
		    	ffw.close(); 
		    	//System.out.println("Chemin absolu du fichier : " + ff.getAbsolutePath());
		    	} catch (Exception e) {}
			break;

		case "son":
			System.out.println("Modification Seuil son");
		    try{
		    	File ff = new File("SeuilSon.txt");
		    	FileWriter ffw=new FileWriter(ff);
		    	ffw.write(String.valueOf( seuil ));
		    	ffw.write("\n"); 
		    	ffw.close(); 
		    	//System.out.println("Chemin absolu du fichier : " + ff.getAbsolutePath());
		    	} catch (Exception e) {}
			break;

		case "image":
			System.out.println("Modification Seuil Image");
		    try{
		    	File ff = new File("SeuilImage.txt");
		    	FileWriter ffw=new FileWriter(ff);
		    	ffw.write(String.valueOf( seuil ));
		    	ffw.write("\n"); 
		    	ffw.close(); 
		    	//System.out.println("Chemin absolu du fichier : " + ff.getAbsolutePath());
		    	} catch (Exception e) {}
			break;

		default:
			System.out.println("Erreur ecriture fichier"); return(false);

		}
		return (true);
	}	
}
