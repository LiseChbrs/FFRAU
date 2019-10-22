package test;

import java.util.Random;

import GestionClassement.*;
import GestionDonnees.*;
import GestionInscription.*;
import GestionRallye.*;

public class Run {

	public static void main(String[] args) {

		/*
		 * Initialisation des données
		 */

		Constructeur cons1 = new Constructeur("Mercedes");
		Constructeur cons2 = new Constructeur("Peugeot");
		Constructeur cons3 = new Constructeur("Volkswagen");

		Vehicule v1 = new Camion("TWN PKS", 300, cons1);
		Vehicule v2 = new Moto("PRK SN RC", 100, cons3);
		Vehicule v3 = new Voiture("THFFC", 150, cons2);
		Vehicule v4 = new Camion("THKLLNG", 310, cons2);
		Vehicule v5 = new Voiture("LFES STRNG", 170, cons2);

		Coureur c1 = new Coureur(1, "SMITH", "Elliott", "05-01-1970", "A", '-', v1);
		Coureur c2 = new Coureur(2, "DUBOIS", "Clément", "03-10-1990", "B", '+', v2);
		Coureur c3 = new Coureur(3, "TYLER", "Emily", "12-09-1984", "AB", '-', v3);
		Coureur c4 = new Coureur(4, "TAYLOR", "Liz", "07-12-1974", "O", '+', v4);
		Coureur c5 = new Coureur(5, "SCAY", "Nicolas", "24-05-1979", "A", '+', v5);
		
		//ASSOCIER 4 COUREURS
		c1.associerConstructeur(cons1);
		c2.associerConstructeur(cons1);
		c3.associerConstructeur(cons3);
		c4.associerConstructeur(cons3);
		
		Rallye r1 = new Rallye("Rallye de Paris", "Paris", "France", TypeRegle.rallye);
		Rallye r2 = new Rallye("Championnat du Monde de Super Rallye", "Londres", "Angleterre", TypeRegle.superRallye);
		Rallye r3 = new Rallye("Rallye de la Noix de Grenoble", "Grenoble", "France", TypeRegle.rallye);

		EditionRallye er1_1 = new EditionRallye(r1.getNomR(), r1.getVilleR(), r1.getPaysR(), r1.getRegle(), "09-10-18", "18-10-18", 3, 2018);
		EditionRallye er1_2 = new EditionRallye(r1.getNomR(), r1.getVilleR(), r1.getPaysR(), r1.getRegle(), "09-10-19", "18-10-19", 4, 2019);
		EditionRallye er2_1 = new EditionRallye(r2.getNomR(), r2.getVilleR(), r2.getPaysR(), r2.getRegle(), "24-05-17", "31-05-17", 7, 2017);
		EditionRallye er3_1 = new EditionRallye(r3.getNomR(), r3.getVilleR(), r3.getPaysR(), r3.getRegle(), "08-06-16", "17-06-16", 2, 2016);

		//utilité du numéro d'étape dans le constructeur ?? On peut juste se servir de la position de l'étape dans l'arraylist
		Etape et1 = new Etape(Difficulte.difficile, 1, 28);
		Etape et2 = new Etape(Difficulte.difficulte_moyenne, 2, 20);
		Etape et3 = new Etape(Difficulte.sans_difficulte_particuliere, 3, 18);

		Etape et4 = new Etape(Difficulte.tres_difficile, 1, 14);
		Etape et5 = new Etape(Difficulte.difficulte_mineures, 2, 19);
		Etape et6 = new Etape(Difficulte.difficulte_moyenne, 3, 22);

		//faut il vérifier que la somme des distanceparc des spéciale est égale à la distance de son étape ? 
		Speciale s1 = new Speciale(9.5, 1, 11.5, TypeRegleSpecial.speciale);
		Speciale s2 = new Speciale(10.5, 2, 10.2, TypeRegleSpecial.superSpeciale);
		Speciale s3 = new Speciale(8, 3, 11.3, TypeRegleSpecial.speciale);

		/************************
		 * Peuplement des données 
		 ************************/

		/********************
		 *Rallye 1 édition 1  
		 ********************/

		//Etapes
		er1_1.addEtape(et1);
		er1_1.addEtape(et2);
		er1_1.addEtape(et3);

		//Speciale
		et1.addSpeciale(s1);
		et1.addSpeciale(s2);
		et1.addSpeciale(s3);

		//Coureurs
		er1_1.addCoureur(c1);
		er1_1.addCoureur(c4);
		er1_1.addCoureur(c5);

		ClassementEtape ce = new ClassementEtape(et1) ;

		ce.enregistrerTemps(c1, s1, 8.5);
		ce.enregistrerTemps(c4, s1, 8.8);
		ce.enregistrerTemps(c5, s1, 8.2);
		ce.enregistrerTemps(c1, s2, 9.3);
		ce.enregistrerTemps(c4, s2, 8.9);
		ce.enregistrerTemps(c5, s2, 9.1);


		System.out.println(ce.calculerClassement());

		/********************
		 *Rallye 1 édition 2 
		 ********************/

		//Etapes
		er1_2.addEtape(et4);
		er1_2.addEtape(et5);
		er1_2.addEtape(et6);	


		//Coureurs
		er1_2.addCoureur(c4);
		er1_2.addCoureur(c2);
		er1_2.addCoureur(c1);

		/*
		 *Rallye 2 édition 1 
		 */

		//Etapes
		er2_1.addEtape(et4);
		er2_1.addEtape(et5);
		er2_1.addEtape(et6);

		//Coureurs
		er2_1.addCoureur(c3);
		er2_1.addCoureur(c4);
		er2_1.addCoureur(c5);
		er2_1.addCoureur(c2);
		er2_1.addCoureur(c1);

		/*
		 *Rallye 3 édition 1 
		 */

		//Etapes
		er3_1.addEtape(et1);
		er3_1.addEtape(et2);
		er3_1.addEtape(et3);

		//Coureurs 
		er2_1.addCoureur(c1);
		er2_1.addCoureur(c4);
		er2_1.addCoureur(c2);
		er2_1.addCoureur(c3);


		/**************
		 * Classements*
		 **************/
		//ClassementGénéralRallye
		ClassementGeneralProvisoire cgp = new ClassementGeneralProvisoire();
		cgp.addClassementEtape(ce);

		ClassementEtape ce2 = new ClassementEtape(et2);
		Random rdm = new Random();
		ce2.enregistrerTemps(c1, s1, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c1, s2, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c1, s3, rdm.nextDouble()+20);

		ce2.enregistrerTemps(c2, s1, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c2, s2, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c2, s3, rdm.nextDouble()+20);

		ce2.enregistrerTemps(c3, s1, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c3, s2, rdm.nextDouble()+20);
		ce2.enregistrerTemps(c3, s3, rdm.nextDouble()+20);

		cgp.addClassementEtape(ce2);

		System.out.println(cgp.getListClassementEtapes().get(1).calculerClassement());
		er1_1.addClassementGeneralProvisoire(cgp);
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementG());
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementCons());
		
		for(Coureur c : er1_1.getCoureurs()) {
			System.out.println(c.toString() +" "+ c.getConstructeur());
		}


	}

}