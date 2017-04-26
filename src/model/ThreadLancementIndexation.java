package model;

import java.util.Calendar;
import java.util.Observable;

public class ThreadLancementIndexation /*extends Thread*/  extends Observable implements Runnable{
	
	private Descripteur descripteur=new Descripteur();
	private TypeFichier type;
	private int nbMots;
	private boolean conditionArret=true;
	private String descripteurGenere="";
	private Calendar calendar=Calendar.getInstance();
	int minuteReference;
	
	public ThreadLancementIndexation(TypeFichier type, int nbMots){
		this.type=type;
		this.nbMots=nbMots;
		minuteReference=calendar.get(Calendar.MINUTE);
	}
	/*methods*/
	
	public void run(){
		do {
			try {
				Thread.sleep(20000);
				int minute = calendar.get(Calendar.MINUTE);
				if((minute-minuteReference)<1){
					minuteReference=minute;
					descripteurGenere=descripteur.getDescripteurGenere(type, nbMots);
				}
				descripteurGenere=descripteur.getDescripteurGenere(type, nbMots);
				//System.out.println(descripteurGenere+"\n Je suis dans run");
				
				//System.out.println("Je suis passe dans le Run");
				conditionArret=false;
				//this.lancerIndexation();
			} catch (Exception e) {			
				e.printStackTrace();
			}
		} while (conditionArret);
		
	}

	public void genererDescripteur(TypeFichier type, int nbMots) {
		this.type=type;
		this.nbMots=nbMots;
		
	}
	public String getDescripteurGenere(){
		return descripteurGenere;
	}
		
}
