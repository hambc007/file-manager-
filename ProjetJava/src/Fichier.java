
public class Fichier {

	
	private String Auteur,Titre,Tags,R�sum�,Commentaires;

	
	public Fichier(){}
	public Fichier(String Auteur,String Titre,String Tags,String Resume,String Commentaires){
		setAuteur(Auteur);
		setTags( Tags);
		setTitre( Titre);
		 setResume( Resume) ;
		setCommentaires( Commentaires);
	}

	
	public String getAuteur() {
		return Auteur;
	}

	public void setAuteur(String auteur) {
		Auteur = auteur;
	}

	public String getTags() {
		return Tags;
	}

	public void setTags(String tags) {
		Tags = tags;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		if(!titre.equals(""))
		Titre = titre;
	}

	public String getResume() {
		return R�sum�;
	}

	public void setResume(String Resume) {
		R�sum� = Resume;
	}

	public String getCommentaire() {
		return Commentaires;
	}

	public void setCommentaires(String commentaires) {
		Commentaires = commentaires;
	}
}
