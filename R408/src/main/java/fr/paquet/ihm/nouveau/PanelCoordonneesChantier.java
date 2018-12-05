package fr.paquet.ihm.nouveau;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Commune;

public class PanelCoordonneesChantier extends PanelCoordonnees {

	/**
	 * @author paquet
	 */
	private JDialogNouveau jDialogNouveau = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesChantier(JDialogNouveau jDialogNouveau) {
		super();

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Coordonnées du chantier"));

		// effacer tous les components
		removeAll();

		// mutte
		setjDialogNouveau(jDialogNouveau);

		// construit le panel de Coordonnes
		buildPanel();

		// listener des textFields
		for (JTextField textField : getCoordonnesField()) {
			textField.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {

					JTextField textField = (JTextField) e.getSource();
					String title = textField.getName();

					if (!textField.getText().equals("")) {

						if (title.equals("ADRESSE1")) {
							getjDialogNouveau().getProjet().getChantier().getAdresse().setAdresse1(textField.getText());
						}
						if (title.equals("ADRESSE2")) {
							getjDialogNouveau().getProjet().getChantier().getAdresse().setAdresse2(textField.getText());
						}
						if (title.equals("ADRESSE3")) {
							getjDialogNouveau().getProjet().getChantier().getAdresse().setAdresse3(textField.getText());
						}
						if (title.equals("CODEPOSTAL")) {
							try {
								getjDialogNouveau().getProjet().getChantier().getAdresse()
										.setCodeCommune(textField.getText());
							} catch (Exception e1) {

								e1.printStackTrace();
							}
						}

						if (title.equals("COMMUNE")) {
							getjDialogNouveau().getProjet().getChantier().getAdresse().setCom(textField.getText());
						}
						if (title.equals("MAIL")) {
							try {
								getjDialogNouveau().getProjet().getChantier().getAdresse().setMail(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
						if (title.equals("TEL")) {
							try {
								getjDialogNouveau().getProjet().getChantier().getAdresse()
										.setTelephone(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
					}
				}

				@Override
				public void focusGained(FocusEvent e) {

					// selectionne le tout le texte du texField
					JTextField tF = (JTextField) e.getSource();
					tF.setText("");

				}
			});

		}

	}

	private Commune commune = null;

	private Commune getCommune() {
		if (commune == null)
			commune = new Commune();
		return commune;
	}

	private JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

}
