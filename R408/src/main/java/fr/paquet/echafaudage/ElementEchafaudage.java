package fr.paquet.echafaudage;

public enum ElementEchafaudage {

	amarrageBaie, embasePoteaux, equereGardeCoprs70, equereGardeCoprsMulti3, gardeCorps70, jambeForce, lisse70, plancherTrappe3, plateau3, plateau70, plinthe70, plinthe3, poteau1, poteau2, poteau3, socleReglable50, verinDeButtee;

	public String getName() {
		switch (this) {
		case amarrageBaie:
			return "Amarrage baie";
		case embasePoteaux:
			return "Embase poteaux";
		case equereGardeCoprs70:
			return "Equere garde-corps 0.70 m";
		case equereGardeCoprsMulti3:
			return "Garde corps Multi 3.00 m";
		case gardeCorps70:
			return "Garde-corps 0.70 m";
		case jambeForce:
			return "Jambe force et bracon";
		case lisse70:
			return "Lisse 0.70 m";
		case plancherTrappe3:
			return "Plancher trappe 3.00 m";
		case plateau3:
			return "Plateau 3.00 m"; // plateforme
		case plateau70:
			return "Plateau 70"; // plateforme
		case plinthe70:
			return "Plinthe 0.70 m";
		case plinthe3:
			return "Plinthe 3.00 m";
		case poteau1:
			return "Poteau 1.00 m";
		case poteau2:
			return "Poteau 2.00 m";
		case poteau3:
			return "Poteau 3.00 m";
		case socleReglable50:
			return "Socle Reglable 0.5 m"; // pied
		case verinDeButtee:
			return "Verin de butee";
		}
		return null;
	}

	
	
}
