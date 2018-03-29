package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.ihm.echaf.OngletProjet;

public class ActionNouveau extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionNouveau() {
		super();
		putValue(NAME, "Nouveau");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		OngletProjet c = new OngletProjet(null);
		c.setVisible(true);
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
