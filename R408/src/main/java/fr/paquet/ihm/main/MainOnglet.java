package fr.paquet.ihm.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.*;

import fr.paquet.ihm.echaf.LayoutEchafRevit;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private int nbOnglet = 0;
	private static MainOnglet onglet = null;

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

		// affichage des Layouts.
		JPanel onglet = new JPanel();
		onglet.add(new JLabel(getTitre()));
		onglet.setPreferredSize(new Dimension(1800, 900));
		onglet.setLayout(new LayoutEchafRevit());

		// Ajout de l'onglet
		addTab(getTitre(), onglet);
		setOpaque(true);
	}

	private int getNbOnglet() {
		return nbOnglet;
	}

	private void setNbOnglet(int nbOnglet) {
		this.nbOnglet = nbOnglet;
	}

	/**
	 * 
	 * @return le titre de l'onglet<br/>
	 */
	private String getTitre() {

		return "sansTitre" + " " + getNbOnglet();

	}

}
