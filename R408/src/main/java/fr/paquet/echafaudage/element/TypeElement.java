package fr.paquet.echafaudage.element;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TypeElement {

	@Id
	@Column(name = "TYTYID", length = 50)
	protected String ref = null;
	
	@Column(name = "TYTYNA", length = 50)
	protected String name = null;
	
	@ManyToOne
	@XStreamAsAttribute
	protected Constructeur cons = null;
	
	@Column(name = "TYTYPO")
	protected double poids = 0.0;
	
	@Enumerated(EnumType.STRING)
	@XStreamAsAttribute
	protected TypeEchaf tE = null;

	protected TypeElement() {
		super();
	}

	protected TypeElement(String name, String ref, Constructeur cons, double poids, TypeEchaf tE) {
		this();
		this.name = name;
		this.ref = ref;
		this.cons = cons;
		this.poids = poids;
		this.tE = tE;
	}

	public abstract String getReference();

	public abstract String getName();

	public abstract Constructeur getConstructeur();

	public abstract double getPoids();

	public abstract TypeEchaf getTypeEchaf();

	public abstract boolean isPied();
	
}
