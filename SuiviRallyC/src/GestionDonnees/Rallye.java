package GestionDonnees;

/***
 * Classe Données pour Rallye
 * @author MIAGE UT1
 *
 */
public class Rallye {

	private String nomR;
	private String villeR;
	private String paysR;
	
	
	public Rallye(String nomR, String villeR, String paysR) {
		super();
		this.nomR = nomR;
		this.villeR = villeR;
		this.paysR = paysR;
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
