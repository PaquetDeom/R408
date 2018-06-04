package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;

public class PanelNomPrenomClient extends JPanel implements PropertyChangeListener, AlertListener {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private PanelClient panelClient = null;

	public PanelNomPrenomClient(PanelClient panelClient) {
		super();

		setPanelClient(panelClient);

		// listener.
		getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.addPropertyChangeListener(this);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des Component au panel
		AddLineJLabelJTextField lcl1 = new AddLineJLabelJTextField(this, "NOMCLIENT", "Nom du Client", 20, 0, 0, 1, 1,
				0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl2 = new AddLineJLabelJTextField(this, "PRENOMCLIENT", "Prenom du Client", 20, 0, 1,
				1, 1, 0, 0, GridBagConstraints.NONE);

		// ajout des listeners
		LTextField(lcl1.getTextField());
		LTextField(lcl2.getTextField());

	}

	private void LTextField(JTextField textField) {

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (!textField.getText().equals("")) {
					if (textField.getName().equals("NOMCLIENT")) {
						getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
								.setNom(textField.getText());
						textField.setText(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet()
								.getClient().getNom());
					}

					if (textField.getName().equals("PRENOMCLIENT")) {
						getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
								.setPrenom(textField.getText());
						textField.setText(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet()
								.getClient().getPrenom());
					}
				}

			}

			@Override
			public void focusGained(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();
				tF.selectAll();

			}
		});

	}

	public PanelClient getPanelClient() {
		return panelClient;
	}

	public void setPanelClient(PanelClient panelClient) {
		this.panelClient = panelClient;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		if (getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient().getNom() != null
				&& getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
						.getPrenom() != null) {

			Client clt = new ClientFactory().findClientByNameAndFirstName(
					getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient().getNom(),
					getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient().getPrenom());

			if (clt == null) {
				new AlertWindow("Question", "Ce client n'est pas dans la base. Voulez-vous l'ajouter?", this);

			}

		}

	}

	@Override
	public void buttonClick(String button) {

		if (button.equals("Oui")) {
			ClientFactory clF = new ClientFactory();
			try {
				clF.saveClient(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient());
			} catch (Exception e) {

				e.printStackTrace(System.out);
				new AlertWindow("Erreur", e.getMessage());
			}
		}

	}

}
