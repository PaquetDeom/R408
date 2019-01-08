package fr.paquet.ihm.main;

import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.ihm.action.*;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	/**
	 * @author Nathanaël
	 */

	private ActionSave actionSave = null;
	private Action3D action3D = null;
	private ActionUrl actionUrl = null;
	private static MainMenu mainMenu = null;

	/**
	 * Constructeur de la class ajoute les Action a MainMenu<br/>
	 */
	private MainMenu() {

		addAction(new ActionNouveau());
		addAction(new ActionGestionnaire());
		addAction(new ActionQuitter());
		setAction3D(new Action3D());
		addAction(getAction3D());
		addAction(new ActionMotCle());
		setActionSave(new ActionSave());
		addAction(getActionSave());
		setActionUrl(new ActionUrl());
		addAction(getActionUrl());

	}

	public static MainMenu getUniqInstance() {
		if (mainMenu == null)
			mainMenu = new MainMenu();
		return mainMenu;
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

	public ActionSave getActionSave() {
		return actionSave;
	}

	public void setActionSave(ActionSave actionSave) {
		this.actionSave = actionSave;
	}

	public Action3D getAction3D() {
		return action3D;
	}

	public void setAction3D(Action3D action3d) {
		action3D = action3d;
	}

	public ActionUrl getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(ActionUrl actionUrl) {
		this.actionUrl = actionUrl;
	}
}
