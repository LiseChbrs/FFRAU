package GestionClassement;

import GestionRallye.Speciale;

public class SpecialTemps {

	private Speciale key;
	private Double value;

	public SpecialTemps(Speciale key, Double value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Speciale getKey() {
		return key;
	}
	public void setKey(Speciale key) {
		this.key = key;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}


	public boolean equals(Object o) {
		if(o instanceof SpecialTemps) {
			return ((SpecialTemps) o).getKey().equals(this.getKey());
		}else {
			return false;
		}
	}
}
