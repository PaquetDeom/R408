package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class JPanelProjet extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletProjet onglet = null;

	public JPanelProjet(OngletProjet onglet) {
		super();
		setOnglet(onglet);
		setLayout(new GridBagLayout());
		add(new PanelEntete(this), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		add(new PanelEchafaudage(this), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new PanelResultats(this), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	public OngletProjet getOnglet() {
		return onglet;
	}

	private void setOnglet(OngletProjet onglet) {
		this.onglet = onglet;
	}

}
