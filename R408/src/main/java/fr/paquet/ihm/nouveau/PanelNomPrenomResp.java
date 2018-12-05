package fr.paquet.ihm.nouveau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
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

	public PanelNomPrenomResp(JDialogNouveau jDN) {
		super(jDN);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				"Responsable du projet"));

		// setteurs
		setButtonCreer(new JButton("Creer"));
		setjTextFieldNom(new JTextField(20));
		setjTextFieldPrenom(new JTextField(20));
		setButtonOk(new JButton("Ok"));
		setButtonCancel(new JButton("Annuler"));

		buildPanel();

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
					getjTextFieldNom().setText(getResps().get(i).getNom());
					getjTextFieldPrenom().setText(getResps().get(i).getPrenom());
					frizeSaisi();
					getButtonCreer().setEnabled(false);
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

				if (resps != null && !resps.isEmpty()) {
					setResps(resps);
					setTableModel(new ResponsableModel(getResps()));
					setTable(new JTable(getTableModel()));
					getPanelTable().add(getTable());

				}
				getButtonCreer().setEnabled(isClickable());
				PanelNomPrenomResp.this.repaint();
			}

			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldNom.setText("");
				getButtonCreer().setEnabled(isClickable());

			}

		});

		getButtonCreer().setEnabled(isClickable());
		this.jTextFieldNom = jTextFieldNom;

	}

	@Override
	public void setjTextFieldPrenom(JTextField jTextFieldPrenom) {

		jTextFieldPrenom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				getButtonCreer().setEnabled(isClickable());

			}

			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldPrenom.setText("");
				getButtonCreer().setEnabled(isClickable());

			}
		});

		this.jTextFieldPrenom = jTextFieldPrenom;

	}

	@Override
	public void setTableModel(TableModel tM) {

		this.tableModel = tM;
	}

	private boolean isClickable() {

		if (getTable() == null) {
			if (getjTextFieldNom() == null || getjTextFieldPrenom() == null || getjTextFieldNom().getText().equals("")
					|| getjTextFieldPrenom().getText().equals(""))
				return false;
			else
				return true;
		} else
			return false;
	}

	@Override
	public void setButtonCreer(JButton button) {

		button.setEnabled(isClickable());

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Responsable resp = new Responsable(getjTextFieldNom().getText().toUpperCase(),
						getjTextFieldPrenom().getText());

				if (resp != null) {
					frizeSaisi();
					ResponsableFactory Rf = new ResponsableFactory();
					try {
						Rf.saveResponsable(resp);
						getjDialogNouveau().getProjet().setResp(
								new Responsable(getjTextFieldNom().getText(), getjTextFieldPrenom().getText()));
						new AlertWindow(AlertType.INFORMATION, "Le responsable a bien été sauvé");
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

				if (!getjTextFieldNom().getText().equals("") && !getjTextFieldPrenom().getText().equals("")) {
					getjDialogNouveau().getProjet()
							.setResp(new Responsable(getjTextFieldNom().getText(), getjTextFieldPrenom().getText()));
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
		if (getTable() != null)
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

}
