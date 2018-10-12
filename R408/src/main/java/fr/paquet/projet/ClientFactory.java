package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

public class ClientFactory extends Connect {

	public ClientFactory() {

	}

	/**
	 * 
	 * @param name
	 * @param firstName
	 * @return un client selon son nom et son prenom<br/>
	 */
	public Client findClientByNameAndFirstName(String name, String firstName) {

		Query query = getEm()
				.createQuery("SELECT Client FROM Client client where client.nom=:name and client.prenom=:firstName");
		query.setParameter("name", name);
		query.setParameter("firstName", firstName);

		try {

			return (Client) query.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace(System.out);
			return null;
		}

	}

	/**
	 * Sauvegarde de client<br/>
	 * 
	 * @param resp
	 * @throws Exception
	 */
	public void saveClient(Client client) throws Exception {

		if (findClientByNameAndFirstName(client.getNom(), client.getPrenom()) != null) {
			throw new Exception("ce client existe deja");
		} else {

			EntityTransaction t = getEm().getTransaction();
			try {

				t.begin();
				getEm().persist(client);
				t.commit();

			} catch (Exception e) {
				t.rollback();
				throw (e);
			}

		}

	}

	/**
	 * Suppression de client<br/>
	 * 
	 * @param resp
	 */
	public void removeClient(Client client) {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(client);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	/**
	 * 
	 * @param name
	 * @return la liste des clients par rapport à leurs noms<br/>
	 */
	public List<Client> findClientsByName(String name) {

		Query query = getEm().createQuery("SELECT client FROM Client client where client.nom=:name");

		query.setParameter("name", name);

		@SuppressWarnings("unchecked")
		List<Client> l = query.getResultList();

		return l;
	}

}
