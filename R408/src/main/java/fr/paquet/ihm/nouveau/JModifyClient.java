package fr.paquet.ihm.nouveau;

import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;

public class JModifyClient extends JModifyDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabelJTextField jtfNom = null;
	JLabelJTextField jtfPrenom = null;
	JLabelJTextField jtfAdr1 = null;
	JLabelJTextField jtfAdr2 = null;
	JLabelJTextField jtfAdr3 = null;
	JLabelJTextField jtfAdr4 = null;
	JLabelJTextField jtfCP = null;
	JLabelJTextField jtfCommune = null;
	JLabelJTextField jtfMail = null;
	JLabelJTextField jtfTel = null;

	private Client getClient() {
		return (Client) getModifyObject();
	}

	public JModifyClient(Object object) {
		super(object);
		jtfNom = new JLabelJTextField(getMaintenancePanel(), "Nom", 0, 0);
		jtfPrenom = new JLabelJTextField(getMaintenancePanel(), "Prenom", 0, 1);
		jtfAdr1 = new JLabelJTextField(getMaintenancePanel(), "Adresse", 0, 2);
		jtfAdr2 = new JLabelJTextField(getMaintenancePanel(), "", 0, 3);
		jtfAdr3 = new JLabelJTextField(getMaintenancePanel(), "", 0, 4);
		jtfAdr4 = new JLabelJTextField(getMaintenancePanel(), "", 0, 5);
		jtfCP = new JLabelJTextField(getMaintenancePanel(), "CP", 0, 6);
		jtfCommune = new JLabelJTextField(getMaintenancePanel(), "Ville", 0, 7);
		jtfMail = new JLabelJTextField(getMaintenancePanel(), "EMail", 0, 8);
		jtfTel = new JLabelJTextField(getMaintenancePanel(), "Tel", 0, 9);

		if (getClient() != null) {
			jtfNom.setText(getClient().getNom());
			jtfPrenom.setText(getClient().getPrenom());
			jtfAdr1.setText(getClient().getAdresse().getAdresse1());
			jtfAdr2.setText(getClient().getAdresse().getAdresse2());
			jtfAdr3.setText(getClient().getAdresse().getAdresse3());
			jtfAdr4.setText(getClient().getAdresse().getAdresse4());
			jtfCP.setText(getClient().getAdresse().getCodeCommune());
			jtfCommune.setText(getClient().getAdresse().getCom());
			jtfMail.setText(getClient().getAdresse().getMail());
			jtfTel.setText(getClient().getAdresse().getTel());
		}
	}

	public void save() {
		try {
			if (getClient() == null)
				setModifyObject(new Client());
			getClient().setNom(jtfNom.getText());
			getClient().setPrenom(jtfPrenom.getText());
			if (!jtfAdr1.getText().equals(""))
				getClient().getAdresse().setAdresse1(jtfAdr1.getText());
			if (!jtfAdr2.getText().equals(""))
				getClient().getAdresse().setAdresse2(jtfAdr2.getText());
			if (!jtfAdr3.getText().equals(""))
				getClient().getAdresse().setAdresse3(jtfAdr3.getText());
			if (!jtfAdr4.getText().equals(""))
				getClient().getAdresse().setAdresse4(jtfAdr4.getText());
			if (!jtfCP.getText().equals(""))
				getClient().getAdresse().setCodeCommune(jtfCP.getText());
			if (!jtfCommune.getText().equals(""))
				getClient().getAdresse().setCom(jtfCommune.getText());
			if (!jtfMail.getText().equals(""))
				getClient().getAdresse().setMail(jtfMail.getText());
			if (!jtfTel.getText().equals(""))
				getClient().getAdresse().setTelephone(jtfTel.getText());
			new ClientFactory().saveClient(getClient());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
