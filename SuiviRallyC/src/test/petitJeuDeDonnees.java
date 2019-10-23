package test;

import java.util.Random;

import GestionClassement.ClassementEtape;
import GestionClassement.ClassementGeneralProvisoire;
import GestionDonnees.Difficulte;
import GestionDonnees.Rallye;
import GestionDonnees.TypeRegle;
import GestionInscription.Camion;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;
import GestionInscription.Moto;
import GestionInscription.Vehicule;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;
import GestionRallye.Speciale;
import GestionRallye.TypeRegleSpecial;

public class petitJeuDeDonnees {

	public static void main(String[] args) {
		Constructeur cons1 = new Constructeur("Mercedes");
		Constructeur cons3 = new Constructeur("Volkswagen");

		Vehicule v1 = new Camion("TWN PKS", 300, cons1);
		Vehicule v2 = new Camion("PRK SN RC", 100, cons3);

		Coureur c1 = new Coureur(1, "SMITH", "Elliott", "05-01-1970", "A", '-', v1);
		Coureur c2 = new Coureur(2, "DUBOIS", "Clement", "03-10-1990", "B", '+', v2);


		//ASSOCIER 4 COUREURS
		c1.associerConstructeur(cons1);
		c2.associerConstructeur(cons3);

		Rallye r1 = new Rallye("Rallye de Paris", "Paris", "France", TypeRegle.superRallye);

		EditionRallye er1_1 = new EditionRallye(r1.getNomR(), r1.getVilleR(), r1.getPaysR(), r1.getRegle(), "09-10-18", "18-10-18", 3, 2018);

		Etape et1 = new Etape(Difficulte.difficile, 1, 28,er1_1);
		Etape et2 = new Etape(Difficulte.difficulte_moyenne, 2, 20,er1_1);
		Etape et3 = new Etape(Difficulte.sans_difficulte_particuliere, 3, 18,er1_1);

		Speciale s1 = new Speciale(9.5, 1, 21.5, TypeRegleSpecial.speciale);
		Speciale s2 = new Speciale(10.5, 2, 10.2, TypeRegleSpecial.superSpeciale);

		et1.addSpeciale(s1);
		et1.addSpeciale(s2);
		et2.addSpeciale(s1);
		et2.addSpeciale(s2);
		et3.addSpeciale(s1);
		et3.addSpeciale(s2);

		/*************************
		 * AJOUT DES PARTICIPANTS*
		 *************************/
		er1_1.addCoureur(c1);
		er1_1.addCoureur(c2);

		ClassementGeneralProvisoire cgp = new ClassementGeneralProvisoire(er1_1);
		for(Etape e : er1_1.getEtapes()) {
			ClassementEtape ce = new ClassementEtape(e);
			for(Speciale s : e.getSpeciales()) {
				for(Coureur c : er1_1.getCoureurs()) {

					if(c.equals(c1) && s.equals(s1) && e.equals(et2)) {
					}else {
						Random rdm = new Random();
						double temps = rdm.nextDouble()+10;
						System.out.println(temps+" du coureur"+c);
						ce.enregistrerTemps(c,s, temps);
					}

				}
			}
			System.out.println("Difficulté : "+e.getCoeffDiff());
			System.out.println(ce.calculerClassement());
			cgp.addClassementEtape(ce);
		}
		er1_1.addClassementGeneralProvisoire(cgp);
		System.out.println("\n Participants : ");
		System.out.println(er1_1.getCoureurs());
		System.out.println();
		System.out.println(er1_1.getClassementGeneralProvisoires().get(0).calculerClassementG(""));

	}

}
