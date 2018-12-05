package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

public class CommuneFactory extends Connect {

	public CommuneFactory() {
		super();
	}

	public void save(Commune commune) {
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().persist(commune);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		}
	}

	public List<Commune> findCommuneByCode(String code) {

		Query query = getEm().createQuery("SELECT Commune FROM Commune commune where commune.codeCommune=:code");
		query.setParameter("code", code);

		try {

			return (List<Commune>) query.getResultList();

		} catch (NoResultException e) {

			e.printStackTrace(System.out);
			return null;
		}

	}

}
