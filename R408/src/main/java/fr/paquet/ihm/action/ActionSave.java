package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.projet.Projet;
import fr.paquet.projet.ProjetFactory;

public class ActionSave extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet projet = null;

	public ActionSave() {
		super();

		putValue(NAME, "Sauver");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			ProjetFactory pF = new ProjetFactory();
			pF.saveProjet(getProjet());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	private Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
