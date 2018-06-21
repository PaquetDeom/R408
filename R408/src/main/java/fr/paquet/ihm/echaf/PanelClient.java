package fr.paquet.ihm.echaf;

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
	private PanelEntete panelEntete = null;
	private PanelCoordonneesClient panelCoordonnesClient = null;
	private PanelNomPrenomClient panelNomPrenomClient = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelClient(PanelEntete panelEntete) {

		super();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données client"));

		// mutte la variable panelEntete.
		setPanelEntete(panelEntete);

		// Ajout du layout.
		setLayout(new GridBagLayout());

		// creation des panels
		setPanelNomPrenomClient(new PanelNomPrenomClient(this));
		setPanelCoordonnesClient(new PanelCoordonneesClient(this));
		
		// ajout des Panel a PanelClient.
		add(getPanelNomPrenomClient(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		add(getPanelCoordonnesClient(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

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

}
