package fr.paquet.echafaudage.element;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.eltByName.ChoixDuType;

/**
 * 
 * @author paquet
 *
 */

public class EltByNameFactory extends Connect implements AlertListener {

	
	private String name = null;
	/**
	 * Constructeur vide<br/>
	 */
	public EltByNameFactory() {
		super();
	}

	public EltByName findEltByNameByName(String name) {
		Query query = getEm().createQuery("SELECT EltByName FROM EltByName eltByName where eltByName.name=:name");
		query.setParameter("name", name);

		try {
			return (EltByName) query.getSingleResult();
		} catch (NoResultException e) {
			setName(name);
			new AlertWindow(AlertType.QUESTION, "Voulez vous lier le mot " + name + " à un type d'élément", this);
			return null;

		}
	}

	public void saveEltByName(EltByName elt) {
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().persist(elt);
			t.commit();
			new AlertWindow(AlertType.INFORMATION, "Le mot clé a bien été sauvegardé");

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}
	}

	public void removeEltByName(EltByName eltByName) {

		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().remove(eltByName);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	private void setName(String name) {
		this.name = name;
	}
	
	private String getName() {
		return name;
	}
	
	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui"))
			new ChoixDuType(EltByNameFactory.this, getName());

	}
}
