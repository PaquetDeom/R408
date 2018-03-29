package fr.paquet.echafaudage;

public enum ClasseEchaf {

	CLASSE1, CLASSE2, CLASSE3, CLASSE4, CLASSE5, CLASSE6;

	/**
	 * 
	 * @return le nom de la classe d'utilisation de l'�chafaudage<br/>
	 */
	public String getClasse() {
		switch (this) {
		case CLASSE1:
			return ("Classe 1 : 0.75KN/m2");
		case CLASSE2:
			return ("Classe 2 : 1.50KN/m2");
		case CLASSE3:
			return ("Classe 3 : 2.00KN/m2");
		case CLASSE4:
			return ("Classe 4 : 3.00KN/m2");
		case CLASSE5:
			return ("Classe 5 : 4.50KN/m2");
		case CLASSE6:
			return ("Classe 6 : 6.00KN/m2");
		}
		return null;
	}

	public double getChargeExploitation() {
		switch (this) {
		case CLASSE1:
			return 0.75;
		case CLASSE2:
			return 1.50;
		case CLASSE3:
			return 2.00;
		case CLASSE4:
			return 3.00;
		case CLASSE5:
			return 4.50;
		case CLASSE6:
			return 6.00;
		}
		return 0;
	}

}
