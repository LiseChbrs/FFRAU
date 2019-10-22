package GestionClassement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;
import GestionInscription.Constructeur;
import GestionInscription.Coureur;
import GestionInscription.*;


public class ClassementGeneralProvisoire {
	private ArrayList<ClassementEtape> listClassementEtapes;
	
	public ClassementGeneralProvisoire() {
		this.listClassementEtapes = new ArrayList<ClassementEtape>();
	}
	
	public void addClassementEtape(ClassementEtape ce) {
		this.listClassementEtapes.add(ce);
	}
	
	public ArrayList<Couple> calculerClassementG(String typeV) {
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
		//All Coureur with their TempsSUM have been added in the listSum.
		
		
		switch (typeV) {
		case "Moto":
			for (int i = 0; i < listSum.size(); i++) {
				if (!(listSum.get(i).getKey().getVehicule() instanceof Moto)) {
					listSum.remove(i);
					i--;
				}
			}
			
			break;
		case "Camion":
			for (int i = 0; i < listSum.size(); i++) {
				if (!(listSum.get(i).getKey().getVehicule() instanceof Camion)) {
					listSum.remove(i);
					i--;
				}
			}
			break;
		case "Voiture":
			for (int i = 0; i < listSum.size(); i++) {
				if (!(listSum.get(i).getKey().getVehicule() instanceof Voiture)) {
					listSum.remove(i);
					i--;
				}
			}
			break;
		default:
			break;
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
		ArrayList<Couple> classementC = this.calculerClassementG("default");
		HashMap<Constructeur, Integer> result = new HashMap<Constructeur, Integer>();
		for1:
		for (int i = 0; i < classementC.size(); i++) {
			Coureur c = classementC.get(i).getKey();
			if (!result.containsKey(c.getConstructeur()) && c.getConstructeur() != null) {
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
		
	    HashMap<Constructeur, Integer> sorted = result
	            .entrySet()
	            .stream()
	            .sorted(comparingByValue())
	            .collect(
	                toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
	                    LinkedHashMap::new));
		/*
        List<Map.Entry<	,Integer>> list = new ArrayList<Map.Entry<Constructeur,Integer>>(result.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Constructeur,Integer>>() {
            
            public int compare(Entry<Constructeur, Integer> o1,
                    Entry<Constructeur, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
        */
		return sorted;
	}
//<<<<<<< HEAD
//=======


	
//>>>>>>> branch 'master' of https://github.com/LiseChbrs/FFRAU.git

	//METHODS
	public ArrayList<ClassementEtape> getListClassementEtapes() {
		return listClassementEtapes;
	}
}