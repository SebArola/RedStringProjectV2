package vueGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.ControleurConnexionAdmin;
import vueGraphique.ZDialog;
import model.fichierConfig;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	private JPanel jp_mainPanel;
	private PanelComparaisonFichier panelRFichier;
	private PanelRechercheMotCles panelRMotCles;
	private JMenu jm_menu;
	private JMenuBar jmb_barmenu;
	private JMenuItem[] jmitem_menu;
	private JPanel jpn_souspanel;
	private PanelMenuAdministrateur panelMenuAdmin;
	private ControleurConnexionAdmin ctrl_coAdmin;
	private FrameHistorique historique;
	private FrameIndexation jf_indexation;
	
	public Fenetre() {
		super("2SATER");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.historique = new FrameHistorique();
		this.jf_indexation=FrameIndexation.getInstance();//frame indexation
				
		this.setSize(920, 475);
		historique.setLocation((dim.width / 2 - this.getWidth() / 2) + this.getWidth(),
				(dim.height / 2 - this.getHeight() / 2));
		historique.setVisible(true);
		historique.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fermer();
			}
		});

		this.jp_mainPanel = new JPanel(new BorderLayout());

		this.setContentPane(jp_mainPanel);

		this.panelRFichier = new PanelComparaisonFichier();
		this.panelRMotCles = new PanelRechercheMotCles();
		this.panelMenuAdmin = new PanelMenuAdministrateur();
		this.ctrl_coAdmin = new ControleurConnexionAdmin();

		this.jmb_barmenu = new JMenuBar();
		this.jm_menu = new JMenu();
		this.jm_menu.setIcon(new ImageIcon("Icon/menu_icon.png"));
		this.jmitem_menu = new JMenuItem[4];

		this.jmitem_menu[0] = new JMenuItem("Recherche");
		this.jmitem_menu[1] = new JMenuItem("Comparaison de fichier");
		this.jmitem_menu[2] = new JMenuItem("Connexion Administrateur");
		this.jmitem_menu[3] = new JMenuItem("Quitter");

		this.jm_menu.add(jmitem_menu[0]);
		this.jm_menu.add(jmitem_menu[1]);
		this.jm_menu.add(jmitem_menu[2]);
		this.jm_menu.addSeparator();
		this.jm_menu.add(jmitem_menu[3]);

		this.jmb_barmenu.add(this.jm_menu);

		this.setJMenuBar(this.jmb_barmenu);

		this.jp_mainPanel.add(panelRMotCles, BorderLayout.CENTER);

		this.gestion_panel();
	}

	private void gestion_panel() {

		// Evennement
		this.jmitem_menu[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelRMotCles();
			}
		});

		this.jmitem_menu[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelRFichier();
			}
		});

		this.jmitem_menu[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelMenuAdministrateur();
			}
		});

		this.jmitem_menu[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});

	}

	protected void panelMenuAdministrateur() {
		String mdp = "";
		ZDialog zd = new ZDialog(null, "Identification", true);
		String login=zd.getLoginSaisie();
		mdp=zd.getMdpSaisie();
		if(login!=null && mdp != null){
			if(this.ctrl_coAdmin.connexionAdministrateur(login, mdp) ){
				fichierConfig.getInstance().loadFichierConfig();
				this.jp_mainPanel.remove(this.panelRFichier);
				this.jp_mainPanel.remove(this.panelRMotCles);
				this.jp_mainPanel.add(this.panelMenuAdmin);
				this.jp_mainPanel.repaint();
				this.jp_mainPanel.revalidate();
			} else{
				JOptionPane.showMessageDialog(this, "Login ou mot de passe incorrect");

			}
		} 
		
	}

	protected void panelRMotCles() {
		this.jp_mainPanel.remove(this.panelRFichier);
		this.jp_mainPanel.remove(this.panelMenuAdmin);

		this.jp_mainPanel.add(this.panelRMotCles);
		this.jp_mainPanel.repaint();
		this.jp_mainPanel.revalidate();
	}

	protected void panelRFichier() {
		this.jp_mainPanel.remove(this.panelRMotCles);
		this.jp_mainPanel.remove(this.panelMenuAdmin);

		this.jp_mainPanel.add(this.panelRFichier);
		this.jp_mainPanel.repaint();
		this.jp_mainPanel.revalidate();
	}

	protected void fermer() {
		if (JOptionPane.showConfirmDialog(this, "Voulez vous quitter ?", "Quitter",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.historique.dispose();
			this.jf_indexation.dispose();
			this.dispose();
		}
	}

}
