package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;


public class AddLineJCheckBox {

	private String titre = null;
	private JCheckBox box = null;

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
	public AddLineJCheckBox(JPanel panel, JCheckBox box, int gridx, int gridy,
			int gridwidth, int gridheiht, long weithx, long weithy, int fill) {

		super();

		setTitre(titre);
		setBox(box);

		panel.add(getBox(), new GridBagConstraints(gridx, gridy, gridwidth, gridheiht, weithx, weithy,
				GridBagConstraints.FIRST_LINE_END, fill, new Insets(0, 0, 0, 0), 0, 0));

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



	public JCheckBox getBox() {
		return box;
	}



	public void setBox(JCheckBox box) {
		this.box = box;
	}

	
}
