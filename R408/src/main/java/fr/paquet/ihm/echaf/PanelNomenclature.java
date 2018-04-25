package fr.paquet.ihm.echaf;

import java.awt.GridBagLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class PanelNomenclature extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @author paquet
	 */
	
	private PanelResultats panelResultats = null;

	public PanelNomenclature(PanelResultats pr) {
		super();
		setPanelResultats(pr);
		
		//Cree un renfoncement autour du panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Nomenclature"));
		
		//ajout du layout
		setLayout(new GridBagLayout());

	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}
}
