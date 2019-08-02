import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestion_Fichier {

	private String DRIVER="oracle.jdbc.driver.OracleDriver";
	private String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private String LOGIN="system";
	private String PassWord="system";
	
	private Connection cnn;
	private Statement st;
	
	public Gestion_Fichier(){}
	
	//initialisation pour la connexion avec la base
	public void init(){
		
		try {
			Class.forName(DRIVER);
			cnn=DriverManager.getConnection(URL, LOGIN, PassWord);
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//fermer la connexion avec la base de donnée
	public void close(){
		try {
			cnn.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//methode d'ajouter une fichier 
public boolean AjouterFichier(Fichier fiche){
	 String ReqAjout="insert into Fichier values('"+fiche.getTitre()+"','"+fiche.getAuteur()+"','"+fiche.getTags()+"','"+fiche.getResume()+"','"+fiche.getCommentaire()+"')";
	boolean x =true ;
	 try {
		
		/*	Class.forName(DRIVER);
		
		cnn=DriverManager.getConnection(URL, LOGIN, PassWord);	*/
		st=cnn.createStatement();
		st.executeUpdate(ReqAjout);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		return false;
	}
	
	return x;
	
}


//methode de modifier une fichier
public boolean ModifierFichier(String a,String b ,String c ,String d ,String f ,String s){
	String reqModification ="UPDATE FICHIER " +
                                "set  titre='"+a+"'"
                                +" set TAG ='"+b+"' "
                            +"set  AUTEUR = '"+c+"'"
                            + "set RESUME = '"+d+"' "
                            + "set COMMENTAIRE='"+f+ 
                            "' where titre='"+s+"'";
	try {
		st=cnn.createStatement();
		st.executeUpdate(reqModification);
	} catch (SQLException e ) {
		// TODO Auto-generated catch block
		return false;
	}
	
	return true;
}


//methode de recherche une fichier
public Fichier RechercheFichier(String titre){
	
	
	String ReqRecherche="select * from Fichier where TITRE='"+titre+"'";
	ResultSet res;
	Fichier fiche = null ;
		try {
			st=cnn.createStatement();
			res=st.executeQuery(ReqRecherche);
			while(res.next()){
				fiche=new Fichier();
				fiche.setTitre(res.getString(1));
				fiche.setTags(res.getString(2));
				fiche.setAuteur(res.getString(3));

				fiche.setResume(res.getString(4));
				fiche.setCommentaires(res.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	return fiche;
}



//methode de recherche une fichier
public boolean SupprimerFichier(String titre){
	String ReqSuppri="Delete  from FICHIER where TITRE='"+titre+"'";
	int res ;
		try {
			st=cnn.createStatement();
			res=st.executeUpdate(ReqSuppri);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	return true;
}

}
