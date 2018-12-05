package fr.paquet.ihm.nouveau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.main.MainMenu;

public class PanelTitre extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private PanelProj panelProj = null;
	private JTextField jTextFieldTitre = null;
	private JTextField jTextFieldUrl = null;

	public PanelTitre(PanelProj panelProj) {
		super();

		setPanelProj(panelProj);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des Component au panel
		JLabelJTextField lcl1 = new JLabelJTextField(this, "TITRE", "Titre du projet", 40, 0, 0, 1, 1, 0,
				0, GridBagConstraints.NONE);
		JLabelJTextField lcl2 = new JLabelJTextField(this, "URL", "Entrer une url", 40, 0, 1, 1, 1, 0, 0,
				GridBagConstraints.NONE);

		setjTextFieldTitre(lcl1.getTextField());
		setjTextFieldUrl(lcl2.getTextField());

	}

	private JTextField getjTextFieldTitre() {
		return jTextFieldTitre;
	}

	private void setjTextFieldTitre(JTextField jTextFieldTitre) {

		// ajout du listener sur la zone de saisi du nom.
		jTextFieldTitre.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();

				// si le titre est null ou ""
				if (tF.getText() == null || tF.getText().equals("")) {
					tF.setText("Le titre du projet doit être renseigné");
					tF.setForeground(Color.RED);
					tF.selectAll();

				} else {
					getjTextFieldTitre().setText(tF.getText().trim());
					getPanelProj().getjDialogNouveau().getProjet().setTitre(tF.getText());
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

				JTextField tF = (JTextField) e.getSource();
				tF.selectAll();
			}
		});

		this.jTextFieldTitre = jTextFieldTitre;
	}

	public PanelProj getPanelProj() {
		return panelProj;
	}

	public void setPanelProj(PanelProj panelProj) {
		this.panelProj = panelProj;
	}

	public JTextField getjTextFieldUrl() {
		return jTextFieldUrl;
	}

	private void setjTextFieldUrl(JTextField jTextFieldUrl) {
		
		jTextFieldUrl.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				jTextFieldUrl.setText("");
				
			}
		});
		this.jTextFieldUrl = jTextFieldUrl;
	}

}
