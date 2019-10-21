package GestionInscription;

public abstract class Vehicule {

	protected double coeffCorrectif;
	protected String immatV;
	protected Constructeur constructeurAuto;
	
	
	public Vehicule( String immatV,Constructeur cons) {
		super();
		this.coeffCorrectif = 1;
		this.immatV = immatV;
		this.constructeurAuto = cons;
	}


	public double getCoeffCorrectif() {
		return coeffCorrectif;
	}


	public void setCoeffCorrectif(int coeffCorrectif) {
		this.coeffCorrectif = coeffCorrectif;
	}


	public String getImmatV() {
		return immatV;
	}


	public void setImmatV(String immatV) {
		this.immatV = immatV;
	}
	/***
	 * Calcule est retourne le nouveau coef
	 * @return
	 */
	protected abstract double calculerCoeffCorrectif();
	
	
}
