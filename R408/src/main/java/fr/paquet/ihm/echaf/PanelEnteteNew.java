package fr.paquet.ihm.echaf;

import java.awt.Dimension;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelEnteteNew extends JPanel implements FocusListener {

	private ArrayList<JTextField> saisis = null;

	public PanelEnteteNew() {

		setPreferredSize(new Dimension(1900, 1200));

		for (EnteteCritere ent : EnumSet.allOf(EnteteCritere.class)) {

			// affichage du label et du textField
			add(ent.getLabel(), ent.getLayout());
			add(ent.getSaisi(), ent.getLayout());

			// ajout du listener
			JTextField entField = ent.getSaisi();
			entField.addFocusListener(this);

			// remplissage de la liste des saisis
			addSaisis(entField);

		}

	}

	private void addSaisis(JTextField saisi) {
		getSaisis().add(saisi);
	}

	/**
	 * 
	 * @return La liste des saisis sans espace a droite et a gauche<br/>
	 */
	public ArrayList<JTextField> getSaisis() {
		if (saisis == null)
			saisis = new ArrayList<JTextField>();
		return saisis;
	}

	/**
	 * 
	 * @return null<br/>
	 *         si le premier element de la liste "saisis" est egale a ""<br/>
	 * @return le nom du projet sans espace a droite et a gauche<br/>
	 */
	public String getTitre() {
		if (getSaisis().get(0).getText().equals(""))
			return null;
		return getSaisis().get(0).getText().trim();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		System.out.println("coucou");

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		JTextField textField = (JTextField) arg0.getSource();
		String nameTextField = textField.getName();
		EnteteCritere ent = EnteteCritere.getEnteteCritere(nameTextField);
		ent.actionPerf();

	}

}
