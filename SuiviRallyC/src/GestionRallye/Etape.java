package GestionRallye;

import java.util.ArrayList;

import GestionDonnees.Difficulte;

public class Etape {
	private Difficulte difficulte;
	ArrayList<Speciale> speciales;
	private int numEtape;
	private int distanceParcE;
	private double coeffDiff;




	public Etape(Difficulte difficulte, int numEtape, int distanceParcE, double coeffDiff) {
		super();
		this.difficulte = difficulte;
		this.numEtape = numEtape;
		this.distanceParcE = distanceParcE;
		this.coeffDiff = coeffDiff;
		this.speciales = new ArrayList<Speciale>();
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	public int getNumEtape() {
		return numEtape;
	}
	public void setNumEtape(int numEtape) {
		this.numEtape = numEtape;
	}
	public int getDistanceParcE() {
		return distanceParcE;
	}
	public void setDistanceParcE(int distanceParcE) {
		this.distanceParcE = distanceParcE;
	}
	public double getCoeffDiff() {
		return coeffDiff;
	}
	public void setCoeffDiff(double coeffDiff) {
		this.coeffDiff = coeffDiff;
	}
	public ArrayList<Speciale> getSpeciales() {
		return speciales;
	}
	public void setSpeciales(ArrayList<Speciale> speciales) {
		this.speciales = speciales;
	}




}
