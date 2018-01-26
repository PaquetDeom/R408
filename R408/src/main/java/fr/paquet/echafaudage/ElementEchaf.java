package fr.paquet.echafaudage;

import javax.persistence.*;

@Entity
@Table(name = "ELEMENT")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ElementEchaf {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere les elements d'echafaudage<br/>
	 */

	@Column(name = "ELELNA", length = 50)
	private String name = null;

	@ManyToOne
	private Constructeur constructeur = null;

	@Id
	@Column(name = "ELELID", length = 50)
	private String reference = null;

	@Column(name = "ELELPO")
	private double poids = 0;

	@Column(name = "ELELTY")
	private TypeEchaf type = null;

	public ElementEchaf() {

	}

	public ElementEchaf(Constructeur constructeur, String name, String reference,TypeEchaf type, double poids) {
		super();
		setConstructeur(constructeur);
		setName(name);
		setReference(reference);
		setTypeEchaf(type);
		setPoids(poids);
	}
	
	private void setTypeEchaf(TypeEchaf type) {
		this.type = type;
	}

	private void setName(String name) {
		this.name = name.trim();
	}

	private void setPoids(double poids) {
		this.poids = poids;
	}

	private void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	private void setReference(String reference) {
		this.reference = reference.trim();
	}

	/**
	 * 
	 * @return le nom sans espace avant et apres<br/>
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return le niom du constructeur sans espace avant et apres et en
	 *         majuscule<br/>
	 */
	public Constructeur getConstructeur() {
		return constructeur;
	}

	/**
	 * 
	 * @return la reference de l'element<br/>
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * 
	 * @return le poids de l'element<br/>
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 *  
	 * @return le type d'échaffaudage<br/>
	 */
	public TypeEchaf getTypeEchaf() {
		return type;
	}

}
