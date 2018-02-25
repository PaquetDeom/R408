package fr.paquet.ihm.main;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

import fr.paquet.ihm.echaf.*;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private int nbOnglet = 0;
	private static MainOnglet onglet = null;
	private PanelNew panelNew = null;

	/**
	 * Constructeur de la class private car ne doit etre instanciee qu une fois<br/>
	 */
	private MainOnglet() {
		super(SwingConstants.TOP);
		buildOnglet();
	}

	/**
	 * 
	 * @return Le main onglet unique<br/>
	 */
	public static MainOnglet getUniqInstance() {
		if (onglet == null) {
			onglet = new MainOnglet();
		} else
			onglet.buildOnglet();
		return onglet;
	}

	/**
	 * Cree un nouvel onglet<br/>
	 */
	private void buildOnglet() {

		// Comptage du nb d'onglet actif
		setNbOnglet(getNbOnglet() + 1);

		// Ajout de l'onglet
		this.addTab(getTitre(), getPanelNew());
		setOpaque(true);
	}

	private PanelNew getPanelNew() {
		if (panelNew == null)
			panelNew = new PanelNew();
		return panelNew;
	}

	private int getNbOnglet() {
		return nbOnglet;
	}

	private void setNbOnglet(int nbOnglet) {
		this.nbOnglet = nbOnglet;
	}

	/**
	 * 
	 * @return le titre de du document<br/>
	 */
	private String getTitre() {

		if (getPanelNew().getTitre().equals("saisir le titre"))

			return "sansTitre" + " " + getNbOnglet();
		else
			return getPanelNew().getTitre();

	}

}
