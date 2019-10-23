package test;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import GestionClassement.*;
import GestionDonnees.*;
import GestionInscription.*;
import GestionRallye.*;
import GestionVue.EnregistrementCoureurSpeciale;
import GestionVue.Frallye;
import GestionVue.Fmenu;

public class Run {

	public static void main (String[] args) {
		ArrayList<Rallye> listRallye = new ArrayList<Rallye>();
		listRallye.add(new Rallye("France", "Toulouse", "France", TypeRegle.rallye));
		ArrayList<EditionRallye> listERallye = new ArrayList<EditionRallye>();
		ArrayList<Etape> listEtape = new ArrayList<Etape>();



		Constructeur cons1 = new Constructeur("Mercedes");
		Constructeur cons2 = new Constructeur("Peugeot");
		Constructeur cons3 = new Constructeur("Volkswagen");

		Vehicule v1 = new Camion("TWN PKS", 300, cons1);
		Vehicule v2 = new Moto("PRK SN RC", 100, cons3);
		Vehicule v3 = new Voiture("THFFC", 150, cons2);
		Vehicule v4 = new Camion("THKLLNG", 310, cons2);
		Vehicule v5 = new Voiture("LFES STRNG", 170, cons2);

		Coureur c1 = new Coureur(1, "SMITH", "Elliott", "05-01-1970", "A", '-', v1);
		Coureur c2 = new Coureur(2, "DUBOIS", "Clement", "03-10-1990", "B", '+', v2);
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

		//utilit� du num�ro d'�tape dans le constructeur ?? On peut juste se servir de la position de l'�tape dans l'arraylist
		Etape et1 = new Etape(Difficulte.difficile, 1, 28,er1_1);
		Etape et2 = new Etape(Difficulte.difficulte_moyenne, 2, 20,er1_1);
		Etape et3 = new Etape(Difficulte.sans_difficulte_particuliere, 3, 18,er1_1);

		Etape et4 = new Etape(Difficulte.tres_difficile, 1, 14,er3_1);
		Etape et5 = new Etape(Difficulte.difficulte_mineures, 2, 19,er3_1);
		Etape et6 = new Etape(Difficulte.difficulte_moyenne, 3, 22,er3_1);

		//faut il v�rifier que la somme des distanceparc des sp�ciale est �gale � la distance de son �tape ? 
		Speciale s1 = new Speciale(9.5, 1, 11.5, TypeRegleSpecial.speciale);
		Speciale s2 = new Speciale(10.5, 2, 10.2, TypeRegleSpecial.superSpeciale);
		Speciale s3 = new Speciale(8, 3, 11.3, TypeRegleSpecial.speciale);

		/************************
		 * Peuplement des donn�es 
		 ************************/

		/********************
		 *Rallye 1 �dition 1  
		 ********************/

		ClassementAnnuel ca = new ClassementAnnuel();




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

		//FERMER AUX INSCRIPTIONS
		er1_1.fermerInscription();

		ClassementEtape ce = new ClassementEtape(et1) ;

		ce.enregistrerTemps(c1, s1, 8.5);
		ce.enregistrerTemps(c4, s1, 8.8);
		ce.enregistrerTemps(c5, s1, 8.2);
		ce.enregistrerTemps(c1, s2, 9.3);
		ce.enregistrerTemps(c4, s2, 8.9);
		ce.enregistrerTemps(c5, s2, 9.1);


		System.out.println(ce.calculerClassement());

		ClassementEtape ceet2 = new ClassementEtape(et2);

		ceet2.enregistrerTemps(c1, s1, 9.14);
		ceet2.enregistrerTemps(c1,s2,10.13);
		ceet2.enregistrerTemps(c2, s1, 6.18);
		ceet2.enregistrerTemps(c2, s2, 7.89);
		ceet2.enregistrerTemps(c3, s1, 17.43);
		ceet2.enregistrerTemps(c2,s3, 13.74);
		ceet2.enregistrerTemps(c5, s1, 9.14);
		ceet2.enregistrerTemps(c5, s2, 18.10);


		System.out.println(ceet2.calculerClassement());

		ClassementEtape ceet3 = new ClassementEtape(et3);

		ceet3.enregistrerTemps(c1, s1, 10.45);
		ceet3.enregistrerTemps(c1,s2,8.65);
		ceet3.enregistrerTemps(c2, s1, 16.18);
		ceet3.enregistrerTemps(c2, s2, 14.45);
		ceet3.enregistrerTemps(c3, s1, 19.34);
		ceet3.enregistrerTemps(c2,s3, 11.45);
		ceet3.enregistrerTemps(c5, s1, 4.7);
		ceet3.enregistrerTemps(c5, s2, 14.02);


		System.out.println(ceet3.calculerClassement());


		/********************
		 *Rallye 1 �dition 2 
		 ********************/

		//Etapes
		er1_2.addEtape(et4);
		er1_2.addEtape(et5);
		er1_2.addEtape(et6);	


		//Coureurs
		//		er1_2.addCoureur(c4);
		//		er1_2.addCoureur(c2);
		//		er1_2.addCoureur(c1);

		/*
		 *Rallye 2 �dition 1 
		 */

		//Etapes
		er2_1.addEtape(et4);
		er2_1.addEtape(et5);
		er2_1.addEtape(et6);

		//Coureurs
		//		er2_1.addCoureur(c3);
		//		er2_1.addCoureur(c4);
		//		er2_1.addCoureur(c5);
		//		er2_1.addCoureur(c2);
		//		er2_1.addCoureur(c1);

		/*
		 *Rallye 3 �dition 1 
		 */

		//Etapes
		er3_1.addEtape(et1);
		er3_1.addEtape(et2);
		er3_1.addEtape(et3);

		//Coureurs 
		er3_1.addCoureur(c1);
		er3_1.addCoureur(c4);
		er3_1.addCoureur(c2);
		er3_1.addCoureur(c3);
		er3_1.addCoureur(c5);


		/**************
		 * Classements*
		 **************/
		//ClassementG�n�ralRallye
		ClassementGeneralProvisoire cgp = new ClassementGeneralProvisoire(er3_1);
		cgp.addClassementEtape(ce);
		cgp.addClassementEtape(ceet2);
		cgp.addClassementEtape(ceet3);


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

		Rapport r11,r21;
		r11 = new Rapport(+15,false);
		r21 = new Rapport(-12.25,true);
		ce2.enregistrerRapport(c1, r11);
		//ce2.enregistrerRapport(c2, r21);

		cgp.addClassementEtape(ce2);

		System.out.println(cgp.getListClassementEtapes().get(1).calculerClassement());
		er1_1.addClassementGeneralProvisoire(cgp);
		System.out.println("Voiture");
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementG("Voiture"));
		System.out.println("Moto");
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementG("Moto"));
		System.out.println("Camion");
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementG("Camion")+"\n");
		System.out.println(er1_1.getClassementRallye().get(0).calculerClassementCons() +"\n");



		for(Coureur c : er1_1.getCoureurs()) {
			if(c.getConstructeur() == null) {
				System.out.println(c.toString() +" => Aucun Constructeur");
			}else {
				System.out.println(c.toString() +" => "+ c.getConstructeur());
			}
		}


		//CLASSEMENT ANNUEL
		ca.addEditionRallye(er1_1);
		ca.addEditionRallye(er1_2);
		ca.addEditionRallye(er2_1);
		ca.addEditionRallye(er3_1);
		ArrayList<Couple> classAnnuel = ca.getClassementAnnuel(2018, "");
		int place =1;
		for (Couple couple : classAnnuel) {
			System.out.println("Place "+place+" "+couple.getKey() + " : " + couple.getValue());
			place ++;
		}

		ClassementGeneralProvisoire cgp3 = new ClassementGeneralProvisoire(er1_1);

		//RETOUR CLASSEMENT RALLYE DE PARIS
		System.out.println("\n Rallye de paris Voiture \n"+er1_1.calculerClassementDefinitif().calculerClassementG("Voiture"));
		System.out.println("\n Rallye de paris Moto \n"+er1_1.calculerClassementDefinitif().calculerClassementG("Camion"));
		System.out.println("\n Rallye de paris Camion \n"+er1_1.calculerClassementDefinitif().calculerClassementG("Moto"));



		//Compl�ter les enregistrements
		System.out.println("\n ETAPE DE "+er3_1.getNomR());
		for(Etape e : er3_1.getEtapes()) {
			e.setEtat(Etat.debute);
			ClassementEtape cE;
			cE = new ClassementEtape(e);

			cE.enregistrerTemps(c3, s1, rdm.nextDouble()+20);
			cE.enregistrerTemps(c1, s1, rdm.nextDouble()+20);
			cE.enregistrerTemps(c2, s1, rdm.nextDouble()+20);
			cE.enregistrerTemps(c4, s1, rdm.nextDouble()+20);
			cE.enregistrerTemps(c5, s1, rdm.nextDouble()+20);

			cE.enregistrerTemps(c3, s2, rdm.nextDouble()+20);
			cE.enregistrerTemps(c1, s2, rdm.nextDouble()+20);
			cE.enregistrerTemps(c2, s2, rdm.nextDouble()+20);
			cE.enregistrerTemps(c4, s2, rdm.nextDouble()+20);
			cE.enregistrerTemps(c5, s2, rdm.nextDouble()+20);

			cE.enregistrerTemps(c3, s3, rdm.nextDouble()+20);
			cE.enregistrerTemps(c1, s3, rdm.nextDouble()+20);
			cE.enregistrerTemps(c2, s3, rdm.nextDouble()+20);
			cE.enregistrerTemps(c4, s3, rdm.nextDouble()+20);
			cE.enregistrerTemps(c5, s3, rdm.nextDouble()+20);

			e.setClassement(cE);
			cgp3.addClassementEtape(cE);
		}

		//		for(Etape e : er3_1.getEtapes()) {
		//			System.out.println(e.getClassement().calculerClassement());
		//		}

		er3_1.addClassementGeneralProvisoire(cgp3);
		System.out.println("Grenoble Voiture \n"+er3_1.calculerClassementDefinitif().calculerClassementG("Voiture"));
		System.out.println("Grenoble Moto \n"+er3_1.calculerClassementDefinitif().calculerClassementG("Moto"));
		System.out.println("Grenoble Camion \n"+er3_1.calculerClassementDefinitif().calculerClassementG("Camion"));


		ArrayList<Coureur> coureurs = new ArrayList<Coureur>();
		coureurs.add(c1);
		//coureurs.add(c2);
		//coureurs.add(c3);
		coureurs.add(c4);
		coureurs.add(c5);
		for(Coureur xi : coureurs) {
			System.out.println("Coureur : "+xi.getNomC()+" "+xi.getPrenomC()+xi.getHistoriqueCoureur());
		}

		listRallye.add(r1);
		listRallye.add(r2);
		listRallye.add(r3);
		
		listERallye.add(er1_1);
		
		
		Fmenu frame = new Fmenu(listRallye, listERallye, listEtape,er1_1);
		frame.setVisible(true);

		//EnregistrementCoureurSpeciale ecs = new EnregistrementCoureurSpeciale(er1_1);
	}

	//

}