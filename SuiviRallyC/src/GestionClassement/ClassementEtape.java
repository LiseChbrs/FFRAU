package GestionClassement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import GestionDonnees.Etat;
import GestionDonnees.TypeRegle;
import GestionInscription.Camion;
import GestionInscription.Coureur;
import GestionInscription.Voiture;
import GestionRallye.EditionRallye;
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
		if(this.etape.getEtat().equals(Etat.debute)) {
			if(this.listRapport.containsKey(c) ) {
				Rapport r = this.listRapport.get(c);
				if(r.elimine) {
				}else {
					if(s.getChronoLimiteS() > t) {
						if(this.listTemps.containsKey(c)) {
							//ICI
							SpecialTemps spt = new SpecialTemps(s,t);
							if(this.listTemps.get(c).contains(spt)) {
								for(int i=0;i<this.listTemps.get(c).size();i++) {
									SpecialTemps test = this.listTemps.get(c).get(i);
									if(test.equals(spt)) {
										this.listTemps.get(c).remove(test);
										this.listTemps.get(c).add(i,spt);
										break;
									}
								}

							}else {
								this.listTemps.get(c).add(new SpecialTemps(s,t));
							}
						}else {
							ArrayList<SpecialTemps> spta = new ArrayList<SpecialTemps>();
							spta.add(new SpecialTemps(s,t));
							this.listTemps.put(c, spta);
						}
					}else if (!(s.getChronoLimiteS() > t)){
						System.out.println("Temps supérieur au chrono limite");
						Rapport re = new Rapport(0, true);
						this.listRapport.put(c, re);
					}
				}
			}else {
				if(s.getChronoLimiteS() > t) {
					if(this.listTemps.containsKey(c)) {
						SpecialTemps spt = new SpecialTemps(s,t);
						if(this.listTemps.get(c).contains(spt)) {
							for(int i=0;i<this.listTemps.get(c).size();i++) {
								SpecialTemps test = this.listTemps.get(c).get(i);
								if(test.equals(spt)) {
									this.listTemps.get(c).remove(test);
									this.listTemps.get(c).add(i,spt);
									break;
								}
							}
						}else {
							this.listTemps.get(c).add(spt);	
						}

					}else {
						ArrayList<SpecialTemps> spt = new ArrayList<SpecialTemps>();
						spt.add(new SpecialTemps(s,t));
						this.listTemps.put(c, spt);
					}
				}else if (!(s.getChronoLimiteS() > t)){
					System.out.println("Temps supérieur au chrono limite");
					Rapport r = new Rapport(0, true);
					this.listRapport.put(c, r);
				}	else {
					System.out.println("ETAPE CLOSE.");
				}
			}
		}
	}

	/***
	 * Si on a déjà un rapport on voir pour ajouter les pénalités si
	 * le coureur n'est pas éliminé.
	 * Sinon, il nous suffit d'ajouter un nouveau rapport.
	 * @param c
	 * @param r
	 */
	public void enregistrerRapport(Coureur c, Rapport r) {
		if(this.listRapport.containsKey(c)) {
			if(r.getelimine()) {
				this.listRapport.put(c, r);
			}else {
				r.penalitetps += this.listRapport.get(c).penalitetps;
				this.listRapport.put(c, r);
			}
		}else {
			this.listRapport.put(c, r);
		}
	}	



	public double calculerTempsCoef(double temps) {
		double coeff = this.etape.getCoeffDiff();
		return temps * coeff;
	}


	public ArrayList<Couple> calculerClassement() {
		this.etape.setEtat(Etat.clos);
		this.verifierElimination();
		ArrayList<Couple> classement = new ArrayList<Couple>();
		for(Entry<Coureur, ArrayList<SpecialTemps> > e : this.listTemps.entrySet()) {
			double somme =0;
			for(SpecialTemps s : e.getValue()) {
				somme += s.getValue();
			}
			//ON AFFECTE LE TEMPS SELON LE RAPPORT
			if(this.listRapport.containsKey(e.getKey())) {
				Rapport r = this.listRapport.get(e.getKey());
				//Si on a une élimination on le retire de la liste.
				if(r.getelimine()) {
					System.out.println(e.getKey().getNomC()+" "+e.getKey().getPrenomC()+" est éliminé");
				}else {
					//Sinon on lui impute une éventuelle pénalité/Bonus(selon le signe).
					somme += r.getPenalite();
				}

			}
			//On insère dans le classement.Permet d'avoir le temps minoré selon le coefficient.
			somme = this.calculerTempsCoef(somme);
			classement.add(new Couple(e.getKey(),somme));
		}
		for(int i =0;i<classement.size();i++) {
			Couple c = classement.get(i);
			if(this.listRapport.containsKey(c.getKey())) {
				Rapport r  = this.listRapport.get(c.getKey());
				if(r.getelimine()) {
					System.out.println("ELIMINE");
					classement.remove(i);
					i--;
				}
			}
		}

		//Il faut ensuite trier le classement.
		Collections.sort(classement, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));
		return classement;
	}

	private void verifierElimination() {
		EditionRallye er = this.etape.getEditionRallye();
		for(Coureur c : er.getCoureurs()) {
			ArrayList<SpecialTemps> st = this.avoirTempsCoureur(c);
			//CA VEUT DIRE QUE LE COUREUR A RATE UN TEMPS 
			if(st.size() < this.getEtape().getSpeciales().size()) {
				if(er.getRegle().equals(TypeRegle.superRallye)) {
					Rapport rpt;
					for(int i=0;i<this.etape.getSpeciales().size();i++) {
						int lim = this.etape.getSpeciales().size()-1;
						Speciale s = this.getEtape().getSpeciales().get(i);
						SpecialTemps stest = new SpecialTemps(s, (double)0);
						if(!st.contains(stest)) {
							if(i == lim) {
								double pen = 10;
								System.out.println("Penalité de "+pen+" pour "+c);
								if(this.listRapport.containsKey(c)) {
									rpt = this.listRapport.get(c);
									rpt.penalitetps += pen;
								}else {
									rpt = new Rapport(10,false);
									this.listRapport.put(c,rpt);
								}
							}else {
								double pen = 5;
								System.out.println("Penalité de "+pen);
								if(this.listRapport.containsKey(c)) {
									rpt = this.listRapport.get(c);
									rpt.penalitetps += pen;
								}else {
									rpt = new Rapport(5,false);
									this.listRapport.put(c,rpt);
								}
							}
						}
					}
				}else {
					//ON L'ELIMINE
					Rapport r = new Rapport(0,true);
					System.out.println("ELIMINATED");
					this.listRapport.put(c, r);
				}
			}

		}
		this.enleverLesElimines();
	}
	/***
	 * Cette méthode supprime les participants ayant été éliminés afin de garantir
	 * des classements cohérents.
	 */
	private void enleverLesElimines() {
		for(int i=0;i< this.etape.getEditionRallye().getCoureurs().size();i++) {
			Coureur c = this.etape.getEditionRallye().getCoureurs().get(i);
			if(this.listRapport.containsKey(c)) {
				Rapport r = this.listRapport.get(c);
				if (r.getelimine()) {
					this.etape.getEditionRallye().getCoureurs().remove(i);
					i--;
				}
			}
		}
	}

	/***
	 * Retourne un hashmap de classements triés par type de véhicule.
	 * Accessible par String : "Voiture","Moto","Camion".
	 * @return
	 */
	public HashMap<String,ArrayList<Couple>> getClassementByVehicule(){
		HashMap<String,ArrayList<Couple>> sorted = new HashMap<String, ArrayList<Couple>>();
		ArrayList<Couple> r = this.calculerClassement();
		ArrayList<Couple> voitures = new ArrayList<>();
		ArrayList<Couple> motos = new ArrayList<>();
		ArrayList<Couple> camions = new ArrayList<>();

		for(Couple c : r) {
			if(c.getKey().getVehicule() instanceof Voiture) {
				voitures.add(c);
			}else if(c.getKey().getVehicule() instanceof Camion) {
				camions.add(c);
			}else {
				motos.add(c);
			}
		}
		Collections.sort(voitures, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));
		Collections.sort(camions, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));
		Collections.sort(motos, (c1,c2) -> c1.getValue().compareTo(c2.getValue()));

		sorted.put("Voiture", voitures);
		sorted.put("Moto",motos);
		sorted.put("Camion",camions);
		return sorted;
	}


	/***
	 * Retourne les temps des spéciales de l'étape du classement.
	 * @param c
	 * @return
	 */
	public  ArrayList<SpecialTemps> avoirTempsCoureur(Coureur c) {
		return this.listTemps.get(c);
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