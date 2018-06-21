package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelProj extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private PanelTitre panelTitre = null;
	private PanelNomPrenomResp panelNomPrenomResp = null;


	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelProj(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données du projet"));

		setLayout(new GridBagLayout());

		// creation du panel resp
		setPanelNomPrnomResp(new PanelNomPrenomResp(this));
		setPanelTitre(new PanelTitre(this));

		// Affichage des component sur la panelProj
		add(getPanelTitre(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getPanelNomPrenomResp(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

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

	private PanelNomPrenomResp getPanelNomPrenomResp() {
		return panelNomPrenomResp;
	}

	private void setPanelNomPrnomResp(PanelNomPrenomResp panelNomPrenomResp) {
		this.panelNomPrenomResp = panelNomPrenomResp;
	}

	private PanelTitre getPanelTitre() {
		return panelTitre;
	}

	private void setPanelTitre(PanelTitre panelTitre) {
		this.panelTitre = panelTitre;
	}

}
