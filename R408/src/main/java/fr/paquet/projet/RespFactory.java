package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

public class RespFactory extends Connect {

	public RespFactory() {

	}

	/**
	 * 
	 * @param name
	 * @param firstName
	 * @return un responsable selon son nom et son prenom<br/>
	 */
	public Responsable findResponsableByNameAndFirstName(String name, String firstName) {

		Query query = getEm().createQuery(
				"SELECT Responsable FROM Responsable responsable where responsable.nom=:name and responsable.prenom=:firstName");
		query.setParameter("name", name);
		query.setParameter("firstName", firstName);

		try {

			return (Responsable) query.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace(System.out);
			return null;
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

	/**
	 * Sauvegarde de responsable<br/>
	 * 
	 * @param resp
	 * @throws Exception
	 */
	public void saveResp(Responsable resp) throws Exception {

		if (findResponsableByNameAndFirstName(resp.getNom(), resp.getPrenom()) != null) {
			throw new Exception("ce client existe deja");
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
	 * Suppression de resp<br/>
	 * 
	 * @param resp
	 */
	public void removeResp(Responsable resp) {

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

}
