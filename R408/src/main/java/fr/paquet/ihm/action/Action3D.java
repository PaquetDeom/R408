package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Projet;

public class Action3D extends ActionBDA {

	/**
	 * @author paquet
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet projet = null;

	public Action3D() {
		super();
		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Runtime.getRuntime().exec(getUrl());
		} catch (IOException e) {
			new AlertWindow(AlertType.ERREUR, "Firefox n'est pas installé sur l'ordinateur");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	private String getUrl() {
		return "firefox " + projet.getUrl();
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public String getName() {

		return "Visionneuse 3D";
	}

}
