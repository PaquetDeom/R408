package fr.paquet.echafaudage;

import java.util.List;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("constructeur")
@Entity
@Table(name = "Constructeur")
public class Constructeur {
	
	@XStreamOmitField
	@Id
	@GeneratedValue
	@Column(name = "COCOID")
	private int id = 0;
	
	@Column(name = "COCONA", length = 50)
	private String name = null;
	
	@XStreamOmitField
	@Transient
	private List<ElementEchaf> elements = null;
	
	
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
	 * @return Le nom d'un constructeur d'echafaudage sans espace a droite et a gauche<br/>
	 */
	public String getName() {
		return name;
	}

}
