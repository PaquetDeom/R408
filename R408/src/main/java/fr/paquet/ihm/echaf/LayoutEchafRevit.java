package fr.paquet.ihm.echaf;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutEchafRevit extends FlowLayout {

	private JTextField titreField = null;

	public LayoutEchafRevit() {

		super(FlowLayout.CENTER);
		addLayoutComponent("Titre", getTitreField());

	}

	private JTextField getTitreField() {
		if (titreField == null) {
			titreField = new JTextField();
			titreField.setText("Veuillez saisir le titre du document");
		}
		return titreField;
	}

	/**
	 * 
	 * @return le nom du projet<br/>
	 */
	public String getTitre() {
		if (getTitreField() == null)
			return null;
		return getTitreField().getText();
	}

}
