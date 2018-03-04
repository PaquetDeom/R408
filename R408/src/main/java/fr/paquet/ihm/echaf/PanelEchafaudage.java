package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class PanelEchafaudage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;

	public PanelEchafaudage(JPanelProjet panelProjet) {
		super();
		setPanelProjet(panelProjet);

		setLayout(new GridBagLayout());

		JLabel a = new JLabel("C'est pas fait");
		add(a, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	private void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

}
