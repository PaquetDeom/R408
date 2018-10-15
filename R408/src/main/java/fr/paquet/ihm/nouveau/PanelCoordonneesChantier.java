package fr.paquet.ihm.nouveau;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Commune;

public class PanelCoordonneesChantier extends PanelCoordonnees {

	/**
	 * @author paquet
	 */
	private PanelChantier panelChantier = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesChantier(PanelChantier panelChantier) {
		super();

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelChantier(panelChantier);

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
							getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
									.setAdresse1(textField.getText());
						}
						if (title.equals("ADRESSE2")) {
							getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
									.setAdresse2(textField.getText());
						}
						if (title.equals("ADRESSE3")) {
							getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
									.setAdresse3(textField.getText());
						}
						if (title.equals("CODEPOSTAL")) {
							try {
								if (getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
										.getCommune() == null)
									getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
											.setCommune(getCommune());

								getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
										.getCommune().setCodeCommune(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, "La commune n'a pas été enregistrée");
							}
						}

						if (title.equals("COMMUNE")) {

							try {
								if (getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
										.getCommune() == null)
									getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
											.setCommune(getCommune());

								getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
										.getCommune().setCommune(textField.getText());

							} catch (Exception e2) {
								e2.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, "La commune n'a pas été enregistrée");
							}

						}
						if (title.equals("MAIL")) {
							try {
								getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
										.setMail(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
						if (title.equals("TEL")) {
							try {
								getPanelChantier().getjDialogNouveau().getProjet().getChantier().getAdresse()
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

}
