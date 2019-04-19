package fr.paquet.ihm.parameterCsv;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class JPanelCsv extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogParameterCsv jDP = null;

	public JPanelCsv(JDialogParameterCsv jDP) {

		super();
		setjDP(jDP);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Vue du Fichier"));

		setLayout(new GridBagLayout());

		int i = 0;

		while (i < 15) {
			add(new JLabel(jDP.getCsvElementReader().getLines().get(i)), new GridBagConstraints(0, i, 1, 1, 0, 0,
					GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			i++;
		}

	}

	public JDialogParameterCsv getjDP() {
		return jDP;
	}

	private void setjDP(JDialogParameterCsv jDP) {
		this.jDP = jDP;
	}
}
