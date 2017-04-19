package vueGraphique;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelMenuAdministrateur extends JPanel{

	
	public PanelMenuAdministrateur(){
		super(new GridLayout(2,1));
		
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame();
		PanelMenuAdministrateur p = new PanelMenuAdministrateur();
		frame.setContentPane(p);
		frame.pack();
		frame.setVisible(true);
	}

}
