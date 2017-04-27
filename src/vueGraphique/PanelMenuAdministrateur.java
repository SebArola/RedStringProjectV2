package vueGraphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.TypeFichier;
import model.fichierConfig;

public class PanelMenuAdministrateur extends JPanel {
	private JButton jb_save;
	private JButton jb_cancel;
	private GridLayout grid_layout;
	private JPanel jp_button;
	private JPanel grid_panel;
	private JTextField[] jtxtf_tab;
	private JPanel jp_ficConfig;
	private JPanel jp_indexation;
	private JTabbedPane tabbedPane;
	private JButton jb_indexationImage;
	private JButton jb_indexationTexte;
	private JButton jb_indexationSon;
	private FrameIndexation fIndexation;

	public PanelMenuAdministrateur() {

		this.jp_ficConfig = new JPanel();
		this.jp_indexation = new JPanel();
		this.tabbedPane = new JTabbedPane();

		this.setupPanelConfig();
		this.setupPanelIndexation();

		this.tabbedPane.add(this.jp_ficConfig, "Fichier de configuration");
		this.tabbedPane.add(this.jp_indexation, "Lancement indexation");

		this.add(tabbedPane);
		
		
		//Frame Indexation
				

		this.gestionPanel();

	}

	private void setupPanelIndexation() {
		GridLayout grid = new GridLayout(6, 5);
		grid.setVgap(20);
		this.jp_indexation.setLayout(grid);

		this.jb_indexationImage = new JButton("Indexation image");
		this.jb_indexationTexte = new JButton("Indexation texte");
		this.jb_indexationSon = new JButton("Indexation son");

		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(this.jb_indexationImage);
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));

		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));

		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(this.jb_indexationTexte);
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));

		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));

		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(this.jb_indexationSon);
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
		this.jp_indexation.add(new JLabel(" "));
	}

	private void setupPanelConfig() {
		this.grid_layout = new GridLayout(7, 2);
		this.grid_layout.setVgap(20);
		GridLayout grid = new GridLayout(1, 2);
		grid.setHgap(30);
		this.jp_button = new JPanel(grid);
		this.jb_cancel = new JButton("Annuler");
		this.jb_save = new JButton("Sauvegarder");
		this.jp_button.add(this.jb_save);
		this.jp_button.add(this.jb_cancel);
		this.grid_panel = new JPanel(this.grid_layout);

		this.jp_ficConfig.setLayout(new BorderLayout());
		this.jtxtf_tab = new JTextField[5];
		this.jtxtf_tab[0] = new JTextField(fichierConfig.getInstance().getCheminBD());
		this.jtxtf_tab[1] = new JTextField("" + fichierConfig.getInstance().getSeuilComparaisonImage());
		this.jtxtf_tab[2] = new JTextField("" + fichierConfig.getInstance().getSeuilComparaisonTexte());
		this.jtxtf_tab[3] = new JTextField("" + fichierConfig.getInstance().getSeuilComparaisonSon());
		this.jtxtf_tab[4] = new JTextField("" + fichierConfig.getInstance().getNbQuantif());

		this.grid_panel.add(new JLabel("Chemin base de données"));
		this.grid_panel.add(this.jtxtf_tab[0]);
		this.grid_panel.add(new JLabel("Seuil comparaison image"));
		this.grid_panel.add(this.jtxtf_tab[1]);
		this.grid_panel.add(new JLabel("Seuil comparaison texte"));
		this.grid_panel.add(this.jtxtf_tab[2]);
		this.grid_panel.add(new JLabel("Seuil comparaison son"));
		this.grid_panel.add(this.jtxtf_tab[3]);
		this.grid_panel.add(new JLabel("Nombre de quantification"));
		this.grid_panel.add(this.jtxtf_tab[4]);

		this.grid_panel.add(this.jp_button);
		this.jp_ficConfig.add(grid_panel, BorderLayout.CENTER);
		this.jp_ficConfig.add(new JLabel("             "), BorderLayout.WEST);
		this.jp_ficConfig.add(new JLabel("                                              "), BorderLayout.EAST);
		this.jp_ficConfig.add(new JLabel("       "), BorderLayout.NORTH);
	}

	private void gestionPanel() {
		fIndexation=FrameIndexation.getInstance();
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
		
		//======>gestion tabPane Indexation
		this.jb_indexationImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fIndexation.lancementIndexation(TypeFichier.IMAGE);
				fIndexation.setVisible(true);
				//fIndexation.panIndexation(TypeFichier.IMAGE);
				
			}
		});
		//actionListenerIndexationSon
		this.jb_indexationSon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fIndexation.lancementIndexation(TypeFichier.SON);
				fIndexation.setVisible(true);
				
			}
		});
		
		//ActionListenerIndexationTexte
		this.jb_indexationTexte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fIndexation.lancementIndexation(TypeFichier.TEXTE);
				fIndexation.setVisible(true);
				
			}
		});
	}

	protected void jb_cancel_action() {
		if (JOptionPane.showConfirmDialog(this, "Voulez vous annuler les modifications ?", "Annuler",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.jtxtf_tab[0].setText(fichierConfig.getInstance().getCheminBD());
			this.jtxtf_tab[1].setText("" + fichierConfig.getInstance().getSeuilComparaisonImage());
			this.jtxtf_tab[2].setText("" + fichierConfig.getInstance().getSeuilComparaisonTexte());
			this.jtxtf_tab[3].setText("" + fichierConfig.getInstance().getSeuilComparaisonSon());
			this.jtxtf_tab[4].setText("" + fichierConfig.getInstance().getNbQuantif());
		}
	}

	protected void jb_save_action() {
		if (JOptionPane.showConfirmDialog(this, "Sauvegarder ?", "Sauvegarder",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (this.jtxtf_tab[0].getText().contains(" ")) {
				String tab_temp[] = this.jtxtf_tab[0].getText().split(" ");
				String temp = "";
				for (int i = 0; i < tab_temp.length; i++) {
					temp += tab_temp[i];
				}
				this.jtxtf_tab[0].setText(temp);

			}
			fichierConfig.getInstance().setCheminBD(this.jtxtf_tab[0].getText());
			fichierConfig.getInstance().setSeuilComparaisonImage(Integer.parseInt(this.jtxtf_tab[1].getText()));
			fichierConfig.getInstance().setSeuilComparaisonTexte(Integer.parseInt(this.jtxtf_tab[2].getText()));
			fichierConfig.getInstance().setSeuilComparaisonSon(Integer.parseInt(this.jtxtf_tab[3].getText()));
			fichierConfig.getInstance().setNbQuantif(Integer.parseInt(this.jtxtf_tab[4].getText()));
			if (!fichierConfig.getInstance().saveFichierConfig()) {
				JOptionPane.showMessageDialog(this, "Chemin d'accés introuvable.Verifier le chemin\nSauvegarde annulée");
			}
		}
	}
}
