package fr.paquet.ihm.echaf;

import javax.swing.JComponent;

import fr.paquet.ihm.main.MainOnglet;

import fr.paquet.projet.*;

public class OngletProjet extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555340311930007466L;
	private Projet projet = null;
	private JPanelProjet panelProjet = null;

	/**
	 * Cree un nouvel onglet<br/>
	 */
	public OngletProjet(Projet projet) {

		super();

		setProjet(projet);

		// Ajout de l'onglet
		MainOnglet.getUniqInstance().addTab(getTitre(getProjet()), getJPanelProjet());

		// Ajout à la liste des MainOnglets
		MainOnglet.getUniqInstance().addOnglet(this);

	}

	private JPanelProjet getJPanelProjet() {
		if (panelProjet == null)
			panelProjet = new JPanelProjet(this);
		return panelProjet;
	}

	/**
	 * 
	 * @return le titre de du document<br/>
	 * 
	 */
	private String getTitre(Projet projet) {

		return projet.getTitre();

	}

	public Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {

		this.projet = projet;
	}

}
