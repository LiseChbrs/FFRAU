package GestionClassement;

import java.util.ArrayList;

import GestionRallye.EditionRallye;

public class ClassementAnnuel {
	ArrayList<EditionRallye> listER;
	public ClassementAnnuel() {
		this.listER = new ArrayList<EditionRallye>();
	}
	
	public void addEditionRallye(EditionRallye er) {
		this.listER.add(er);
	}
	
	public ArrayList<Couple> getClassementAnnuel(int annee, String typeV) {
		ArrayList<Couple> listSum = new ArrayList<Couple>();
		ArrayList<Couple> listPart = new ArrayList<Couple>();
		for (EditionRallye er : listER) {
			if (er.getAnneeER() == annee && er.getClassementGeneralProvisoires().size() >=1) {
				ClassementGeneralProvisoire cgp = er.calculerClassementDefinitif();
				if (cgp != null) {
				for (Couple cp : cgp.calculerClassementG(typeV)) {
					boolean isExist = false;
					for (Couple cpList : listSum) {
						if(cp.getKey() == cpList.getKey()) {
							cpList.setValue(cpList.getValue() + cp.getValue());
							for (Couple cpPart : listPart) {
								if (cpPart.getKey() == cp.getKey()) {
									cpPart.setValue(cpPart.getValue() + 1);
									break;
								}
							}
							isExist = true;
							break;
							
						}
					}
					if (!isExist) {
						listSum.add(cp);
						listPart.add(new Couple(cp.getKey(), (double)1));
					}
				}
				}
			}
			
		}
		
		ArrayList<Couple> result = new ArrayList<Couple>();
		
		for (Couple cpAver : listSum) {
			for (Couple cpPt : listPart) {
				if (cpPt.getKey() == cpAver.getKey()) {
					cpAver.setValue(cpAver.getValue()/cpPt.getValue());
					break;
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
	
	public void calculerClassementAnnuel(int annee) {
		
	}
	
	public void miseAJourClassementAnnuel(ClassementGeneralProvisoire cg) {
		
	}
	

}