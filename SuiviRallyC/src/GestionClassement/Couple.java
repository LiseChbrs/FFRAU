package GestionClassement;

import GestionInscription.Coureur;

/***
 * Classe permettant de stocker les coureurs et leur temps dans les classements.
 * @author MIAGE UT1
 *
 */
public class Couple {
	private Coureur key;
	private Double value;
	public Couple(Coureur key, Double value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Coureur getKey() {
		return key;
	}
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double d) {
		this.value = d;
	}

	public boolean equals(Object o) {
		if (o instanceof Couple) {
			return this.key.equals(((Couple) o).getKey());
		}else {
			return false;
		}
	}

	public String toString() {
		return this.key +" : "+this.value;
	}

}
