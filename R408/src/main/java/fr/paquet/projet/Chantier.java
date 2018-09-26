package fr.paquet.projet;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.paquet.echafaudage.Echafaudage;

@XStreamAlias("chantier")
@Entity
@Table(name = "CHANTIER")
public class Chantier implements Aadresse {

	/**
	 * 
	 */
	@XStreamOmitField
	@Id
	@Column(name = "CHCHID")
	@GeneratedValue
	private long iD = 0;

	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse = null;

	@OneToOne(cascade = CascadeType.ALL)
	private Echafaudage echafaudage = null;

	@XStreamOmitField
	@OneToOne
	private Projet projet = null;

	public Chantier() {
		super();
	}

	public Chantier(Projet projet, Echafaudage echaf) {

		this();
		setProjet(projet);
		setEchafaudage(echaf);
	}

	public Adresse getAdresse() {
		if (adresse == null)
			return getProjet().getClient().getAdresse();
		else
			return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Echafaudage getEchafaudage() {
		return echafaudage;
	}

	public void setEchafaudage(Echafaudage echafaudage) {
		this.echafaudage = echafaudage;
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
