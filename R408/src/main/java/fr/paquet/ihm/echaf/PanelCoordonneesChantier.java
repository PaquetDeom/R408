package fr.paquet.ihm.echaf;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

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
							getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse1(textField.getText());
						}
						if (title.equals("ADRESSE2")) {
							getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse2(textField.getText());
						}
						if (title.equals("ADRESSE3")) {
							getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse3(textField.getText());
						}
						if (title.equals("CODEPOSTAL")) {
							try {
								getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().getCommune().setCodeCommune(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
						if (title.equals("COMMUNE")) {
							getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().getCommune().setCommune(textField.getText());
						}
						if (title.equals("MAIL")) {
							try {
								getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().setMail(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
						if (title.equals("TEL")) {
							try {
								getPanelChantier().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().setTelephone(textField.getText());
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
					tF.selectAll();

				}
			});

		}

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
