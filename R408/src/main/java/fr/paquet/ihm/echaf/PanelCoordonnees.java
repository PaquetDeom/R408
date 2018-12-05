package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class PanelCoordonnees extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;

	public PanelCoordonnees() {
		super();

		// ajout d'un Layout.
		setLayout(new GridBagLayout());

		// ajout des Component au panel cordonneesPanel.
		add(new JLabel("Lieu dit : "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("N° : "), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Nom de la rue : "), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Code Postal : "), new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Ville : "), new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Adresse mail : "), new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("N° de telephone : "), new GridBagConstraints(0, 6, 1, 1, 0, 0,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		setVisible(true);

	}
	
}
