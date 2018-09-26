package fr.paquet.echafaudage;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("elementEchafaudage")
@Entity
@Table(name = "ELEMENT")
public class ElementEchaf {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere les elements d'echafaudage<br/>
	 */

	@Column(name = "ELELNA", length = 50)
	private String name = null;

	@ManyToOne(cascade = CascadeType.ALL)
	private Constructeur constructeur = null;

	@Id
	@Column(name = "ELELID", length = 50)
	private String reference = null;

	@Column(name = "ELELPO")
	private double poids = 0;

	@Column(name = "ELELTY")
	private TypeEchaf type = null;

	@Column(name = "ELELSU")
	private double surface = 0.0;

	@Enumerated(EnumType.STRING)
	private TypeElement tElement = null;

	public ElementEchaf() {
		super();

	}

	public ElementEchaf(Constructeur constructeur, String name, String reference, TypeEchaf type, double poids,
			double surface, TypeElement typeElemnt) throws Exception {
		super();
		setConstructeur(constructeur);
		setName(name);
		setReference(reference);
		setTypeEchaf(type);
		setPoids(poids);
		setSurface(surface);
		setTypeElement(typeElemnt);
	}

	private void setTypeElement(TypeElement typeElement) {
		this.tElement = typeElement;
	}

	public TypeElement getTypeElement() {
		return tElement;
	}

	private void setSurface(double surface) {
		this.surface = surface;
	}

	public double getSurface() {
		return surface;
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
	 * @return le type d'�chaffaudage<br/>
	 */
	public TypeEchaf getTypeEchaf() {
		return type;
	}
}
