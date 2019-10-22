package GestionRallye;

import java.util.ArrayList;

import GestionClassement.ClassementGeneralProvisoire;
import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionInscription.Coureur;

public class EditionRallye extends Rallye{
	private String dateDebER;
	private String dateFinER;
	private int numER;
	private int anneeER;
	private ArrayList<Etape> etapes;
	private ArrayList<Coureur> coureurs;
	private ArrayList<ClassementGeneralProvisoire> classementRallye;

	/***
	 * 
	 * @param nomR
	 * @param villeR
	 * @param paysR
	 * @param regle
	 * @param dateDebER JJ/MM/AAAA
	 * @param dateFinER JJ/MM/AAAA
	 * @param nomER
	 * @param anneeER
	 */
	public EditionRallye(String nomR, String villeR, String paysR, TypeRegle regle, String dateDebER, String dateFinER,
			int nomER, int anneeER) {
		super(nomR, villeR, paysR, regle);

		this.dateDebER = dateDebER;
		this.dateFinER = dateFinER;
		this.numER = nomER;
		this.anneeER = anneeER;
		this.setEtapes(new ArrayList<Etape>());
		this.coureurs = new ArrayList<Coureur>();
	}

	//METHODS 

	/***
	 * Ajoute une spéciale en ciblant l'étape.
	 * @param e
	 */
	public void ajouterSpeciale(Etape etape,double distanceparcER, int ordre,double chronoLimite,TypeRegleSpecial type) {
		//		if(this.etapes.contains(etape)) {
		//			this.getEtapes().get(etape).addSpeciale(new Speciale(distanceparcER,ordre,chronoLimite,type));
		//		
		//		}else {
		//			System.out.println("L'étape n'existe pas. Veuillez la créer.");
		//		}
		int i =0;
		boolean found = false;
		while(i<this.etapes.size() && !found) {
			Etape et = this.etapes.get(i);
			if(et.equals(etape)) {
				this.etapes.get(i).addSpeciale(new Speciale(distanceparcER, ordre, chronoLimite, type));
				found = true;
			}
			i++;
		}
		if(!found) System.out.println("L'étape n'existe pas.");

	}

	public void addEtape(Etape e) {
		this.etapes.add(e);
	}

	public void addCoureur(Coureur c) {
		this.coureurs.add(c);
	}

	public void addClassementGeneralProvisoire(ClassementGeneralProvisoire cgp) {
		this.classementRallye.add(cgp);
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


	public int getNumER() {
		return numER;
	}


	public void setNumER(int nomER) {
		this.numER = nomER;
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


	/***
	 * Egalité sur le nom du rallye, et le numéro d'édition de l'éditionRallye
	 */
	public boolean equals(Object o) {
		if(o instanceof EditionRallye ) {
			if(super.getNomR().equals(((EditionRallye) o).getNomR())) {
				if(this.numER == ((EditionRallye) o).getNumER()) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
