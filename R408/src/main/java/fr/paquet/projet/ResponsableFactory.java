package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

public class ResponsableFactory extends Connect {

	public ResponsableFactory() {

	}

	/**
	 * 
	 * @param name
	 * @param firstName
	 * @return un resposable selon son nom et son prenom<br/>
	 */
	public Responsable findResponsableByNameAndFirstName(String name, String firstName) {

		Query query = getEm().createQuery(
				"SELECT Responsable FROM Responsable responsable where responsable.nom=:name and responsable.prenom=:firstName");
		query.setParameter("name", name);
		query.setParameter("firstName", firstName);

		try {

			return (Responsable) query.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Sauvegarde de responsable<br/>
	 * 
	 * @param resp
	 * @throws Exception
	 */
	public void saveResponsable(Responsable resp) throws Exception {

		if (findResponsableByNameAndFirstName(resp.getNom(), resp.getPrenom()) != null) {
			throw new Exception("ce responsable existe deja");
		} else {

			EntityTransaction t = getEm().getTransaction();
			try {

				t.begin();
				getEm().persist(resp);
				t.commit();

			} catch (Exception e) {
				t.rollback();
				throw (e);
			}
		}

	}

	/**
	 * Suppression de responsable<br/>
	 * 
	 * @param resp
	 */
	public void removeResponsable(Responsable resp) {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(resp);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	public List<Responsable> findResponsablesByName(String name) {

		Query query = getEm()
				.createQuery("SELECT responsable FROM Responsable responsable where responsable.nom=:name");

		query.setParameter("name", name);

		@SuppressWarnings("unchecked")
		List<Responsable> l = query.getResultList();

		return l;

	}
}
