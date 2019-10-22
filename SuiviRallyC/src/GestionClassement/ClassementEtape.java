package GestionClassement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import GestionInscription.Camion;
import GestionInscription.Coureur;
import GestionInscription.Moto;
import GestionInscription.Vehicule;
import GestionInscription.Voiture;
import GestionRallye.Etape;
import GestionRallye.Speciale;;

public class ClassementEtape {

	private HashMap<Coureur,ArrayList<SpecialTemps>> listTemps;
	private HashMap<Coureur,Rapport> listRapport;
	private Etape etape;

	public ClassementEtape(Etape etape) {
		this.listTemps = new HashMap<Coureur, ArrayList<SpecialTemps>>();
		this.etape = etape;
		this.listRapport = new HashMap<Coureur, Rapport>();

	}

	public void enregistrerTemps(Coureur c, Speciale s, Double t) {
		if(this.listTemps.containsKey(c)) {
			this.listTemps.get(c).add(new SpecialTemps(s,t));
		}else {
			ArrayList<SpecialTemps> spt = new ArrayList<SpecialTemps>();
			spt.add(new SpecialTemps(s,t));
			this.listTemps.put(c, spt);
		}

	}


	public void enregistrerRapport(Coureur c, Rapport r) {
		this.listRapport.put(c, r);
	}



	public double calculerTempsCoef(double temps) {
		double coeff = this.etape.getCoeffDiff();
		return temps * coeff;
	}


	public ArrayList<Couple> calculerClassement() {
		ArrayList<Couple> classement = new ArrayList<Couple>();
		for(Entry<Coureur, ArrayList<SpecialTemps> > e : this.listTemps.entrySet()) {
			double somme =0;
			for(SpecialTemps s : e.getValue()) {
				somme += s.getValue();
			}
			//ON AFFECTE LE TEMPS SELON LE RAPPORT
			if(this.listRapport.containsKey(e.getKey())) {
				Rapport r = this.listRapport.get(e);
				//Si on a une élimination on le retire de la liste.
				if(r.getelimine()) {
					this.listTemps.remove(e);
				}else {
					//Sinon on lui impute une éventuelle pénalité/Bonus(selon le signe).
					somme += r.getPenalite();
				}

			}
			//On insère dans le classement.
			//Permet d'avoir le temps minoré selon le coefficient.
			somme = this.calculerTempsCoef(somme);
			classement.add(new Couple(e.getKey(),somme));
		}
		//Il faut ensuite trier le classement.
		Collections.sort(classement, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));
		return classement;
	}

	public HashMap<Vehicule,ArrayList<Couple>> getClassementByVehicule(){
		HashMap<Vehicule,ArrayList<Couple>> sorted = new HashMap<Vehicule, ArrayList<Couple>>();
		ArrayList<Couple> r = this.calculerClassement();
		ArrayList<Voiture> v = new ArrayList<>();
		ArrayList<Moto> m = new ArrayList<>();
		ArrayList<Camion> ca = new ArrayList<>();
		
		for(Couple c : r) {
			if(c.getKey().getVehicule() instanceof Voiture) {
				
			}
		}
		
		return sorted;
	}

	public HashMap<Coureur, ArrayList<SpecialTemps>> getListTemps() {
		return listTemps;
	}

	public HashMap<Coureur, Rapport> getListRapport() {
		return listRapport;
	}

	public Etape getEtape() {
		return etape;
	}



}