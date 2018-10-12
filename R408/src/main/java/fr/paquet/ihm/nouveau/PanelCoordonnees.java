package fr.paquet.ihm.nouveau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.ihm.echaf.AddLineJLabelJTextField;

public class PanelCoordonnees extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private List<JTextField> coordonneesField = null;

	public PanelCoordonnees() {
		super();

	}

	/**
	 * methode qui construit le panel<br/>
	 */
	protected void buildPanel() {
		// effacer tous les components
		removeAll();

		// ajout d'un Layout.
		setLayout(new GridBagLayout());

		// ajout des Component au panel cordonneesPanel.
		AddLineJLabelJTextField lc1 = new AddLineJLabelJTextField(PanelCoordonnees.this, "ADRESSE1", "Lieu dit", 20, 0,
				0, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc2 = new AddLineJLabelJTextField(PanelCoordonnees.this, "ADRESSE2", "N°", 5, 0, 1, 1,
				1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc3 = new AddLineJLabelJTextField(PanelCoordonnees.this, "ADRESSE3", "Nom de la rue",
				20, 0, 2, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc4 = new AddLineJLabelJTextField(PanelCoordonnees.this, "CODEPOSTAL", "Code Postal", 8,
				0, 3, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc5 = new AddLineJLabelJTextField(PanelCoordonnees.this, "COMMUNE", "Ville", 20, 0, 4,
				1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc6 = new AddLineJLabelJTextField(PanelCoordonnees.this, "MAIL", "Adresse mail", 20, 0,
				5, 1, 1, 0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lc7 = new AddLineJLabelJTextField(PanelCoordonnees.this, "TEL", "N° de telephone", 20,
				0, 6, 1, 1, 0, 0, GridBagConstraints.NONE);
		
		addCoordonneesField(lc1.getTextField());
		addCoordonneesField(lc2.getTextField());
		addCoordonneesField(lc3.getTextField());
		addCoordonneesField(lc4.getTextField());
		addCoordonneesField(lc5.getTextField());
		addCoordonneesField(lc6.getTextField());
		addCoordonneesField(lc7.getTextField());

	}
	
	private void addCoordonneesField(JTextField tF) {
		getCoordonnesField().add(tF);
	}
	
	/**
	 * 
	 * @return La liste des cordonneesField qui forment une adresse<br/>
	 */
	protected List<JTextField> getCoordonnesField(){
		if(coordonneesField == null)
			coordonneesField = new ArrayList<JTextField>();
		return coordonneesField;
	}

}
