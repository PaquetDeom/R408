package fr.paquet.ihm.echaf;

import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelEntete extends JPanel {

	private JPanelProjet panelProjet = null;

	public PanelEntete(JPanelProjet panelProjet) {

		super();
		setPanelProjet(panelProjet);

		GridLayout layout = new GridLayout(1, 3);
		setLayout(layout);
			
		add(new PanelProj(this), layout);
		add(new PanelClient(this), layout);
		add(new PanelChantier(this), layout);
		
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	private void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

	
}
