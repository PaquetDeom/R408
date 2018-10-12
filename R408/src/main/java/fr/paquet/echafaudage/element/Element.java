package fr.paquet.echafaudage.element;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.paquet.echafaudage.Echafaudage;

@Entity
@Table(name = "Element")
public class Element {

	@Id
	@GeneratedValue
	@Column(name = "ELELID")
	private long id = 0;

	@Column(name = "ELELPO")
	private int position = 0;

	@Transient
	private TypeElement type = null;

	@Enumerated(EnumType.STRING)
	private InstanciationElement inst = null;

	@ManyToOne()
	private Echafaudage echafaudage = null;

	/**
	 * Constructeur vide<br/>
	 */
	public Element() {
		super();
	}

	public Element(Echafaudage echaf, TypeElement type, InstanciationElement inst, int position) throws Exception {
		this();
		setEchafaudage(echaf);
		setType(type);
		setPosition(position);
		setInst(inst);
	}

	private void setInst(InstanciationElement inst) {

		this.inst = inst;
	}

	public InstanciationElement getInst() {
		return inst;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	private void setType(TypeElement type) throws Exception {
		// if
		// (!getEchafaudage().getConstructeur().getName().equals(getType().getConstructeur().getName()))
		// throw new Exception("Le constructeur de l'élément doit être le même que
		// l'échafaudage");
		// else
		this.type = type;
	}

	private void setEchafaudage(Echafaudage echafaudage) {
		this.echafaudage = echafaudage;
	}

	public int getPosition() {
		return position;
	}

	public TypeElement getType() {
		return type;
	}

	public Echafaudage getEchafaudage() {
		return echafaudage;
	}

}
