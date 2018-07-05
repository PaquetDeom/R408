package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;


import fr.paquet.ihm.echaf.OngletProjet;
import fr.paquet.projet.*;;

public class ActionNouveau extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionSave actionSave = new ActionSave();

	public ActionNouveau() {
		super();
		putValue(NAME, "Nouveau");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Projet projet = new Projet();

		OngletProjet c;
		c = new OngletProjet(projet);
		
		actionSave.setOngletProjet(c);
		c.setVisible(true);

	}

	public ActionSave getActionSave() {
		return actionSave;
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
