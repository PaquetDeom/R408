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

import fr.paquet.echafaudage.element.Element;
import fr.paquet.echafaudage.element.EltByName;
import fr.paquet.echafaudage.element.EltByNameFactory;
import fr.paquet.echafaudage.element.InstanciationElement;
import fr.paquet.echafaudage.element.Plateau;

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

	@OneToMany(cascade = CascadeType.ALL)
	private List<Element> elements = null;

	@ManyToOne(cascade = CascadeType.ALL)
	@XStreamAsAttribute
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
	private PropertyChangeSupport changeSupport = null;

	@XStreamOmitField
	@Transient
	private Hashtable<InstanciationElement, Integer> elementEchafs = null;

	/**
	 * 
	 * @return le numéros du dernier étage d'un échafaudage<br/>
	 */
	private int getNumDuDernierEtage() {

		int a = 0;

		for (int i = 0; i < getElements().size(); i++) {
			Element el = getElements().get(i);
			if (el.getPosition() > a)
				a = el.getPosition();
		}
		return a;
	}

	/**
	 * Compte le nombre de type d'élément selon son origine d'instanciation<br/>
	 */
	private void initHashtable() {
		elementEchafs = new Hashtable<InstanciationElement, Integer>();

		for (Element el : getElements()) {

			if (elementEchafs.get(el.getInst()) == null)
				elementEchafs.put(el.getInst(), 1);
			else
				elementEchafs.put(el.getInst(), elementEchafs.get(el.getInst()) + 1);
		}
	}

	/**
	 * 
	 * @return L'énumération des clés de la hashtable getElementEchafs()<br/>
	 */
	public Enumeration<InstanciationElement> getDistinctElements() {
		return getElementEchafs().keys();
	}

	/**
	 * 
	 * @param inst
	 *            de type InstanciationElement
	 * @return les valeurs de la hashtable getElemntEchafs() en fonction de leurs
	 *         clés<br/>
	 */
	public int getElementCount(InstanciationElement inst) {
		return getElementEchafs().get(inst);
	}

	/**
	 * 
	 * @return le nombre d'élément par TypeElement<br/>
	 */
	private Hashtable<InstanciationElement, Integer> getElementEchafs() {
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
	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe, List<Element> elements) {
		this(constructeur, type, classe);
		setListElementEchaf(elements);
	}

	public Echafaudage(Constructeur constructeur, TypeEchaf type, ClasseEchaf classe) {
		this();
		setConstructeur(constructeur);
		setTypeEchaf(type);
		setClasseEchaf(classe);
		setListElementEchaf(new ArrayList<Element>());
	}

	public void setChangeSupport(PropertyChangeSupport pCS) {
		this.changeSupport = pCS;
	}

	private PropertyChangeSupport getChangeSupport() {
		return changeSupport;
	}

	private void setListElementEchaf(List<Element> elements) {
		this.elements = elements;
	}

	public void addElement(Element element) throws Exception {
		if (element.getType().getConstructeur() == getConstructeur()
				&& element.getType().getTypeEchaf() == getTypeEchaf()) {
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
	public List<Element> getElements() {
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

		for (Element elEchaf : getElements()) {
			poids = poids + elEchaf.getType().getPoids();
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

		// crée la variable de méthode surface de type double
		double surface = 0;

		// pour un element de la liste des Element getPlateau
		for (Element el : getPlateau()) {

			// L'obj pl est elt de type Type element transformer en type Plateau
			Plateau pl = (Plateau) el.getType();

			// si la position de elt est égale au numéros du dernier étage
			if (el.getPosition() == getNumDuDernierEtage())
				// surface = surface + la surface du plateau
				surface = surface + pl.getSurface();
			// si la position de elt est égale au numéros du dernier étage -1
			if (el.getPosition() == getNumDuDernierEtage() - 1)
				// surface = surface + la surface du plateau/2
				surface = surface + (pl.getSurface() / 2);
		}
		return surface;
	}

	/**
	 * 
	 * @return la liste des plateaux d'echafaudage<br/>
	 */
	private List<Element> getPlateau() {

		// crée une liste d'Element
		List<Element> lElt = new ArrayList<Element>();
		// crée un EltByNameFactory
		EltByNameFactory elt = new EltByNameFactory();

		// pour un element el de la liste getElements()
		for (Element el : getElements()) {

			// cherche un EltByName par le nom de l'element
			EltByName eltType = elt.findEltByNameByName(el.getType().getName());
			// si eltType est de type plateau
			if (eltType.getIntanc().equals(InstanciationElement.plateau))
				// add la liste lElt
				lElt.add(el);

		}

		return lElt;
	}

	/**
	 * 
	 * @return Le nombre de pieds d'echafaudage<br/>
	 * @throws Exception
	 *             l'echafaudage n'a pas de pieds<br/>
	 */
	public int getNbDePieds() throws Exception {

		int nbDePieds = 0;

		for (Element el : getElements()) {
			if (el.getType().isPied() == true)
				nbDePieds = nbDePieds + 1;
		}

		if (nbDePieds == 0)
			throw new Exception("L'echafaudage doit contenir des pieds");

		return nbDePieds;

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

	public void setListElements(List<Element> elements) {
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
