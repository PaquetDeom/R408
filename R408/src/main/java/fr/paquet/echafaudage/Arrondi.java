package fr.paquet.echafaudage;

import java.math.BigDecimal;

public class Arrondi {

	/**
	 * @author paquet
	 * 
	 */

	private double nbAArrondir = 0.0;
	private int nbDeChiffre = 0;

	public Arrondi(double a, int b) {
		super();
		setNbAArrondir(a);
		setNbDeChiffre(b);
	}

	private void setNbDeChiffre(int b) {
		this.nbDeChiffre = b;

	}

	private void setNbAArrondir(double a) {
		this.nbAArrondir = a;

	}

	public double getDoubleArrondi() {

		double a = 0.0;

		BigDecimal bd = new BigDecimal(getNbAArrondir());
		bd = bd.setScale(getNbDeChiffre(), BigDecimal.ROUND_DOWN);
		a = bd.doubleValue();

		return a;
	}

	private int getNbDeChiffre() {

		return nbDeChiffre;
	}

	private double getNbAArrondir() {

		return nbAArrondir;
	}

}
