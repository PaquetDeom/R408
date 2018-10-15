package fr.paquet.ihm.nouveau;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Commune;

public class PanelCoordonneesClient extends PanelCoordonnees {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private JDialogClient jDialogClient = null;

	public PanelCoordonneesClient(JDialogClient jDC) {
		super();

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setjDialogClient(jDC);

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
							getjDialogClient().getAdresse().setAdresse1(textField.getText());
						}
						if (title.equals("ADRESSE2")) {
							getjDialogClient().getAdresse().setAdresse2(textField.getText());
						}
						if (title.equals("ADRESSE3")) {
							getjDialogClient().getAdresse().setAdresse3(textField.getText());
						}
						if (title.equals("CODEPOSTAL")) {
							try {
								if (getjDialogClient().getAdresse().getCommune() == null)
									getjDialogClient().getAdresse().setCommune(getCommune());

								getjDialogClient().getAdresse().getCommune().setCodeCommune(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, "problème lors de l'enregistrement de la commune");
							}
						}
						if (title.equals("COMMUNE")) {

							try {
								if (getjDialogClient().getAdresse().getCommune() == null)
									getjDialogClient().getAdresse().setCommune(getCommune());

								getjDialogClient().getAdresse().getCommune().setCommune(textField.getText());
							} catch (Exception e2) {
								e2.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, "problème lors de l'enregistrement de la commune");
							}

						}
						if (title.equals("MAIL")) {
							try {
								getjDialogClient().getAdresse().setMail(textField.getText());
							} catch (Exception e1) {
								e1.printStackTrace(System.out);
								new AlertWindow(AlertType.ERREUR, e1.getMessage());
							}
						}
						if (title.equals("TEL")) {
							try {
								getjDialogClient().getAdresse().setTelephone(textField.getText());
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

	public JDialogClient getjDialogClient() {
		return jDialogClient;
	}

	private void setjDialogClient(JDialogClient jDialogClient) {
		this.jDialogClient = jDialogClient;
	}

}
