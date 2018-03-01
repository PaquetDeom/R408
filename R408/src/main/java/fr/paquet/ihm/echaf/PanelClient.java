package fr.paquet.ihm.echaf;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class PanelClient extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;

	public PanelClient(PanelEntete panelEntete) {

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
