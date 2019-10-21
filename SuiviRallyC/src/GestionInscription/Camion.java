package GestionInscription;

public class Camion extends Vehicule{

	private int poidsCa;
	
	public Camion( String immatV, int poidsCa,Constructeur cons) {
		super(immatV,cons);
		this.poidsCa = poidsCa;
	}

	@Override
	protected double calculerCoeffCorrectif() {

		if(this.poidsCa >=2000) {
			this.coeffCorrectif = this.coeffCorrectif +((int)(2000 - this.poidsCa)/100)*0.1;
		}else {
			this.coeffCorrectif = this.coeffCorrectif - ((int)(this.poidsCa - 2000)/100)*0.1;
		}
		return 0;
	}

}
