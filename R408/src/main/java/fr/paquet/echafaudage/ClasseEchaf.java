package fr.paquet.echafaudage;

public enum ClasseEchaf {

	CLASSE1, CLASSE2, CLASSE3, CLASSE4, CLASSE5;

	/**
	 * 
	 * @return le nom de la classe d'utilisation de l'echafaudage<br/>
	 */
	public String getClasse() {
		switch (this) {
		case CLASSE1:
			return ("Classe 1 : charge d'exploitation = 75 DAN/m2");
		case CLASSE2:
			return ("Classe 2 : charge d'exploitation = 150 DAN/m2");
		case CLASSE3:
			return ("Classe 3 : charge d'exploitation = 200 DAN/m2");
		case CLASSE4:
			return ("Classe 4 : charge d'exploitation = 300 DAN/m2");
		case CLASSE5:
			return ("Classe 5 : charge d'exploitation = 450 DAN/m2");

		}
		return null;
	}

	public double getChargeExploitation() {
		switch (this) {
		case CLASSE1:
			return 75;
		case CLASSE2:
			return 150;
		case CLASSE3:
			return 200;
		case CLASSE4:
			return 300;
		case CLASSE5:
			return 450;
		
		}
		return 0;
	}

}
