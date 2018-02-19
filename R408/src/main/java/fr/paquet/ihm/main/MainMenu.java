package fr.paquet.ihm.main;

import java.util.EnumSet;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	public MainMenu() {

		super();

		for (Action action : EnumSet.allOf(Action.class)) {
			action.getAction();
		}
		addMenu();
	}

	private void addMenu() {

		for (int i = 0; i < Action.getMenus().size(); i++) {
			add(Action.getMenus().get(i));
		}

	}
}
