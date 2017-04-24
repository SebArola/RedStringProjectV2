package vueGraphique;

import java.awt.FlowLayout;
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
import javax.swing.plaf.ColorChooserUI;

import controleur.ControlleurComparaisonFichier;

@SuppressWarnings("serial")
public class PanelRechercheMotCles extends JPanel {

	private JTextField jtxtf_barRecherche;
	private JPanel panelBar;
	private JPanel panelTypeFic;
	private JPanel panelResultat[];
	private JComboBox<String> jcb_typeFic;
	private ControlleurComparaisonFichier ctrl_comparraison;
	private HashMap<String, Integer> resultat;
	private JButton jb_confirm;
	private Object tabChemin[];
	private int i; // ça c'est gitan faite pas gaffe


	public PanelRechercheMotCles() {
		super();
		this.ctrl_comparraison = new ControlleurComparaisonFichier();
		this.setLayout(new GridLayout(6, 3));
		this.panelBar = new JPanel(new GridLayout(2, 1));
		this.panelTypeFic = new JPanel(new GridLayout(3, 4));
		this.jb_confirm = new JButton();
		this.jb_confirm.setIcon(new ImageIcon("Icon/confirm.png"));

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
		this.panelResultat = new JPanel[6];
		this.add(new JLabel());
		for (int i = 0; i < 6; i++) {
			this.panelResultat[i] = new JPanel(new GridLayout(2, 1));
			this.panelResultat[i].add(new JLabel(""));
			this.panelResultat[i].add(new JLabel(""));
			this.add(this.panelResultat[i]);
		}
		this.gestionPanel();
	}

	public void gestionPanel() {

		this.jtxtf_barRecherche.addMouseListener(new MouseListener(){

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
					for (int i = 0; i < 6; i++) {
						remove(panelResultat[i]);
						panelResultat[i] = new JPanel(new GridLayout(2, 1));
						panelResultat[i].add(new JLabel(""));
						panelResultat[i].add(new JLabel(""));
						add(panelResultat[i]);
						panelResultat[i].revalidate();
						panelResultat[i].repaint();
					}
					lancementRechercheMotCles(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
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
					for (int i = 0; i < 6; i++) {
						remove(panelResultat[i]);
						panelResultat[i] = new JPanel(new GridLayout(2, 1));
						panelResultat[i].add(new JLabel(""));
						panelResultat[i].add(new JLabel(""));
						add(panelResultat[i]);
						panelResultat[i].revalidate();
						panelResultat[i].repaint();
					}
					lancementRechercheMotCles(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
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
					for (int i = 0; i < 6; i++) {
						remove(panelResultat[i]);
						panelResultat[i] = new JPanel(new GridLayout(2, 1));
						panelResultat[i].add(new JLabel(""));
						panelResultat[i].add(new JLabel(""));
						add(panelResultat[i]);
						panelResultat[i].revalidate();
						panelResultat[i].repaint();
					}
					lancementRechercheMotCles(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
				}
			}
		});

		this.jb_confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					remove(panelResultat[i]);
					panelResultat[i] = new JPanel(new GridLayout(2, 1));
					panelResultat[i].add(new JLabel(""));
					panelResultat[i].add(new JLabel(""));
					add(panelResultat[i]);
					panelResultat[i].revalidate();
					panelResultat[i].repaint();
				}
				lancementRechercheMotCles(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());

			}
		});
	}

	public void lancementRechercheMotCles(String chemin, String type) {
		if(type.equals("Image")){
			
		}
	}

	private int partitionner(Object[] tab, int premier, int dernier) {
		int j = premier;
		Object temp;
		int pivot = premier;
		for (int i = premier + 1; i <= dernier; i++) {
			if (this.resultat.get(tab[i]) >= this.resultat.get(tab[pivot])) {
				temp = tab[i];
				tab[i] = tab[j];
				tab[j] = temp;
				j++;
			}

		}

		return j;
	}

	private Object[] quickSort(Object[] tab, int premier, int dernier) {
		int pivot = 0;
		if (premier < dernier) {
			pivot = partitionner(tab, premier, dernier);
			tab = this.quickSort(tab, premier, pivot - 1);
			tab = this.quickSort(tab, pivot + 1, dernier);
		}
		return tab;
	}

}
