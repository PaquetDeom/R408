package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

public class AddLineJLabelJTextField {

	private String titre = null;
	private JTextField textField = null;

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
	public AddLineJLabelJTextField(JPanel panel, String titre, String textLabel, int taille, int gridx, int gridy,
			int gridwidth, int gridheiht, long weithx, long weithy, int fill) {

		super();

		setTitre(titre);
		setJTextField(new JTextField(taille));
		this.textField.setName(getTitre());

		panel.add(new JLabel(textLabel), new GridBagConstraints(gridx, gridy, gridwidth, gridheiht, 0, 0,
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

}
