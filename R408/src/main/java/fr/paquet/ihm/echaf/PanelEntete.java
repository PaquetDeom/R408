package fr.paquet.ihm.echaf;

import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelEntete extends JPanel {

	private JPanelProjet panelProjet = null;

	public PanelEntete(JPanelProjet panelProjet) {

		super();
		setPanelProjet(panelProjet);

		add(new PanelProj(this));
		add(new PanelClient(this));

		if (getPanelProjet().getOnglet().getProjet().getChantier().getAdresse() != null)
			add(new PanelChantier(this));

		GridLayout layout = new GridLayout(1, 3);
		setLayout(layout);

	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	private void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

}
