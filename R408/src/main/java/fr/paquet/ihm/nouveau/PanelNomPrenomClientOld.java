package fr.paquet.ihm.nouveau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.AddLineJLabelJTextField;
import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;

public class PanelNomPrenomClientOld extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private PanelClient panelClient = null;
	private JTextField jTextFieldNom = null;
	private JTextField jTextFieldPrenom = null;
	private JButtonTest buttonTest = null;

	public class JButtonTest extends JButton implements ActionListener, AlertListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JButtonTest() {
			super("Recherche le client dans la base");

			addActionListener(this);
			setEnabled(isEnable());
		}

		private boolean isEnable() {

			if (getjTextFieldNom() != null && getjTextFieldPrenom() != null) {
				if (!getjTextFieldNom().getText().equals("") && !getjTextFieldPrenom().getText().equals(""))
					return true;
				else
					return false;
			} else
				return false;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Client clt = null;
			// si le jTextFieldNom et jTextFiledprenom sont non null;
			if (!getjTextFieldNom().getText().equals("") && !getjTextFieldPrenom().getText().equals("")) {

				// Recherche par le nom et prenom si le client est dans la base de données.
				clt = new ClientFactory().findClientByNameAndFirstName(getjTextFieldNom().getText(),
						getjTextFieldPrenom().getText());

				// Si le resultat de la recherche est null
				if (clt == null) {
					// creation du nouveau client.
					clt = new Client(getjTextFieldNom().getText(), getjTextFieldPrenom().getText());
					getPanelClient().getjDialogNouveau().getProjet().setClient(clt);
					// Alert est propose de l'enregistrer dans la base de données.
					new AlertWindow(AlertType.QUESTION, "Ce client n'est pas dans la base. Voulez-vous l'ajouter?", this);

				}
			}

		}

		@Override
		public void buttonClick(String button) {

			// si le boutton cliqué est égale à "oui".
			if (button.equals("Oui")) {
				// Persit le cline dans la base de données.
				ClientFactory clF = new ClientFactory();
				try {
					clF.saveClient(
							getPanelClient().getjDialogNouveau().getProjet().getClient());
				} catch (Exception e) {

					e.printStackTrace(System.out);
					new AlertWindow(AlertType.ERREUR, e.getMessage());
				}
			}

		}

	}

	public PanelNomPrenomClientOld(PanelClient panelClient) {
		super();

		setPanelClient(panelClient);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des Component au panel
		AddLineJLabelJTextField lcl1 = new AddLineJLabelJTextField(this, "NOMCLIENT", "Nom du Client", 20, 0, 0, 1, 1,
				0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl2 = new AddLineJLabelJTextField(this, "PRENOMCLIENT", "Prenom du Client", 20, 0, 1,
				1, 1, 0, 0, GridBagConstraints.NONE);

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridBagLayout());
		add(panelButton, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

		panelButton.add(getJButtonTest(), new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

		// mutation des variable jTextFieldNom et jTextFieldPrenom.
		setjTextFieldNom(lcl1.getTextField());
		setjTextFieldPrenom(lcl2.getTextField());

	}

	private JButtonTest getJButtonTest() {
		if (buttonTest == null)
			buttonTest = new JButtonTest();
		return buttonTest;
	}

	private void selectAll(JTextField tF) {
		tF.selectAll();

	}

	private JTextField getjTextFieldNom() {
		return jTextFieldNom;
	}

	private void setjTextFieldNom(JTextField jTextFieldNom) {

		// ajout du listener sur la zone de saisi du nom.
		jTextFieldNom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				String nom = jTextFieldNom.getText();

				// si le texte de jTextFieldNom est différent de null ou ""
				if (!nom.equals("") && nom != null)
					// Affiche le nom sans espace à droite et à gauche et en majuscule.
					jTextFieldNom.setText(nom.trim().toUpperCase());
				getJButtonTest().setEnabled(getJButtonTest().isEnable());
			}

			@Override
			public void focusGained(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();
				selectAll(tF);
			}
		});

		this.jTextFieldNom = jTextFieldNom;
	}

	private JTextField getjTextFieldPrenom() {
		return jTextFieldPrenom;
	}

	private void setjTextFieldPrenom(JTextField jTextFieldPrenom) {

		// ajout du listener sur la zone de saidsi du prenom.
		jTextFieldPrenom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				String prenom = jTextFieldPrenom.getText();

				// si le texte de jTextFieldPrenom est différent de null ou ""
				if (!prenom.equals("") && prenom != null) {
					// Affiche le prenom sans espace à droite et à gauche
					// et avec une majuscule au premier caractere.
					prenom = prenom.trim().toLowerCase();
					prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
					jTextFieldPrenom.setText(prenom);
				}
				getJButtonTest().setEnabled(getJButtonTest().isEnable());

			}

			@Override
			public void focusGained(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();
				selectAll(tF);

			}
		});
		this.jTextFieldPrenom = jTextFieldPrenom;
	}

	public PanelClient getPanelClient() {
		return panelClient;
	}

	public void setPanelClient(PanelClient panelClient) {
		this.panelClient = panelClient;
	}

}
