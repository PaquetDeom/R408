package fr.paquet.ihm.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements WindowListener {

	/**
	 * @author Nathanael
	 * 
	 *         Fenetre pricipale du logiciel<br/>
	 */

	private static MainMenu mainMenu = null;
	private static MainFrame mainFrame = null;

	private MainFrame() {
		super("Logiciel de calcul R408");
		addWindowListener(this);
		setAlwaysOnTop(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(getMainMenu());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * 
	 * @return l'instance unique de la class<br/>
	 */
	public static MainFrame getUniqInstance() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
	}

	/**
	 * 
	 * @return le menu principal<br/>
	 */
	public static MainMenu getMainMenu() {
		if (mainMenu == null)
			mainMenu = new MainMenu();
		return mainMenu;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
