package fr.paquet.ihm.echaf;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertWindow;

public class PanelProj extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private List<JTextField> textFields = null;

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

		// Affichage des JLabel et JtextField sur le Panel en fonction du Layout
		AddLineJLabelJTextField l1 = new AddLineJLabelJTextField(this, "TITRE", "Titre du projet", 20, 0, 1, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField l2 = new AddLineJLabelJTextField(this, "NOMRESP", "Nom du responsable", 20, 0, 2, 1, 1,
				0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField l3 = new AddLineJLabelJTextField(this, "PRENOMRESP", "Prenom du responsable", 20, 0, 3,
				1, 1, 0, 1, GridBagConstraints.NONE);

		// listener + put dans la HashTable
		putTextField(l1.getTextField());
		putTextField(l2.getTextField());
		putTextField(l3.getTextField());

		add(new JPanel(), new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	/**
	 * Methode qui met le textField dans la HashTable<br/>
	 * Contient le Listener des TexField<br/>
	 * 
	 * @param titre
	 * @param textField
	 */
	private void putTextField(JTextField textField) {

		getTextFields().add(textField);

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();

				if (tF.getName().equals("TITRE")) {

					if (!tF.getText().equals(""))
						getPanelEntete().getPanelProjet().getOnglet().getProjet().setTitre(textField.getText());
					if (tF.getText().equals("") || tF.getText() == null
							|| tF.getText().equals("Veuillez saisir un titre au projet")) {
						new AlertWindow("Erreur", "Le projet doit avoir un titre");
						tF.setText("Veuillez saisir un titre au projet");
						tF.setForeground(Color.red);
						//TODO Bruno
						tF.requestFocus();
						tF.moveCaretPosition(0);

					}
				}

				if (tF.getName().equals("NOMRESP")) {
					if (!tF.getText().equals("")) {
						getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().setNom(textField.getText());
						textField.setText(getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getNom());
						System.out
								.println(getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getNom());
					}

				}

				if (tF.getName().equals("PRENOMRESP")) {
					if (!tF.getText().equals("")) {
						getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp()
								.setPrenom(textField.getText());
						textField.setText(
								getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getPrenom());
						System.out.println(
								getPanelEntete().getPanelProjet().getOnglet().getProjet().getResp().getPrenom());
					}
				}

			}

			@Override
			public void focusGained(FocusEvent e) {

				// Sélectionne tout le texte du textField
				JTextField tF = (JTextField) e.getSource();
				tF.selectAll();

			}

		});

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
	private List<JTextField> getTextFields() {
		if (textFields == null)
			textFields = new ArrayList<JTextField>();
		return textFields;
	}

}
