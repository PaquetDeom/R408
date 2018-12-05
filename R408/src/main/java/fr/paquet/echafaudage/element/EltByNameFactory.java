package fr.paquet.echafaudage.element;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

/**
 * 
 * @author paquet
 *
 */

public class EltByNameFactory extends Connect {

	private String name = null;

	/**
	 * Constructeur vide<br/>
	 */
	public EltByNameFactory() {
		super();
	}

	@SuppressWarnings("finally")
	public EltByName findEltByNameByName(String name) {

		Query query = getEm().createQuery("SELECT EltByName FROM EltByName eltByName where eltByName.name=:name");
		query.setParameter("name", name);

		try {

			EltByName elt = null;
			elt = (EltByName) query.getSingleResult();

			setEltByName(elt);

		} catch (Exception e) {
			e.getSuppressed();
			if (getEltByName() == null)
				setName(name);
		} finally {
			return getEltByName();
		}
	}

	private EltByName elt = null;

	public void setEltByName(EltByName elt) {
		this.elt = elt;
	}

	private EltByName getEltByName() {
		return elt;
	}

	public void saveEltByName(EltByName elt) {
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().persist(elt);
			t.commit();

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

	public List<EltByName> findAllEltByNames() throws Exception {
		
		Query query = getEm().createQuery("SELECT EltByName FROM EltByName eltByName");
		
		@SuppressWarnings("unchecked")
		List<EltByName> list = (List<EltByName>) query.getResultList();
		
		if(list.isEmpty())
			throw new Exception("Il n'y a pas de mot clé dans la liste");
		
		return list;
	}

}
