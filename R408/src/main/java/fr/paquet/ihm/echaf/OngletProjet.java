package fr.paquet.ihm.echaf;

import java.util.List;

import javax.swing.JComponent;

import fr.paquet.ihm.main.MainOnglet;
import fr.paquet.projet.Chantier;
import fr.paquet.projet.Client;
import fr.paquet.projet.Projet;
import fr.paquet.projet.ProjetListener;
import fr.paquet.projet.Responsable;

public class OngletProjet extends JComponent implements ProjetListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555340311930007466L;
	private Projet projet = null;
	private JPanelProjet panelProjet = null;

	/**
	 * Cree un nouvel onglet<br/>
	 */
	public OngletProjet(Projet projet) {

		super();
		setProjet(projet);

		// Ajout de l'onglet
		MainOnglet.getUniqInstance().addTab(getTitre(getProjet()), getJPanelProjet());

		// Ajout à la liste des MainOnglets
		MainOnglet.getUniqInstance().addOnglet(this);

		// Ajout du listener qui écoute les changement du projet
		getProjet().addProjetListener(this);
	}

	private JPanelProjet getJPanelProjet() {
		if (panelProjet == null)
			panelProjet = new JPanelProjet(this);
		return panelProjet;
	}

	/**
	 * 
	 * @return le titre de du document<br/>
	 */
	private String getTitre(Projet projet) {

		if (projet.getTitre() == null || projet.getTitre().equals(""))
			return "sansTitre" + " " + MainOnglet.getUniqInstance().getOnglets().size();
		else
			return projet.getTitre();

	}

	public Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public void changeTitre(String nouveauTitre) {
		getTitre(getProjet());
		MainOnglet.getUniqInstance().setTitleAt(MainOnglet.getUniqInstance().getSelectedIndex(), nouveauTitre);
		MainOnglet.getUniqInstance().setVisible(true);
	}

	@Override
	public void changeClient(Client nouveauClient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeChantiers(List<Chantier> nouveauChantier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeResponsable(Responsable nouveauResp) {
		// TODO Auto-generated method stub

	}

}
