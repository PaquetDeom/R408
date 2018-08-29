package fr.paquet.ihm.explorer;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.echaf.FileChooser;
import fr.paquet.io.xml.importxml.ProjetIntegration;
import fr.paquet.projet.Projet;
import fr.paquet.projet.ProjetFactory;

public class Gestionnaire extends JFrame implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableProjets = null;
	private List<Projet> projets = null;
	private Projet projetselected = null;
	private JButton buttonImport = null;
	private JButton buttonExport = null;
	private JButton buttonOuvrir = null;
	private JButton buttonDelete = null;

	private List<Projet> getProjets() throws Exception {
		projets = new ProjetFactory().findAllProjets();
		return projets;
	}

	private void setTableProjets(JTable table) throws Exception {

		table.setModel(new GestionnaireModel(getProjets()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				DefaultListSelectionModel dLSM = (DefaultListSelectionModel) e.getSource();
				int i = dLSM.getMinSelectionIndex();

				try {

					setProjetSelected(getProjets().get(i));
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		this.tableProjets = table;
	}

	private void setProjetSelected(Projet projet) {
		this.projetselected = projet;
	}

	private Projet getProjetSelected() {
		return projetselected;
	}

	private JTable getTableProjets() throws Exception {

		return tableProjets;
	}

	public Gestionnaire() {

		super("Gestionnaire de projets");

		try {

			// creation de la fenêtre
			setAlwaysOnTop(false);
			setSize(900, 600);

			// creation du layout

			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
					0.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
					Double.MIN_VALUE };

			// ajout du layout au panel
			getContentPane().setLayout(gridBagLayout);

			// creation du constraint
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.gridheight = 8;
			gbc_table.gridwidth = 12;
			gbc_table.insets = new Insets(5, 5, 5, 5);
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.gridx = 0;
			gbc_table.gridy = 1;

			// ajout du button import
			GridBagConstraints gbc_btnImport = new GridBagConstraints();
			gbc_btnImport.insets = new Insets(5, 0, 5, 0);
			gbc_btnImport.gridx = 12;
			gbc_btnImport.gridy = 2;
			getContentPane().add(getButtonImport(), gbc_btnImport);

			// ajout du button export
			getButtonExport().setEnabled(false);
			GridBagConstraints gbc_btnExport = new GridBagConstraints();
			gbc_btnExport.insets = new Insets(0, 0, 5, 0);
			gbc_btnExport.gridx = 12;
			gbc_btnExport.gridy = 3;
			getContentPane().add(getButtonExport(), gbc_btnExport);

			// ajout du button ouvrir
			GridBagConstraints gbc_btnOuvrir = new GridBagConstraints();
			gbc_btnOuvrir.insets = new Insets(10, 0, 5, 0);
			gbc_btnOuvrir.gridx = 12;
			gbc_btnOuvrir.gridy = 5;
			getContentPane().add(getButtonOuvrir(), gbc_btnOuvrir);

			// ajout du button delete
			GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
			gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
			gbc_btnSupprimer.gridx = 12;
			gbc_btnSupprimer.gridy = 6;
			getContentPane().add(getButtonDelete(), gbc_btnSupprimer);

			// creation de la table
			setTableProjets(new JTable());

			// ajout de la JTable au Jpanel
			getContentPane().add(getTableProjets(), gbc_table);

		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, e.getMessage());
			e.printStackTrace(System.out);
		}

	}

	private JButton getButtonImport() {
		if (buttonImport == null)
			buttonImport = new JButton("Import");

		buttonImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileChooser fc = new FileChooser();
				ProjetIntegration projetInt = null;

				if (fc.getFile() != null) {
					projetInt = new ProjetIntegration(fc.getFile());
					try {
						projetInt.integre();
					} catch (Exception e1) {

						e1.printStackTrace(System.out);
						new AlertWindow(AlertType.ERREUR, "Projet non integrer");
					}
				}
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

				if (getProjetSelected() != null) {

					new AlertWindow(AlertType.QUESTION, "Etes vous sûre de vouloir supprimer le projet",
							Gestionnaire.this);

				}

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
				try {
					XMLEncoder encoder = new XMLEncoder(new FileOutputStream("toto.xml"));
					try {
						// serialisation de l'objet
						encoder.writeObject(getProjetSelected());
						encoder.flush();
					} finally {
						// fermeture de l'encodeur
						encoder.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
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

	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui")) {
			new ProjetFactory().removeProjet(getProjetSelected());
			setProjetSelected(null);
			Gestionnaire.this.dispose();
			try {
				new Gestionnaire();
				setVisible(true);

			} catch (Exception e) {
				e.printStackTrace(System.out);
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}
			Gestionnaire.this.repaint();
		}

	}

}
