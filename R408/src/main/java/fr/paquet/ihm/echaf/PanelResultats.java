package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResultats extends JPanel {
	
	public class JButtonCalcul extends JButton implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public JButtonCalcul() {
			super();
			setText("Lancer le calcul");
			setEnabled(true);
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelProjet panelProjet = null;

	public PanelResultats(JPanelProjet panelProjet) {
		super();
		setPanelProjet(panelProjet);

		setLayout(new GridBagLayout());

		JLabel a = new JLabel("C'est pas fait");
		add(a, new GridBagConstraints(0, 0, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	public JPanelProjet getPanelProjet() {
		return panelProjet;
	}

	public void setPanelProjet(JPanelProjet panelProjet) {
		this.panelProjet = panelProjet;
	}

}
