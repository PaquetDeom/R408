package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.nouveau.JDialogUrl;
import fr.paquet.projet.Projet;

public class ActionUrl extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet projet = null;

	public ActionUrl() {
		super();
		putValue(NAME, getName());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new JDialogUrl(getProjet());

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	private Projet getProjet() {
		return projet;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Url de la 3D";
	}

}
