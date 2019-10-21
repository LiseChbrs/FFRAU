package GestionRallye;

import java.util.ArrayList;

import GestionClassement.ClassementEtape;
import GestionDonnees.Difficulte;

public class Etape {
	private Difficulte difficulte;
	ArrayList<Speciale> speciales;
	private int numEtape;
	private int distanceParcE;
	private double coeffDiff;
	private ClassementEtape classement;




	public Etape(Difficulte difficulte, int numEtape, int distanceParcE) {
		super();
		this.difficulte = difficulte;
		this.numEtape = numEtape;
		this.distanceParcE = distanceParcE;
		//this.coeffDiff = coeffDiff;
		this.speciales = new ArrayList<Speciale>();
	}

	//METHODS
	public void addSpeciale(Speciale s) {
		this.speciales.add(s);
	}

	//GETTERS & SETTERS

	public Difficulte getDifficulte() {
		return difficulte;
	}
	public ClassementEtape getClassement() {
		return classement;
	}

	/***
	 * Permet d'inscrire le classement correspondant à une étape.
	 * @param classement
	 */
	public void setClassement(ClassementEtape classement) {
		this.classement = classement;
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



	public boolean equals(Object o) {
		if(o instanceof Etape) {
			return ((Etape) o).getNumEtape() == this.numEtape;
		}else {
			return false;
		}
	}

}
