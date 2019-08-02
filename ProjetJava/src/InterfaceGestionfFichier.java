import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;


	public class InterfaceGestionfFichier extends JFrame implements ActionListener{
		JToolBar br = new JToolBar();
		Gestion_Fichier g=new Gestion_Fichier();
		JTextField txtTitle=new JTextField() ;  
		

		JTextField txttag=new JTextField();
		JTextField txtAuteur=new JTextField();
		JTextField txtResume=new JTextField();
		JTextField txtCommentaire=new JTextField();
		
		
		JButton btajout=new JButton(new ImageIcon("ajouter.gif"));
		JButton btModifie=new JButton(new ImageIcon("modifier.gif"));
		JButton btsupprimer=new JButton(new ImageIcon("supprimer.gif"));
		JButton btRecherche=new JButton(new ImageIcon("rechercher.gif"));
		JButton btAffiche=new JButton(new ImageIcon("bas-haut-vue-icone-4014-48.png"));
		JButton btAffiche2=new JButton(new ImageIcon("bas-vue-icone-6741-48.png")) ;
	    JButton btcontinue =new JButton("parcourir") ;
		public InterfaceGestionfFichier(){
			
			
			
	getContentPane().setLayout(new BorderLayout());
	GridLayout po=new GridLayout(5,2);
	po.setHgap(10);
	po.setVgap(10);

			JPanel p =new JPanel(po);
			p.add(new JLabel("Title *"));
			p.add(txtTitle);
			p.add(new JLabel("Tag *"));
			p.add(txttag);
			p.add(new JLabel("Auteur"));
			p.add(txtAuteur);
			p.add(new JLabel("Resume"));
			p.add(txtResume);
			p.add(new JLabel("Commentaire"));
			p.add(txtCommentaire);
			br.add(btcontinue) ;
			br.add(btajout);		
			br.add(btModifie);
			br.add(btsupprimer);
			br.add(btRecherche);
			
			br.add(btAffiche);
			br.add(btAffiche2);
	        
			getContentPane().add(br , BorderLayout.NORTH);
			getContentPane().add(p , BorderLayout.CENTER);
			
			btcontinue.addActionListener(this);
			 btajout .addActionListener(this) ; 
			 btModifie.addActionListener(this);
			 btsupprimer.addActionListener(this);
			 btRecherche.addActionListener(this);
			this.setVisible(true);
			this.pack();
			this.setTitle("File Manager");
			this.setResizable(false);
			this.setLocation(250, 250);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g.init();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean res = false;
			// TODO Auto-generated method stub
			if (e.getSource()==btcontinue ){
				
				    
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				} else {
				  System.out.println("No Selection ");
				}

			}
			if(e.getSource()==btajout){
			
					 
				   if (g.RechercheFichier(txtTitle.getText())!=null)
					   
						 javax.swing.JOptionPane.showMessageDialog(null,"le titre de ce fichier existe"); 
				   
				   
				   else{

						 
				 if ((txtTitle.getText().equals("")==true ) || (txttag.getText().equals("")==true ))
				
				 javax.swing.JOptionPane.showMessageDialog(null,"les deux champs titre et tags sont obligatoires"); 
				 else {
		 res=g.AjouterFichier(new Fichier(txtTitle.getText(),txttag.getText(),txtAuteur.getText(),txtResume.getText(),txtCommentaire.getText()));
if(!res){
			 javax.swing.JOptionPane.showMessageDialog(null,"erreur"); 
}
			 txtTitle.setText("") ;
			 txttag.setText("") ; ;
			 txtAuteur.setText("") ; 
			 txtResume.setText("") ; 
			 txtCommentaire.setText("") ;
			 javax.swing.JOptionPane.showMessageDialog(null,"ajout avec succée"); 
 
				 
				 
				
				 }
						 
	}}
		
			
			
			
			if(e.getSource()==btModifie){
				
				  String str=JOptionPane.showInputDialog(null,"donner le titre de fichier"); 

				 if (g.RechercheFichier(str)==null)
					 javax.swing.JOptionPane.showMessageDialog(null,"le fichier n'existe pas"); 
			   
			   
			   else{
				res=   g.ModifierFichier(txtTitle.getText(),txttag.getText(),txtAuteur.getText(),txtResume.getText(),txtCommentaire.getText(),str );
                   if(!res) {
                	   javax.swing.JOptionPane.showMessageDialog(null,"erreur"); 
                   }
                   else {
                   			 txtTitle.setText("") ;
                   			 txttag.setText("") ; ;
                   			 txtAuteur.setText("") ; 
                   			 txtResume.setText("") ; 
                   			 txtCommentaire.setText("") ;
                   			 javax.swing.JOptionPane.showMessageDialog(null,"modification a ete effectuee"); 
                	   
                   }
			   }
			}
		
			if(e.getSource()==btRecherche ){
				   String str=JOptionPane.showInputDialog(null,"donner le choix de recherche :"
				   		+ "  1=avec titre"
				   		+ "  2=avec auteur"
				   		+ "  3=avec tag"); 
				
				 if ((str.equals("")==true )||(str.equals("1")==false)||(str.equals("2")==false)||(str.equals("3")==false) ) {
						 javax.swing.JOptionPane.showMessageDialog(null," ereur "); }
				 else  {
					Fichier f;
					f= g.RechercheFichier(str) ;
					 txtTitle.setText(f.getTitre()) ;
					 txttag.setText(f.getTags())  ;
					 txtAuteur.setText(f.getAuteur()) ;
					 txtResume.setText(f.getResume()) ; 
					 txtCommentaire.setText(f.getCommentaire()) ;

					 




				 
				 }
				  }
				if (e.getSource()== btsupprimer)  {
					 String str=JOptionPane.showInputDialog(null,"donner le titre de fichier"); 

					 if (g.RechercheFichier(str)==null) {
						 javax.swing.JOptionPane.showMessageDialog(null,"le fichier n'existe pas"); 
					 }
						 else {
							res = g.SupprimerFichier(str) ;
							 if(!res) {
								 javax.swing.JOptionPane.showMessageDialog(null,"erreur"); }
								 else
									 javax.swing.JOptionPane.showMessageDialog(null,"le fichier a ete suprimee "); 

							 }
						 }
				   
				   
					
					
				}

			}
			
			
	
		

	
		
		
		
		
		

