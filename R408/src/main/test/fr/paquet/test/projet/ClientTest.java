package fr.paquet.test.projet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.paquet.projet.Adresse;
import fr.paquet.projet.Client;
import fr.paquet.projet.Commune;
import fr.paquet.projet.Projet;

public class ClientTest {

	private Client getClient() throws Exception {

		// creation adresse
		Adresse adresse = new Adresse(null, null, null, null, new Commune("81500", "         aMbres"));
		Client client = new Client(null, "             PAQUET-deom        ", "           NaThanAel         ", adresse);

		// creation des projets
		Projet p1 = new Projet();
		Projet p2 = new Projet();
		Projet p3 = new Projet();
		p1.setTitre("TITRE1");
		p2.setTitre("TITRE2");
		p3.setTitre("TITRE3");

		// add projets à la liste de projets de client
		client.addProjet(p1);
		client.addProjet(p2);
		client.addProjet(p3);

		return client;
	}

	@Test
	public void testGetProjets() {
		try {

			assertTrue(getClient().getProjets().size() == 3);

			for (int i = 0; i < getClient().getProjets().size(); i++) {
				Projet p = getClient().getProjets().get(i);
				switch (i) {
				case 0:
					assertTrue(p.getTitre().equals("Titre1"));
					break;
				case 1:
					assertTrue(p.getTitre().equals("Titre2"));
					break;
				case 2:
					assertTrue(p.getTitre().equals("Titre3"));
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAdresse() {
		try {

			assertTrue(getClient().getAdresse().getCommune().getCommune().equals("AMBRES"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
