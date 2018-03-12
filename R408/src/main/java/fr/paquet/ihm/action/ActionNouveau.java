package fr.paquet.ihm.action;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;

import javax.swing.KeyStroke;

import fr.paquet.ihm.main.MainFrame;
import fr.paquet.ihm.main.MainOnglet;
import fr.paquet.projet.Projet;

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
		Component c = MainFrame.getMainOnglet().buildOnglet(new Projet());
		c.setVisible(true);
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
