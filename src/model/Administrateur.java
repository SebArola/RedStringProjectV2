package model;

public class Administrateur {
	private String loginAdmin;
	private String mdpAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	
	BDAdmin bdAdmin=BDAdmin.getInstanceBDAdmin();
	private boolean connecte=false;
	
	
	
	public Administrateur(String nomAdmin2, String prenom, String mdp, String login) {
		loginAdmin=login;
		nomAdmin=nomAdmin2;
		prenomAdmin=prenom;
		mdpAdmin=mdp;
		bdAdmin.ajouterAdmin(this);
		System.out.println("test Administrateur");
	}

	public String getLoginAdmin() {
		return loginAdmin;
	}
	
	public String getNomAdmin() {
		return nomAdmin;
	}
	
	public String getMdpAdmin(){
		return mdpAdmin;
	}
	public String getPrenomAdmin(){
		return prenomAdmin;
	}

	public boolean selectionProfil(String loginAdmin2, String mdpAdmin2) {
		System.out.println("Login Admin2="+loginAdmin2);
		System.out.println("Login Admin:"+loginAdmin);
		boolean profilOk=false;
		if(this.loginAdmin.equalsIgnoreCase(loginAdmin2) || this.mdpAdmin.equals(mdpAdmin2))
			profilOk=true;
		else
			profilOk=false;
		
		return profilOk;
	}

	public void connexionProfil() {
		connecte=true;		
	}
	
	public boolean isConnecte(){
		return connecte;
	}
	
	
}
