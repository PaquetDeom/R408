package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import fr.paquet.projet.RespFactory;
import fr.paquet.projet.Responsable;

public class PanelNomPrenomResp extends PanelNomPrenom {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Responsable> resps = null;

	public PanelNomPrenomResp(JDialogNouveau jDN) {
		super(jDN);

		// setteurs
		setTableModel(new ResponsableModel());
		setTable(new JTable(getTableModel()));
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

		getPanelTable().add(getTable());

		getPanelButtonDroite().add(getButtonOk(), BorderLayout.EAST);

	}

	@Override
	public void setTable(JTable table) {
		this.table = table;

	}

	@Override
	public void setjTextFieldNom(JTextField jTextFieldNom) {

		jTextFieldNom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				RespFactory rF = new RespFactory();
				setResps(rF.findResponsablesByName(jTextFieldNom.getText()));

				ResponsableModel rM = (ResponsableModel) PanelNomPrenomResp.this.getTableModel();
				rM.setResponsables(getResps());
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
				// TODO Auto-generated method stub

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
				// TODO Auto-generated method stub

			}
		});

		this.buttonCreer = button;

	}

	@Override
	public void setButtonOk(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.buttonOk = button;

	}

	@Override
	public void setButtonCancel(JButton button) {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

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
