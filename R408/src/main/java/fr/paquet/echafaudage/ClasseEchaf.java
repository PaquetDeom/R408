package fr.paquet.echafaudage;

import javax.persistence.*;

public enum ClasseEchaf {

	CLASSE1, CLASSE2, CLASSE3, CLASSE4, CLASSE5, CLASSE6;

	/**
	 * 
	 * @return le nom de la classe d'utilisation de l'�chafaudage<br/>
	 */
	public String getCLASSE() {
		switch (this) {
		case CLASSE1:
			return ("Classe 1");
		case CLASSE2:
			return ("Classe 2");
		case CLASSE3:
			return ("Classe 3");
		case CLASSE4:
			return ("Classe 4");
		case CLASSE5:
			return ("Classe 5");
		case CLASSE6:
			return ("Classe 6");
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
