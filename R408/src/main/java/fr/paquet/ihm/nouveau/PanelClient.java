package fr.paquet.ihm.nouveau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelClient extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private JDialogNouveau jDialogNouveau = null;
	private PanelCoordonneesClient panelCoordonnesClient = null;
	private PanelNomPrenomClient panelNomPrenomClient = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelClient(JDialogNouveau dN) {

		super();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données client"));

		// mutte la variable jDialogNouveau
		setjDialogNouveau(dN);

		// Ajout du layout.
		setLayout(new GridBagLayout());

		// creation des panels
		setPanelNomPrenomClient(new PanelNomPrenomClient(this.getjDialogNouveau()));
		setPanelCoordonnesClient(new PanelCoordonneesClient(this));

		// ajout des Panel a PanelClient.
		add(getPanelNomPrenomClient(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		add(getPanelCoordonnesClient(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

	}

	/**
	 * 
	 * @return le Panel de coordonnes des clients<br/>
	 */
	private PanelCoordonneesClient getPanelCoordonnesClient() {
		return panelCoordonnesClient;
	}

	private void setPanelCoordonnesClient(PanelCoordonneesClient panelCoordonnesClient) {
		this.panelCoordonnesClient = panelCoordonnesClient;
	}

	/**
	 * 
	 * @return Le panel de nom des clients<br/>
	 */
	private PanelNomPrenomClient getPanelNomPrenomClient() {
		return panelNomPrenomClient;
	}

	private void setPanelNomPrenomClient(PanelNomPrenomClient panelNomPrenomClient) {
		this.panelNomPrenomClient = panelNomPrenomClient;
	}

	public JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

}
