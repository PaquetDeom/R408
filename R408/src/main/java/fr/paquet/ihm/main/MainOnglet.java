package fr.paquet.ihm.main;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

import fr.paquet.ihm.echaf.*;
import fr.paquet.projet.Projet;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private int nbOnglet = 0;
	private static MainOnglet onglet = null;

	/**
	 * Constructeur de la class private car ne doit etre instanciee qu une fois<br/>
	 */
	private MainOnglet() {
		super(SwingConstants.TOP);

	}

	/**
	 * 
	 * @return Le main onglet unique<br/>
	 */
	public static MainOnglet getUniqInstance() {
		if (onglet == null) {
			onglet = new MainOnglet();
		}
		return onglet;
	}

	/**
	 * Cree un nouvel onglet<br/>
	 */
	public Component buildOnglet(Projet projet) {
		Component c = null;
		// Comptage du nb d'onglet actif
		setNbOnglet(getNbOnglet() + 1);

		// Ajout de l'onglet

		this.addTab(getTitre(projet), c = getJPanelProjet(projet));
		return c;
	}

	private JPanelProjet getJPanelProjet(Projet projet) {

		return new JPanelProjet(projet);
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
	private String getTitre(Projet projet) {

		if (getJPanelProjet(projet).getProjet().getTitre() == null
				|| getJPanelProjet(projet).getProjet().getTitre().equals(""))
			return "sansTitre" + " " + getNbOnglet();
		else
			return getJPanelProjet(projet).getProjet().getTitre();

	}

}
