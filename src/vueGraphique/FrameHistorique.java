package vueGraphique;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.ControleurHistorique;

public class FrameHistorique extends JFrame implements Observer {
	private ControleurHistorique ctrl_historique;
	private JTable jt_tableau;
	private String[][] historique;
	private int nbElement;
	private JScrollPane scrollpane;

	public FrameHistorique() {
		super("Historique");

		this.ctrl_historique = new ControleurHistorique();
		this.historique = new String[0][3];
		this.nbElement = 0;
		this.jt_tableau = new JTable(historique, new String[] { "Recherche", "Type fichier", "Nb résultat" });
		this.scrollpane = new JScrollPane(this.jt_tableau);

		this.add(this.scrollpane);
		this.ctrl_historique.addObserver(this);
		this.setSize(250, 400);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String[] recherche = (String[]) arg1;

		String[][] tab_temp = this.historique;
		this.historique = new String[this.nbElement + 1][3];
		for (int i = tab_temp.length - 1; i >= 0; i--) {
			this.historique[i+1][0] = tab_temp[i][0];
			this.historique[i+1][1] = tab_temp[i][1];
			this.historique[i+1][2] = tab_temp[i][2];
		}

		this.historique[0][0] = recherche[0];
		this.historique[0][1] = recherche[1];
		this.historique[0][2] = recherche[2];
		this.nbElement++;
		this.jt_tableau = new JTable(historique, new String[] { "Recherche", "Type fichier", "Nb résultat" });
		this.scrollpane.setViewportView(jt_tableau);
	}

}
