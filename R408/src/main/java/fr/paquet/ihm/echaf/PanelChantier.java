package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelChantier extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private PanelCoordonneesChantier pCC = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelChantier(PanelEntete panelEntete) {

		super();

		setPanelEntete(panelEntete);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données du chantier"));

		setLayout(new GridBagLayout());

		// creation de panels.
		JPanel radioPanel = new JPanel();
		setpCC(new PanelCoordonneesChantier(this));

		// ajout des panels ci-dessus a panel chantier
		add(radioPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

		// creation du radio button
		JRadioButton radioButton = new JRadioButton("L'adresse du chantier est différente de l'adresse client");

		// ajout du listener
		radioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				remove(getpCC());

				if (radioButton.isSelected()) {
					add(getpCC(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

				}

				SwingUtilities.updateComponentTreeUI(PanelChantier.this);
				PanelChantier.this.repaint();

			}
		});

		// ajout du radioButton au panel radioButtonPanel.
		radioPanel.add(radioButton, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
	}

	/**
	 * 
	 * @return le Panel de l'entête<br/>
	 */
	public PanelEntete getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(PanelEntete panelEntete) {
		this.panelEntete = panelEntete;
	}

	public PanelCoordonneesChantier getpCC() {
		return pCC;
	}

	public void setpCC(PanelCoordonneesChantier pCC) {
		this.pCC = pCC;
	}

}
