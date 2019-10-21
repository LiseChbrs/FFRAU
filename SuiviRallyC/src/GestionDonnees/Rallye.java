package GestionDonnees;

/***
 * Classe Données pour Rallye
 * @author Romain Giroux
 *
 */
public class Rallye {

	private String nomR;
	private String villeR;
	private String paysR;
	private TypeRegle regle;
	
	
	public Rallye(String nomR, String villeR, String paysR,TypeRegle regle) {
		super();
		this.nomR = nomR;
		this.villeR = villeR;
		this.paysR = paysR;
		this.regle = regle;
	}
	
	

	public TypeRegle getRegle() {
		return regle;
	}

	public void setRegle(TypeRegle regle) {
		this.regle = regle;
	}




	public String getNomR() {
		return nomR;
	}
	public void setNomR(String nomR) {
		this.nomR = nomR;
	}
	public String getVilleR() {
		return villeR;
	}
	public void setVilleR(String villeR) {
		this.villeR = villeR;
	}
	public String getPaysR() {
		return paysR;
	}
	public void setPaysR(String paysR) {
		this.paysR = paysR;
	}
	
	
}
