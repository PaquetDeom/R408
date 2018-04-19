package fr.paquet.echafaudage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.EnumSet;
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

	@Enumerated(EnumType.STRING)
	private TypeSol typeSol = null;

	PropertyChangeSupport changeSupport = null;

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

	public void setChangeSupport(PropertyChangeSupport pCS) {
		this.changeSupport = pCS;
	}

	private PropertyChangeSupport getChangeSupport() {
		return changeSupport;
	}

	private void setListElementEchaf(List<ElementEchaf> elements) {
		this.elements = elements;
	}

	public void addElement(ElementEchaf element) throws Exception {
		if (element.getConstructeur() == getConstructeur() && element.getTypeEchaf() == getTypeEchaf()) {
			getElements().add(element);
		} else
			throw new Exception("L'élément n'est pas compatible avec ce type d'echafaudage");
	}

	public synchronized TypeEchaf getTypeEchaf() {
		return type;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public synchronized ClasseEchaf getClasseEchaf() {
		return classe;
	}

	/**
	 * 
	 * @return la list des elements d'echafaudage<br/>
	 */
	public List<ElementEchaf> getElements() {
		return elements;
	}

	public synchronized void setClasseEchaf(ClasseEchaf classe) {
		ClasseEchaf ce = this.classe;
		this.classe = classe;
		getChangeSupport().firePropertyChange("classe", ce, classe);

	}

	public synchronized void setTypeEchaf(TypeEchaf type) {
		TypeEchaf te = this.type;
		this.type = type;
		getChangeSupport().firePropertyChange("type", te, type);
	}

	public void setConstructeur(Constructeur constructeur) {
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

	/**
	 * 
	 * @return La charge d'exploitation de l'echafaudage<br/>
	 */
	public double getChargeExploitation() {

		return getClasseEchaf().getChargeExploitation() * getSurfaceExploitation();
	}

	/**
	 * 
	 * @return La surface d'exploitation de l'echafaudage<br/>
	 */
	public double getSurfaceExploitation() {

		double surface = 0;

		for (ElementEchaf el : getPlateformes()) {
			if (el.getPosition() == 2) {
				surface = surface + el.getSurface() / 2;
			} else {
				surface = surface + el.getSurface();
			}
		}

		return surface;
	}

	/**
	 * 
	 * @return la liste de plateforme d'echafaudage<br/>
	 */
	private List<ElementEchaf> getPlateformes() {

		List<ElementEchaf> elEchafs = new ArrayList<ElementEchaf>();

		for (ElementEchaf el : getElements()) {
			for (ElementEchafaudage elEchaf : EnumSet.allOf(ElementEchafaudage.class)) {
				if (el.equals(elEchaf)) {
					if (elEchaf.isPlateforme())
						elEchafs.add(el);
				}
			}
		}

		return elEchafs;

	}

	/**
	 * 
	 * @return Le nombre de pieds d'echafaudage<br/>
	 */
	public int getNbDePieds() {

		List<ElementEchaf> elEchafs = new ArrayList<ElementEchaf>();

		for (ElementEchaf el : getElements()) {
			for (ElementEchafaudage elEchaf : EnumSet.allOf(ElementEchafaudage.class)) {
				if (el.equals(elEchaf)) {
					if (elEchaf.isPied())
						elEchafs.add(el);
				}
			}
		}

		return elEchafs.size();

	}

	/**
	 * 
	 * @return le type de sol sur lequel est l'echafaudage<br/>
	 */
	public synchronized TypeSol getTypeSol() {
		return typeSol;
	}

	public synchronized void setTypeSol(TypeSol typeSol) {
		TypeSol ts = this.typeSol;
		this.typeSol = typeSol;
		getChangeSupport().firePropertyChange("typeSol", ts, typeSol);
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);

	}

	public void setListElements(List<ElementEchaf> elements) {
		this.elements = elements;

	}

	private double getSurfaceCale() {

		return ((getChargeExploitation() + getPoidsPropre()) / getNbDePieds()) / getTypeSol().getChargeAdmissible();
	}

	public double getDimensionCale() {

		return Math.sqrt(getSurfaceCale());
	}

}
