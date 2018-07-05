package fr.paquet.projet;

import java.util.*;

import javax.persistence.*;

import javax.persistence.OneToOne;
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

	@Transient
	private List<Projet> projets = null;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse = null;

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Client() {
		super();

	}

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom) {
		super(nom, prenom);
	}

	public void setAdresse(Adresse adresse) {
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

	public String toString() {
		return getNom() + " " + getPrenom();
	}
}
