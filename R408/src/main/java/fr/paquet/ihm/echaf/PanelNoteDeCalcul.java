package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.echafaudage.Arrondi;
import fr.paquet.ihm.alert.AlertWindow;

public class PanelNoteDeCalcul extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @author paquet<br/>
	 */

	private PanelResultats panelResultats = null;

	public PanelNoteDeCalcul(PanelResultats pr) {
		super();
		setPanelResultats(pr);

		// Cree un renfoncement autour du panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Note de calcul"));

		// ajoute un layout
		setLayout(new GridBagLayout());

		// Creation et affichage des JLabel

		addLineLabel(new JLabel("Constructeur : "), new JLabel(String.valueOf(getPanelResultats().getPanelProjet()
				.getOnglet().getProjet().getChantier().getEchafaudage().getConstructeur().getName())), 0);

		addLineLabel(new JLabel("Type Echafaudage : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getTypeEchaf().getType()), 1);

		addLineLabel(new JLabel("Type de sol : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getTypeSol().getType()), 2);

		addLineLabel(new JLabel("Poids propre : "), new JLabel(String.valueOf(getPanelResultats().getPanelProjet()
				.getOnglet().getProjet().getChantier().getEchafaudage().getPoidsPropre()) + " DAN"), 3);

		addLineLabel(new JLabel("Classe echafaudage : "), new JLabel(getPanelResultats().getPanelProjet().getOnglet()
				.getProjet().getChantier().getEchafaudage().getClasseEchaf().getClasse()), 4);

		addLineLabel(new JLabel("Charge d'exploitation totale : "),
				new JLabel(String.valueOf(Arrondi.getDoubleArrondi(getPanelResultats().getPanelProjet().getOnglet()
						.getProjet().getChantier().getEchafaudage().getChargeExploitation(), 2)) + " DAN"),
				5);

		try {
			addLineLabel(new JLabel("Nombre de pieds : "), new JLabel(String.valueOf(getPanelResultats()
					.getPanelProjet().getOnglet().getProjet().getChantier().getEchafaudage().getNbDePieds()) + " U"),
					6);

			addLineLabel(new JLabel("Dimension mini de la cale : "),
					new JLabel(
							String.valueOf(Arrondi.getDoubleArrondi(getPanelResultats().getPanelProjet().getOnglet()
									.getProjet().getChantier().getEchafaudage().getDimensionCale(), 2))
									+ " x "
									+ String.valueOf(Arrondi
											.getDoubleArrondi(getPanelResultats().getPanelProjet().getOnglet()
													.getProjet().getChantier().getEchafaudage().getDimensionCale(), 2)
											+ " cm2")),
					7);

		} catch (Exception e) {
			new AlertWindow("Erreur", e.getMessage());
			e.printStackTrace(System.out);
		}

	}

	private void addLineLabel(JLabel label, JLabel label2, int nLine) {

		add(label, new GridBagConstraints(0, nLine, 1, 1, 0, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(label2, new GridBagConstraints(1, nLine, 1, 1, 1, 0, GridBagConstraints.BASELINE,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}

}
