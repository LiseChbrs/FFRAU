package GestionClassement;

import java.util.ArrayList;

public class ClassementGeneralProvisoire {
	ArrayList<ClassementEtape> listClassementEtapes;
	
	public ClassementGeneralProvisoire() {
		this.listClassementEtapes = new ArrayList<ClassementEtape>();
	}
	
	public void addClassementEtape(ClassementEtape ce) {
		this.listClassementEtapes.add(ce);
	}
	
	public void calculerClassementG() {
		
	}
	
	public void calculerClassementCons() {
		
	}
	

}