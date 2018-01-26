package fr.paquet.dataBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connect {

	/**
	 * @author Nathanael
	 * 
	 *         Connection a la base de donnees<br/>
	 */

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	/**
	 * 
	 * @return la connection a la base de donnee "derby"<br/>
	 */
	public static EntityManagerFactory getEmf() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("r408");
		if (emf.isOpen())
			return emf;
		return emf;

	}

	/**
	 * 
	 * @return entity manager unique<br/>
	 */
	public static EntityManager getEm() {
		if(em == null)
			em = getEmf().createEntityManager();
		return em;
	}

}
