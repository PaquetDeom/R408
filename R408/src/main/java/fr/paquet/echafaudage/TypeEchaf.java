package fr.paquet.echafaudage;




public enum TypeEchaf {

	TYPE1, TYPE2;

	/**
	 * 
	 * @return le type d'�chafaudage<br/>
	 */
	public String getType() {
		switch (this) {
		case TYPE1:
			return ("Echafaudage à cadre");
		case TYPE2:
			return ("Echafaudage multi-directionel");
		}
		return null;
	}

}
