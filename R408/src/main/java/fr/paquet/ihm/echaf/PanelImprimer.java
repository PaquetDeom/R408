package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class PanelImprimer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelResultats panelResultats = null;

	public PanelImprimer(PanelResultats panelResultats) {
		super();
		setPanelResultats(panelResultats);

		// Cree un renfoncement autour du panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Generation de documents"));

		// ajout du layout
		setLayout(new GridBagLayout());

		// création du button imprimer
		JButton imp = new JButton("imprimer");

		imp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new AlertWindow(AlertType.ATTENTION, "bientôt sa va imprimer");
			}
		});

		add(imp, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}

}
