package fr.paquet.projet;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

/**
 * 
 * @author paquet
 *
 */

public class ProjetFactory extends Connect implements AlertListener {

	private Projet projet = null;

	/**
	 * 
	 * Constructeur de la class<br/>
	 *
	 */
	public ProjetFactory() {
		super();

	}

	public ProjetFactory(Projet projet) {
		this();

		setProjet(projet);
	}

	/**
	 * 
	 * @param title
	 * @return un projet suivant son titre<br/>
	 */
	public Projet findProjetByTitle(String titre) {

		Query query = getEm().createQuery("SELECT Projet FROM Projet projet where projet.titre=:titre");
		query.setParameter("titre", titre);

		try {

			return (Projet) query.getSingleResult();

		} catch (NoResultException e) {

			e.printStackTrace(System.out);
			return null;
		}

	}

	/**
	 * 
	 * @return tous les projets de la DB<br/>
	 * @throws Exception
	 *             la liste est vide<br/>
	 */
	public List<Projet> findAllProjets() throws Exception {

		Query query = getEm().createQuery("Select projet FROM Projet projet");
		@SuppressWarnings("unchecked")
		List<Projet> projets = (List<Projet>) query.getResultList();

		if (projets.isEmpty())
			throw new Exception("Il n'y a pas de projet dans la base de donnees");

		return projets;
	}

	public void saveProjet() throws Exception {

		if (getProjet().getTitre() == null || getProjet().getTitre().equals("")) {
			throw new Exception("le projet doit avoir un titre");
		}

		if (findProjetByTitle(getProjet().getTitre()) != null) {
			new AlertWindow(AlertType.QUESTION, "ce projet existe déja voulez-vous le mettre à jour", this);
		} else {
			EntityTransaction t = getEm().getTransaction();
			try {

				t.begin();
				getEm().persist(getProjet());
				t.commit();
				new AlertWindow(AlertType.INFORMATION, "Le projet a bien été sauvegardé");

			} catch (Exception e) {
				
				new AlertWindow(AlertType.ERREUR, "Le projet n'a pas été sauvé");
				t.rollback();
				throw (e);
			}
		}

	}

	public void RefrechProjet() {
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().refresh(getProjet());
			new AlertWindow(AlertType.INFORMATION, "Le projet a bien été mis à jour");
		} catch (Exception e) {
			t.rollback();
			new AlertWindow(AlertType.ERREUR, "Le projet n'a pas été mis à jour");
			throw(e);
		}
	}

	/**
	 * suppr un projet de la DB<br/>
	 * 
	 * @param projet
	 */
	public void removeProjet() {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(getProjet());
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	private Projet getProjet() {
		return projet;
	}

	private void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Override
	public void buttonClick(String button) {
		if (button == "Oui")
			RefrechProjet();

	}

}
