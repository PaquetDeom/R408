package fr.paquet.echafaudage;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

/**
 * 
 * @author paquet
 *
 */

public class ElementEchafFactory extends Connect {

	private ElementEchaf element = null;

	/**
	 * 
	 * Constructeur de la class<br/>
	 *
	 */
	public ElementEchafFactory() {
		super();

	}

	/**
	 * 
	 * @param element
	 */
	public ElementEchafFactory(ElementEchaf element) {
		this();

		setElementEchaf(element);
	}

	/**
	 * 
	 * @param name
	 * @return l'élément d'échafaudage en fonction de son nom<br/>
	 */
	public ElementEchaf findElementByName(String name) {

		Query query = getEm().createQuery("SELECT ElementEchaf FROM ElementEchaf element where element.name=:name");
		query.setParameter("name", name);

		try {

			return (ElementEchaf) query.getSingleResult();

		} catch (NoResultException e) {

			e.printStackTrace(System.out);
			return null;
		}

	}

	public List<ElementEchaf> findAllElements() throws Exception {

		Query query = getEm().createQuery("Select element FROM ElementEchaf element");
		@SuppressWarnings("unchecked")
		List<ElementEchaf> elements = (List<ElementEchaf>) query.getResultList();

		if (elements.isEmpty())
			throw new Exception("Il n'y a pas d'élément dans la base de donnees");

		return elements;
	}

	/**
	 * Sauve un élément dans la DB<br/>
	 * 
	 * @throws Exception
	 */
	public void saveElement() throws Exception {

		if (findElementByName(getElementEchaf().getName()) == null) {

			EntityTransaction t = getEm().getTransaction();

			try {
				t.begin();
				getEm().persist(getElementEchaf());
				t.commit();

			} catch (Exception e) {

				new AlertWindow(AlertType.ERREUR, "L'élément n'a pas été sauvé");
				t.rollback();
				throw (e);
			}
		}
	}

	/**
	 * suppr un élément d'échafaudage de la DB<br/>
	 */
	public void removeElement() {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(getElementEchaf());
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	private ElementEchaf getElementEchaf() {
		return element;
	}

	private void setElementEchaf(ElementEchaf element) {
		this.element = element;
	}

}
