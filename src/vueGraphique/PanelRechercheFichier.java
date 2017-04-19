package vueGraphique;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
		Object tabChemin[] = resultat.keySet().toArray();
		tabChemin = this.quickSort(tabChemin, 0, tabChemin.length - 1);
		// for (Object chemin : tabPourcentage) {
		// System.out.println("Resultat n°" + i + " :\n - Fichier : " + chemin +
		// "\n - Similaritée : "
		// + resultat.get(chemin));
		// i++;
		// }
		if(tabChemin.length>0){

			if (type.equals("Texte")) {
				Runtime runtime = Runtime.getRuntime();
				try {
					
					runtime.exec(new String[] { "gedit", (String) tabChemin[0] });
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (type.equals("Image")) {
				JFrame image = new JFrame("Premier résultat");
				class panelImage extends JPanel {
					Image resultat;

					public panelImage(String s) {
						resultat = getToolkit().getImage(s);
					}

					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(resultat, 0, 0, getWidth(), getHeight(), this);
					}
				}
				image.add(new panelImage((String) tabChemin[0]));
				image.setSize(300,200);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				image.setLocation(dim.width / 2 - image.getWidth() / 2, dim.height / 2 - image.getHeight() / 2);
				
				image.setVisible(true);
			}
	
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
