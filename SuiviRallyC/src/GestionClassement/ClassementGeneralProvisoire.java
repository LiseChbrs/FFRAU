package GestionClassement;

import java.util.ArrayList;
import java.util.HashMap;

import GestionInscription.Coureur;

public class ClassementGeneralProvisoire {
	ArrayList<ClassementEtape> listClassementEtapes;
	
	public ClassementGeneralProvisoire() {
		this.listClassementEtapes = new ArrayList<ClassementEtape>();
	}
	
	public void addClassementEtape(ClassementEtape ce) {
		this.listClassementEtapes.add(ce);
	}
	
	public void calculerClassementG() {
		HashMap<Coureur, Double> sumTemps = new HashMap<Coureur, Double>();
		for (ClassementEtape ce : listClassementEtapes) {
			
		}
		
	}
	
	public void calculerClassementCons() {
		
	}
	

}