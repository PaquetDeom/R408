package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;

import javax.swing.*;

public class PanelProj extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelEntete panelEntete = null;
	private List<JLabel> labels = null;
	private List<JTextField> textFields = null; 
	
	private void addLabel(JLabel label) {
		getLabels().add(label);
	}
	
	private void addTextField(JTextField textField) {
		getTextFields().add(textField);
	}
	
	private List<JTextField> getTextFields(){
		if(textFields == null)
			textFields = new ArrayList<JTextField>();
		return textFields;
	}
	
	private List<JLabel> getLabels(){
		if(labels == null)
			labels = new ArrayList<JLabel>();
		return labels;
	}
	
	private JTextField buildTextField(String name, int taille) {
		JTextField textField = new JTextField(taille);
		textField.setName(name);
		return textField;
	}
	
	private void listener() {
		
		for(int i = 0; i<getTextFields().size();i++) {
			JTextField JTF = getTextFields().get(i);
			JTF.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
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
		
		JTextField titreField = buildTextField("TITRE", 20);
		addTextField(titreField);
	
		JLabel titre = buildLabel("TITRE", "titre du projet");
		addLabel(titre);

		add(titre, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.BASELINE, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		add(titreField, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.BASELINE_LEADING,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		
		listener();
	}

	public PanelEntete getPanelEntete() {
		return panelEntete;
	}

	private void setPanelEntete(PanelEntete panelEntete) {
		this.panelEntete = panelEntete;
	}

}
