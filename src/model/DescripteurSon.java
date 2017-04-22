package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class DescripteurSon {
	public String descripteur;
	public String nom;
	public int nombreOccurence;
	
	
	public DescripteurSon(DescripteurSon ds){
		this.descripteur =ds.descripteur ;
		this.nom=ds.nom;
		this.nombreOccurence=ds.nombreOccurence;
	}
	
	public DescripteurSon(String nom){
		String lecture="";
		try{
			//InputStream ips=new FileInputStream(nom); 
			//InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(new FileReader(nom));
			String ligne="";
			do{
				ligne=br.readLine();
				if(ligne!=null)
					lecture+=ligne+"\n";
			}while (ligne!=null);
				
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		System.out.println("lecture: "+lecture);
		this.descripteur=lecture;
		System.out.println("lecture: "+descripteur);
	    this.nom=nom;
	    this.nombreOccurence=0;
	}
	public String toString(){
		return("Nom :"+this.nom +" Descripteur :"+this.descripteur);
	}
}
