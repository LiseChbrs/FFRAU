package test;

import GestionDonnees.Difficulte;
import GestionDonnees.TypeRegle;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;
import GestionInscription.Voiture;
import GestionRallye.EditionRallye;
import GestionRallye.Etape;
import GestionRallye.TypeRegleSpecial;

public class JeuDeDonnees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EditionRallye er = new EditionRallye("miage", "Argeles", "France", TypeRegle.rallye, "26/12/2019", "23/07/2020", 1, 2019);
		Etape e1 = new Etape(Difficulte.difficulte_moyenne, 1,126);
		er.addEtape(e1);
		er.ajouterSpeciale(e1, 123, 1, 150.35, TypeRegleSpecial.speciale);
		er.ajouterSpeciale(e1, 123, 2, 150.35, TypeRegleSpecial.speciale);

		System.out.println(er.toString());
		Constructeur c1 = new Constructeur("MARHABAAT");
		Voiture v1 = new Voiture("126AG63",300,c1);
		Voiture v2 = new Voiture("126AG63",250,c1);
		Voiture v3 = new Voiture("126AG63",445,c1);
		er.addCoureur(new Coureur(1, "Giroux", "Romain", "26/12/1995", "ZQSD", '/', v1));
		er.addCoureur(new Coureur(2, "Chambers", "Lise", "26/12/1997", "ZQSD", '/', v2));
		er.addCoureur(new Coureur(3, "Frid", "Mohamed", "26/12/1995", "ZQSD", '/', v3));

	}
}
