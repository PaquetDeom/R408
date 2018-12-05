package fr.paquet.echafaudage;

import java.math.BigDecimal;

public class Arrondi {

	/**
	 * @author paquet
	 * 
	 */

	public static double getDoubleArrondi(double a, int b) {

		BigDecimal bd = new BigDecimal(a);
		bd = bd.setScale(b, BigDecimal.ROUND_DOWN);
		a = bd.doubleValue();

		return a;
	}

}
