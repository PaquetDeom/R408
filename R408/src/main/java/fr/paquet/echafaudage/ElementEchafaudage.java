package fr.paquet.echafaudage;

public enum ElementEchafaudage {

	PIED, PIEDINCLINABLE, CADRE, GARDECORPSGRAND, GARDECORPSPETIT, PLINTHE, CONTREVENTEMENT, DEPORT, PETITEPLATEFORME, GRANDEPLATEFORME;

	public String getName() {
		switch (this) {
		case PIED:
			return "pied droit";
		case PIEDINCLINABLE :
			return "pied inclinable";
		case CADRE :
			return "cadre";
		case GARDECORPSGRAND :
			return "grand garde-corp";
		case GARDECORPSPETIT :
			return "petit garde-corp";
		case PLINTHE :
			return "plinthe";
		case CONTREVENTEMENT :
			return "contreventement";
		case DEPORT :
			return "console de déport";
		case PETITEPLATEFORME :
			return "petite plateforme";
		case GRANDEPLATEFORME :
			return "grande plateforme";
		}
		return null;
	}
}
