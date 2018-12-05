package fr.paquet.projet;

import java.util.regex.Pattern;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

@Entity
@Table(name = "COMMUNE")
public class Commune {

	/**
	 * @author Nathanaël
	 * 
	 *         La class gere les communes ainsi que leur code postaux<br/>
	 */

	@XStreamOmitField
	@Id
	@GeneratedValue
	@Column(name = "COCOID")
	private double id = 0;

	@Column(name = "CMCMCOMMUNE", length = 50)
	private String commune = null;

	@Column(name = "CMCMCODE_COMMUNE", length = 20)
	private String codeCommune = null;

	/**
	 * Constructeur vide pour la gestion de la DB<br/>
	 */
	public Commune() {
		super();
	}

	/**
	 * Constructeur de la class
	 * 
	 * @param codePostal
	 *            Saisi d'une String<br/>
	 * @param commune
	 *            Saisi d'une String<br/>
	 * @throws Exception
	 *             si le code postal n'est pas de type 31500<br/>
	 */
	public Commune(String codeCommune, String commune) throws Exception {
		this();
		setCodeCommune(codeCommune);
		setCommune(commune);
	}

	private void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	private void setCommune(String commune) {
		this.commune = commune;
	}

	/**
	 * 
	 * @return Le code de la commune<br/>
	 */
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * 
	 * @return La commune sans espace a droite et a gauche et en majuscule<br/>
	 */
	public String getCommune() {
		return commune;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

}
