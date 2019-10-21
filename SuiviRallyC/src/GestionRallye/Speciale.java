package GestionRallye;

public class Speciale {

	private double distanceParcS;
	private int numOrdreS;
	private double chronoLimiteS;
	private TypeRegleSpecial typeR;
	
	
	public Speciale(double distanceParcS, int numOrdreS, double chronoLimiteS, TypeRegleSpecial typeR) {
		super();
		this.distanceParcS = distanceParcS;
		this.numOrdreS = numOrdreS;
		this.chronoLimiteS = chronoLimiteS;
		this.typeR = typeR;
	}


	public double getDistanceParcS() {
		return distanceParcS;
	}


	public void setDistanceParcS(double distanceParcS) {
		this.distanceParcS = distanceParcS;
	}


	public int getNumOrdreS() {
		return numOrdreS;
	}


	public void setNumOrdreS(int numOrdreS) {
		this.numOrdreS = numOrdreS;
	}


	public double getChronoLimiteS() {
		return chronoLimiteS;
	}


	public void setChronoLimiteS(double chronoLimiteS) {
		this.chronoLimiteS = chronoLimiteS;
	}


	public TypeRegleSpecial getTypeR() {
		return typeR;
	}


	public void setTypeR(TypeRegleSpecial typeR) {
		this.typeR = typeR;
	}
	
	
	
	
}