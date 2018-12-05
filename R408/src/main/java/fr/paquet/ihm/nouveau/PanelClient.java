package fr.paquet.ihm.nouveau;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.echaf.PanelCoordonneesClient;

public class PanelClient extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private JDialogNouveau jDialogNouveau = null;
	private PanelCoordonneesClient panelCoordonneeClient = null;
	private PanelCoordonneesChantier panelCoordonneeChantier = null;
	private PanelNomPrenomClient panelNomPrenomClient = null;
	private JPanel panelC = new JPanel();

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
		setLayout(new GridLayout(2, 1));

		// creation des panels
		setPanelNomPrenomClient(new PanelNomPrenomClient(this.getjDialogNouveau()));

		// ajout des Panel a PanelClient.
		add(getPanelNomPrenomClient(), 0, 0);

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

	public PanelCoordonneesClient getPanelCoordonneeClient() {
		return panelCoordonneeClient;
	}

	public void setPanelCoordonneeClient(PanelCoordonneesClient panelCoordonneeClient) {
		this.panelCoordonneeClient = panelCoordonneeClient;
	}

	public PanelCoordonneesChantier getPanelCoordonneeChantier() {
		return panelCoordonneeChantier;
	}

	public void setPanelCoordonneeChantier(PanelCoordonneesChantier panelCoordonneeChantier) {
		this.panelCoordonneeChantier = panelCoordonneeChantier;
	}

	public JPanel getPanelC() {

		panelC.setLayout(new GridLayout(1, 2));

		panelC.add(getPanelCoordonneeClient(), 0, 0);
		panelC.add(getPanelCoordonneeChantier(), 0, 1);

		add(panelC, 2, 0);
		setVisible(true);
		this.repaint();

		return panelC;
	}

}
