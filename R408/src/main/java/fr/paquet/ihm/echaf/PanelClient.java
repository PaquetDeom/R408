package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelClient extends JPanel {

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
	public PanelClient(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);

		setLayout(new GridBagLayout());

		add(new JLabel("Données client"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		AddLineJLabelJTextField lcl1 = new AddLineJLabelJTextField(this, "NOMCLIENT", "Nom du Client", 20, 0, 1, 1, 1,
				0, 0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl2 = new AddLineJLabelJTextField(this, "PRENOMCLIENT", "Prenom du Client", 20, 0, 2,
				1, 1, 0, 0, GridBagConstraints.NONE);
		new AddLineJLabelJTextField(this, "ESPACE", "-------------------------", 0, 0, 3, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl4 = new AddLineJLabelJTextField(this, "ADRESSE1", "Lieu dit", 20, 0, 4, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl5 = new AddLineJLabelJTextField(this, "ADRESSE2", "N°", 5, 0, 5, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl6 = new AddLineJLabelJTextField(this, "ADRESSE3", "Nom de la rue", 20, 0, 6, 1, 1, 0,
				0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl7 = new AddLineJLabelJTextField(this, "CODEPOSTAL", "Code postal", 8, 0, 7, 1, 1, 0,
				0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl8 = new AddLineJLabelJTextField(this, "COMMUNE", "Ville", 20, 0, 8, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl9 = new AddLineJLabelJTextField(this, "MAIL", "Adresse mail", 20, 0, 9, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lcl10 = new AddLineJLabelJTextField(this, "TEL", "N° de telephone", 20, 0, 10, 1, 1, 0,
				0, GridBagConstraints.NONE);

		putTextField(lcl1.getTitre(), lcl1.getTextField());
		putTextField(lcl2.getTitre(), lcl2.getTextField());
		putTextField(lcl4.getTitre(), lcl4.getTextField());
		putTextField(lcl5.getTitre(), lcl5.getTextField());
		putTextField(lcl6.getTitre(), lcl6.getTextField());
		putTextField(lcl7.getTitre(), lcl7.getTextField());
		putTextField(lcl8.getTitre(), lcl8.getTextField());
		putTextField(lcl9.getTitre(), lcl9.getTextField());
		putTextField(lcl10.getTitre(), lcl10.getTextField());

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
