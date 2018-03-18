package fr.paquet.projet;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {

	/**
	 * 
	 */

	@Id
	@Column(name = "PEPEID")
	@GeneratedValue
	private long id = 0;

	@Column(name = "PEPENO", length = 20)
	private String nom = null;

	@Column(name = "PEPEPR", length = 20)
	private String prenom = null;

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
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		nom = nom.trim().toUpperCase();
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
	 * @return le prenom sans espace à droite et à gauche avec la première
	 *         lettre en majuscule<br/>
	 */
	public String getPrenom() {

		return prenom;
	}

	public void setPrenom(String prenom) {
		if (!prenom.trim().equals("")) {
			prenom = prenom.trim().toLowerCase();
			prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
		}
		this.prenom = prenom;
	}

}
