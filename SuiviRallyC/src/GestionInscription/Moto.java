package GestionInscription;

public class Moto extends Vehicule{

	private int cylindreM;
	
	public Moto(int coeffCorrectif, String immatV, int cC,Constructeur cons) {
		super(coeffCorrectif, immatV, cons);
		this.cylindreM = cC;
	}

	public int getCylindreM() {
		return cylindreM;
	}

	public void setCylindreM(int cylindreM) {
		this.cylindreM = cylindreM;
	}

	
	
}
