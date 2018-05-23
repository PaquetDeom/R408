package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import fr.paquet.ihm.alert.AlertWindow;

public class Action3D extends ActionBDA {

	/**
	 * @author paquet
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Action3D() {
		super();
		putValue(NAME, "Visionneuse 3D");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			// TODO Visionneuse 3D
			Runtime.getRuntime().exec(
					"firefox https://myhub.autodesk360.com/ue2a6a670/shares/public/SHabee1QT1a327cf2b7afa739ff959d55066?mode=embed");
		} catch (IOException e) {
			new AlertWindow("Erreur", "Le programme n'est pas installé sur l'ordinateur");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

}
