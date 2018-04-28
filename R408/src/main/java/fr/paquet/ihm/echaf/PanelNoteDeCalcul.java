package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelNoteDeCalcul extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @author paquet<br/>
	 */

	private PanelResultats panelResultats = null;

	public PanelNoteDeCalcul(PanelResultats pr) {
		super();
		setPanelResultats(pr);

		// Cree un renfoncement autour du panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Note de calcul"));

		// ajoute un layout
		setLayout(new GridBagLayout());

		// Creation et affichage des JLabel

		addLineLabel(new JLabel("Constructeur : "), new JLabel(String.valueOf(getPanelResultats().getPanelProjet()
				.getOnglet().getProjet().getChantier().getEchafaudage().getConstructeur().getName())), 0);

		addLineLabel(new JLabel("Type Echafaudage : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getTypeEchaf().getType()), 1);

		addLineLabel(new JLabel("Type de sol : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getTypeSol().getType()), 2);

		

		addLineLabel(new JLabel("Poids propre : "), new JLabel(String.valueOf(getPanelResultats().getPanelProjet()
				.getOnglet().getProjet().getChantier().getEchafaudage().getPoidsPropre()) + " DAN"), 3);
		
		addLineLabel(new JLabel("Classe echafaudage : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getClasseEchaf().getClasse()), 4);

		addLineLabel(new JLabel("Charge d'exploitation totale : "),
				new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet().getChantier()
						.getEchafaudage().getChargeExploitation()) + " DAN"),
				5);

		addLineLabel(new JLabel("Nombre de pieds : "), new JLabel(String.valueOf(getPanelResultats().getPanelProjet()
				.getOnglet().getProjet().getChantier().getEchafaudage().getNbDePieds()) + " U"), 6);

		addLineLabel(new JLabel("Dimension mini de la cale : "), new JLabel(String.valueOf(getPanelResultats()
				.getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().getDimensionCale()) + " cm"),
				7);

		// Panel de remplissage à la fin
		/*
		 * add(new JPanel(), new GridBagConstraints(0, 8, 1, 2, 0, 1,
		 * GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
		 * 0, 0));
		 */
	}

	private void addLineLabel(JLabel label, JLabel label2, int nLine) {

		add(label, new GridBagConstraints(0, nLine, 1, 1, 0, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(label2, new GridBagConstraints(1, nLine, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}

}
