package fr.paquet.ihm.main;

import java.util.ArrayList;

import javax.swing.*;

public enum Action {

	/**
	 * @author Nathanaël
	 * 
	 * Class Enum qui gere la barre des menus<br/>
	 */
	
	NOUVEAU, OUVRIR, QUITTER, COPIER, COUPER, COLLER, APROPOS;

	private static ArrayList<JMenu> menus = null;

	/**
	 * 
	 * @return Les actions de la barre des menus<br/>
	 */
	public MainAction getAction() {

		switch (this) {

		case NOUVEAU:
			return getMainAction("Fichier", "Nouveau", '0');
		case OUVRIR:
			return getMainAction("Fichier", "Ouvrir", '0');
		case QUITTER:
			return getMainAction("Fichier", "Quitter", '0');
		case COPIER:
			return getMainAction("Editer", "Copier", 'C');
		case COUPER:
			return getMainAction("Editer", "Couper", 'X');
		case COLLER:
			return getMainAction("Editer", "Coller", 'V');
		case APROPOS:
			return getMainAction("Aide", "A Propos", '0');
		}
		return null;
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
	private MainAction getMainAction(String menuString, String menuItem, char menuRacourci) {
		JMenu menu = null;
		if (getMenu(menuString) == null) {
			menu = new JMenu(menuString);
			addMenu(menu);
		} else {
			menu = getMenu(menuString);
		}

		if (menuRacourci == '0') {
			menuRacourci = menuString.charAt(0);
			return new MainAction(menu, new JMenuItem(menuItem, menuRacourci));
		}

		return new MainAction(menu, new JMenuItem(menuItem), menuRacourci);
	}

}
