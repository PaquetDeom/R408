package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public abstract class PanelNomPrenom extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogNouveau jDialogNouveau = null;
	protected JTextField jTextFieldNom = null;
	protected JTextField jTextFieldPrenom = null;
	protected JButton buttonCreer = null;
	protected JButton buttonOk = null;
	protected JButton buttonCancel = null;
	protected JTable table = null;
	protected TableModel tableModel = null;
	private JPanel panelDroite = null;
	private JPanel panelGauche = null;
	private JPanel panelSaisi = null;
	private JPanel panelButtonDroite = null;
	private JPanel panelButtonGauche = null;
	private JPanel panelTable = null;

	protected PanelNomPrenom(JDialogNouveau jDN) {
		super();

		// setteur
		setjDialogNouveau(jDN);
		setPanelDroite(new JPanel());
		setPanelGauche(new JPanel());
		setPanelSaisi(new JPanel());
		setPanelButtonDroite(new JPanel());
		setPanelButtonGauche(new JPanel());
		setPanelTable(new JPanel());

		getPanelButtonDroite().setLayout(new BorderLayout());
		getPanelButtonGauche().setLayout(new BorderLayout());
		getPanelDroite().setLayout(new GridBagLayout());
		getPanelGauche().setLayout(new GridBagLayout());
		getPanelSaisi().setLayout(new GridBagLayout());
		getPanelTable().setLayout(new GridBagLayout());

		// ajout du layout
		setLayout(new GridBagLayout());

		// traitement des panels
		getPanelGauche().add(getPanelSaisi(), new GridBagConstraints(0, 0, 1, 1, 1, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getPanelGauche().add(getPanelButtonGauche(), new GridBagConstraints(0, 1, 1, 1, 1, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		getPanelDroite().add(getPanelTable(), new GridBagConstraints(0, 0, 1, 1, 1, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		getPanelDroite().add(getPanelButtonDroite(), new GridBagConstraints(0, 1, 1, 1, 1, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		// ajout des panels au panel pricipal
		add(getPanelGauche(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));
		add(getPanelDroite(), new GridBagConstraints(1, 0, 1, 1, 1, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 5, 5));

	}

	public abstract void setTable(JTable table);

	public abstract void setjTextFieldNom(JTextField jTextFieldNom);

	public abstract void setjTextFieldPrenom(JTextField jTextFieldPrenom);

	public abstract void setTableModel(TableModel tM);

	public abstract void setButtonCreer(JButton button);

	public abstract void setButtonOk(JButton button);

	public abstract void setButtonCancel(JButton button);

	protected JTable getTable() {
		return table;
	}

	protected TableModel getTableModel() {
		return tableModel;
	}

	protected JTextField getjTextFieldNom() {
		return jTextFieldNom;
	}

	protected JTextField getjTextFieldPrenom() {
		return jTextFieldPrenom;
	}

	protected JButton getButtonCreer() {
		return buttonCreer;
	}

	protected JButton getButtonOk() {
		return buttonOk;
	}

	protected JButton getButtonCancel() {
		return buttonCancel;
	}

	protected JPanel getPanelDroite() {
		return panelDroite;
	}

	private void setPanelDroite(JPanel panelDroite) {
		this.panelDroite = panelDroite;
	}

	protected JPanel getPanelGauche() {
		return panelGauche;
	}

	private void setPanelGauche(JPanel panelGauche) {
		this.panelGauche = panelGauche;
	}

	protected JPanel getPanelSaisi() {
		return panelSaisi;
	}

	private void setPanelSaisi(JPanel panelSaisi) {
		this.panelSaisi = panelSaisi;
	}

	protected JPanel getPanelButtonDroite() {
		return panelButtonDroite;
	}

	public void setPanelButtonDroite(JPanel panelButtonDroite) {
		this.panelButtonDroite = panelButtonDroite;
	}

	protected JPanel getPanelButtonGauche() {
		return panelButtonGauche;
	}

	private void setPanelButtonGauche(JPanel panelButtonGauche) {
		this.panelButtonGauche = panelButtonGauche;
	}

	protected JPanel getPanelTable() {
		return panelTable;
	}

	protected void setPanelTable(JPanel panelTable) {
		this.panelTable = panelTable;
	}

	protected JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

}
