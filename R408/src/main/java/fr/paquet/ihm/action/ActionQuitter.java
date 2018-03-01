package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import main.Main;

public class ActionQuitter extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionQuitter() {
		super();
		putValue(NAME, "Quitter");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.FermetureSansErreur();
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
