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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.ControleurHistorique;
import controleur.ControlleurComparaisonFichier;
import model.TypeFichier;
import model.fichierConfig;

@SuppressWarnings("serial")
public class PanelComparaisonFichier extends JPanel {

	private JTextField jtxtf_barRecherche;
	private JPanel panelBar;
	private JPanel panelTypeFic;
	private JPanel panelResultat[];
	private JComboBox<String> jcb_typeFic;
	private ControlleurComparaisonFichier ctrl_comparraison;
	private HashMap<String, Integer> resultat;
	private JButton jb_confirm;
	private Object tabChemin[];
	private ControleurHistorique ctrl_historique;
	private int i; // ça c'est gitan faite pas gaffe

	public PanelComparaisonFichier() {
		super();
		this.ctrl_comparraison = new ControlleurComparaisonFichier();
		this.setLayout(new GridLayout(6, 3));
		this.panelBar = new JPanel(new GridLayout(2, 1));
		this.panelTypeFic = new JPanel(new GridLayout(3, 4));
		this.jb_confirm = new JButton();
		this.jb_confirm.setIcon(new ImageIcon("Icon/confirm.png"));
		this.ctrl_historique = new ControleurHistorique();

		this.jtxtf_barRecherche = new JTextField("Entrez le nom du fichier");
		this.panelBar.add(new JLabel("Comparaison de fichier"));
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

		this.add(new JLabel(new ImageIcon("")));
		this.add(new JLabel(new ImageIcon("Icon/logo_haut.png")));
		this.add(new JLabel(new ImageIcon("")));
		this.add(new JLabel(new ImageIcon("")));
		this.add(new JLabel(new ImageIcon("Icon/logo_bas.png")));
		this.add(new JLabel(new ImageIcon("")));
//		this.add(new JButton());
//		this.add(new JButton());
//		this.add(new JButton());
//		this.add(new JButton());
//		this.add(new JButton());
//		this.add(new JButton());

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
				if (jtxtf_barRecherche.getText().equals("Entrez le nom du fichier"))
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
					for (int i = 0; i < 6; i++) {
						remove(panelResultat[i]);
						panelResultat[i] = new JPanel(new GridLayout(2, 1));
						panelResultat[i].add(new JLabel(""));
						panelResultat[i].add(new JLabel(""));
						add(panelResultat[i]);
						panelResultat[i].revalidate();
						panelResultat[i].repaint();
					}
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
					for (int i = 0; i < 6; i++) {
						remove(panelResultat[i]);
						panelResultat[i] = new JPanel(new GridLayout(2, 1));
						panelResultat[i].add(new JLabel(""));
						panelResultat[i].add(new JLabel(""));
						add(panelResultat[i]);
						panelResultat[i].revalidate();
						panelResultat[i].repaint();
					}
					lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());
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
				lancementComparaisonFichier(jtxtf_barRecherche.getText(), (String) jcb_typeFic.getSelectedItem());

			}
		});
	}

	public void lancementComparaisonFichier(String chemin, String type) {
		this.jtxtf_barRecherche.setText("Entrez le nom du fichier");
		switch (type) {
		case "Texte":
			try {
				this.resultat = this.ctrl_comparraison.comparaisonFichier(chemin, TypeFichier.TEXTE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "Image":
			try {
				this.resultat = this.ctrl_comparraison.comparaisonFichier(chemin, TypeFichier.IMAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "Son":
			try {
				this.resultat = this.ctrl_comparraison.comparaisonFichier(chemin, TypeFichier.SON);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
		if (resultat != null) {
			tabChemin = resultat.keySet().toArray();
			tabChemin = this.quickSort(tabChemin, 0, tabChemin.length - 1);

			if (tabChemin.length > 0) {

				if (type.equals("Texte")) {
					Runtime runtime = Runtime.getRuntime();
					try {

						runtime.exec(new String[] { "gedit", (String) tabChemin[0] });
					} catch (IOException e) {
						e.printStackTrace();
					}
					int j = -1;
					int k = 0;
					int nbElementParZone = 2;
					JButton jb_resultat[] = new JButton[tabChemin.length];
					if (tabChemin.length > 12) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
							this.add(this.panelResultat[i]);
							nbElementParZone = 3;
						}

					} else if (tabChemin.length > 18) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
							this.add(this.panelResultat[i]);
							nbElementParZone = 6;
						}
					}
					for (i = 0; i < tabChemin.length; i++) {
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
								(String) tabChemin[i] + " " + resultat.get((String) tabChemin[i]) + "%");
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
					this.ctrl_historique.addRecherche(chemin, type, i);

				} else if (type.equals("Image")) {
					// gpicview
					String extension = (String) tabChemin[0];
					extension = extension.substring(extension.lastIndexOf(".") + 1);
					if (extension.equals("bmp")) {
						Runtime runtime = Runtime.getRuntime();
						try {

							runtime.exec(new String[] { "gpicview", (String) tabChemin[0] });
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
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
						image.setSize(300, 200);
						Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
						image.setLocation(dim.width / 2 - image.getWidth() / 2, dim.height / 2 - image.getHeight() / 2);

						image.setVisible(true);
					}

					int j = -1;
					int k = 0;
					int nbElementParZone = 2;
					JButton jb_resultat[] = new JButton[tabChemin.length];
					if (tabChemin.length > 12) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
							this.add(this.panelResultat[i]);
							nbElementParZone = 3;
						}

					} else if (tabChemin.length > 18) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
							this.add(this.panelResultat[i]);
							nbElementParZone = 6;
						}
					}
					for (i = 0; i < tabChemin.length; i++) {
						if (i % nbElementParZone == 0) {
							if (j > -1) {
								this.panelResultat[j].repaint();
								this.panelResultat[j].revalidate();
							}
							j++;
							k = 0;
							this.panelResultat[j].removeAll();
						}
						String nom = (String) tabChemin[i];
						nom = nom.substring(nom.lastIndexOf("/") + 1);
						jb_resultat[i] = new JButton(nom + " " + resultat.get((String) tabChemin[i]) + "%");
						jb_resultat[i].addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisJB = (JButton) e.getSource();
								if (thisJB.getText().substring(thisJB.getText().lastIndexOf(".") + 1,
										thisJB.getText().lastIndexOf(" ")).equals("bmp")) {
									Runtime runtime = Runtime.getRuntime();
									try {
										runtime.exec(new String[] { "gpicview",
												fichierConfig.getInstance().getCheminBD() + "/Data/IMG_NG/" + thisJB
														.getText().substring(0, thisJB.getText().lastIndexOf(" ")) });
									} catch (IOException t) {
										t.printStackTrace();
									}
								} else {
									JFrame image = new JFrame(thisJB.getText());
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

									image.add(new panelImage(fichierConfig.getInstance().getCheminBD()
											+ "/Data/IMG_RGB/"
											+ thisJB.getText().substring(0, thisJB.getText().lastIndexOf(" "))));

									image.setSize(300, 200);
									Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
									image.setLocation(dim.width / 2 - image.getWidth() / 2,
											dim.height / 2 - image.getHeight() / 2);

									image.setVisible(true);
								}

							}
						});

						this.panelResultat[j].add(jb_resultat[i]);
					}
					this.ctrl_historique.addRecherche(chemin, type, i);
				} else if (type.equals("Son")) {
					Runtime runtime = Runtime.getRuntime();
					try {

						runtime.exec(new String[] { "play", (String) tabChemin[0] });
					} catch (IOException e) {
						e.printStackTrace();
					}
					int j = -1;
					int k = 0;
					int nbElementParZone = 2;
					JButton jb_resultat[] = new JButton[tabChemin.length];
					if (tabChemin.length > 12) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 1));
							this.add(this.panelResultat[i]);
							nbElementParZone = 3;
						}

					} else if (tabChemin.length > 18) {
						for (int i = 0; i < 6; i++) {
							this.remove(this.panelResultat[i]);
							this.panelResultat[i] = new JPanel(new GridLayout(3, 2));
							this.add(this.panelResultat[i]);
							nbElementParZone = 6;
						}
					}
					for (i = 0; i < tabChemin.length; i++) {
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
								(String) tabChemin[i] + " " + resultat.get((String) tabChemin[i]) + "%");
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
					this.ctrl_historique.addRecherche(chemin, type, i);
				}

			} else {
				JOptionPane.showMessageDialog(this, "Aucun résultat");
			}
			
		}
		resultat = null;
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
