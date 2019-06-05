package fr.paquet.ihm.echaf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.io.jrxml.GeneratePDF;

import fr.paquet.projet.Projet;

public class PanelImprimer extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelResultats panelResultats = null;
	private JButton jGenere = null;

	public PanelImprimer(PanelResultats panelResultats) {
		super();
		setPanelResultats(panelResultats);

		// Cree un renfoncement autour du panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Generation de documents"));

		// ajout du layout
		setLayout(new GridBagLayout());

		// setteur button
		setjGenere(new JButton("Génére"));

		add(getjGenere(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

	}

	public PanelResultats getPanelResultats() {
		return panelResultats;
	}

	private void setPanelResultats(PanelResultats panelResultats) {
		this.panelResultats = panelResultats;
	}

	private JButton getjGenere() {
		return jGenere;
	}

	private void setjGenere(JButton jGenere) {

		jGenere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Projet projet = getPanelResultats().getPanelProjet().getOnglet().getProjet();

				if (projet != null)
					try {
						
						new GeneratePDF(projet);
						
					} catch (Exception e) {
						new AlertWindow(AlertType.ERREUR, "Le rapport n'a pas été généré");
						e.printStackTrace();
					}
				else
					new AlertWindow(AlertType.ATTENTION, "Aucun projet actif");

			}
		});

		this.jGenere = jGenere;
	}

	

}
