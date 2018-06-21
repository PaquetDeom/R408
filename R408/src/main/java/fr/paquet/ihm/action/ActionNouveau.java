package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.ihm.echaf.OngletProjet;
import fr.paquet.projet.Chantier;
import fr.paquet.projet.Client;
import fr.paquet.projet.Projet;
import fr.paquet.projet.Responsable;

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

		Client client = new Client();
		Responsable resp = new Responsable();
		Echafaudage echaf = new Echafaudage();
		Projet projet = new Projet();
		Chantier chantier = new Chantier(projet, echaf);
		projet.setClient(client);
		projet.setResp(resp);
		projet.setChantier(chantier);

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
