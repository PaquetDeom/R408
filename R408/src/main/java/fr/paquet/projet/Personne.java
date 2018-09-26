package fr.paquet.projet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.persistence.*;

import org.w3c.dom.Element;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {

	/**
	 * 
	 */

	@XStreamOmitField
	@Id
	@Column(name = "PEPEID")
	@GeneratedValue
	private long id = 0;

	@Column(name = "PEPENO", length = 20)
	private String nom = null;

	@Column(name = "PEPEPR", length = 20)
	private String prenom = null;

	@XStreamOmitField
	@Transient
	private PropertyChangeSupport changeSupport = null;

	protected PropertyChangeSupport getChangeSupport() {
		if (changeSupport == null)
			changeSupport = new PropertyChangeSupport(this);
		return changeSupport;
	}

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		this();
		setNom(nom);
		setPrenom(prenom);
	}

	/**
	 * 
	 * @return le nom sans espace à droite et à gauche et en majuscule<br/>
	 */
	public synchronized String getNom() {
		return nom;
	}

	public synchronized void setNom(String nom) {

		if (!nom.equals("") && nom != null) {
			nom = nom.trim().toUpperCase();
			String oldValue = this.nom;
			this.nom = nom;
			getChangeSupport().firePropertyChange("nom", oldValue, nom);
		}
		this.nom = nom;

	}

	public long getiD() {
		return id;
	}

	public void setiD(long iD) {
		this.id = iD;
	}

	/**
	 * 
	 * @return le prenom sans espace à droite et à gauche avec la première lettre en
	 *         majuscule<br/>
	 */
	public String getPrenom() {

		return prenom;
	}

	public synchronized void setPrenom(String prenom) {
		if (!prenom.trim().equals("")) {
			prenom = prenom.trim().toLowerCase();
			prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
		}

		if (!prenom.equals("") || prenom != null) {
			String oldValue = this.prenom;
			this.prenom = prenom;
			getChangeSupport().firePropertyChange("prenom", oldValue, prenom);
		}

		this.prenom = prenom;
	}

	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {

		getChangeSupport().addPropertyChangeListener(l);

	}
}
