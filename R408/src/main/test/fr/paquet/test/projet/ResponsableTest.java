package fr.paquet.test.projet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.paquet.projet.Chantier;
import fr.paquet.projet.Client;
import fr.paquet.projet.Projet;
import fr.paquet.projet.Responsable;

public class ResponsableTest {

	@Test
	public void testResponsableNom() {
		try {

			Responsable resp = new Responsable("      pAqUet-dEOm   ", " AmElia ");

			assertTrue(resp.getNom().equals("PAQUET-DEOM"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testResponsablePrenom() {
		try {

			Responsable resp = new Responsable("      pAqUet-dEOm   ", " AmElia ");

			assertTrue(resp.getPrenom().equals("Amelia"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testResponsableProjets() {
		try {

			Client client = new Client();
			Chantier chantier = new Chantier();
			Responsable resp = new Responsable("PAQUET-DEOM", "Amelia");

			fr.paquet.projet.Projet projet = new Projet(null, "   tItRe    ", client, chantier, resp);

			assertTrue(resp.getProjets().get(0).equals(projet));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
