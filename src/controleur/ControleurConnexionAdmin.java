package controleur;

import model.BDAdmin;;

public class ControleurConnexionAdmin {
	private BDAdmin bdAdmin=BDAdmin.getInstanceBDAdmin();
	public boolean connexionAdministrateur(String loginAdmin , String mdpAdmin){
		return bdAdmin.connexionAdmin(loginAdmin, mdpAdmin);
	}
}
