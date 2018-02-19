package fr.paquet.ihm.main;

import java.util.ArrayList;

import javax.swing.*;

public enum Action {

	NOUVEAU, OUVRIR, QUITTER, COPIER, COUPER, COLLER;

	private static ArrayList<JMenu> menus = null;

	private static void addMenu(JMenu menu) {
		getMenus().add(menu);
	}

	public static ArrayList<JMenu> getMenus() {
		if (menus == null)
			menus = new ArrayList<JMenu>();
		return menus;
	}

	private static JMenu getMenu(String menuString) {
		for (int i = 0; i < getMenus().size(); i++) {
			JMenu menu = getMenus().get(i);
			if (menuString.equals(menu.getText())) {
				return menu;
			}
		}
		return null;
	}

	public MainAction getAction() {
		
		switch (this) {

		case NOUVEAU: {
			String menuString = "Fichier";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Nouveau", 'N'));
		}

		case OUVRIR: {
			String menuString = "Fichier";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Ouvrir", 'O'));
		}

		case QUITTER: {
			String menuString = "Fichier";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Quitter", 'Q'));

		}

		case COPIER: {
			String menuString = "Editer";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Copier"), 'C');

		}

		case COUPER: {
			String menuString = "Editer";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Couper"), 'X');

		}
		case COLLER: {
			String menuString = "Editer";
			JMenu menu = null;
			if (getMenu(menuString) == null) {
				menu = new JMenu(menuString);
				addMenu(menu);
			} else {
				menu = getMenu(menuString);
			}

			return new MainAction(menu, new JMenuItem("Coller"), 'V');

		}
		}
		return null;
	}

}
