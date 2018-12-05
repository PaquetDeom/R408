package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

public class PanelCoordonneesChantier extends PanelCoordonnees {

	/**
	 * @author paquet
	 */
	private PanelChantier panelChantier = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesChantier(PanelChantier panelChantier) {
		super();

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelChantier(panelChantier);

		// listener des labels
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getAdresse1()),
				new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getAdresse2()),
				new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getAdresse3()),
				new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getCodeCommune()),
				new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getCom()),
				new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getMail()),
				new GridBagConstraints(1, 5, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getChantier()
				.getAdresse().getTel()),
				new GridBagConstraints(1, 6, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
	}

	private void setPanelChantier(PanelChantier panelChantier) {
		this.panelChantier = panelChantier;
	}

	/**
	 * 
	 * @return le panelChantier correspondant<br/>
	 */
	private PanelChantier getPanelChantier() {
		return panelChantier;
	}

}
