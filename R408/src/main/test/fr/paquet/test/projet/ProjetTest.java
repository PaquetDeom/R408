package fr.paquet.test.projet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.paquet.projet.*;

public class ProjetTest {

	@Test
	public void testProjetTitre() {
		try {

			Client client = new Client();
			Chantier chantier = new Chantier();
			Responsable resp = new Responsable();

			fr.paquet.projet.Projet projet = new Projet(null, "   tItRe    ", client, chantier, resp);

			assertTrue(projet.getTitre().equals("Titre"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProjetClient() {
		try {

			Client client = new Client();
			Chantier chantier = new Chantier();
			Responsable resp = new Responsable();

			fr.paquet.projet.Projet projet = new Projet(null, "   tItRe    ", client, chantier, resp);

			assertTrue(projet.getClient().equals(client));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProjetChantier() {
		try {

			Client client = new Client();
			Chantier chantier = new Chantier();
			Responsable resp = new Responsable();

			fr.paquet.projet.Projet projet = new Projet(null, "   tItRe    ", client, chantier, resp);

			assertTrue(projet.getChantier().equals(chantier));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testProjetResponsable() {
		try {

			Client client = new Client();
			Chantier chantier = new Chantier();
			Responsable resp = new Responsable();

			fr.paquet.projet.Projet projet = new Projet(null, "   tItRe    ", client, chantier, resp);

			assertTrue(projet.getResp().equals(resp));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
