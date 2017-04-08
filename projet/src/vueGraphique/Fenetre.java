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

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	private JPanel jp_mainPanel;
	private PanelRechercheFichier panelRFichier;
	private PanelRechercheMotCles panelRMotCles;
	private JMenu jm_menu;
	private JMenuBar jmb_barmenu;
	private JMenuItem[] jmitem_menu;
	private JPanel jpn_souspanel;

	public Fenetre() {
		super("2SATER");
		this.setSize(740, 425);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fermer();
			}
		});
		
		this.jp_mainPanel = new JPanel(new BorderLayout());
		
		this.setContentPane(jp_mainPanel);

		this.panelRFichier = new PanelRechercheFichier();
		this.panelRMotCles = new PanelRechercheMotCles();

		this.jmb_barmenu = new JMenuBar();
		this.jm_menu = new JMenu();
		this.jm_menu.setIcon(new ImageIcon("menu_icon.png"));
		this.jmitem_menu = new JMenuItem[4];

		this.jmitem_menu[0] = new JMenuItem("Recherche par mots clés");
		this.jmitem_menu[1] = new JMenuItem("Recherche par fichier");
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
				// TODO
			}
		});

		this.jmitem_menu[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});

	}

	protected void panelRMotCles() {
		this.jp_mainPanel.remove(this.panelRFichier);
		this.jp_mainPanel.add(this.panelRMotCles);
		this.jp_mainPanel.repaint();
		this.jp_mainPanel.revalidate();
	}

	protected void panelRFichier() {
		this.jp_mainPanel.remove(this.panelRMotCles);
		this.jp_mainPanel.add(this.panelRFichier);
		this.jp_mainPanel.repaint();
		this.jp_mainPanel.revalidate();
	}

	protected void fermer() {
		if (JOptionPane.showConfirmDialog(this, "Voulez vous quitter ?", "Quitter",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

	public static void main(String args[]) {
		Fenetre fen = new Fenetre();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		fen.setLocation(dim.width / 2 - fen.getWidth() / 2, dim.height / 2 - fen.getHeight() / 2);
		fen.setVisible(true);
	}

}
