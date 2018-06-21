package fr.paquet.ihm.explorer;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.projet.Client;
import fr.paquet.projet.Projet;
import fr.paquet.projet.Responsable;

public class GestionnaireModel implements TableModel {

	private List<Projet> projets = null;

	private void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	private List<Projet> getProjets() {
		return projets;
	}

	public GestionnaireModel(List<Projet> projets) {
		super();
		setProjets(projets);

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO

	}

	@Override
	public Class<?> getColumnClass(int column) {

		if (column == 0)
			return Projet.class;
		if (column == 1)
			return Client.class;
		if (column == 2)
			return Responsable.class;
		else
			return null;
	}

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0)
			return "Titre du projet";
		if (columnIndex == 1)
			return "Client";
		if (columnIndex == 2)
			return "Responsable";
		else
			return null;
	}

	@Override
	public int getRowCount() {

		return getProjets().size();
	}

	@Override
	public Object getValueAt(int line, int column) {

		Projet projet = getProjets().get(line);
		if (column == 0)
			return projet;
		if (column == 1)
			return projet.getClient();
		if (column == 2)
			return projet.getResp();
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

}
