package fr.paquet.projet;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "RESPONSABLE")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "REREID")),
		@AttributeOverride(name = "nom", column = @Column(name = "RERENOM", length = 20)),
		@AttributeOverride(name = "prenom", column = @Column(name = "REREPRENOM", length = 50)), })
public class Responsable extends Personne {

	/**
	 * 
	 */

	@Transient
	private List<Projet> projets = null;

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Responsable() {
		super();
	}

	/**
	 * Constructeur de la Class<br/>
	 * 
	 * @param nom
	 * @param prenom
	 */
	public Responsable(String nom, String prenom) {
		super(nom, prenom);
		getProjets();

	}

	/**
	 * 
	 * @return La liste de projet du responsable<br/>
	 */
	public List<Projet> getProjets() {
		if (projets == null)
			projets = new ArrayList<Projet>();
		return projets;
	}

	public String toString() {
		return getNom() + " " + getPrenom();
	}
	

}
