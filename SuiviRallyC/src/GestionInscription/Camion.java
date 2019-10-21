package GestionInscription;

public class Camion extends Vehicule{

	private int poidsCa;
	
	public Camion(int coeffCorrectif, String immatV, int poidsCa,Constructeur cons) {
		super(coeffCorrectif, immatV,cons);
		this.poidsCa = poidsCa;
	}

}
