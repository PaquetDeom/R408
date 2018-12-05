package fr.paquet.projet;

import java.util.regex.Pattern;

import javax.persistence.*;
import javax.validation.constraints.Null;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("adresses")
@Entity
@Table(name = "ADRESSE")
public class Adresse {

	/**
	 * @author Nathanaël
	 * 
	 *         La class gere les adresses<br/>
	 */

	@XStreamOmitField
	@Id
	@GeneratedValue
	@Column(name = "ADADID")
	private long id = 0;

	@Column(name = "ADADAD1", length = 100)
	private String adresse1 = null;

	@Column(name = "ADADAD2", length = 100)
	private String adresse2 = null;

	@Column(name = "ADADAD3", length = 100)
	private String adresse3 = null;

	@Column(name = "ADADAD4", length = 100)
	private String adresse4 = null;

	@Column(name = "ADADCM", length = 100)
	private String com = null;

	@Column(name = "ADADCO", length = 100)
	private String codeCommune = null;

	//@OneToOne(cascade = CascadeType.DETACH)
	//private Commune commune = null;

	@Column(name = "ADADMAIL", length = 100)
	private String mail = null;

	@Column(name = "ADADTEL", length = 20)
	private String tel = null;

	/**
	 * Constructeur vide<br/>
	 */
	public Adresse() {
		super();
	}

	public Adresse(String add1, String add2, String add3, String add4, String codeCommune, String commune)
			throws Exception {
		this();
		setAdresse1(add1);
		setAdresse2(add2);
		setAdresse3(add3);
		setAdresse4(add4);
		setCodeCommune(codeCommune);
		setCom(commune);
	}

	public void setId(long id) {

		this.id = id;
	}

	public void setAdresse1(String adresse) {
		if (adresse != null)
			this.adresse1 = adresse.trim();
	}

	public void setAdresse2(String adresse) {
		if (adresse != null)
			this.adresse2 = adresse.trim();
	}

	public void setAdresse3(String adresse) {
		if (adresse != null)
			this.adresse3 = adresse.trim();
	}

	public void setAdresse4(String adresse) {
		if (adresse != null)
			this.adresse4 = adresse.trim();
	}

	public void setMail(String mail) throws Exception {

		mail = mail.trim();
		boolean a = false;
		a = Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", mail);

		if (a == false)
			throw new Exception("Adresse mail invalide");
		this.mail = mail;
	}

	public void setTelephone(String tel) throws Exception {

		tel = tel.trim();
		boolean a = false;
		a = Pattern.matches("^(\\\\+33|0|0033)[0-9]{9}$", tel);

		if (a == false)
			throw new Exception("Numéros invalide");
		this.tel = tel;
	}

	/**
	 * 
	 * @return le ligne d'adresse 1 sans espace a droite et a gauche<br/>
	 */
	public String getAdresse1() {
		return adresse1;
	}

	/**
	 * 
	 * @return le ligne d'adresse 2 sans espace a droite et a gauche<br/>
	 */
	public String getAdresse2() {
		return adresse2;
	}

	/**
	 * 
	 * @return le ligne d'adresse 3 sans espace a droite et a gauche<br/>
	 */
	public String getAdresse3() {
		return adresse3;
	}

	/**
	 * 
	 * @return le ligne d'adresse 1 sans espace a droite et a gauche<br/>
	 */
	public String getAdresse4() {
		return adresse4;
	}

	/**
	 * 
	 * @return La commune et son code postal<br/>
	 * @throws Exception
	 */
	/**public Commune getCommune() throws Exception {
		if (commune == null) {
			if (getCodeCommune() == null || getCom() == null)
				throw new Exception("La commune ne peut pas être crée");
			commune = new Commune(getCodeCommune(), getCom());
		}
		return commune;
	}*/

	/**
	 * 
	 * @return une adresse mail sous forme dddddd@dddd.ddd<br/>
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @return Le numeros de telephone sous la forme 03.25.65.21.41<br/>
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 
	 * @return L'id pour la gestion de la DB<br/>
	 */
	public long getId() {
		return id;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com.trim().toUpperCase();
	}

	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) throws Exception {

		codeCommune = codeCommune.trim().toUpperCase();
		boolean a = false;
		a = Pattern.matches("([0-9]([0-9]||[AB])[0-9][0-9][0-9])", codeCommune);

		if (a == false)
			throw new Exception("Saisi du code commune invalide");
		this.codeCommune = codeCommune;
	}

}
