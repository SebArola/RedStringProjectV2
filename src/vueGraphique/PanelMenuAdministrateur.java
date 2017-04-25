package vueGraphique;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.fichierConfig;

public class PanelMenuAdministrateur extends JPanel{
	
	public PanelMenuAdministrateur(){
		super(new GridLayout(7,2));
		this.add(new JLabel("Chemin base de données"));
		this.add(new JTextField(fichierConfig.getInstance().getCheminBD()));
		this.add(new JLabel("Seuil comparaison image"));
		this.add(new JTextField(fichierConfig.getInstance().getSeuilComparaisonImage()));
		this.add(new JLabel("Seuil comparaison texte"));
		this.add(new JTextField(fichierConfig.getInstance().getSeuilComparaisonTexte()));
		this.add(new JLabel("Seuil comparaison son"));
		this.add(new JTextField(fichierConfig.getInstance().getSeuilComparaisonSon()));
		this.add(new JLabel("Nombre de quantification"));
		this.add(new JTextField(fichierConfig.getInstance().getNbQuantif()));
		
	}
}
