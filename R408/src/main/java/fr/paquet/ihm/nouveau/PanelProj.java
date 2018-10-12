package fr.paquet.ihm.nouveau;

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
	private PanelTitre panelTitre = null;
	private JDialogNouveau jDialogNouveau = null;
	private PanelNomPrenomResp panelNomPrenomResp = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelProj(JDialogNouveau jD) {

		super();
		setjDialogNouveau(jD);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données du projet"));

		setLayout(new GridBagLayout());

		// creation du panel resp
		setPanelNomPrnomResp(new PanelNomPrenomResp(this.getjDialogNouveau()));
		setPanelTitre(new PanelTitre(this));

		// Affichage des component sur la panelProj
		add(getPanelTitre(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getPanelNomPrenomResp(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

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

	public JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

}
