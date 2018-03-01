package fr.paquet.echafaudage;

import javax.persistence.*;


public enum TypeEchaf {

	TYPE1, TYPE2;

	/**
	 * 
	 * @return le type d'�chafaudage<br/>
	 */
	public String getType() {
		switch (this) {
		case TYPE1:
			return ("Echafaudage a cadre");
		case TYPE2:
			return ("Echafaudage multi-directionelle");
		}
		return null;
	}

}
