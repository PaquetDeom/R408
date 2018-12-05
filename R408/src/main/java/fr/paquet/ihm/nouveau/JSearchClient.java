package fr.paquet.ihm.nouveau;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.projet.Client;
import fr.paquet.projet.ClientFactory;

public class JSearchClient extends JSearchDialog {
	JLabelJTextField jtfNom = null;
	private Client client = null;

	public JSearchClient(String nom) {
		super();

		jtfNom = new JLabelJTextField(getPanelCritere(), "Nom", 0, 0);
		jtfNom.setText(nom);
		doSearchAction();
	}

	@Override
	public List getValues() {
		if (jtfNom == null)
			return new ArrayList();
		ClientFactory cF = new ClientFactory();
		return cF.findClientsByName(jtfNom.getText());
	}

	@Override
	public String[] getColumnsName() {
		return new String[] { "nom", "prenom", "CP", "Ville" };
	}

	@Override
	public Class[] getColumnsClass() {
		return new Class[] { String.class, String.class, String.class, String.class };
	}

	@Override
	public Object getListValue(Object object, int columnIndex) {
		Client c = (Client) object;
		switch (columnIndex) {
		case 0:
			return c.getNom();
		case 1:
			return c.getPrenom();
		case 2:
			try {
				return c.getAdresse().getCodeCommune();
			} catch (Exception e) {
				return "";
			}
		case 3:
			try {
				return c.getAdresse().getCom();
			} catch (Exception e) {
				return "";
			}
		}
		return "";
	}

	@Override
	protected Class getDialogClass() {
		return JModifyClient.class;
	}

}
