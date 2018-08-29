package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.OngletProjet;
import fr.paquet.projet.Projet;
import fr.paquet.projet.ProjetFactory;

public class ActionSave extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletProjet ongletProjet = null;

	public ActionSave() {
		super();

		putValue(NAME, "Sauver");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	private OngletProjet getOngletProjet() {

		return ongletProjet;
	}

	public void setOngletProjet(OngletProjet ongletProjet) {
		this.ongletProjet = ongletProjet;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ProjetFactory pF = new ProjetFactory();
		try {
			pF.saveProjet(getProjet());
		} catch (Exception e) {
			e.printStackTrace(System.out);
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}
	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	public Projet getProjet() throws Exception {
		if (getOngletProjet() == null) {
			throw new Exception("Aucun projet en cours");
		}
		return getOngletProjet().getProjet();
	}

}
