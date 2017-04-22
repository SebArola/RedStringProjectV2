package controlleur;

import model.Administrateur;
import model.BDAdmin;

public class ControleurCreerProfil {
	private BDAdmin bdAdmin=BDAdmin.getInstanceBDAdmin();
	//son role est de permettre la création des admin. On a fait abstraction de son boundary, car faut bien que l'admin soit pre-enregistrer dans la base
	public void creerProfilAdmin(String nomAdmin, String prenom, String mdp){
		String login=""+nomAdmin+"."+prenom;
		if(!(bdAdmin.rechercherAdmin(login, mdp))){
			//System.out.println("test rechercherAdmin de controlcrerProfil"); //TODO test pour detecter passage
			new Administrateur(nomAdmin, prenom, mdp, login);
		}
	}
}
