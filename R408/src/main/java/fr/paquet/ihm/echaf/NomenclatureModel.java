package fr.paquet.ihm.echaf;

import java.util.Collection;
import java.util.Collections;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.echafaudage.Echafaudage;
import fr.paquet.echafaudage.ElementEchaf;
import fr.paquet.echafaudage.TypeElement;

public class NomenclatureModel implements TableModel {
	
	private Echafaudage echaf=null;
	
	private Echafaudage getEchaf() {
		return echaf;
	}

	private void setEchaf(Echafaudage echaf) {
		this.echaf = echaf;
	}

	public NomenclatureModel(Echafaudage echaf) {
		super();
		setEchaf(echaf);
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return Collections.list(getEchaf().getDistinctElements()).size();
	}


	@Override
	public Class<?> getColumnClass(int column) {
		if(column==0)
			return ElementEchaf.class;
		else
			return Integer.class;
	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {
	}


	@Override
	public String getColumnName(int column) {
		if(column==0)
			return "type d'element";
		else
			return "nombre";
	}

	@Override
	public Object getValueAt(int line, int column) {
		TypeElement element=Collections.list(getEchaf().getDistinctElements()).get(line);
		if(column==0)
			return element;
		else
			return getEchaf().getElementCount(element);
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
