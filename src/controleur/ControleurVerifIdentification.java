package controleur;

import model.Administrateur;
import model.BDAdmin;

public class ControleurVerifIdentification {
	BDAdmin bdAdmin=BDAdmin.getInstanceBDAdmin();
	
	public boolean verifierIdentification(int numProfil){
		boolean verifierOk;
		Administrateur admin=bdAdmin.getAdmin(numProfil);
		if(admin.isConnecte())
			verifierOk=true;
		else
			verifierOk=false;
		
		return verifierOk;
		
	}

}
