package fr.paquet.ihm.explorer;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import fr.paquet.ihm.echaf.FileChooser;

public class Gestionnaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton buttonImport = null;
	private JButton buttonExport = null;
	private JButton buttonOuvrir = null;
	private JButton buttonDelete = null;

	public Gestionnaire() {

		super("Gestionnaire de projets");
		setAlwaysOnTop(false);
		setSize(900, 600);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 8;
		gbc_table.gridwidth = 12;
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		getContentPane().add(table, gbc_table);

		GridBagConstraints gbc_btnImport = new GridBagConstraints();
		gbc_btnImport.insets = new Insets(5, 0, 5, 0);
		gbc_btnImport.gridx = 12;
		gbc_btnImport.gridy = 2;
		getContentPane().add(getButtonImport(), gbc_btnImport);

		getButtonExport().setEnabled(false);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 12;
		gbc_btnExport.gridy = 3;
		getContentPane().add(getButtonExport(), gbc_btnExport);

		GridBagConstraints gbc_btnOuvrir = new GridBagConstraints();
		gbc_btnOuvrir.insets = new Insets(10, 0, 5, 0);
		gbc_btnOuvrir.gridx = 12;
		gbc_btnOuvrir.gridy = 5;
		getContentPane().add(getButtonOuvrir(), gbc_btnOuvrir);

		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 12;
		gbc_btnSupprimer.gridy = 6;
		getContentPane().add(getButtonDelete(), gbc_btnSupprimer);

	}

	private JButton getButtonImport() {
		if (buttonImport == null)
			buttonImport = new JButton("Import");

		buttonImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FileChooser();

			}
		});

		return buttonImport;
	}

	private JButton getButtonDelete() {
		if (buttonDelete == null)
			buttonDelete = new JButton("Supprimer");

		buttonDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});

		return buttonDelete;
	}

	private JButton getButtonExport() {
		if (buttonExport == null)
			buttonExport = new JButton("Export");

		buttonExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});

		return buttonExport;
	}

	private JButton getButtonOuvrir() {
		if (buttonOuvrir == null)
			buttonOuvrir = new JButton("Ouvrir");

		buttonOuvrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO

			}
		});

		return buttonOuvrir;
	}

}
