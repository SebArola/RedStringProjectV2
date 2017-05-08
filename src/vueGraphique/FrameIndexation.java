package vueGraphique;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import controleur.ControleurIndexation;
import model.Descripteur;
import model.TypeFichier;

public class FrameIndexation extends JFrame implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5260375365942218393L;
	private ControleurIndexation controleurIndexation;	
	private TypeFichier  type_fichier;
	private String baseDescripteurImage;
	private String baseDescripteurTexte;
	private String baseDescripteurSon;
	private JEditorPane panImage= new JEditorPane();
	private JEditorPane panSon= new JEditorPane();
	private JEditorPane panTexte= new JEditorPane();
	
	private FrameIndexation(){
		super("indexation");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500, 400);
		this.setLocation((dim.width / 2 - this.getWidth() / 2) - this.getWidth()-10,
				(dim.height / 2 - this.getHeight() / 2));
		//this.setVisible(true);
		this.controleurIndexation=new ControleurIndexation();
		controleurIndexation.connectObservers(this);
		
		///s====================>		
		//Texte par défaut		
		
		JTabbedPane onglet=new JTabbedPane();
				
		onglet.addTab("Descripteur image", new JScrollPane(panImage));
		onglet.addTab("Descripteur Son", new JScrollPane(panSon));
		onglet.addTab("Descripteur texte", new JScrollPane(panTexte));
		this.getContentPane().add(onglet);
		boolean t;
		if(this.type_fichier==TypeFichier.IMAGE){
			//onglet.setEnabledAt(0, false);
			t=this.type_fichier==TypeFichier.IMAGE;
			System.out.println(""+t);
		}
	};
	
	

	private static FrameIndexation instance=null;
	
	public static final FrameIndexation getInstance(){
		if(instance==null){
			instance=new FrameIndexation();
		}
		return instance;
	}	
	
	/*methods*/
	public void lancementIndexation(TypeFichier typefichier){
		
		switch (typefichier) {
		case IMAGE:
			controleurIndexation.getDescripteur(TypeFichier.IMAGE, 0);
			//type_fichier=TypeFichier.IMAGE;
			panImage.setText(""+baseDescripteurImage);
			break;
		case TEXTE:
			controleurIndexation.getDescripteur(TypeFichier.TEXTE, 2);
			//type_fichier=TypeFichier.TEXTE;
			panTexte.setText(""+baseDescripteurTexte);
			break;
		case SON:
			controleurIndexation.getDescripteur(TypeFichier.SON, 3);
			//type_fichier=TypeFichier.SON;
			panSon.setText(""+baseDescripteurSon.substring(100));
			break;

		default:
			break;
		}		
	}

	@Override
	public void update(Observable descripteur, Object baseDescripteur) {

		if(descripteur instanceof Descripteur){
			if(baseDescripteur instanceof String[]){
				String labels[]=(String[])baseDescripteur;
				int numLabel=Integer.valueOf(labels[0]);
				
				switch (numLabel) {
				case 1:
					//System.out.println("update image");
					baseDescripteurImage=labels[1];
					break;
				case 2:
					baseDescripteurTexte=labels[1];
					break;
				case 3:
					baseDescripteurSon=labels[1];
					break;
				default:
					break;
				}
			}
		}
		
	}
	
}
