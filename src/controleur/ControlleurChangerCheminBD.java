package controlleur;

import model.fichierConfig;

public class ControlleurChangerCheminBD {
	public ControlleurChangerCheminBD(){
		
	}
	
	public void changerCheminBD(String c){
		fichierConfig.getInstance().setCheminBD(c);
	}
}
