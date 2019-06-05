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
	
}
