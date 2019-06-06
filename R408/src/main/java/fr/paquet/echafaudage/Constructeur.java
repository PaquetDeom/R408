package fr.paquet.echafaudage;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("constructeur")
@Entity
@Table(name = "CONSTRUCTEUR")
public class Constructeur {

	@XStreamOmitField
	@Id
	@GeneratedValue
	@Column(name = "COCOID")
	private int id = 0;

	@Column(name = "COCONA", length = 50)
	private String name = null;

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Constructeur() {
		super();
	}

	public Constructeur(String name) {
		super();
		setName(name);
	}

	private void setName(String name) {
		this.name = name.trim();

	}

	/**
	 * 
	 * @return Le nom d'un constructeur d'echafaudage sans espace a droite et a
	 *         gauche<br/>
	 * @throws Exception
	 */
	public String getName() throws Exception {
		if (name == null)
			throw new Exception("Le constructeur doit avoir un nom");
		return name;
	}

}
