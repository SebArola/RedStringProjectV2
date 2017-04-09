package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TexteMotsCles {
	public String texte;
	public String nom;
	
	
	public TexteMotsCles(TexteMotsCles ds){
		this.texte =ds.texte ;
		this.nom=ds.nom;
	}
	
	public TexteMotsCles(String nom){
		String lecture="";
		try{
			InputStream ips=new FileInputStream(nom); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				lecture+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		this.texte=lecture;
	    this.nom=nom;
	}
	public String toString(){
		return("Nom :"+this.nom +" Descripteur :"+this.texte);
	}
}
