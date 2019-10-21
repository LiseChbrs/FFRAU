package GestionClassement;
import java.util.HashMap;
import GestionInscription.Coureur;
import GestionRallye.Speciale;;

public class ClassementEtape {
	
	HashMap<Coureur,HashMap<Speciale, Double>> listTemps;
	HashMap<Coureur,Rapport> listRapport;
	
	public ClassementEtape() {
		this.listTemps = new HashMap<Coureur, HashMap<Speciale, Double>>();
		
		this.listRapport = new HashMap<Coureur, Rapport>();
		
	}
	
	public void enregistrerTemps(Coureur c, Speciale s, Double t) {
		
	}
	
	
	public void enregistrerRapport(Coureur c, Rapport r) {
		this.listRapport.put(c, r);
	}
	
	public void calculerTempsCoef() {
		
	}
	
	public void calculerClassement() {
		
	}
	

}