package fr.paquet.ihm.main;

import java.util.ArrayList;
import java.util.EnumSet;

import javax.swing.*;

import main.Exit;
import main.Main;

public enum Action {

	/**
	 * @author Nathanaël
	 * 
	 *         Class Enum qui gere la barre des menus<br/>
	 */

	NOUVEAU, OUVRIR, QUITTER, COPIER, COUPER, COLLER, APROPOS;

	private static ArrayList<JMenu> menus = null;

	/**
	 * 
	 * @param actionName
	 * @return L'action suivant son nom<br/>
	 */
	public static Action getAction(String actionName) {
		for (Action act : EnumSet.allOf(Action.class)) {
			if (actionName.equals(act.getNameAction()))
				return act;
		}
		return null;
	}

	private String getNameAction() {

		switch (this) {

		case NOUVEAU:
			return "NOUVEAU";
		case OUVRIR:
			return "OUVRIR";
		case QUITTER:
			return "QUITTER";
		case COPIER:
			return "COPIER";
		case COUPER:
			return "COUPER";
		case COLLER:
			return "COLLER";
		case APROPOS:
			return "APROPOS";
		}
		return null;
	}

	/**
	 * 
	 * @return Les actions de la barre des menus<br/>
	 */
	public MainAction getMainAction() {

		switch (this) {

		case NOUVEAU:
			return buildMainAction("Fichier", "Nouveau", '0');
		case OUVRIR:
			return buildMainAction("Fichier", "Ouvrir", '0');
		case QUITTER:
			return buildMainAction("Fichier", "Quitter", '0');
		case COPIER:
			return buildMainAction("Editer", "Copier", 'C');
		case COUPER:
			return buildMainAction("Editer", "Couper", 'X');
		case COLLER:
			return buildMainAction("Editer", "Coller", 'V');
		case APROPOS:
			return buildMainAction("Aide", "A Propos", '0');
		}
		return null;
	}

	/**
	 * Actions a executer lorsqu'un menuItem est actionne<br/>
	 */
	public void actionPerf() {

		switch (this) {

		case NOUVEAU:
			MainFrame.getMainPanel().add(MainOnglet.getUniqInstance());
			Main.getMainFrame().setVisible(true);
			break;
		case OUVRIR:
			System.out.println("Ouvrir is click");
			break;
		case QUITTER:
			System.out.println("Quitter is click");
			new Exit();
			break;
		case COPIER:
			System.out.println("Copier is click");
			break;
		case COUPER:
			System.out.println("Couper is click");
			break;
		case COLLER:
			System.out.println("Coller is click");
			break;
		case APROPOS:
			System.out.println("A Propos is click");
			break;
		}

	}

	private static void addMenu(JMenu menu) {
		getMenus().add(menu);
	}

	/**
	 * 
	 * @return La liste des JMenus<br/>
	 */
	public static ArrayList<JMenu> getMenus() {
		if (menus == null)
			menus = new ArrayList<JMenu>();
		return menus;
	}

	/**
	 * 
	 * @param menuString
	 * @return un JMenu selon sa denomination<br/>
	 */
	private static JMenu getMenu(String menuString) {
		for (int i = 0; i < getMenus().size(); i++) {
			JMenu menu = getMenus().get(i);
			if (menuString.equals(menu.getText())) {
				return menu;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param menuString
	 * @param menuItem
	 * @param menuRacourci
	 * @return la MainAction avec ou sans touche de racourci<br/>
	 */
	private MainAction buildMainAction(String menuString, String menuItemString, char menuRacourci) {

		return MainAction.getUniqInstance(buildMenu(menuString), new JMenuItem(menuItemString), menuRacourci);
	}

	/**
	 * 
	 * @param menuString
	 *            Verifie que le menu (Fichier, Editer...) existe<br/>
	 *            si il n'existe pas le crée<br/>
	 * @return Le menu Fichier, Editer...<br/>
	 */
	private JMenu buildMenu(String menuString) {

		JMenu menu = null;

		if (getMenu(menuString) == null) {
			menu = new JMenu(menuString);
			addMenu(menu);
		} else {
			menu = getMenu(menuString);
		}

		return menu;
	}

}
