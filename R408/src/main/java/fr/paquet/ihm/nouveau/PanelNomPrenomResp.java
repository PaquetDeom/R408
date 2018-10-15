package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.projet.Responsable;
import fr.paquet.projet.ResponsableFactory;

public class PanelNomPrenomResp extends PanelNomPrenom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Responsable> resps = null;
	private Responsable responsable = null;

	public PanelNomPrenomResp(JDialogNouveau jDN) {
		super(jDN);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				"Responsable du projet"));

		// setteurs
		setjTextFieldNom(new JTextField(20));
		setjTextFieldPrenom(new JTextField(20));
		setButtonCreer(new JButton("Creer"));
		setButtonOk(new JButton("Ok"));
		setButtonCancel(new JButton("Annuler"));

		// ajout des components au panel.
		getPanelSaisi().add(new JLabel("Nom : "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(new JLabel("Prenom : "), new GridBagConstraints(0, 1, 1, 1, 0, 0,
				GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(getjTextFieldNom(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		getPanelSaisi().add(getjTextFieldPrenom(), new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		getPanelButtonGauche().add(getButtonCreer(), BorderLayout.CENTER);
		getPanelButtonGauche().add(getButtonCancel(), BorderLayout.EAST);

		getPanelButtonDroite().add(getButtonOk(), BorderLayout.EAST);

	}

	@Override
	public void setTable(JTable table) {

		// donne le type de sélection
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();

		// ajout d'un listener
		rowSM.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				DefaultListSelectionModel dLSM = (DefaultListSelectionModel) e.getSource();
				int i = dLSM.getMinSelectionIndex();

				try {
					setResponsable(getResps().get(i));
					getjTextFieldNom().setText(getResps().get(i).getNom());
					getjTextFieldPrenom().setText(getResps().get(i).getPrenom());
					frizeSaisi();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		this.table = table;

	}

	@Override
	public void setjTextFieldNom(JTextField jTextFieldNom) {

		jTextFieldNom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				ResponsableFactory rF = new ResponsableFactory();
				List<Responsable> resps = rF.findResponsablesByName(jTextFieldNom.getText());

				if (resps != null && resps.isEmpty()) {
					setResps(resps);
					setTableModel(new ResponsableModel(getResps()));
					setTable(new JTable(getTableModel()));
					getPanelTable().add(getTable());
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldNom.setText("");

			}
		});

		this.jTextFieldNom = jTextFieldNom;

	}

	@Override
	public void setjTextFieldPrenom(JTextField jTextFieldPrenom) {

		jTextFieldPrenom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldPrenom.setText("");

			}
		});

		this.jTextFieldPrenom = jTextFieldPrenom;

	}

	@Override
	public void setTableModel(TableModel tM) {

		this.tableModel = tM;
	}

	@Override
	public void setButtonCreer(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setResponsable(
						new Responsable(getjTextFieldNom().getText().toUpperCase(), getjTextFieldPrenom().getText()));

				if (getResponsable() != null) {
					frizeSaisi();
					ResponsableFactory Rf = new ResponsableFactory();
					try {
						Rf.saveResponsable(getResponsable());
					} catch (Exception e1) {
						e1.printStackTrace(System.out);
						new AlertWindow(AlertType.ERREUR, "Le responsable n'a pas été sauvé");
					}
				}
			}
		});

		this.buttonCreer = button;

	}

	@Override
	public void setButtonOk(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getResponsable() != null) {
					getjDialogNouveau().getProjet().setResp(getResponsable());
					frizeSaisi();
				} else {
					new AlertWindow(AlertType.ERREUR, "Veuillez saisir un responsable");
				}

			}
		});

		this.buttonOk = button;

	}

	private void frizeSaisi() {
		getjTextFieldNom().setEnabled(false);
		getjTextFieldPrenom().setEnabled(false);
		getTable().setEnabled(false);
	}

	private void desFrizeSaisi() {
		getjTextFieldNom().setEnabled(true);
		getjTextFieldPrenom().setEnabled(true);
		getTable().setEnabled(true);
	}

	@Override
	public void setButtonCancel(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setResponsable(null);
				getjDialogNouveau().getProjet().setResp(null);
				desFrizeSaisi();
				PanelNomPrenomResp.this.repaint();
			}
		});
		this.buttonCancel = button;
	}

	private List<Responsable> getResps() {
		return resps;
	}

	private void setResps(List<Responsable> resps) {
		this.resps = resps;
	}

	private Responsable getResponsable() {
		return responsable;
	}

	@SuppressWarnings("unlikely-arg-type")
	private void setResponsable(Responsable responsable) {

		if ((getjTextFieldNom() != null && !getjTextFieldNom().equals(""))
				&& (getjTextFieldPrenom() != null && !getjTextFieldPrenom().equals("")))
			this.responsable = responsable;
		else
			this.responsable = null;
	}

}
