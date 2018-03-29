package fr.paquet.ihm.echaf;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import fr.paquet.ihm.main.MainOnglet;

import fr.paquet.projet.*;

public class OngletProjet extends JComponent implements PropertyChangeListener {

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

		// creer le projet si la variable de methode projet est nulle
		if (projet == null)
			setProjet(new Projet(this, "", new Client(), new Chantier(), new Responsable()));

		// Ajout de l'onglet
		MainOnglet.getUniqInstance().addTab(getTitre(getProjet()), getJPanelProjet());

		// Ajout à la liste des MainOnglets
		MainOnglet.getUniqInstance().addOnglet(this);

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

		if (projet.getTitre().equals(""))
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
	public void propertyChange(PropertyChangeEvent evt) {

		if (evt.getPropertyName().equals("titre")) {
			String title = (String) evt.getNewValue();
			getTitre(getProjet());
			MainOnglet.getUniqInstance().setTitleAt(MainOnglet.getUniqInstance().getSelectedIndex(), title);

		}

	}

}
