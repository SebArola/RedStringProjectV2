package controleur;

import java.util.Observer;

import model.Historique;
import vueGraphique.FrameHistorique;

public class ControleurHistorique {
	
	private Historique historique;
	
	public ControleurHistorique(){
		this.historique = Historique.getInstance();
	}

	public void addRecherche(String recherche, String typeFic, int nbResultat){
		this.historique.addRecherche(new String[] {recherche, typeFic, ""+nbResultat});
	}
	
	public void addObserver(Observer o){
		if(o.getClass().equals(FrameHistorique.class)){
			this.historique.addObserver(o);
		}
	}

}
