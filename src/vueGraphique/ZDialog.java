
package vueGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ZDialog extends JDialog {
	private JPasswordField jpf_passWord;
	private JLabel labelLogin, labelMdp;
	private JButton  ok, cancel;
	private JTextField jtf_login;
	private String loginSaisie;
	private String mdpSaisie;
	
  public ZDialog(JFrame parent, String title, boolean modal){
    //On appelle le construteur de JDialog correspondant
    super(parent, title, modal);
    //On spécifie une taille
    this.setSize(350, 150);
    //La position
    this.setLocationRelativeTo(null);
    //La boîte ne devra pas être redimensionnable
    this.setResizable(false);
    //Enfin on l'affiche
	 this.initComponent();
    this.setVisible(true);
    //Tout ceci ressemble à ce que nous faisons depuis le début avec notre JFrame.
  }

private void initComponent() {
	JPanel panPrincipal=new JPanel();
	 panPrincipal.setBackground(new Color(238,238,238));

	    panPrincipal.setPreferredSize(new Dimension(300, 60));
	    jtf_login = new JTextField();
	    jtf_login.setPreferredSize(new Dimension(100, 25));
	    jpf_passWord=new JPasswordField();
	    jpf_passWord.setPreferredSize(new Dimension(100, 25));
	    
	    labelLogin=new JLabel("Entrez le login: ");
	    panPrincipal.add(labelLogin, BorderLayout.EAST);
	    panPrincipal.add(jtf_login, BorderLayout.WEST);
	   
	    labelMdp=new JLabel("Mot de passe: ");	   
	   panPrincipal.add(labelMdp, BorderLayout.EAST);
	   panPrincipal.add(jpf_passWord,BorderLayout.WEST);
	    
	    //pancontent
	    JPanel content = new JPanel();
	    content.setBackground(new Color(238,238,238));
	    content.add(panPrincipal,  BorderLayout.EAST);
	   

	    //gestion des events
	    JPanel control=new JPanel();
	    JButton okBouton = new JButton("OK");
	    okBouton.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent arg0) {        
	    	  mdpSaisie=String.copyValueOf(jpf_passWord.getPassword());
	    	  loginSaisie=jtf_login.getText();
	        //zInfo = new ZDialogInfo(nom.getText(), (String)sexe.getSelectedItem(), getAge(), (String)cheveux.getSelectedItem() ,getTaille());

	        setVisible(false);

	      }
	    });
	    
	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	    	
	        setVisible(false);
	      }
	    });
	     
	    control.add(okBouton);
	    control.add(cancelBouton);
	    
	    this.getContentPane().add(content, BorderLayout.CENTER); 
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	    
	   
	
}
public String getMdpSaisie(){
	return mdpSaisie;
}

public String getLoginSaisie(){
	return loginSaisie;
}
  
  
}