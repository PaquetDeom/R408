package fr.paquet.ihm.alert;

import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class AlertWindow extends JOptionPane {

	@SuppressWarnings("unused")
	private String message = null;
	@SuppressWarnings("unused")
	private String[] buttons = null;

	private ArrayList<AlertListener> listenerList = new ArrayList<AlertListener>();

	/**
	 * Ajout des AlertListener a la liste<br/>
	 * 
	 * @param listener
	 */
	public void addButtonListener(AlertListener listener) {
		listenerList.add(listener);
	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param title
	 *            de la JOptionPane<br/>
	 *            le titre doit etre soit "Erreur" soit "Information" soit
	 *            "Attention"<br/>
	 * @param message
	 *            d'erreur ou d'alerte<br/>
	 */
	public AlertWindow(String title, String message) {

		super();

		ImageIcon img = new ImageIcon();

		if (title.equals("Erreur")) {
			img = new ImageIcon("/home/paquet/git/R408/R408/src/images/iconErreur.jpeg");

			showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE, img);
		}
		if (title.equals("Information")) {
			img = new ImageIcon("/home/paquet/git/R408/R408/src/images/iconInfo.jpeg");

			showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, img);
		}
		if (title.equals("Attention")) {
			img = new ImageIcon("/home/paquet/git/R408/R408/src/images/iconWarning.jpeg");

			showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE, img);
		}

	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param title
	 *            de la JOptionPane doit être "Question"<br/>
	 * @param message
	 *            d'erreur ou d'alerte<br/>
	 * @param buttons
	 *            : est un tableau de Jbuttons<br/>
	 * @param listener
	 *            la class qui passe le listener doit implementer l'interface
	 *            AlertListener<br/>
	 */
	public AlertWindow(String title, String message, AlertListener listener) {
		this(title, message);
		addButtonListener(listener);

		if (title.equals("Question")) {
			ImageIcon img = new ImageIcon("/home/paquet/git/R408/R408/src/images/iconQuestion.jpeg");

			int option = showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, img);

			if (option == JOptionPane.OK_OPTION) {

				for (AlertListener l : listenerList) {
					l.buttonClick("Oui");
				}
			}
			if (option == JOptionPane.NO_OPTION) {

				for (AlertListener l : listenerList) {
					l.buttonClick("Non");
				}
			}
		}
	}

}
