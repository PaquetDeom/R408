package fr.paquet.echafaudage.element;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

public enum InstanciationElement {

	amarrageBaie, embasePoteaux, equerreGardeCorps, gardeCorps, jambeForce, lisse, plancherTrappe, plateau, plinthe, poteau, socleReglable, verinDeButtee;

	public TypeElement instanciationElt(String name, String ref, Constructeur cons, double poids, TypeEchaf tE,
			double surface, double longueur) {
		switch (this) {
		case amarrageBaie:
			return new AmarrageBaie(name, ref, cons, poids, tE);

		case embasePoteaux:
			return new EmbasePoteaux(name, ref, cons, poids, tE);

		case equerreGardeCorps:
			return new EquerreGardesCorps(name, ref, cons, poids, tE, longueur);

		case gardeCorps:
			return new GardesCorps(name, ref, cons, poids, tE, longueur);

		case jambeForce:
			return new JambeDeForce(name, ref, cons, poids, tE);

		case lisse:
			return new Lisse(name, ref, cons, poids, tE, longueur);

		case plancherTrappe:
			return new PlancherTrappe(name, ref, cons, poids, tE, longueur);

		case plateau:
			return new Plateau(name, ref, cons, poids, tE, longueur, surface);

		case plinthe:
			return new Plinthe(name, ref, cons, poids, tE, longueur);

		case poteau:
			return new Poteaux(name, ref, cons, poids, tE, longueur);

		case socleReglable:
			return new SocleReglable(name, ref, cons, poids, tE, longueur);

		default:
			return null;
		}
	}

	public String toString() {
		switch (this) {

		case amarrageBaie:
			return "Amarrage de baie";

		case embasePoteaux:
			return "Embase de poteaux";

		case equerreGardeCorps:
			return "Equerre de gardes corps";

		case gardeCorps:
			return "Gardes corps";

		case jambeForce:
			return "Jambe de force";

		case lisse:
			return "Lisse";

		case plancherTrappe:
			return "Plancher trappe";

		case plateau:
			return "Plateau";

		case plinthe:
			return "Plinthe";

		case poteau:
			return "Poteau";

		case socleReglable:
			return "Socle réglable";

		default:
			return null;

		}
	}
}
