package fr.paquet.projet;

import javax.persistence.EntityTransaction;

import fr.paquet.dataBase.Connect;

public class AdresseFactory extends Connect {

	public AdresseFactory() {
		super();
	}

	public void save(Adresse adresse) {
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().persist(adresse);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}

}
