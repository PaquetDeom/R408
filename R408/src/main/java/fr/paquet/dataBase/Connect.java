package fr.paquet.dataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	 *         url de la db jdbc:hsqldb:hsql://localhost:5434/r408
	 */
	public static EntityManagerFactory getEmf() {
		if (emf != null && emf.isOpen())
			return emf;
		else
			emf = Persistence.createEntityManagerFactory("R408");
		return emf;

	}

	/**
	 * 
	 * @return entity manager unique<br/>
	 */
	public static EntityManager getEm() {
		if (em == null)
			em = getEmf().createEntityManager();
		return em;
	}

	/**
	 * 
	 * @return la connection à la base de donnée<br/>
	 * @throws SQLException la connection n'a pas été établi<br/>
	 */
	public static Connection getConnection() throws SQLException {

		Driver monDriver = new org.hsqldb.jdbcDriver();

		DriverManager.registerDriver(monDriver);
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:5434/r408", "r408", "Login5340");

	}

}
