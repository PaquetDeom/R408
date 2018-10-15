package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;
import fr.paquet.projet.Responsable;
import fr.paquet.projet.ResponsableFactory;

import javax.swing.SwingConstants;

public class PanelNomPrenomClient extends PanelNomPrenom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client client = null;
	private List<Client> clients = null;

	public PanelNomPrenomClient(JDialogNouveau jDN) {
		super(jDN);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				"Client du projet"));

		// setteurs
		setjTextFieldNom(new JTextField(20));
		setjTextFieldPrenom(new JTextField(20));
		setButtonCreer(new JButton("Creer"));
		setButtonOk(new JButton("Ok"));
		setButtonCancel(new JButton("Annuler"));

		// ajout des components au panel.

		getPanelSaisi().add(new JLabel("Nom : "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(new JLabel("Prenom : "), new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(getjTextFieldNom(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(getjTextFieldPrenom(), new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		getPanelButtonGauche().add(getButtonCreer(), BorderLayout.CENTER);
		getPanelButtonGauche().add(getButtonCancel(), BorderLayout.EAST);

		getPanelButtonDroite().add(getButtonOk(), BorderLayout.EAST);

	}

	@Override
	public void setTable(JTable table) {

		// donne le type de sélection
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();

		// ajout d'un listener
		rowSM.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				DefaultListSelectionModel dLSM = (DefaultListSelectionModel) e.getSource();
				int i = dLSM.getMinSelectionIndex();
				getjTextFieldNom().setText(getClients().get(i).getNom());
				getjTextFieldPrenom().setText(getClients().get(i).getPrenom());
				frizeSaisi();

				try {
					setClient(getClients().get(i));
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		this.table = table;

	}

	@Override
	public void setjTextFieldNom(JTextField jTextFieldNom) {

		jTextFieldNom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				ClientFactory cF = new ClientFactory();
				List<Client> clients = cF.findClientsByName(jTextFieldNom.getText());

				if (clients != null && clients.isEmpty()) {
					setClients(clients);
					setTableModel(new ClientModel(getClients()));
					setTable(new JTable(getTableModel()));
					getPanelTable().add(getTable());
				}

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				jTextFieldNom.setText("");

			}
		});

		this.jTextFieldNom = jTextFieldNom;

	}

	@Override
	public void setjTextFieldPrenom(JTextField jTextFieldPrenom) {

		jTextFieldPrenom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldPrenom.setText("");

			}
		});

		this.jTextFieldPrenom = jTextFieldPrenom;

	}

	@Override
	public void setTableModel(TableModel tM) {
		this.tableModel = tM;
	}

	@Override
	public void setButtonCreer(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if ((!getjTextFieldNom().getText().equals("") && getjTextFieldNom().getText() != null)
						&& (!getjTextFieldPrenom().getText().equals("") && getjTextFieldPrenom().getText() != null))
					setClient(new Client(getjTextFieldNom().getText().toUpperCase(), getjTextFieldPrenom().getText()));

				if (getClient() != null) {
					frizeSaisi();
					new JDialogClient(getClient(), PanelNomPrenomClient.this);

				} else {
					new AlertWindow(AlertType.ERREUR, "Veuillez saisir le nom et le prenom du client");
				}

			}
		});

		this.buttonCreer = button;
	}

	@Override
	public void setButtonOk(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getClient() != null) {
					getjDialogNouveau().getProjet().setClient(getClient());
					frizeSaisi();
				} else {
					new AlertWindow(AlertType.ERREUR, "Veuillez saisir un client");
				}

			}
		});

		this.buttonOk = button;

	}

	@Override
	public void setButtonCancel(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setClient(null);
				getjDialogNouveau().getProjet().setClient(null);
				desFrizeSaisi();
				PanelNomPrenomClient.this.repaint();
			}
		});
		this.buttonCancel = button;
	}

	public Client getClient() {
		return client;
	}

	private void setClient(Client client) {

		if ((getjTextFieldNom() != null && !getjTextFieldNom().equals(""))
				&& (getjTextFieldPrenom() != null && !getjTextFieldPrenom().equals("")))
			this.client = client;
		else
			this.client = null;
	}

	private List<Client> getClients() {
		return clients;
	}

	private void setClients(List<Client> clients) {
		this.clients = clients;
	}

	private void frizeSaisi() {
		getjTextFieldNom().setEnabled(false);
		getjTextFieldPrenom().setEnabled(false);
		if (getTable() != null)
			getTable().setEnabled(false);
	}

	private void desFrizeSaisi() {
		getjTextFieldNom().setEnabled(true);
		getjTextFieldPrenom().setEnabled(true);
		getTable().setEnabled(true);
	}

}
