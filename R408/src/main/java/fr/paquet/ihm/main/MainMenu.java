package fr.paquet.ihm.main;

import java.util.EnumSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	/**
	 * @author Nathanaël
	 */

	/**
	 * Constructeur de la class ajoute les Action a MainMenu<br/>
	 */
	public MainMenu() {

		super();

		for (Action action : EnumSet.allOf(Action.class)) {
			action.getMainAction();
		}
		addMenu();
	}

	/**
	 * Ajoute les menus dans la barre des menus<br/>
	 */
	private void addMenu() {

		for (int i = 0; i < Action.getMenus().size(); i++) {
			add(Action.getMenus().get(i));
		}

	}
}
