package fr.paquet.ihm.nouveau;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelChantier extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private JDialogNouveau jDialogNouveau = null;
	private PanelCoordonneesChantier pCC = null;
	private JButton buttonAdresse = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelChantier(JDialogNouveau dN) {

		super();

		setjDialogNouveau(dN);
		setButtonAdresse(new JButton("Adresse chantier = adresse client"));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Adresse du chantier"));

		setLayout(new GridBagLayout());

		// creation de panels.
		setpCC(new PanelCoordonneesChantier(this));
		JPanel panelButton = new JPanel();
		
		panelButton.setLayout(new BorderLayout());
		

		// ajout des panels ci-dessus a panel chantier
		add(panelButton,new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 5, 5));
		add(getpCC(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 5, 5));
		
		panelButton.add(getButtonAdresse(), BorderLayout.CENTER);
		

	}

	public PanelCoordonneesChantier getpCC() {
		return pCC;
	}

	public void setpCC(PanelCoordonneesChantier pCC) {
		this.pCC = pCC;
	}

	public JDialogNouveau getjDialogNouveau() {
		return jDialogNouveau;
	}

	private void setjDialogNouveau(JDialogNouveau jDialogNouveau) {
		this.jDialogNouveau = jDialogNouveau;
	}

	private JButton getButtonAdresse() {
		return buttonAdresse;
	}

	private void setButtonAdresse(JButton buttonAdresse) {
		
		buttonAdresse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.buttonAdresse = buttonAdresse;
	}

}
