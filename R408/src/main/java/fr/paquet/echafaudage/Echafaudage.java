package fr.paquet.echafaudage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Enumeration;
import java.util.Hashtable;

import java.util.List;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("echafaudage")
@Entity
@Table(name = "ECHAFAUDAGE")
public class Echafaudage {

	/**
	 * @author Nathanael
	 * 
	 *         Class qui gere un echafaudage<br/>
	 */

	@XStreamOmitField
	@Id
	@Column(name = "ECECID")
	@GeneratedValue
	private long id = 0;

	@OneToMany(cascade = CascadeType.DETACH)
	@OrderBy("name")
	private List<ElementEchaf> elements = null;

	@ManyToOne(cascade = CascadeType.ALL)
	private Constructeur constructeur = null;

	@XStreamAsAttribute
	@Enumerated(EnumType.STRING)
	private TypeEchaf type = null;

	@XStreamAsAttribute
	@Enumerated(EnumType.STRING)
	private ClasseEchaf classe = null;

	@XStreamAsAttribute
	@Enumerated(EnumType.STRING)
	private TypeSol typeSol = null;

	@XStreamOmitField
	@Transient
	private Hashtable<TypeElement, Integer> elementEchafs = null;

	//TODO JPa et HashTable
	@XStreamAsAttribute
	@CollectionTable(name = "ECECPO", joinColumns = @JoinColumn(name = "ELELID"))
	private Hashtable<ElementEchaf, Integer> positionDesElements = null;

	@XStreamOmitField
	@Transient
	private PropertyChangeSupport changeSupport = null;

	/**
	 * 
	 * @return la position dans l'échafaudage d'un élément<br/>
	 */
	public Hashtable<ElementEchaf, Integer> getPositionDesElements() {
		if (positionDesElements == null)
			positionDesElements = new Hashtable<ElementEchaf, Integer>();
		return positionDesElements;
	}

	/**
	 * 
	 * @param el
	 *            de type ElementEchaf <br/>
	 * @param p
	 *            de type Integer <br/>
	 */
	public void setPositionDesElements(ElementEchaf el, int p) {
		getPositionDesElements().put(el, p);
	}

	/**
	 * 
	 * @return la plus haute position d'un échafaudage<br/>
	 */
	private int getNumDuDernierEtage() {

		int a = 0;

		for (int i = 0; i < getElementEchafs().size(); i++) {
			ElementEchaf el = getElements().get(i);

			if (getPositionDesElements().get(el) > a)
				a = getPositionDesElements().get(el);
		}
		return a;
	}

	/**
	 * Compte le nombre de TypeElement<br/>
	 */
	private void initHashtable() {
		elementEchafs = new Hashtable<TypeElement, Integer>();
		for (ElementEchaf el : getElements()) {
			if (elementEchafs.get(el.getTypeElement()) == null)
				elementEchafs.put(el.getTypeElement(), 1);
			else
				elementEchafs.put(el.getTypeElement(), elementEchafs.get(el.getTypeElement()) + 1);
		}
	}

	/**
	 * 
	 * @return le nombre d'élément par TypeElement<br/>
	 */
	private Hashtable<TypeElement, Integer> getElementEchafs() {
		if (elementEchafs == null) {
			initHashtable();
		}
		return elementEchafs;
	}

	/**
	 * Constructeur vide<br/>
	 */
	public Echafaudage() {
		super();
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Constructeur de la Class<br/>
	 * 
	 * @param constructeur
	 * @param type
	 * @param classe
	 * @param elements
	 */
	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe, List<ElementEchaf> elements) {
		this(constructeur, type, classe);
		setListElementEchaf(elements);
	}

	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe) {
		this();
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

	public Enumeration<TypeElement> getDistinctElements() {
		return getElementEchafs().keys();
	}

	public int getElementCount(TypeElement element) {
		return getElementEchafs().get(element);
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

		BigDecimal bd = new BigDecimal(poids);
		bd = bd.setScale(2, BigDecimal.ROUND_DOWN);
		poids = bd.doubleValue();

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

			if (getPositionDesElements().get(el) == getNumDuDernierEtage())
				surface = surface + el.getSurface();
			if (getPositionDesElements().get(el) == getNumDuDernierEtage() - 1)
				surface = surface + el.getSurface() / 2;
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
			if (el.getSurface() != 0) {
				elEchafs.add(el);
			}
		}

		return elEchafs;

	}

	/**
	 * 
	 * @return Le nombre de pieds d'echafaudage<br/>
	 * @throws Exception
	 *             l'echafaudage n'a pas de pieds<br/>
	 */
	public int getNbDePieds() throws Exception {

		List<ElementEchaf> elEchafs = new ArrayList<ElementEchaf>();

		for (ElementEchaf el : getElements()) {
			if (el.getTypeElement().isPied())
				elEchafs.add(el);
		}

		if (elEchafs.size() == 0)
			throw new Exception("L'echafaudage doit contenir des pieds");

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

	private double getSurfaceCale() throws Exception {

		return (getChargeAReprendre() / getNbDePieds()) / getTypeSol().getChargeAdmissible();
	}

	public double getDimensionCale() throws Exception {

		double dim = 0.0;
		dim = Math.sqrt(getSurfaceCale());

		if (dim < 20)
			return 20;

		return dim;
	}

	public double getChargeAReprendre() {

		return getPoidsPropre() + getChargeExploitation();
	}

}
