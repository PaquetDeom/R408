package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

import javax.swing.*;

import fr.paquet.projet.Responsable;

public class PanelProj extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private Hashtable<String, JTextField> textFields = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelProj(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);

		setLayout(new GridBagLayout());

		// Titre du JPanel
		add(new JLabel("Données du projet"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		// Affichage des JLabel et JtextField sur le Panel en fonction du Layout
		AddLineJLabelJTextField l1 = new AddLineJLabelJTextField(this, "TITRE", "Titre du projet", 20, 0, 1, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField l2 = new AddLineJLabelJTextField(this, "NOMRESP", "Nom du responsable", 20, 0, 2, 1, 1,
				0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField l3 = new AddLineJLabelJTextField(this, "PRENOMRESP", "Prenom du responsable", 20, 0, 3,
				1, 1, 0, 1, GridBagConstraints.NONE);

		// listener + put dans la HashTable
		putTextField(l1.getTitre(), l1.getTextField());
		putTextField(l2.getTitre(), l2.getTextField());
		putTextField(l3.getTitre(), l3.getTextField());

	}

	/**
	 * Methode qui met le textField dans la HashTable<br/>
	 * Contient le Listener des TexField<br/>
	 * 
	 * @param titre
	 * @param textField
	 */
	private void putTextField(String titre, JTextField textField) {
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (titre.equals("TITRE")) {
					if (!textField.getText().trim().equals(""))
						getPanelEntete().getPanelProjet().getOnglet().getProjet().setTitre(textField.getText());

				} else {
					if (getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp() == null)
						getPanelEntete().getPanelProjet().getOnglet().getProjet().setResp(new Responsable());
					if (titre.equals("NOMRESP")) {
						getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().setNom(textField.getText());
						textField.setText(getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getNom());
					}

					if (titre.equals("PRENOMRESP")) {
						getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp()
								.setPrenom(textField.getText());
						textField.setText(
								getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getPrenom());
					}

				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		getTextFields().put(titre, textField);
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
	 * @return la Hashtabe<TITRE, JtextField><br/>
	 */
	private Hashtable<String, JTextField> getTextFields() {
		if (textFields == null)
			textFields = new Hashtable<String, JTextField>();
		return textFields;
	}

}
