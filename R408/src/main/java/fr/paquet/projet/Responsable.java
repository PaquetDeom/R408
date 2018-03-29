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

	@ManyToMany
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

	public void addProjet(Projet projet) {
		if (!getProjets().contains(projet))
			getProjets().add(projet);
	}

	public void removeProjet(Projet projet) {
		if (getProjets().contains(projet))
			getProjets().remove(projet);
	}
}
