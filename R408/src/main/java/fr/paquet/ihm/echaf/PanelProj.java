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

		addComponent("TITRE", "Titre du projet", 20, 0);
		addComponent("NOMRESP", "Nom du responsable", 20, 1);
		addComponent("PRENOMRESP", "Prenom du responsable", 20, 2);

	}

	/**
	 * Methode chargee d'empiler les differents components<br/>
	 * 
	 * @param titre
	 * @param textLabel
	 * @param taille
	 * @param position
	 */
	private void addComponent(String titre, String textLabel, int taille, int position) {

		JTextField textField = new JTextField(taille);
		putTextField(titre, textField);

		add(new JLabel(textLabel), new GridBagConstraints(0, position, 1, 1, 1.0, 1.0, GridBagConstraints.LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(textField, new GridBagConstraints(1, position, 1, 1, 1.0, 1.0, GridBagConstraints.BASELINE,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	private void putTextField(String titre, JTextField textField) {
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (titre.equals("TITRE")) {
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

	private Hashtable<String, JTextField> getTextFields() {
		if (textFields == null)
			textFields = new Hashtable<String, JTextField>();
		return textFields;
	}

}
