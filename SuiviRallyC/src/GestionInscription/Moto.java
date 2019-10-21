package GestionInscription;

public class Moto extends Vehicule{

	private int cylindreM;

	public Moto( String immatV, int cC,Constructeur cons) {
		super(immatV, cons);
		this.cylindreM = cC;
	}

	public int getCylindreM() {
		return cylindreM;
	}

	public void setCylindreM(int cylindreM) {
		this.cylindreM = cylindreM;
	}

	@Override
	protected double calculerCoeffCorrectif() {
		// TODO Auto-generated method stub
		if(this.cylindreM >=500) {
			this.coeffCorrectif = this.coeffCorrectif -((int)(this.cylindreM-500)/25)*0.25;
		}else {
			this.coeffCorrectif = this.coeffCorrectif +((int)(500-this.cylindreM)/25)*0.25;
		}
		return this.coeffCorrectif;
	}



}
