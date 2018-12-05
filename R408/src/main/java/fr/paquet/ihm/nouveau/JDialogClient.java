package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Adresse;
import fr.paquet.projet.Client;

public class JDialogClient extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelNom = null;
	private JPanel panelButton = null;
	private PanelCoordonneesClient pCC = null;
	private JButton buttonOk = null;
	private JButton buttonAnnul = null;
	private Adresse adresse = null;
	private PanelNomPrenomClient panelNometPrenomClient = null;

	public JDialogClient(Client client, PanelNomPrenomClient panelNometPrenomClient) {
		super();

		// setteurs
		setPanelNom(new JPanel());
		setPanelButton(new JPanel());
		setpCC(new PanelCoordonneesClient(this));
		setButtonOk(new JButton("Ok"));
		setButtonAnnul(new JButton("Annuler"));
		setAdresse(new Adresse());
		setPanelNometPrenomClient(panelNometPrenomClient);

		// construction de la fenetre
		setTitle("Création d'un nouveau client");
		setSize(600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);
		setModal(true);

		// layout
		getContentPane().setLayout(new GridBagLayout());

		getContentPane().add(getPanelNom(), new GridBagConstraints(0, 0, 1, 1, 1.0, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(getpCC(), new GridBagConstraints(0, 1, 1, 1, 0.0, 3.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getContentPane().add(getPanelButton(), new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		getPanelNom().setLayout(new GridBagLayout());
		JLabel ln1 = new JLabel("Nom : ");
		JLabel lp1 = new JLabel("Prenom : ");
		JLabel ln2 = new JLabel(client.getNom());
		JLabel lp2 = new JLabel(client.getPrenom());

		getPanelNom().add(ln1, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.BASELINE,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		getPanelNom().add(lp1, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.BASELINE,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		getPanelNom().add(ln2, new GridBagConstraints(1, 0, 1, 1, 2.0, 0.0, GridBagConstraints.BASELINE,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getPanelNom().add(lp2, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.BASELINE,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		getPanelButton().setLayout(new BorderLayout());
		JPanel pB2 = new JPanel();
		pB2.setLayout(new GridLayout());

		pB2.add(getButtonAnnul());
		pB2.add(getButtonOk());
		getPanelButton().add(pB2, BorderLayout.EAST);
	}

	private JPanel getPanelNom() {
		return panelNom;
	}

	private void setPanelNom(JPanel panelNom) {
		panelNom.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Client"));
		this.panelNom = panelNom;
	}

	private JPanel getPanelButton() {
		return panelButton;
	}

	private void setPanelButton(JPanel panelButton) {
		this.panelButton = panelButton;
	}

	private PanelCoordonneesClient getpCC() {
		return pCC;
	}

	private void setpCC(PanelCoordonneesClient pCC) {
		pCC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Coordonnées du client"));
		this.pCC = pCC;
	}

	private JButton getButtonOk() {
		return buttonOk;
	}

	private void setButtonOk(JButton buttonOk) {

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getAdresse() != null) {
					getPanelNometPrenomClient().getjDialogNouveau().getProjet().getClient().setAdresse(getAdresse());
					JDialogClient.this.dispose();

				} else
					new AlertWindow(AlertType.ERREUR, "Veuillez saisir une adresse");

			}
		});
		this.buttonOk = buttonOk;
	}

	private JButton getButtonAnnul() {
		return buttonAnnul;
	}

	private void setButtonAnnul(JButton buttonAnnul) {

		buttonAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialogClient.this.dispose();

			}
		});

		this.buttonAnnul = buttonAnnul;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	private void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public PanelNomPrenomClient getPanelNometPrenomClient() {
		return panelNometPrenomClient;
	}

	public void setPanelNometPrenomClient(PanelNomPrenomClient panelNometPrenomClient) {
		this.panelNometPrenomClient = panelNometPrenomClient;
	}

}
