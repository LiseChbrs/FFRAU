package GestionRallye;

import java.util.ArrayList;

import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionInscription.Coureur;

public class EditionRallye extends Rallye{
private String dateDebER;
private String dateFinER;
private String nomER;
private int anneeER;
private ArrayList<Etape> etapes;
private ArrayList<Coureur> coureurs;
	
	
	public EditionRallye(String nomR, String villeR, String paysR, TypeRegle regle, String dateDebER, String dateFinER,
		String nomER, int anneeER) {
	super(nomR, villeR, paysR, regle);
	this.dateDebER = dateDebER;
	this.dateFinER = dateFinER;
	this.nomER = nomER;
	this.anneeER = anneeER;
	this.setEtapes(new ArrayList<Etape>());
	this.coureurs = new ArrayList<Coureur>();
}
	
	//METHODS 

	public void addEtape(Etape e) {
		this.etapes.add(e);
	}
	
	public void addCoureur(Coureur c) {
		this.coureurs.add(c);
	}
	
	//GETTERS&SETTERS
	
	public String getDateDebER() {
		return dateDebER;
	}


	public void setDateDebER(String dateDebER) {
		this.dateDebER = dateDebER;
	}


	public String getDateFinER() {
		return dateFinER;
	}


	public void setDateFinER(String dateFinER) {
		this.dateFinER = dateFinER;
	}


	public String getNomER() {
		return nomER;
	}


	public void setNomER(String nomER) {
		this.nomER = nomER;
	}


	public int getAnneeER() {
		return anneeER;
	}


	public void setAnneeER(int anneeER) {
		this.anneeER = anneeER;
	}


	public ArrayList<Etape> getEtapes() {
		return etapes;
	}


	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}


	
}
