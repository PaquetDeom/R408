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

	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		nom = nom.trim().toLowerCase();
		nom = nom.replaceFirst(".", (nom.charAt(0) + "").toUpperCase());
		this.nom = nom;
	}

	public long getiD() {
		return id;
	}

	private void setiD(long iD) {
		this.id = iD;
	}

	public String getPrenom() {
		
		return prenom;
	}

	private void setPrenom(String prenom) {
		prenom = prenom.trim().toLowerCase();
		prenom = prenom.replaceFirst(".", (nom.charAt(0) + "").toUpperCase());
		this.prenom = prenom;
	}

}
