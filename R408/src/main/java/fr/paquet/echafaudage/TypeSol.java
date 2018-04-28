package fr.paquet.echafaudage;

public enum TypeSol {

	SABLEFIN, SABLEGROSSIER, SABLEGRAVIER, ARGILEMOLLE, ARGILE, ARGILEDURE, ROCHE, BITUME, BRIQUEPLEINE, PIERRE, BA;

	/**
	 * 
	 * @return le nom de la classe d'utilisation de l'echafaudage<br/>
	 */
	public String getType() {
		switch (this) {
		case SABLEFIN:
			return ("sable fin");
		case SABLEGROSSIER:
			return ("sable grossier");
		case SABLEGRAVIER:
			return ("sable gravier");
		case ARGILEMOLLE:
			return ("argile molle");
		case ARGILE:
			return ("argile");
		case ARGILEDURE:
			return ("argile dure");
		case ROCHE:
			return ("roche");
		case BITUME:
			return ("bitume");
		case BRIQUEPLEINE:
			return ("brique pleine");
		case PIERRE:
			return ("pierre");
		case BA:
			return ("BA");
		}
		return null;
	}

	public double getChargeAdmissible() {
		switch (this) {
		case SABLEFIN:
			return 0.5;
		case SABLEGROSSIER:
			return 2;
		case SABLEGRAVIER:
			return 3;
		case ARGILEMOLLE:
			return 0.1;
		case ARGILE:
			return 1.5;
		case ARGILEDURE:
			return 1;
		case ROCHE:
			return 10;
		case BITUME:
			return 1;
		case BRIQUEPLEINE:
			return 12;
		case PIERRE:
			return 15;
		case BA:
			return 45;
		}
		return 0;
	}

}
