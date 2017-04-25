package vueGraphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.fichierConfig;

public class PanelMenuAdministrateur extends JPanel{
	private JButton jb_save;
	private JButton jb_cancel;
	private GridLayout grid_layout;
	private JPanel jp_button;
	private JPanel grid_panel;
	private JTextField[] jtxtf_tab;
	
	public PanelMenuAdministrateur(){
		this.grid_layout = new GridLayout(7,2);
		this.grid_layout.setVgap(25);
		GridLayout grid = new GridLayout(1,2);
		grid.setHgap(30);
		this.jp_button = new JPanel(grid);
		this.jb_cancel = new JButton("Annuler");
		this.jb_save = new JButton("Sauvegarder");
		this.jp_button.add(this.jb_save);
		this.jp_button.add(this.jb_cancel);
		this.grid_panel = new JPanel(this.grid_layout);

		this.setLayout(new BorderLayout());
		this.jtxtf_tab = new JTextField[5];
		this.jtxtf_tab[0] = new JTextField(fichierConfig.getInstance().getCheminBD());
		this.jtxtf_tab[1] = new JTextField(""+fichierConfig.getInstance().getSeuilComparaisonImage());
		this.jtxtf_tab[2] = new JTextField(fichierConfig.getInstance().getCheminBD());
		this.jtxtf_tab[3] = new JTextField(fichierConfig.getInstance().getCheminBD());
		this.jtxtf_tab[4] = new JTextField(fichierConfig.getInstance().getCheminBD());

		this.grid_panel.add(new JLabel("Chemin base de données"));
		this.grid_panel.add(this.jtxtf_tab[0]);
		this.grid_panel.add(new JLabel("Seuil comparaison image"));
		this.grid_panel.add(this.jtxtf_tab[1]);
		this.grid_panel.add(new JLabel("Seuil comparaison texte"));
		this.grid_panel.add(new JTextField(""+fichierConfig.getInstance().getSeuilComparaisonTexte()));
		this.grid_panel.add(new JLabel("Seuil comparaison son"));
		this.grid_panel.add(new JTextField(""+fichierConfig.getInstance().getSeuilComparaisonSon()));
		this.grid_panel.add(new JLabel("Nombre de quantification"));
		this.grid_panel.add(new JTextField(""+fichierConfig.getInstance().getNbQuantif()));
		
	
		this.grid_panel.add(this.jp_button);
		this.add(grid_panel,BorderLayout.CENTER);
		this.add(new JLabel("             "),BorderLayout.WEST);
		this.add(new JLabel("                                              "),BorderLayout.EAST);
		this.add(new JLabel("       "),BorderLayout.NORTH);

		this.gestionPanel();
		
	}
	
	private void gestionPanel(){
		this.jb_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jb_save_action();
			}
		});
		
		this.jb_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jb_cancel_action();
				
			}
		});
	}
	
	protected void jb_cancel_action() {
		
	}

	protected void jb_save_action(){
		
	}
}
