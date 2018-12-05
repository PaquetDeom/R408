package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import fr.paquet.projet.Client;

public class PanelCoordonneesClient extends PanelCoordonnees {

	/**
	 * @author paquet
	 */
	private PanelClient panelClient = null;
	private static final long serialVersionUID = 1L;

	public PanelCoordonneesClient(Client client) {
		super();

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Coordonnées client"));

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelClient(panelClient);

		// listener des labels
		add(new JLabel(client.getAdresse().getAdresse1()), new GridBagConstraints(1, 0, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getAdresse2()), new GridBagConstraints(1, 1, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getAdresse3()), new GridBagConstraints(1, 2, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getCodeCommune()), new GridBagConstraints(1, 3, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getCom()), new GridBagConstraints(1, 4, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getMail()), new GridBagConstraints(1, 5, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(client.getAdresse().getTel()), new GridBagConstraints(1, 6, 1, 1, 1, 0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelCoordonneesClient(PanelClient panelClient) {
		super();

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Coordonnées client"));

		// effacer tous les components
		removeAll();

		// mutte la variable panelChantier
		setPanelClient(panelClient);

		// listener des labels
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getAdresse1()),
				new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getAdresse2()),
				new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getAdresse3()),
				new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getCodeCommune()),
				new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getCom()),
				new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getMail()),
				new GridBagConstraints(1, 5, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient()
				.getAdresse().getTel()),
				new GridBagConstraints(1, 6, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));

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
