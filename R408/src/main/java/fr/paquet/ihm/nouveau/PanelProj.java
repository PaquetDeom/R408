package fr.paquet.ihm.nouveau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelProj extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private JLabelJTextField titre = null;
	private JLabelJTextField url = null;
	private JLabelJTextField responsable = null;
	private JLabelJTextField client = null;
	private JDialogNouveau jDialogNouveau = null;

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
		setTitre( new JLabelJTextField(this, "Projet", 0, 0));
		setUrl(new JLabelJTextField(this, "URL", 0, 1));
		setResponsable(new JLabelJTextField(this, "Responsable", 0, 2, JSearchResponsable.class));
		setClient(new JLabelJTextField(this, "Client", 0, 3, JSearchClient.class));

		
	

	}

	public JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

	public JLabelJTextField getTitre() {
		return titre;
	}

	private void setTitre(JLabelJTextField titre) {
		this.titre = titre;
	}

	public JLabelJTextField getUrl() {
		return url;
	}

	private void setUrl(JLabelJTextField url) {
		this.url = url;
	}

	public JLabelJTextField getResponsable() {
		return responsable;
	}

	private void setResponsable(JLabelJTextField responsable) {
		this.responsable = responsable;
	}

	public JLabelJTextField getClient() {
		return client;
	}

	private void setClient(JLabelJTextField client) {
		this.client = client;
	}



}
