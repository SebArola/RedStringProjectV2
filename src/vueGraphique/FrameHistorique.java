package vueGraphique;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTable;

import controleur.ControleurHistorique;

public class FrameHistorique extends JFrame implements Observer {
	private ControleurHistorique ctrl_historique;
	private JTable jt_tableau;
	private String[][] historique;
	private int nbElement;
	
	public FrameHistorique() {
		super("Historique");
		this.ctrl_historique = new ControleurHistorique();
		this.historique = new String[10][3];
		this.nbElement = 0;
		this.jt_tableau = new JTable(historique, new String[] {"Recherche","Type fichier", "Nb résultat"});
		this.getContentPane().add(this.jt_tableau.getTableHeader(), BorderLayout.NORTH);
		this.getContentPane().add(this.jt_tableau, BorderLayout.CENTER);
		this.ctrl_historique.addObserver(this);
		this.pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String[] recherche = (String[]) arg1;

		if(this.nbElement>=this.historique.length){
			String[][] tab_temp = this.historique;
			this.historique = new String[this.nbElement+10][3];
			for(int i=0; i<tab_temp.length;i++){
				this.historique[i][0] = tab_temp[i][0];
				this.historique[i][1] = tab_temp[i][1];
				this.historique[i][2] = tab_temp[i][2];
			}
		}
		this.historique[this.nbElement][0] = recherche[0];
		this.historique[this.nbElement][1] = recherche[1];
		this.historique[this.nbElement][2] = recherche[2];
		this.nbElement++;
		this.jt_tableau.revalidate();
		this.jt_tableau.repaint();
	}
	
	

}
