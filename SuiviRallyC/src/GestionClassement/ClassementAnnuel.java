package GestionClassement;

import java.util.ArrayList;

import GestionRallye.EditionRallye;

public class ClassementAnnuel {
	ArrayList<EditionRallye> listER;
	public ClassementAnnuel() {
		this.listER = new ArrayList<EditionRallye>();
	}
	
	public void addEditionRallye(EditionRallye er) {
		this.listER.add(er);
	}
	
	public void getClassementAnnuel(int annee) {
	}
	
	public void calculerClassementAnnuel(int annee) {
		
	}
	
	public void miseAJourClassementAnnuel(ClassementGeneralProvisoire cg) {
		
	}
	

}