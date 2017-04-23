package controleur;

import model.BDAdmin;;

public class ControleurConnexionAdmin {
	private BDAdmin bdAdmin=BDAdmin.getInstanceBDAdmin();
	public int connexionAdministrateur(String loginAdmin , String mdpAdmin){
		int numProfil;
		numProfil=bdAdmin.connexionAdmin(loginAdmin, mdpAdmin);
		 
		return numProfil;
	}
}
