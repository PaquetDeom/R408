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

		// Creation des JLabel
		JLabel lpp = new JLabel("Poids propre : ");
		JLabel lpp1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getPoidsPropre()));

		JLabel lce = new JLabel("Classe echafaudage : ");
		JLabel lce1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getClasseEchaf()));

		JLabel lc = new JLabel("Constructeur : ");
		JLabel lc1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getConstructeur().getName()));

		JLabel lt = new JLabel("Type Echafaudage : ");
		JLabel lt1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getTypeEchaf()));

		JLabel lts = new JLabel("Type de sol : ");
		JLabel lts1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getTypeSol()));

		JLabel lche = new JLabel("Charge d'exploitation : ");
		JLabel lche1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getChargeExploitation()));

		JLabel lnp = new JLabel("Nombre de pieds : ");
		JLabel lnp1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getNbDePieds()));

		JLabel ldc = new JLabel("Dimension mini de la cale : ");
		JLabel ldc1 = new JLabel(String.valueOf(getPanelResultats().getPanelProjet().getOnglet().getProjet()
				.getChantier().getEchafaudage().getDimensionCale()));

		// creation d'un numeros de ligne
		int l = 0;

		// affichagegr
		add(lpp, new GridBagConstraints(l, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(lpp1, new GridBagConstraints(l, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		l = l++;
	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}

}
