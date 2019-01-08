package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.paquet.ihm.main.MainFrame;

public abstract class JSearchDialog extends JDialog implements ActionListener, SelectListener {

	JPanel searchPanel = new JPanel(new GridBagLayout());
	private static final long serialVersionUID = 1L;

	public abstract Object getListValue(Object object, int columnIndex);

	public abstract List getValues();

	public abstract String[] getColumnsName();

	public abstract Class[] getColumnsClass();

	private class InnerTableModel extends AbstractTableModel {
		List list = null;
		String[] columnName = null;
		Class[] columnClass = null;

		public InnerTableModel(List list, String[] columnName, Class[] columnClass) {
			this.list = list;
			this.columnName = columnName;
			this.columnClass = columnClass;
		}

		@Override
		public int getRowCount() {
			return (list != null) ? list.size() : 0;
		}

		@Override
		public int getColumnCount() {
			return columnName.length;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columnName[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return columnClass[columnIndex];
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		public Object getObject(int i) {
			return list.get(i);
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return getListValue(getObject(rowIndex), columnIndex);
		}

		public void setValues(List values) {
			list = values;
			fireTableDataChanged();
		}
	}

	public JSearchDialog() {
		super(MainFrame.getUniqInstance());
		setAlwaysOnTop(true);
		JPanel panel = new JPanel(new BorderLayout());
		setContentPane(panel);
		panel.add(getSearchPanel(), BorderLayout.NORTH);
		panel.add(new JScrollPane(getListPanel()), BorderLayout.CENTER);
		panel.add(getButtonPanel(), BorderLayout.SOUTH);
		setSize(600, 500);
		setVisible(true);
	}

	protected JPanel getPanelCritere() {
		return searchPanel;
	}

	private Component getSearchPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JButton btnSearch = new JButton("Chercher");
		btnSearch.addActionListener(this);
		panel.add(getPanelCritere(), BorderLayout.CENTER);
		panel.add(btnSearch, BorderLayout.EAST);
		return panel;
	}

	InnerTableModel tableModel = null;

	public InnerTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(InnerTableModel tableModel) {
		this.tableModel = tableModel;
	}

	JTable table = null;

	private Component getListPanel() {
		if (table == null) {
			setTableModel(new InnerTableModel(getValues(), getColumnsName(), getColumnsClass()));
			table = new JTable(getTableModel());
			table.setSize(600, 500);
		}
		return table;
	}

	private Component getButtonPanel() {
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Annuler");
		JButton btnNew = new JButton("Créer");
		JButton btnModif = new JButton("Modifier");
		JPanel btnPanel = new JPanel(new GridLayout());

		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		btnModif.addActionListener(this);
		btnNew.addActionListener(this);

		btnPanel.add(btnNew);
		btnPanel.add(btnModif);
		btnPanel.add(btnOk);
		btnPanel.add(btnCancel);
		JPanel allPanel = new JPanel(new BorderLayout());
		allPanel.add(btnPanel, BorderLayout.EAST);
		return allPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Chercher")) {
			doSearchAction();
		} else if (e.getActionCommand().equals("Créer")) {
			showMaintenanceDialog(null);
			doSearchAction();
		} else if (e.getActionCommand().equals("Modifier")) {
			if (table.getSelectedRows().length != 0) {
				showMaintenanceDialog(getTableModel().getObject(table.getSelectedRows()[0]));
				doSearchAction();
			} else {
				// TODO : message d'erreur=>Veuillez selectionner une ligne dans la table
			}
		} else if (e.getActionCommand().equals("Ok")) {
			if (table.getSelectedRows().length != 0) {
				fireSelectedEvent(getValues().get(table.getSelectedRows()[0]));
				this.setVisible(false);
				this.dispose();
			} else {
				// TODO : message d'erreur=>Veuillez selectionner une ligne dans la table
			}
		} else if (e.getActionCommand().equals("Annuler")) {
			this.setVisible(false);
			this.dispose();
		}
	}

	protected void doSearchAction() {
		getTableModel().setValues(getValues());
		getListPanel().repaint();
	}

	private void showMaintenanceDialog(Object object) {
		Constructor<JModifyDialog> ctor;
		try {
			ctor = getDialogClass().getConstructor(Object.class);
			JModifyDialog dialog = ctor.newInstance(new Object[] { object });
			dialog.pack();
			dialog.setVisible(true);
			dialog.addSelectListener(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected abstract Class getDialogClass();

	private ArrayList<SelectListener> selectListeners = new ArrayList<SelectListener>();

	public void addSelectListener(SelectListener listener) {
		selectListeners.add(listener);
	}

	public void removeSelectListener(SelectListener listener) {
		selectListeners.remove(listener);
	}

	private void fireSelectedEvent(Object o) {
		for (int i = 0; i < selectListeners.size(); i++) {
			SelectListener sl = selectListeners.get(i);
			sl.objectSelected(new PropertyChangeEvent(this, o.getClass().toString(), null, o));
		}
	}

	public void objectSelected(PropertyChangeEvent o) {
		if (o != null)
			doSearchAction();
	}

}
