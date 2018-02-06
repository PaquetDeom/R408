package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.main.*;

public class Main {

	private static JFrame mainFrame = null;
	private static Server server = null;
	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		try {
			
			// demarage de la base de donnees
			HsqlProperties p = new HsqlProperties();
			p.setProperty("server.database.0", "file:c:/hsqlDB/DataR408;user=r408;password=Login5340");
			p.setProperty("server.dbname.0", "R408");
			p.setProperty("server.port", "5434");
			server = new Server();
			server.setProperties(p);
			server.start();

			Connect.getEm();

			// fermeture du logiciel
			WindowListener l = new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					// arret de la base de donn�e
					server.shutdown();
					System.exit(0);
				}
			};

			// add listener
			getMainFrame().addWindowListener(l);

			// rendre la fenetre visible
			getMainFrame().setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();

			// fermeture avec erreur
			server.shutdown();
			System.exit(1);

		} finally {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return La Fen�tre principale<br/>
	 */
	public static JFrame getMainFrame() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
	}

}
