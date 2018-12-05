package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

/**
 * 
 * @author paquet
 *
 */

public class ProjetFactory extends Connect {

	/**
	 * 
	 * Constructeur de la class<br/>
	 *
	 */
	public ProjetFactory() {
		super();

	}

	/**
	 * 
	 * @param title
	 * @return un projet suivant son titre<br/>
	 */
	public Projet findProjetByTitle(String titre) {

		Query query = getEm().createQuery("SELECT Projet FROM Projet projet where projet.titre=:titre");
		query.setParameter("titre", titre);

		try {

			return (Projet) query.getSingleResult();

		} catch (NoResultException e) {

			e.printStackTrace(System.out);
			return null;
		}

	}

	/**
	 * 
	 * @return tous les projets de la DB<br/>
	 * @throws Exception
	 *             la liste est vide<br/>
	 */
	public List<Projet> findAllProjets() throws Exception {

		Query query = getEm().createQuery("Select projet FROM Projet projet");
		@SuppressWarnings("unchecked")
		List<Projet> projets = (List<Projet>) query.getResultList();

		if (projets.isEmpty())
			throw new Exception("Il n'y a pas de projet dans la base de donnees");

		return projets;
	}

	public void saveProjet(Projet projet) throws Exception {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().persist(projet);
			t.commit();

		} catch (Exception e) {

			t.rollback();
			throw (e);
		}
	}

	/**
	 * suppr un projet de la DB<br/>
	 * 
	 * @param projet
	 */
	public void removeProjet(Projet projet) {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(projet);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

}
