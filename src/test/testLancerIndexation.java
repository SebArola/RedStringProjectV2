package test;

import java.io.IOException;
import java.util.Scanner;

import controleur.ControleurConnexionAdmin;
import controleur.ControleurCreerProfil;
import controleur.ControleurIndexation;
import controleur.ControleurRechercheSonExtraitSonore;
import controleur.ControleurVerifIdentification;
import controleur.ControlleurRechercheParMotsCles;
import model.fichierConfig;
import vueText.BoundaryConnexionAdmin;
import vueText.BoundaryLancerIndexation;
import vueText.BoundaryModifierSeuilComparaison;
import vueText.BoundaryRechercheParMotsCles;
import vueText.BoundaryRechercheSonExtraitSonore;
import vueText.VueChangerCheminBD;
import vueText.VueChangerParametresIndexation;
import vueText.VueRechercheImage;

public class testLancerIndexation {
		public static void main(String[] args) throws IOException{
			int choix;
			int choixContinuer=1;//  variable qui enregistre si l'admin, veut continuer les tests ou pas!
			int continueSearch1=1;
			@SuppressWarnings("resource")
			Scanner readScanner=new Scanner(System.in);
			
			int numeroProfil;
			ControleurVerifIdentification controlVerifId=new ControleurVerifIdentification();
			ControleurCreerProfil controleuCreerProfil=new ControleurCreerProfil();
			ControleurConnexionAdmin controleurConnexionAdmin=new ControleurConnexionAdmin();
			ControleurIndexation ctrlIndexation=new ControleurIndexation();
			ControleurRechercheSonExtraitSonore controlrses = new ControleurRechercheSonExtraitSonore();
			ControlleurRechercheParMotsCles controlrpmc = new ControlleurRechercheParMotsCles();
			
			//BoundaryRechercheParMotsCles brpmc = new BoundaryRechercheParMotsCles(controlrpmc);
			BoundaryConnexionAdmin vueConnexionAdmin=new BoundaryConnexionAdmin(controleurConnexionAdmin);
			BoundaryLancerIndexation vueLancerIndexation=new BoundaryLancerIndexation(ctrlIndexation, controlVerifId);
			BoundaryModifierSeuilComparaison bmsc = new BoundaryModifierSeuilComparaison();//vue seuil comparaison
			//BoundaryRechercheSonExtraitSonore brses = new BoundaryRechercheSonExtraitSonore(controlrses);
			
			VueChangerParametresIndexation vueChangerParametresIndexation = new VueChangerParametresIndexation(); //
			VueChangerCheminBD vueChangerCheminBD=new VueChangerCheminBD();
			VueRechercheImage vue = new VueRechercheImage();
			
			/*initialisation--Ajout administrateur dans la base de donnée*/
			controleuCreerProfil.creerProfilAdmin("Nengwe", "Roger", "ntaf");
			controleuCreerProfil.creerProfilAdmin("Leguillou", "Aurelien", "aur");
			controleuCreerProfil.creerProfilAdmin("Delarue", "Etienne", "Der");
			controleuCreerProfil.creerProfilAdmin("Arola", "Sebastien", "seb");
			controleuCreerProfil.creerProfilAdmin("Tara", "Lemaire", "Lem");
			
			/*Recherche son*/
			
			/*===Test connection de l'administrateur===*/
			
			System.out.println("====Bienvenue dans SaterSearch!!!====\n\n");			
			do {
				System.out.println("====Qui etes vous?===\n1.Administrateur\n2.Utilisateur");
				choix=readScanner.nextInt();
			} while (choix!=1 && choix!=2);
			switch (choix) {
			case 1:
				/*===test connection profil===*/
				numeroProfil= vueConnexionAdmin.connexionAdmin();
				do {
					System.out.println("\n\nVous pouvez:"
							+ "\n1.Lancer Indexation"
							+ "\n2.Modifier parametres indexation "
							+ "\n3.Modifier seuil Comparaison"
							+ "\n4.Modifier chemin BD\n\n");
					choix=readScanner.nextInt();
					
					switch (choix) {
					case 1:
						/*===test lancer Indexation*/
						vueLancerIndexation.lancerIndexation(numeroProfil);
						break;
					case 2:
						/*====test changer parametres indexations=====*/
						vueChangerParametresIndexation.changerParametresIndexation();
						System.out.println("NBQUANTIF: " + fichierConfig.getInstance().getNbQuantif());
						System.out.println("NBMOTS: " + fichierConfig.getInstance().getNbMots());
						break;
					case 3:
						/*====test modifier seuil comparaison====*/					
						bmsc.modifierSeuilComparaison(numeroProfil);
					case 4:
						/*===test Modifier chemin base de donnée===*/
						vueChangerCheminBD.changerCheminBD();
					default:
						break;
					}		
					System.out.println("Voulez vous continuer les tests?(1, si oui");
					choixContinuer=readScanner.nextInt();
					if(choixContinuer==0)
						System.out.println("Merci d'etre passé :) !!");
				} while (choixContinuer==1 || continueSearch1!=1);
				
				
				/*=====Modifier seuil Indexation ====*/
				
				break;
			case 2:
				int continueSearch=1;
				do {
					int choixRecherche; //contient le numero de choix de fichier faite par l'utilisateur
					System.out.println("=====Mode utilisateur!!=====\n\n");
					System.out.println("Que voulez-vous rechercher?"
							+ "\n1.Fichier texte"
							+ "\n2. Fichier image"
							+ "\n3.Fichier son");
					choixRecherche=readScanner.nextInt();
					if(choixRecherche==1){
						/*===Recherche par mots cles===*/
						//controlrpmc.ajouterDescripteurListe("./Data/Texte1.txt");
						//controlrpmc.ajouterDescripteurListe("./Data/Texte2.txt");
						//controlrpmc.ajouterDescripteurListe("./Data/Texte3.txt");
						//controlrpmc.ajouterDescripteurListe("./Data/Texte4.txt");
						
						//brpmc.rechercheParMotsCles();
					}	
					else if(choixRecherche==2){
						/*===Rechercher Image===*/
						vue.rechercheImage();
					}
					else if(choixRecherche==3){
						/*======Recherche son====*/
						//controlrses.ajouterDescripteurListe("./Data/Descripteur1.txt");
						//controlrses.ajouterDescripteurListe("./Data/Descripteur2.txt");
						//controlrses.ajouterDescripteurListe("./Data/Descripteur3.txt");
						//controlrses.ajouterDescripteurListe("./Data/Descripteur4.txt");
						
						controlrses.afficherListe();
						//brses.rechercheSon();
					}					
				System.out.println("Voulez-vous continuer la recherche?(1, si oui)");
				continueSearch=readScanner.nextInt();				
				
				} while (continueSearch==1);				
				break;
			default:
				break;
				
			}
			
			
		}
}
