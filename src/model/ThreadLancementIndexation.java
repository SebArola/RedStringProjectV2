package model;


public class ThreadLancementIndexation extends Thread{
	
	private Descripteur descripteur=new Descripteur();
	private TypeFichier type;
	private int nbMots;
	
	/*methods*/
	private void lancerIndexation()  throws Exception {
		
		try {
			final Process p=Runtime.getRuntime().exec("./CodePhase1/Src/Indexation/./controlleurIndexation.o");
			System.out.println("Je suis passe dans le lancerIndexation");
			descripteur.getDescripteurGenere(type, nbMots);
			System.out.println("Type: "+type+ " "+nbMots);
			//System.out.println(" "+p.getOutputStream().toString());;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	
	}
	
	public void run(){
		try {
			System.out.println("Je suis passe danss le Run");
			this.lancerIndexation();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	public void genererDescripteur(TypeFichier type, int nbMots) {
		this.type=type;
		this.nbMots=nbMots;
		
	}
		
}
