package fr.paquet.io.csv;

public enum ParameterCsv {

	NAME, REFERENCE, CONSTRUCTEUR, POIDS, SURFACE, POSITION;

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
			return "surface";
		case POSITION:
			return "position";
		default:
			return null;
		}
	}

	public int getDefaultValue() {
		switch (this) {
		case NAME:
			return 0;
		case REFERENCE:
			return 2;
		case CONSTRUCTEUR:
			return 1;
		case POIDS:
			return 4;
		case SURFACE:
			return 5;
		case POSITION:
			return 3;
		default:
			return 0;
		}
	}

}
