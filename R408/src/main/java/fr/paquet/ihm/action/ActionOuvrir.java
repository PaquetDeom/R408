package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.ihm.echaf.OngletProjet;
import fr.paquet.projet.Projet;

public class ActionOuvrir extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet projet = null;

	public ActionOuvrir(Projet projet) throws Exception {
		super();
		setProjet(projet);
		putValue(NAME, "Ouvrir");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		OngletProjet c = new OngletProjet(getProjet());
		c.setVisible(true);
	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	private Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) throws Exception {
		if (projet == null)
			throw new Exception("Veuillez séletionner un projet");
		this.projet = projet;
	}

}
