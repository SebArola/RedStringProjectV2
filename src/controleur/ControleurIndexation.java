package controlleur;

import java.util.Observer;

import model.Descripteur;
import model.ThreadLancementIndexation;
import model.TypeFichier;

public class ControleurIndexation {
	private Descripteur descripteur=new Descripteur();
	private ThreadLancementIndexation threadLancementIndexation;
	
	public void connectObservers(Observer vueObservateurs){
		this.descripteur.addObserver(vueObservateurs);
		
	}
	public String getDescripteur(TypeFichier type, int nbMots) {		
		threadLancementIndexation=new ThreadLancementIndexation(type, nbMots);
		Thread threadLancementIndexation1=new Thread(threadLancementIndexation);
		threadLancementIndexation1.start();//On lance l'execution du code. grace a la methode waitfor() dans le thread, on va attendre jusqu'a
		//ce que l'executio soit finit avant d'invoquer la fonction  getDescripteurGenere.		
		//threadLancementIndexation.genererDescripteur(type, nbMots);
		
		try {
		//Thread.sleep(4000);
			this.wait(40000);
		} catch (Exception e) {
		// TODO: handle exception
		}
		/*String descripteur1=*///descripteur.getDescripteurGenere(type, nbMots);	
		String descripteur1=threadLancementIndexation.getDescripteurGenere();
		System.out.println(descripteur1);
		return descripteur1;
	}

}
