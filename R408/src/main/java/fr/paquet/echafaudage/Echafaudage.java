package fr.paquet.echafaudage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ECHAFAUDAGE")
public class Echafaudage {

	/**
	 * @author Nathanael
	 * 
	 *         Class qui gere un echafaudage<br/>
	 */

	@Id
	@Column(name = "ECECID")
	@GeneratedValue
	private long id = 0;

	@OneToMany
	private List<ElementEchaf> elements = null;

	@ManyToOne
	private Constructeur constructeur = null;

	@Enumerated(EnumType.STRING)
	private TypeEchaf type = null;

	@Enumerated(EnumType.STRING)
	private ClasseEchaf classe = null;

	public Echafaudage() {
		super();
	}

	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe, List<ElementEchaf> elements) {
		this(constructeur, type, classe);
		setListElementEchaf(elements);
	}

	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe) {
		super();
		setConstructeur(constructeur);
		setTypeEchaf(type);
		setClasseEchaf(classe);
		setListElementEchaf(new ArrayList<ElementEchaf>());
	}

	private void setListElementEchaf(List<ElementEchaf> elements) {
		this.elements = elements;
	}

	public void addElement(ElementEchaf element) throws Exception {
		if (element.getConstructeur() == getConstructeur() && element.getTypeEchaf() == getTypeEchaf()) {
			getElements().add(element);
		} else
			throw new Exception("L'�l�ment n'est pas compatible avec ce type d'echaffaudage");
	}

	public TypeEchaf getTypeEchaf() {
		return type;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public ClasseEchaf getClasseEchaf() {
		return classe;
	}

	/**
	 * 
	 * @return la list des elements d'echafaudage<br/>
	 */
	public List<ElementEchaf> getElements() {
		return elements;
	}

	private void setClasseEchaf(ClasseEchaf classe) {
		this.classe = classe;

	}

	private void setTypeEchaf(TypeEchaf type) {
		this.type = type;
	}

	private void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}

	/**
	 * 
	 * @return le poids de l'echafaudage<br/>
	 */
	public double getPoidsPropre() {

		double poids = 0;

		for (ElementEchaf elEchaf : getElements()) {
			poids = poids + elEchaf.getPoids();
		}

		return poids;
	}

	// TODO
	/**
	 * getPlateforme
	 */

	public int getNbDePieds() {

		int i = 0;

		for (ElementEchaf elEchaf : getElements()) {
			if (elEchaf.getName() == "pied droit" || elEchaf.getName() == "pied inclinable")
				i = i++;
		}

		return i;
	}

}
