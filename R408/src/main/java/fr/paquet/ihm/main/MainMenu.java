package fr.paquet.ihm.main;

import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.ihm.action.*;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	/**
	 * @author Nathanaël
	 */

	/**
	 * Constructeur de la class ajoute les Action a MainMenu<br/>
	 */
	public MainMenu() {
		addAction(new ActionNouveau());
		addAction(new ActionGestionnaire());
		addAction(new ActionQuitter());
		addAction(new Action3D());
	}

	private Hashtable<String, JMenu> menus = new Hashtable<String, JMenu>();

	private JMenu getJMenu(String menuName) {
		JMenu menu = menus.get(menuName);
		if (menu == null) {
			menus.put(menuName, menu = new JMenu(menuName));
			super.add(menu);
		}
		return menu;
	}

	public ActionBDA addAction(ActionBDA action) {

		// créé un nouveau JMenu
		JMenuItem jMenuAction = new JMenuItem(action);

		getJMenu(action.getParentMenuName()).add(jMenuAction);
		return action;
	}
}
