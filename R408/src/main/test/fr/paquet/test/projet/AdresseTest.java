package fr.paquet.test.projet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.paquet.projet.*;

public class AdresseTest {

	private Adresse getAdresse() throws Exception {
		DonneesTest test = new DonneesTest();
		Adresse adresse = test.getAdresseClient();
		adresse.setMail("           nath@sfr.fr              ");
		adresse.setTelephone("          0324721485                      ");
		return adresse;
	}

	@Test
	public void testGetAdresse1() {
		try {
			assertTrue(getAdresse().getAdresse1().equals("le grès"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAdresse2() {
		try {
			assertTrue(getAdresse().getAdresse2().equals("659"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAdresse3() {
		try {
			assertTrue(getAdresse().getAdresse3().equals("rue du Pastel"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAdresse4() {
		try {
			assertTrue(getAdresse().getAdresse4().equals(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCommune() {
		try {
			assertTrue(getAdresse().getCommune().getCommune().equals("AMBRES"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMail() {
		try {
			assertTrue(getAdresse().getMail().equals("nath@sfr.fr"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTel() {
		try {
			assertTrue(getAdresse().getTel().equals("0324721485"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
