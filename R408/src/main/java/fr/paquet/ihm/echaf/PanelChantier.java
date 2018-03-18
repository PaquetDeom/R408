package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Hashtable;

import javax.swing.*;

public class PanelChantier extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private Hashtable<String, JTextField> textFields = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelChantier(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);

		setLayout(new GridBagLayout());

		add(new JLabel("Données du chantier"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		GridBagConstraints c = new GridBagConstraints();
		JButton button = new JButton("L'adresse du chantier est différente de l'adresse client");

		c.weightx = 0.0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(button, c);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AddLineJLabelJTextField lc1 = new AddLineJLabelJTextField(PanelChantier.this, "ADRESSE1", "Lieu dit",
						20, 0, 2, 1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc2 = new AddLineJLabelJTextField(PanelChantier.this, "ADRESSE2", "N°", 5, 0, 3,
						1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc3 = new AddLineJLabelJTextField(PanelChantier.this, "ADRESSE3",
						"Nom de la rue", 20, 0, 4, 1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc4 = new AddLineJLabelJTextField(PanelChantier.this, "CODEPOSTAL",
						"Code Postal", 8, 0, 5, 1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc5 = new AddLineJLabelJTextField(PanelChantier.this, "COMMUNE", "Ville", 20, 0,
						6, 1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc6 = new AddLineJLabelJTextField(PanelChantier.this, "MAIL", "Adresse mail",
						20, 0, 7, 1, 1, 0, 0, GridBagConstraints.NONE);
				AddLineJLabelJTextField lc7 = new AddLineJLabelJTextField(PanelChantier.this, "TEL", "N° de telephone",
						20, 0, 8, 1, 1, 0, 0, GridBagConstraints.NONE);

				putTextField(lc1.getTitre(), lc1.getTextField());
				putTextField(lc2.getTitre(), lc2.getTextField());
				putTextField(lc3.getTitre(), lc3.getTextField());
				putTextField(lc4.getTitre(), lc4.getTextField());
				putTextField(lc5.getTitre(), lc5.getTextField());
				putTextField(lc6.getTitre(), lc6.getTextField());
				putTextField(lc7.getTitre(), lc7.getTextField());

				getPanelEntete().getPanelProjet().getOnglet().show();

			}
		});

	}

	private void putTextField(String titre, JTextField textField) {
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		getTextFields().put(titre, textField);
	}

	/**
	 * 
	 * @return le Panel de l'entête<br/>
	 */
	public PanelEntete getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(PanelEntete panelEntete) {
		this.panelEntete = panelEntete;
	}

	private Hashtable<String, JTextField> getTextFields() {
		if (textFields == null)
			textFields = new Hashtable<String, JTextField>();
		return textFields;
	}

}
