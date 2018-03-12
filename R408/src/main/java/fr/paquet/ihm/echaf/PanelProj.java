package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

import javax.swing.*;

import fr.paquet.ihm.main.MainFrame;
import fr.paquet.ihm.main.MainOnglet;

public class PanelProj extends JPanel {

	/**
	 * faire Hash Map
	 */
	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;

	private JTextField buildTextField(String name, int taille) {
		JTextField textField = new JTextField(taille);
		textField.setName(name);
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				JTextField TF = (JTextField) e.getSource();
				String name = TF.getName();

				if (name.equals("TITRE"))
					getPanelEntete().getPanelProjet().getProjet().setTitre(TF.getText());
				MainFrame.getMainOnglet().setVisible(true);
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		return textField;
	}

	private JLabel buildLabel(String name, String text) {
		JLabel label = new JLabel(text);
		label.setName(name);
		return label;
	}

	public PanelProj(PanelEntete panelEntete) {

		super();
		setPanelEntete(panelEntete);

		setLayout(new GridBagLayout());

		buildComponent("TITRE", "Titre du projet", 20);
		buildComponent("NOMRESP", "Nom du responsable de l'étude", 20);

		add(buildLabel("TITRE", "Titre du projet"), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
				GridBagConstraints.BASELINE, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		add(tableTextFields.get("TITRE"), new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.BASELINE_LEADING,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	private Hashtable<String, JTextField> tableTextFields = new Hashtable<String, JTextField>();

	private void buildComponent(String titre, String intitule, int taille) {

		JTextField textField = buildTextField(titre, taille);

		tableTextFields.put(titre, textField);

	}

	public PanelEntete getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(PanelEntete panelEntete) {
		this.panelEntete = panelEntete;
	}

}
