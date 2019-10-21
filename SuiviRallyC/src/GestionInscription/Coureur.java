package GestionInscription;

import java.util.HashMap;

import GestionRallye.Etape;

public class Coureur {

	private int numC;
	private String nomC;
	private String prenomC;
	private String dateNaissC;
	private String grSanguin;
	private char rhesusC;
	private Vehicule vehicule;
	private Constructeur constructeur;

	public Coureur(int numC, String nomC, String prenomC, String dateNaissC, String grSanguin, char rhesusC,Vehicule vehicule) {
		super();
		this.numC = numC;
		this.nomC = nomC;
		this.prenomC = prenomC;
		this.dateNaissC = dateNaissC;
		this.grSanguin = grSanguin;
		this.rhesusC = rhesusC;
		this.vehicule = vehicule;
	}

	//METHODS
	public HashMap<Etape, Integer> getHistoriqueCoureur() {

		return null;
	}



	//GETTERS & SETTERS

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}
	public String getPrenomC() {
		return prenomC;
	}
	public void setPrenomC(String prenomC) {
		this.prenomC = prenomC;
	}
	public String getDateNaissC() {
		return dateNaissC;
	}
	public void setDateNaissC(String dateNaissC) {
		this.dateNaissC = dateNaissC;
	}
	public String getGrSanguin() {
		return grSanguin;
	}
	public void setGrSanguin(String grSanguin) {
		this.grSanguin = grSanguin;
	}
	public char getRhesusC() {
		return rhesusC;
	}
	public void setRhesusC(char rhesusC) {
		this.rhesusC = rhesusC;
	}


}
