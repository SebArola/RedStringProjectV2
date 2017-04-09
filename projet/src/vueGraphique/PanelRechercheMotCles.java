package vueGraphique;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelRechercheMotCles extends JPanel {
	
	private JTextField jtxtf_barRecherche;
	private JPanel panelBar;
	private JPanel panelTypeFic;
	private JComboBox<String> jcb_typeFic;


	
	public PanelRechercheMotCles(){
		super();
		this.setLayout(new GridLayout(6,3));
		this.panelBar = new JPanel(new GridLayout(2,1));
		this.panelTypeFic = new JPanel(new GridLayout(3,4));

		this.jtxtf_barRecherche = new JTextField("Entrez les mots clés");
		this.panelBar.add(new JButton("2"));
		this.panelBar.add(this.jtxtf_barRecherche);
		
		this.jcb_typeFic = new JComboBox<String>();
		this.jcb_typeFic.addItem("Texte");
		this.jcb_typeFic.addItem("Image");
		this.jcb_typeFic.addItem("Son");

		this.panelTypeFic.add(this.jcb_typeFic);
		this.panelTypeFic.add(new JButton("2"));
		this.panelTypeFic.add(new JButton("2"));
		this.panelTypeFic.add(new JButton("2"));
		this.panelTypeFic.add(new JButton("2"));
		this.panelTypeFic.add(new JButton("2"));
		this.panelTypeFic.add(new JButton("2"));

		this.add(new JButton("2"));this.add(new JButton("2"));this.add(new JButton("2"));
		this.add(new JButton("2"));this.add(new JButton("2"));this.add(new JButton("2"));

		this.add(new JButton("2"));this.add(panelBar);this.add(new JButton("2"));
		this.add(new JButton("2"));this.add(panelTypeFic);this.add(new JButton("2"));
		this.add(new JButton("2"));this.add(new JButton("2"));this.add(new JButton("2"));
		this.add(new JButton("2"));this.add(new JButton("2"));this.add(new JButton("2"));
		this.gestionPanel();
	}
	
	public void gestionPanel(){
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
				jtxtf_barRecherche.setText("");
			}
		});
	}

}
