package fr.paquet.io.csv;

public enum ParameterCsv {

	NAME, REFERENCE, CONSTRUCTEUR, POIDS, SURFACE, POSITION;

	public int getPositionLine() {
		switch (this) {
		case NAME:
			return 1;
		case REFERENCE:
			return 2;
		case CONSTRUCTEUR:
			return 3;
		case POIDS:
			return 4;
		case SURFACE:
			return 5;
		case POSITION:
			return 6;
		default:
			return 0;
		}
	}

	public String toString() {
		switch (this) {
		case NAME:
			return "nom de l'élément";
		case REFERENCE:
			return "référence";
		case CONSTRUCTEUR:
			return "constructeur";
		case POIDS:
			return "poids";
		case SURFACE:
			return "position";
		case POSITION:
			return "surface";
		default:
			return null;
		}

	}

}
