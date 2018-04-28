package fr.paquet.ihm.echaf;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.echafaudage.ElementEchaf;
import fr.paquet.echafaudage.TypeEchaf;
import fr.paquet.echafaudage.TypeElement;

public class PanelNomenclature extends JPanel {

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

		// Cree un renfoncement autour du panel
		setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), "Nomenclature"));

		// ajout du layout
		setLayout(new BorderLayout());
		
		JTable tableNomenclature =new JTable();
		tableNomenclature.setModel(new NomenclatureModel(getPanelResultats().getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage()));
		
		this.add(new JScrollPane(tableNomenclature), BorderLayout.CENTER);
	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}
}
