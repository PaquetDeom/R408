package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.ihm.alert.AlertWindow;

public class PanelCoordonneesChantier extends JPanel {

	/**
	 * @author paquet
	 */
	private PanelChantier panelChantier = null;
	private List<JTextField> textFields = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesChantier(PanelChantier panelChantier) {
		super();

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelChantier(panelChantier);

		// ajout d'un Layout.
		setLayout(new GridBagLayout());

		// ajout des Component au panel cordonneesPanel.
		AddLineJLabelJTextField lc1 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "ADRESSE1", "Lieu dit",
				20, 0, 0, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc2 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "ADRESSE2", "N°", 5, 0,
				1, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc3 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "ADRESSE3",
				"Nom de la rue", 20, 0, 2, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc4 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "CODEPOSTAL",
				"Code Postal", 8, 0, 3, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc5 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "COMMUNE", "Ville", 20,
				0, 4, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc6 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "MAIL", "Adresse mail",
				20, 0, 5, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc7 = new AddLineJLabelJTextField(PanelCoordonneesChantier.this, "TEL",
				"N° de telephone", 20, 0, 6, 1, 1, 0, 0, GridBagConstraints.NONE);

		putTextField(lc1.getTextField());
		putTextField(lc2.getTextField());
		putTextField(lc3.getTextField());
		putTextField(lc4.getTextField());
		putTextField(lc5.getTextField());
		putTextField(lc6.getTextField());
		putTextField(lc7.getTextField());

	}

	/**
	 * listener des textFields et ajout à la hashtable correspondante<br/>
	 * 
	 * @param titre
	 * @param textField
	 */
	private void putTextField(JTextField textField) {

		// ajout du TextField à la HashTable.
		getTextFields().add(textField);

		// Listener des TextFields.
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				JTextField textField = (JTextField) e.getSource();
				String title = textField.getName();

				if (!textField.getText().equals("")) {

					if (title.equals("ADRESSE1")) {
						getPanelChantier().getAdresse().setAdresse1(textField.getText());
					}
					if (title.equals("ADRESSE2")) {
						getPanelChantier().getAdresse().setAdresse2(textField.getText());
					}
					if (title.equals("ADRESSE3")) {
						getPanelChantier().getAdresse().setAdresse3(textField.getText());
					}
					if (title.equals("CODEPOSTAL")) {
						try {
							getPanelChantier().getAdresse().getCommune().setCodeCommune(textField.getText());
						} catch (Exception e1) {
							e1.printStackTrace(System.out);
							new AlertWindow("ERREUR", e1.getMessage());
						}
					}
					if (title.equals("COMMUNE")) {
						getPanelChantier().getAdresse().getCommune().setCommune(textField.getText());
					}
					if (title.equals("MAIL")) {
						try {
							getPanelChantier().getAdresse().setMail(textField.getText());
						} catch (Exception e1) {
							e1.printStackTrace(System.out);
							new AlertWindow("ERREUR", e1.getMessage());
						}
					}
					if (title.equals("TEL")) {
						try {
							getPanelChantier().getAdresse().setTelephone(textField.getText());
						} catch (Exception e1) {
							e1.printStackTrace(System.out);
							new AlertWindow("ERREUR", e1.getMessage());
						}
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				
				//selectionne le tout le texte du texField
				JTextField tF = (JTextField) e.getSource();
				tF.selectAll();

			}
		});

	}

	private void setPanelChantier(PanelChantier panelChantier) {
		this.panelChantier = panelChantier;
	}

	/**
	 * 
	 * @return le panelChantier correspondant<br/>
	 */
	private PanelChantier getPanelChantier() {
		return panelChantier;
	}

	private List<JTextField> getTextFields() {
		if (textFields == null)
			textFields = new ArrayList<JTextField>();
		return textFields;
	}

}
