package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitre extends JPanel {

	/**
	 * @author paquet
	 */
	private static final long serialVersionUID = 1L;
	private PanelProj panelProj = null;

	public PanelTitre(PanelProj panelProj) {
		super();

		setPanelProj(panelProj);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des Component au panel
		add(new JLabel("titre du projet : "), new GridBagConstraints(0, 0, 1, 1, 0, 0,
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

		add(new JLabel(getPanelProj().getPanelEntete().getPanelProjet().getOnglet().getProjet().getTitre()),
				new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelProj getPanelProj() {
		return panelProj;
	}

	public void setPanelProj(PanelProj panelProj) {
		this.panelProj = panelProj;
	}

}
