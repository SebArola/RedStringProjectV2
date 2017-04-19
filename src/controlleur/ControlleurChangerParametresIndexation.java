package controlleur;

import model.fichierConfig;

public class ControlleurChangerParametresIndexation {
	
	public ControlleurChangerParametresIndexation(){}

	public void changerNbQuantif(int param) {
		if(param < 1){
			fichierConfig.getInstance().setNbQuantif(1);
		}else if(param > 5){
			fichierConfig.getInstance().setNbQuantif(5);
		}
		else{
			fichierConfig.getInstance().setNbQuantif(param);
		}
	}

	public void changerNbMots(int param) {
		if(param < 1){
			fichierConfig.getInstance().setNbMots(1);
		}else if(param > 5){
			fichierConfig.getInstance().setNbMots(5);
		}else{
			fichierConfig.getInstance().setNbMots(param);
		}
	}
}
