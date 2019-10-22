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
		this.speciales = new ArrayList<Speciale>();
	}

	//METHODS
	public void addSpeciale(Speciale s) {
		this.speciales.add(s);
	}

	private double calculerCoefDiff() {
		double coef =0.0;

		switch(this.difficulte) {
		case sans_difficulte_particuliere :
			coef = 1;
			break;
		case difficulte_mineures :
			coef = 0.9;
			break;
		case difficulte_moyenne :
			coef = 0.8;
			break;
		case difficile : 
			coef = 0.7;
			break;
		case tres_difficile :
			coef = 0.6;
			break;

		}
		return coef;
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



	/***
	 * Deux etapes sont similaires lorsqu'elle ont le même numéro d'ordre.
	 */
	public boolean equals(Object o) {
		if(o instanceof Etape) {
			return ((Etape) o).getNumEtape() == this.numEtape;
		}else {
			return false;
		}
	}

}
