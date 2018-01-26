package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;

import fr.paquet.ihm.main.*;

public class Main {

	private static JFrame mainFrame = null;

	public static void main(String[] args) {
		Server server = null;
		try {
			// demarage de la base de donnée
			HsqlProperties p = new HsqlProperties();
			p.setProperty("server.database.0", "file:c:/hsqlDB/DataR408");
			p.setProperty("server.dbname.0", "r408");
			p.setProperty("server.port", "5434");
			server = new Server();
			server.setProperties(p);
			server.start();

			// fermeture du logiciel
			WindowListener l = new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
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
			System.exit(1);

		} finally {
			try {

				// arret de la base de donnée
				server.shutdown();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return La Fenêtre principale<br/>
	 */
	public static JFrame getMainFrame() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
	}

}
