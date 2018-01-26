package fr.paquet.echafaudage;

public enum TypeSol {
	
	SOL1, SOL2, SOL3, SOL4;

	/**
	 * 
	 * @return le nom de la classe d'utilisation de l'échafaudage<br/>
	 */
	public String getType() {
		switch (this) {
		case SOL1 : return ("terre meuble");
		case SOL2 : return ("terre dure");
		case SOL3 : return ("beton");
		case SOL4 : return ("gravier");
		}
		return null;
	}
	
	public double getChargeAdmissible() {
		switch (this) {
		case SOL1 : return 0.5;
		case SOL2 : return 0.75;
		case SOL3 : return 1.00;
		case SOL4 : return 1.50;
		}
		return 0;
	}

}
