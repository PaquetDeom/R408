package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.explorer.Gestionnaire;

public class ActionGestionnaire extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionGestionnaire() {
		super();
		putValue(NAME, "Gestionnaire de projets");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Gestionnaire gest = new Gestionnaire();
		gest.setVisible(true);

	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
