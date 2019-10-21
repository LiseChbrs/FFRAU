package GestionRallye;

import java.util.ArrayList;

import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;

public class EditionRallye extends Rallye{
private String dateDebER;
private String dateFinER;
private String nomER;
private int anneeER;
private ArrayList<Etape> etapes;
	
	
	public EditionRallye(String nomR, String villeR, String paysR, TypeRegle regle, String dateDebER, String dateFinER,
		String nomER, int anneeER) {
	super(nomR, villeR, paysR, regle);
	this.dateDebER = dateDebER;
	this.dateFinER = dateFinER;
	this.nomER = nomER;
	this.anneeER = anneeER;
	this.setEtapes(new ArrayList<Etape>());
}


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
