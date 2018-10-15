package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;

public class PanelNomPrenomClient extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private PanelClient panelClient = null;

	public PanelNomPrenomClient(PanelClient panelClient) {
		super();

		setPanelClient(panelClient);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des Component au panel

		add(new JLabel("Nom du Client : "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient().getNom()),
				new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));

		add(new JLabel("Prenom du Client : "), new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel(
				getPanelClient().getPanelEntete().getPanelProjet().getOnglet().getProjet().getClient().getPrenom()),
				new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelClient getPanelClient() {
		return panelClient;
	}

	public void setPanelClient(PanelClient panelClient) {
		this.panelClient = panelClient;
	}

}
