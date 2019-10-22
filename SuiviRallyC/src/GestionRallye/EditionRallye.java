package GestionRallye;

import java.util.ArrayList;

import GestionClassement.ClassementGeneralProvisoire;
import GestionClassement.Couple;
import GestionDonnees.Etat;
import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionInscription.Coureur;

public class EditionRallye extends Rallye{
	private String dateDebER;
	private String dateFinER;
	private Etat etat;
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
		this.classementRallye = new ArrayList<ClassementGeneralProvisoire>();
		this.etat = Etat.ouvertAuxInscriptions;
	}

	//METHODS 

	/***
	 * Ajoute une spï¿½ciale en ciblant l'ï¿½tape.
	 * @param e
	 */
	public void ajouterSpeciale(Etape etape,double distanceparcER, int ordre,double chronoLimite,TypeRegleSpecial type) {
		//		if(this.etapes.contains(etape)) {
		//			this.getEtapes().get(etape).addSpeciale(new Speciale(distanceparcER,ordre,chronoLimite,type));
		//		
		//		}else {
		//			System.out.println("L'ï¿½tape n'existe pas. Veuillez la crï¿½er.");
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
		if(!found) System.out.println("L'ï¿½tape n'existe pas.");

	}

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


	public void fermerInscription() {
		this.etat = Etat.debute;
	}
	
	/***
	 * Egalitï¿½ sur le nom du rallye, et le numï¿½ro d'ï¿½dition de l'ï¿½ditionRallye
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

	public void addClassementGeneralProvisoire(ClassementGeneralProvisoire cgp) {
		this.classementRallye.add(cgp);
	}

	public ArrayList<Coureur> getCoureurs() {
		return coureurs;
	}

	public ArrayList<ClassementGeneralProvisoire> getClassementRallye() {
		return classementRallye;
	}

	/***
	 * Retourne le dernier classementProvisoire et met l'état de l'édition ) clos.
	 * @return
	 */
	public ClassementGeneralProvisoire calculerClassementDefinitif(){
		this.etat = Etat.clos;
		int index = this.getClassementRallye().size() -1;
		return this.getClassementRallye().get(index);
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void setCoureurs(ArrayList<Coureur> coureurs) {
		this.coureurs = coureurs;
	}

	public void setClassementRallye(ArrayList<ClassementGeneralProvisoire> classementRallye) {
		this.classementRallye = classementRallye;
	}

	
}
