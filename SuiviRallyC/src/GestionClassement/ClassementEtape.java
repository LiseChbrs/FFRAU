package GestionClassement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import GestionInscription.Coureur;
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



	public void calculerTempsCoef() {

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
				if(r.getelimine()) {
					this.listTemps.remove(e);
					//					somme = 0;
					//					for(Speciale s:this.etape.getSpeciales()) {
					//						somme += s.getChronoLimiteS();
					//					}
				}else {
					somme += r.getPenalite();
				}

			}
			classement.add(new Couple(e.getKey(),somme));
		}
		Collections.sort(classement, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));
		return classement;
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