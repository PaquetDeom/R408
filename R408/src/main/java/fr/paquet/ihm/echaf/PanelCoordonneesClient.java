package fr.paquet.ihm.echaf;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertWindow;

public class PanelCoordonneesClient extends PanelCoordonnees {

	/**
	 * @author paquet
	 */
	private PanelClient panelClient = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesClient(PanelClient panelClient) {
		super();

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelClient(panelClient);

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
							getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse1(textField.getText());
						}
						if (title.equals("ADRESSE2")) {
							getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse2(textField.getText());
						}
						if (title.equals("ADRESSE3")) {
							getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().setAdresse3(textField.getText());
						}
						if (title.equals("CODEPOSTAL")) {
							try {
								getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().getCommune().setCodeCommune(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow("ERREUR", e1.getMessage());
							}
						}
						if (title.equals("COMMUNE")) {
							getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
									.getAdresse().getCommune().setCommune(textField.getText());
						}
						if (title.equals("MAIL")) {
							try {
								getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().setMail(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow("ERREUR", e1.getMessage());
							}
						}
						if (title.equals("TEL")) {
							try {
								getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
										.getAdresse().setTelephone(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow("ERREUR", e1.getMessage());
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

	private void setPanelClient(PanelClient panelClient) {
		this.panelClient = panelClient;
	}

	/**
	 * 
	 * @return le panelClient correspondant<br/>
	 */
	private PanelClient getPanelClient() {
		return panelClient;
	}

}
