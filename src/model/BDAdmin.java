package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class BDAdmin {
	private HashMap<Integer, Administrateur> listeAdmin = new HashMap<>();
	private int numProfil = -1;

	/* singleton */
	private BDAdmin() {
	}

	private static BDAdmin instance = null;

	public static BDAdmin getInstanceBDAdmin() {
		if (instance == null)
			instance = new BDAdmin();
		return instance;
	}
	/* Fin singleton */

	public boolean connexionAdmin(String loginAdmin, String mdpAdmin) {
		for (int i : listeAdmin.keySet()) {
			if (listeAdmin.get(i).getLoginAdmin().equals(loginAdmin)
					&& listeAdmin.get(i).getMdpAdmin().equals(mdpAdmin)) {
				return true;
			}
		}

		return false;
	}

	public void ajouterAdmin(Administrateur administrateur) {
		numProfil++;
		// System.out.println("test de ajouterAdmin:"+numProfil); //Pour
		// détecter que l'ajout a bien fonctionné
		listeAdmin.put(numProfil, administrateur);
	}

	public boolean rechercherAdmin(String login, String mdp) {
		Collection<Administrateur> collection = listeAdmin.values();
		boolean adminExiste = false;
		for (Administrateur admin : collection)
			if (admin.getLoginAdmin().equals(login))
				adminExiste = true;
			else
				adminExiste = false;
		return adminExiste;
	}

	public Administrateur getAdmin(int numProfil2) {
		Administrateur admin = null;
		if (!listeAdmin.isEmpty()) {
			admin = listeAdmin.get(numProfil2);
		}

		return admin;
	}

}
