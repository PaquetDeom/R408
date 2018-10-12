package fr.paquet.ihm.nouveau;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.projet.Client;

public class ClientModel implements TableModel {

	private List<Client> clients = null;

	public ClientModel() {
		super();
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0)
			return Client.class;
		if (columnIndex == 1)
			return Client.class;
		else
			return null;
	}

	@Override
	public int getColumnCount() {

		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0)
			return "Nom du client";
		if (columnIndex == 1)
			return "Prenom du client";
		else
			return null;
	}

	@Override
	public int getRowCount() {
		return getClients().size();
	}

	@Override
	public Object getValueAt(int line, int column) {

		Client client = getClients().get(line);

		if (column == 0)
			return client.getNom();
		if (column == 1)
			return client.getPrenom();
		else
			return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	private List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
