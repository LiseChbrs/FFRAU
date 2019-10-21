package GestionClassement;

public class Rapport {
	double penalitetps;
	boolean elimine;
	
	public Rapport(double p, boolean e) {
		this.elimine = e;
		this.penalitetps = p;
	}
	
	public boolean getelimine() {
		return this.elimine;
	}
	
	public double getPenalite() {
		return this.penalitetps;
	}

}