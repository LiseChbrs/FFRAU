package GestionInscription;

import java.util.ArrayList;

public class Constructeur {

	private String nomConst;
	private ArrayList<Coureur> coureurs;
	private ArrayList<Vehicule> vehiculesC;

	public Constructeur(String nomConst) {
		super();
		this.nomConst = nomConst;
		this.coureurs = new ArrayList<Coureur>();
		this.vehiculesC = new ArrayList<Vehicule>();
	}

	//METHODS
	public void addCoureur(Coureur c) {
		this.coureurs.add(c);
	}

	public void addVehicule(Vehicule v) {
		this.vehiculesC.add(v);
	}

	//GETTERS & SETTERS

	public String getNomConst() {
		return nomConst;
	}
	public void setNomConst(String nomConst) {
		this.nomConst = nomConst;
	}
	public ArrayList<Coureur> getCoureurs() {
		return coureurs;
	}
	public void setCoureurs(ArrayList<Coureur> coureurs) {
		this.coureurs = coureurs;
	}


}
