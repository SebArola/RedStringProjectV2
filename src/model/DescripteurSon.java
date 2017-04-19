package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

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
		this.descripteur=lecture;
	    this.nom=nom;
	    this.nombreOccurence=0;
	}
	public String toString(){
		return("Nom :"+this.nom +" Descripteur :"+this.descripteur);
	}
}
