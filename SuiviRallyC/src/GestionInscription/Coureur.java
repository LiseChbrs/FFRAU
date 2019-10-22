package GestionInscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import GestionClassement.ClassementEtape;
import GestionClassement.ClassementGeneralProvisoire;
import GestionClassement.Couple;
import GestionRallye.EditionRallye;
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
	private ArrayList<ClassementEtape> classementEtapes;
	private ArrayList<EditionRallye> participations;


	public Coureur(int numC, String nomC, String prenomC, String dateNaissC, String grSanguin, char rhesusC,Vehicule vehicule) {
		super();
		this.numC = numC;
		this.nomC = nomC;
		this.prenomC = prenomC;
		this.dateNaissC = dateNaissC;
		this.grSanguin = grSanguin;
		this.rhesusC = rhesusC;
		this.vehicule = vehicule;
		this.classementEtapes = new ArrayList<ClassementEtape>();
		this.participations = new ArrayList<EditionRallye>();
	}

	//METHODS
	public HashMap<EditionRallye, Integer> getHistoriqueCoureur() {
		HashMap<EditionRallye,Integer> historique = new HashMap<EditionRallye, Integer>();

		for(EditionRallye r : this.participations) {
			if(r.getCoureurs().contains(this)){
				ClassementGeneralProvisoire cgp = r.calculerClassementDefinitif();
				HashMap<Integer,ArrayList<Couple>> halo = new HashMap<>();
				halo.put(1,cgp.calculerClassementG("Voiture"));
				halo.put(2,cgp.calculerClassementG("Moto"));
				halo.put(3,cgp.calculerClassementG("Camion"));

				boolean verification = false;

				//ON CHERCHE A VOIR OU SE SITUE NOTRE COUREUR
				int indice = 0;
				for(Entry<Integer, ArrayList<Couple>> e : halo.entrySet()) {
					if(e.getValue().contains(this)) {
						indice = e.getKey();
						verification = true;
						break;
					}
				}

				if(verification) {
					int i =0;
					for(Couple c : halo.get(indice)) {
						if(c.getKey().equals(this)) {
							historique.put(r, i);
							break;
						}
						i++;
					}
				}
			}
		}
		return historique;
	}

	public double calculerTempsCoefCorrectif(double temps) {
		return temps*this.vehicule.calculerCoeffCorrectif();
	}
	
	
	public void inscrire(EditionRallye r) {
		this.participations.add(r);
	}

	//GETTERS & SETTERS
	public void addEdition(EditionRallye e) {
		this.participations.add(e);
	}
	public ArrayList<ClassementEtape> getClassementEtapes() {
		return classementEtapes;
	}

	public void setClassementEtapes(ArrayList<ClassementEtape> classementEtapes) {
		this.classementEtapes = classementEtapes;
	}

	public void addClassementEtape(ClassementEtape cl) {
		this.classementEtapes.add(cl);
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	/***
	 * Si l'attribut n'est pas null, alors le coureur est associé à un constructeur.
	 * @param constructeur
	 */
	public void associerConstructeur(Constructeur constructeur) {
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

	/***
	 * Egalité sur le numéro de coureur
	 */
	public boolean equals(Object o) {
		if(o instanceof Coureur) {
			return (this.numC == ((Coureur) o).getNumC());
		}else {
			return false;
		}
	}

	public String toString() {
		return this.nomC +" "+ this.prenomC;
	}
}
