package main;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.main.MainFrame;

public class Main {

	private static Server server = null;

	/**
	 * Demmarrage de l application.
	 */
	public static void main(String[] args) {

		try {

			// création de la base de donnees
			HsqlProperties p = new HsqlProperties();
			p.setProperty("server.database.0", "file:/home/paquet/hsqlDB/DataR408;user=r408;password=Login5340");
			p.setProperty("server.dbname.0", "R408");
			p.setProperty("server.port", "5434");
			server = new Server();
			server.setProperties(p);
			server.start();

		} catch (IOException | AclFormatException e1) {

			// fermeture avec erreur
			e1.printStackTrace(System.out);
			FermetureAvecErreur();

		} finally {

			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// creation de la mainFrame
					MainFrame mainFrame = MainFrame.getUniqInstance();

					// fermeture du logiciel
					WindowListener l = new WindowAdapter() {
						public void windowClosing(WindowEvent e) {

							new AlertWindow("Question", "Etes-vous sûre de vouloir quitter", new AlertListener() {

								@Override
								public void buttonClick(String button) {
									if (button.equals("Oui"))
										FermetureSansErreur();

								}
							});

						}
					};

					// add listener
					mainFrame.addWindowListener(l);
					mainFrame.setVisible(true);

				} catch (Exception e) {

					// fermeture avec erreur
					System.out.println("Fermeture avec erreur");
					new AlertWindow("Erreur", "Fatal Erreur");
					e.printStackTrace();
					FermetureAvecErreur();

				}
			}
		});
	}

	public static void FermetureSansErreur() {
		server.shutdown();
		System.exit(0);
	}

	public static void FermetureAvecErreur() {
		server.shutdown();
		System.exit(1);
	}

}
