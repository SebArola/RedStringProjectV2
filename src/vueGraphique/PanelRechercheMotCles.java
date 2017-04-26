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

import controleur.ControlleurComparaisonFichier;
import controleur.ControlleurRechercheImage;
import controleur.ControlleurRechercheParMotsCles;
import model.Couleur;
import model.TypeFichier;

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
	private Object tabMotCles[];
	private int i; // ça c'est gitan faite pas gaffe
	private ControlleurRechercheParMotsCles ctrl_rechercheMotClesTXT;
	private ControlleurRechercheImage ctrl_rechercheMotClesIm;

	public PanelRechercheMotCles() {
		super();
		this.ctrl_comparraison = new ControlleurComparaisonFichier();
		this.ctrl_rechercheMotClesTXT = new ControlleurRechercheParMotsCles();
		this.ctrl_rechercheMotClesIm = new ControlleurRechercheImage();
		this.setLayout(new GridLayout(6, 3));
		this.panelBar = new JPanel(new GridLayout(2, 1));
		this.panelTypeFic = new JPanel(new GridLayout(3, 4));
		this.jb_confirm = new JButton();
		this.jb_confirm.setIcon(new ImageIcon("Icon/confirm.png"));

		this.jtxtf_barRecherche = new JTextField("Entrez les mot cles");
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
				if (jtxtf_barRecherche.getText().equals("Entrez les mot cles"))
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

	public void lancementRechercheMotCles(String motcles, String type) {
		this.jtxtf_barRecherche.setText("Entrez les mot cles");
		switch (type) {
		case "Texte":
			this.resultat = this.ctrl_rechercheMotClesTXT.rechercheTexte(motcles);
			break;
		case "Image":
			try {
				switch(motcles){
				case "Bleu":
					this.resultat = this.ctrl_rechercheMotClesIm.rechercheImage(Couleur.BLEU);
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "Son":
			try {
				this.resultat = this.ctrl_comparraison.comparaisonFichier(motcles, TypeFichier.SON);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
		tabMotCles = resultat.keySet().toArray();
		tabMotCles = this.quickSort(tabMotCles, 0, tabMotCles.length - 1);
		// for (Object motcles : tabPourcentage) {
		// System.out.println("Resultat n°" + i + " :\n - Fichier : " + motcles +
		// "\n - Similaritée : "
		// + resultat.get(motcles));
		// i++;
		// }
		if (tabMotCles.length > 0) {

			if (type.equals("Texte")) {
				Runtime runtime = Runtime.getRuntime();
				try {

					runtime.exec(new String[] { "gedit", (String) tabMotCles[0] });
				} catch (IOException e) {
					e.printStackTrace();
				}
				int j = -1;
				int k = 0;
				int nbElementParZone = 2;
				JButton jb_resultat[] = new JButton[tabMotCles.length];
				if (tabMotCles.length > 12) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
						this.add(this.panelResultat[i]);
						nbElementParZone = 3;
					}

				} else if (tabMotCles.length > 18) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
						this.add(this.panelResultat[i]);
						nbElementParZone = 6;
					}
				}
				for (i = 0; i < tabMotCles.length; i++) {
					if (i % nbElementParZone == 0) {
						if (j > -1) {
							this.panelResultat[j].repaint();
							this.panelResultat[j].revalidate();
						}
						j++;
						k = 0;
						this.panelResultat[j].removeAll();
					}
					jb_resultat[i] = new JButton(
							(String) tabMotCles[i] + " " + resultat.get((String) tabMotCles[i]) + "%");
					jb_resultat[i].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Runtime runtime = Runtime.getRuntime();
							try {
								JButton thisJB = (JButton) e.getSource();
								runtime.exec(new String[] { "gedit", thisJB.getText() });
							} catch (IOException exception) {
								exception.printStackTrace();
							}

						}
					});

					this.panelResultat[j].add(jb_resultat[i]);
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
				image.add(new panelImage((String) tabMotCles[0]));
				image.setSize(300, 200);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				image.setLocation(dim.width / 2 - image.getWidth() / 2, dim.height / 2 - image.getHeight() / 2);

				image.setVisible(true);

				int j = -1;
				int k = 0;
				int nbElementParZone = 2;
				JButton jb_resultat[] = new JButton[tabMotCles.length];
				if (tabMotCles.length > 12) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
						this.add(this.panelResultat[i]);
						nbElementParZone = 3;
					}

				} else if (tabMotCles.length > 18) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
						this.add(this.panelResultat[i]);
						nbElementParZone = 6;
					}
				}
				for (i = 0; i < tabMotCles.length; i++) {
					if (i % nbElementParZone == 0) {
						if (j > -1) {
							this.panelResultat[j].repaint();
							this.panelResultat[j].revalidate();
						}
						j++;
						k = 0;
						this.panelResultat[j].removeAll();
					}
					jb_resultat[i] = new JButton(
							(String) tabMotCles[i] + " " + resultat.get((String) tabMotCles[i]) + "%");
					jb_resultat[i].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
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
							JButton thisJB = (JButton) e.getSource();
							image.add(new panelImage(thisJB.getText()));
							image.setSize(300, 200);
							Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
							image.setLocation(dim.width / 2 - image.getWidth() / 2,
									dim.height / 2 - image.getHeight() / 2);

							image.setVisible(true);
						}
					});

					this.panelResultat[j].add(jb_resultat[i]);
				}
			} else if (type.equals("Son")) {
				Runtime runtime = Runtime.getRuntime();
				try {

					runtime.exec(new String[] { "play", (String) tabMotCles[0] });
				} catch (IOException e) {
					e.printStackTrace();
				}
				int j = -1;
				int k = 0;
				int nbElementParZone = 2;
				JButton jb_resultat[] = new JButton[tabMotCles.length];
				if (tabMotCles.length > 12) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
						this.add(this.panelResultat[i]);
						nbElementParZone = 3;
					}

				} else if (tabMotCles.length > 18) {
					for (int i = 0; i < 6; i++) {
						this.remove(this.panelResultat[i]);
						this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
						this.add(this.panelResultat[i]);
						nbElementParZone = 6;
					}
				}
				for (i = 0; i < tabMotCles.length; i++) {
					if (i % nbElementParZone == 0) {
						if (j > -1) {
							this.panelResultat[j].repaint();
							this.panelResultat[j].revalidate();
						}
						j++;
						k = 0;
						this.panelResultat[j].removeAll();
					}
					jb_resultat[i] = new JButton(
							(String) tabMotCles[i] + " " + resultat.get((String) tabMotCles[i]) + "%");
					jb_resultat[i].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Runtime runtime = Runtime.getRuntime();
							try {
								JButton thisJB = (JButton) e.getSource();
								runtime.exec(new String[] { "play", thisJB.getText() });
							} catch (IOException exception) {
								exception.printStackTrace();
							}

						}
					});

					this.panelResultat[j].add(jb_resultat[i]);
				}
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
