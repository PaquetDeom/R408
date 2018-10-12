package fr.paquet.ihm.eltByName;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.InstanciationElement;

public class MotsClesModel implements TableModel {

	private MotsCles dialogParent = null;

	private MotsCles getDialogParent() {
		return dialogParent;
	}

	private void setDialogParent(MotsCles dialogParent) {
		this.dialogParent = dialogParent;
	}

	public MotsClesModel(MotsCles dialogParent) {
		super();

		// set
		setDialogParent(dialogParent);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int column) {
		if (column == 0)
			return EltByName.class;
		if (column == 1)
			return InstanciationElement.class;
		return null;
	}

	@Override
	public int getColumnCount() {

		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0)
			return "Nom";
		if (columnIndex == 1)
			return "Type d'élément";
		else
			return null;
	}

	@Override
	public int getRowCount() {

		return getDialogParent().getElts().size();
	}

	@Override
	public Object getValueAt(int line, int column) {

		EltByName elt = getDialogParent().getElts().get(line);

		if (column == 0)
			return elt.getName();
		if (column == 1)
			return elt.getIntanc();
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
