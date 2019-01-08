package fr.paquet.ihm.nouveau;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class JLabelJTextField implements ActionListener, SelectListener {

	private String titre = null;
	private JTextField textField = null;
	private Class<JSearchDialog> dialogClass = null;

	public JLabelJTextField(JPanel panel, String textLabel, int gridx, int gridy) {
		this(panel, textLabel, gridx, gridy, (Class<JSearchDialog>) null);
	}

	public JLabelJTextField(JPanel panel, String textLabel, int gridx, int gridy, Class dialogClass) {

		panel.add(new JLabel(textLabel), new GridBagConstraints(gridx * 3, gridy, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		textField = new JTextField();
		((AbstractDocument)textField.getDocument()).setDocumentFilter(new UppercaseDocumentFilter());
		if (dialogClass == null)
			panel.add(textField, new GridBagConstraints(gridx * 3 + 1, gridy, 2, 1, 1.0, 0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		else {
			this.dialogClass = dialogClass;
			panel.add(textField, new GridBagConstraints(gridx * 3 + 1, gridy, 1, 1, 1.0, 0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			panel.add(getButtonPanel(), new GridBagConstraints(gridx * 3 + 2, gridy, 1, 1, 0, 0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		}

	}

	private Component getButtonPanel() {
		JPanel btnPanel = new JPanel(new GridLayout(1, 1));
		JButton btnSearch = new JButton("cherche");
		btnSearch.addActionListener(this);
		btnPanel.add(btnSearch);
		return btnPanel;
	}

	JSearchDialog dialog = null;

	private void setDialog(JSearchDialog dialog) {
		this.dialog = dialog;
	}

	public JSearchDialog getDialog() {
		return dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Constructor<JSearchDialog> ctor;
		try {
			ctor = dialogClass.getConstructor(String.class);
			setDialog(ctor.newInstance(new Object[] { getText() }));
			dialog.addSelectListener(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getText() {
		return textField.getText();
	}

	/**
	 * Constructeur de class<br/>
	 * 
	 * @param panel
	 *            type JPanel
	 * @param titre
	 *            type String
	 * @param textLabel
	 *            type String
	 * @param taille
	 *            type int
	 * @param gridx
	 *            type int
	 * @param gridy
	 *            type int
	 * @param gridwidth
	 *            type int
	 * @param gridheiht
	 *            type int
	 * @param weithx
	 *            type long
	 * @param weithy
	 *            type long
	 * @param fill
	 *            type int
	 */
	public JLabelJTextField(JPanel panel, String titre, String textLabel, int taille, int gridx, int gridy,
			int gridwidth, int gridheiht, long weithx, long weithy, int fill) {

		super();

		setTitre(titre);
		setJTextField(new JTextField(taille));
		this.textField.setName(getTitre());

		panel.add(new JLabel(textLabel + " : "), new GridBagConstraints(gridx, gridy, gridwidth, gridheiht, 0, 0,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		if (taille != 0)
			panel.add(getTextField(), new GridBagConstraints(gridx + 1, gridy, gridwidth, gridheiht, 1, 0,
					GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	private void setJTextField(JTextField textField2) {
		this.textField = textField2;

	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * 
	 * @return le nom du JLabel et du JTxteField<br/>
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * 
	 * @return Le JTextField<br/>
	 */
	public JTextField getTextField() {
		return textField;
	}

	public void setText(String text) {
		textField.setText(text);

	}
	
	private Object objet = null;
	
	private void setObject(Object objet) {
		this.objet=objet;
	}
	
	public Object getObjet() {
		return objet;
	}
	

	@Override
	public void objectSelected(PropertyChangeEvent event) {
		setObject(event.getNewValue());
		setText(event.getNewValue().toString());
		((JSearchDialog) event.getSource()).removeSelectListener(this);
	}

}
