package fr.paquet.ihm.echaf;


import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class PanelResultats extends JPanel {

	/**
	 * @author paquet<br/>
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;


	public PanelResultats(JPanelProjet panelProjet) {
		super();
		setPanelProjet(panelProjet);
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Resultat"));		
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}
	

	public void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

	public void add(Component c, Object constraints) {
		super.add(c, constraints);
	}

}
