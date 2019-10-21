package GestionClassement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;


public class ClassementGeneralProvisoire {
	ArrayList<ClassementEtape> listClassementEtapes;
	
	public ClassementGeneralProvisoire() {
		this.listClassementEtapes = new ArrayList<ClassementEtape>();
	}
	
	public void addClassementEtape(ClassementEtape ce) {
		this.listClassementEtapes.add(ce);
	}
	
	public ArrayList<Couple> calculerClassementG() {
		//HashMap<Coureur, Double> sumTemps = new HashMap<Coureur, Double>();
		ArrayList<Couple> listSum = new ArrayList<Couple>();
		for (ClassementEtape ce : listClassementEtapes) {
			ArrayList<Couple> classNow= new ArrayList<Couple>();
			classNow = ce.calculerClassement();
			for (Couple cp : classNow) {
				boolean isExist = false;
				for (Couple ls : listSum) {
					if (ls.getKey() == cp.getKey()) {
						ls.setValue(cp.getValue() + cp.getValue());
						isExist = true;
						break;
					}
				}
				if (!isExist) {
					listSum.add(cp);
				}
			}
		}
		
		for (int i = 0; i < listSum.size(); i++) {
			for (int j = 0; j < listSum.size() - 1 - i; j++) {
				if (listSum.get(j + 1).getValue() < listSum.get(j).getValue()) {
					Couple cp = listSum.get(j);
					listSum.set(j, listSum.get(j + 1));
					listSum.set(j + 1, cp);
				}
			}
		}
		return listSum;
	}
	
	
	public HashMap<Constructeur, Integer> calculerClassementCons() {
		ArrayList<Couple> classementC = this.calculerClassementG();
		HashMap<Constructeur, Integer> result = new HashMap<Constructeur, Integer>();
		for1:
		for (int i = 0; i < classementC.size(); i++) {
			Coureur c = classementC.get(i).getKey();
			if (!result.containsKey(c.getConstructeur())) {
				result.put(c.getConstructeur(), 0);
			}
			switch (i) {
			case 0:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 10);
				break;
			case 1:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 8);
				break;
			case 2:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 6);
				break;
			case 3:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 5);
				break;
			case 4:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 4);
				break;
			case 5:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 3);
				break;
			case 6:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 2);
				break;
			case 7:
				result.put(c.getConstructeur(), result.get(c.getConstructeur()) + 1);
				break;
			case 8:
				
				break for1;
			}
		}
		
		return result;
	}
	

}