package GestionInscription;

public class Voiture extends Vehicule{

	private int puissanceVo;
	
	
	public Voiture(int coeffCorrectif, String immatV,int chevaux,Constructeur cons) {
		super(coeffCorrectif, immatV,cons);
		this.puissanceVo = chevaux;
	}


	public int getPuissanceVo() {
		return puissanceVo;
	}


	public void setPuissanceVo(int puissanceVo) {
		this.puissanceVo = puissanceVo;
	}
	
	

}
