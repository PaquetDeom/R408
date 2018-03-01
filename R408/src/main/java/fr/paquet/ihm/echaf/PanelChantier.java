package fr.paquet.ihm.echaf;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

public class PanelChantier extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;

	public PanelChantier(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);

		setLayout(new GridBagLayout());

	}

	public PanelEntete getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(PanelEntete panelEntete) {
		this.panelEntete = panelEntete;
	}

}
