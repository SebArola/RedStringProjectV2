package vueGraphique;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.ControlleurComparaisonFichier;

@SuppressWarnings("serial")
public class PanelRechercheFichier extends JPanel {

	private JTextField jtxtf_barRecherche;
	private JPanel panelBar;
	private JPanel panelTypeFic;
	private JComboBox<String> jcb_typeFic;
	private ControlleurComparaisonFichier ctrl_comparraison;
	private HashMap<String, Integer> resultat;
	private JButton jb_confirm;

	public PanelRechercheFichier() {
		super();
		this.ctrl_comparraison = new ControlleurComparaisonFichier();
		this.setLayout(new GridLayout(6, 3));
		this.panelBar = new JPanel(new GridLayout(2, 1));
		this.panelTypeFic = new JPanel(new GridLayout(3, 4));
		this.jb_confirm = new JButton();
		this.jb_confirm.setIcon(new ImageIcon("confirm.png"));

		this.jtxtf_barRecherche = new JTextField("Entrez le chemin vers le fichier");
		this.panelBar.add(new JLabel(" "));
		this.panelBar.add(this.jtxtf_barRecherche);

		this.jcb_typeFic = new JComboBox<String>();
		this.jcb_typeFic.addItem("Texte");
		this.jcb_typeFic.addItem("Image");
		this.jcb_typeFic.addItem("Son");

		this.panelTypeFic.add(this.jcb_typeFic);
		this.panelTypeFic.add(new JLabel(" "));
		this.panelTypeFic.add(new JLabel(" "));
		this.panelTypeFic.add(new JLabel(" "));
		this.panelTypeFic.add(new JLabel(" "));
		this.panelTypeFic.add(new JLabel(" "));
		this.panelTypeFic.add(new JLabel(" "));

		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));

		JPanel jp_bouttonConfirm = new JPanel(new GridLayout(2, 5));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(jb_confirm);
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		jp_bouttonConfirm.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(panelBar);
		this.add(jp_bouttonConfirm);
		this.add(new JLabel(" "));
		this.add(panelTypeFic);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));

		this.gestionPanel();
	}

	public void gestionPanel() {
		this.jtxtf_barRecherche.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (jtxtf_barRecherche.getText().equals("Entrez le chemin vers le fichier"))
					jtxtf_barRecherche.setText("");
			}
		});

		this.jtxtf_barRecherche.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
				}
			}
		});

		this.jcb_typeFic.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
				}
			}
		});
		
		this.jb_confirm.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
				}
			}
		});

		this.jb_confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
			}
		});
	}

	public void lancementComparaisonFichier(String chemin, String type) {
		this.jtxtf_barRecherche.setText("Entrez le chemin vers le fichier");
		this.resultat = this.ctrl_comparraison.comparaisonFichier(chemin, type);
	}

}
