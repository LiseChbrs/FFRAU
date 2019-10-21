package GestionInscription;

public abstract class Vehicule {

	private int coeffCorrectif;
	private String immatV;
	private Constructeur constructeurAuto;
	
	
	public Vehicule(int coeffCorrectif, String immatV,Constructeur cons) {
		super();
		this.coeffCorrectif = coeffCorrectif;
		this.immatV = immatV;
		this.constructeurAuto = cons;
	}


	public int getCoeffCorrectif() {
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
	
	
}
