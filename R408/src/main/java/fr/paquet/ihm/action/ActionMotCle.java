package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.ihm.eltByName.MotsCles;

public class ActionMotCle extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionMotCle() {
		super();
		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('M', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new MotsCles();

	}

	@Override
	public String getParentMenuName() {
		// TODO Auto-generated method stub
		return "Outils";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Gestion des mots clés";
	}

}
