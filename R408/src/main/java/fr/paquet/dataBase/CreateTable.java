package fr.paquet.dataBase;

import java.util.List;

import javax.persistence.Query;

public class CreateTable extends Connect {

	/**
	 * @author paquet
	 * 
	 */

	public CreateTable() {
		super();
		CreateTable();

	}

	@SuppressWarnings("unchecked")
	public List<Object> CreateTable() {

		Query query = getEm().createNativeQuery("SELECT * FROM Data");

		return query.getResultList();

	}

}
