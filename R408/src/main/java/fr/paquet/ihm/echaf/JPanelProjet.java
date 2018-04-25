package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JPanelProjet extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletProjet onglet = null;
	private PanelEntete pEntete = null;
	private PanelEchafaudage pEchaf = null;
	private PanelResultats pResul = null;

	public JPanelProjet(OngletProjet onglet) {
		super();
		setOnglet(onglet);
		setLayout(new GridBagLayout());
		
		//creation des panels
		setpEntete(new PanelEntete(this));
		setpEchaf(new PanelEchafaudage(this));
		setpResul(new PanelResultats(this));
		
		//affichage des panels
		add(getpEntete(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		add(getpEchaf(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getpResul(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	public OngletProjet getOnglet() {
		return onglet;
	}

	private void setOnglet(OngletProjet onglet) {
		this.onglet = onglet;
	}

	public PanelEntete getpEntete() {
		return pEntete;
	}

	private void setpEntete(PanelEntete pEntete) {
		this.pEntete = pEntete;
	}

	public PanelEchafaudage getpEchaf() {
		return pEchaf;
	}

	private void setpEchaf(PanelEchafaudage pEchaf) {
		this.pEchaf = pEchaf;
	}

	public PanelResultats getpResul() {
		return pResul;
	}

	private void setpResul(PanelResultats pResul) {
		this.pResul = pResul;
	}

}
