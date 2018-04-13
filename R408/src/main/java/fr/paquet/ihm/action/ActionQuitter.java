package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertWindow;
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
		new AlertWindow("Question", "Etes-vous sûre de vouloir quitter", new AlertListener() {

			@Override
			public void buttonClick(String button) {
				if (button.equals("Oui"))
					Main.FermetureSansErreur();

			}
		});
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
