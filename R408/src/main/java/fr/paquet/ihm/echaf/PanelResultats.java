package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	public void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

}
