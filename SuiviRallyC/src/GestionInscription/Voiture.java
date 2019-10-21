package GestionInscription;

public class Voiture extends Vehicule{

	private int puissanceVo;


	public Voiture( String immatV,int chevaux,Constructeur cons) {
		super( immatV,cons);
		this.puissanceVo = chevaux;

	}


	public int getPuissanceVo() {
		return puissanceVo;
	}


	public void setPuissanceVo(int puissanceVo) {
		this.puissanceVo = puissanceVo;
	}

	/***
	 * Calcul puis retourne l'attribut à jour.
	 */
	protected double calculerCoeffCorrectif() {
		if(this.puissanceVo >=300) {
			coeffCorrectif = (int) (coeffCorrectif + ((this.puissanceVo-300)*0.05));
		}else if(this.puissanceVo < 20) {
			coeffCorrectif = (int) (coeffCorrectif - ((20-this.puissanceVo)*0.05));
		}
		return coeffCorrectif;
	}



}
