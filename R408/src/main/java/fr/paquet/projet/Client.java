package fr.paquet.projet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "CLCLID")),
		@AttributeOverride(name = "nom", column = @Column(name = "CLCLNOM", length = 20)),
		@AttributeOverride(name = "prenom", column = @Column(name = "CLCLPRENOM", length = 50)), })
public class Client extends Personne implements Aadresse {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere les clients<br/>
	 */

	@ManyToMany
	private List<Projet> projets = null;

	@ManyToOne
	private Adresse adresse = null;

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Client() {
		super();

	}

	/**
	 * 
	 * @param listener
	 */
	public Client(PropertyChangeListener listener) {
		this();
		addPropertyChangeListener(listener);
	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 */
	public Client(PropertyChangeListener listener, String nom, String prenom, Adresse adresse) {
		super(nom, prenom);
		setAdresse(adresse);
		addPropertyChangeListener(listener);
	}

	private void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * @return La liste des projets d'un client<br/>
	 */
	public List<Projet> getProjets() {
		if (projets == null)
			projets = new ArrayList<Projet>();
		return projets;
	}

	public void addProjet(Projet projet) {
		getProjets().add(projet);
	}

	@Override
	/**
	 * @return L'adresse du client<br/>
	 */
	public Adresse getAdresse() {
		return adresse;
	}

}
