package fr.paquet.ihm.nouveau;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.projet.Responsable;

public class ResponsableModel implements TableModel {

	private List<Responsable> responsables = null;

	public ResponsableModel(List<Responsable> responsables) {
		super();
		setResponsables(responsables);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0)
			return Responsable.class;
		if (columnIndex == 1)
			return Responsable.class;
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
			return "Nom du responsable";
		if (columnIndex == 1)
			return "Prenom du responsable";
		else
			return null;
	}

	@Override
	public int getRowCount() {
		return getResponsables().size();
	}

	@Override
	public Object getValueAt(int line, int column) {

		Responsable resp = getResponsables().get(line);

		if (column == 0)
			return resp.getNom();
		if (column == 1)
			return resp.getPrenom();
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

	private List<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(List<Responsable> responsables) {
		this.responsables = responsables;
	}

}
