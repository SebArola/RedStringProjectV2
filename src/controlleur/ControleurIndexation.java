package controlleur;

import java.util.Observer;

import model.Descripteur;
import model.TypeFichier;

public class ControleurIndexation {
	private Descripteur descripteur=new Descripteur();
	
	
	public void connectObservers(Observer vueObservateurs){
		this.descripteur.addObserver(vueObservateurs);
	}
	public void getDescripteur(TypeFichier type) {
		/*String descripteur1=*/descripteur.getDescripteurGenere(type);
		
		
	}

}
