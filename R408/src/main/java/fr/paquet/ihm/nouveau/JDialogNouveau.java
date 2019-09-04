package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.OngletProjet;
import fr.paquet.ihm.main.MainFrame;
import fr.paquet.ihm.main.MainMenu;
import fr.paquet.projet.AdresseFactory;
import fr.paquet.projet.Chantier;
import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;
import fr.paquet.projet.CommuneFactory;
import fr.paquet.projet.Projet;
import fr.paquet.projet.ProjetFactory;
import fr.paquet.projet.Responsable;

public class JDialogNouveau extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projet projet = null;
	private PanelProj panelProj = null;
	private PanelClient panelClient = null;
	private JButton jButtonCreer = null;

	public JDialogNouveau(Projet projet) {
		super(MainFrame.getUniqInstance());
		
		setProjet(projet);
		getProjet().setChantier(new Chantier());
		setjButtonCreer(new JButton("Creer le projet"));
		setPanelProj(new PanelProj(this));

		// construction de la fenetre
		setTitle("Création d'un nouveau projet");
		setSize(900, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// layout
		GridBagLayout layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		// traitement de PanelProf
		getContentPane().add(getPanelProj(), new GridBagConstraints(0, 0, 1, 1, 1, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, new GridBagConstraints(0, 3, 3, 1, 1, 0.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));

		buttonPanel.setLayout(new BorderLayout());
		JPanel panelButton2 = new JPanel();
		panelButton2.setLayout(new GridLayout());

		panelButton2.add(getjButtonCreer());

		buttonPanel.add(panelButton2, BorderLayout.EAST);

	}

	public Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	public PanelProj getPanelProj() {
		return panelProj;
	}

	private void setPanelProj(PanelProj panelProj) {
		this.panelProj = panelProj;
	}

	public PanelClient getPanelClient() {
		return panelClient;
	}

	private void setPanelClient(PanelClient panelClient) {
		this.panelClient = panelClient;
	}

	public JButton getjButtonCreer() {
		return jButtonCreer;
	}

	private void setjButtonCreer(JButton jButtonCreer) {

		jButtonCreer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				initProjet();

				if (projetEnable()) {
					OngletProjet oProjet = new OngletProjet(getProjet());

					oProjet.setVisible(true);
					JDialogNouveau.this.dispose();

					// Enregistrement en base de donnée

					ProjetFactory proF = new ProjetFactory();

					try {

						proF.saveProjet(getProjet());
					} catch (Exception e1) {
						e1.printStackTrace();
						new AlertWindow(AlertType.ERREUR, "Le projet n'a pas été sauvegardé");
					}

				} else {
					new AlertWindow(AlertType.ERREUR, "Veuillez renseigner la fenêtre");
				}

			}
		});

		this.jButtonCreer = jButtonCreer;
	}

	private void initProjet() {

		if (!getPanelProj().getTitre().getTextField().getText().equals(""))
			getProjet().setTitre(getPanelProj().getTitre().getTextField().getText());

		if (getPanelProj().getClient().getObjet() != null) {
			Client client = (Client) getPanelProj().getClient().getObjet();
			getProjet().setClient(client);
		}

		if (getPanelProj().getResponsable().getObjet() != null) {
			Responsable resp = (Responsable) getPanelProj().getResponsable().getObjet();
			getProjet().setResp(resp);
		}

		Echafaudage echf = new Echafaudage();
		Chantier chantier = new Chantier(getProjet(), echf);
		getProjet().setChantier(chantier);

		if (!getPanelProj().getUrl().getTextField().getText().equals(""))
			getProjet().setUrl(getPanelProj().getUrl().getTextField().getText());

		MainMenu.getUniqInstance().getActionSave().setProjet(getProjet());

		if (getProjet().getUrl() != null) {
			MainMenu.getUniqInstance().getAction3D().setProjet(getProjet());
			MainMenu.getUniqInstance().getActionUrl().setProjet(getProjet());
		}
	}

	/**
	 * 
	 * @return true si le projet a un titre, un client et un responsable<br/>
	 */
	private boolean projetEnable() {

		Responsable resp = getProjet().getResp();
		Client client = getProjet().getClient();
		String titre = getProjet().getTitre();

		if ((titre != null && !titre.equals("")) && client != null && resp != null)
			return true;
		else
			return false;
	}

}
