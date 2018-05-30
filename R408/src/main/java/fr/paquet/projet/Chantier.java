package fr.paquet.projet;

import javax.persistence.*;

import fr.paquet.echafaudage.Echafaudage;

@Entity
@Table(name = "CHANTIER")
public class Chantier implements Aadresse{
	
	/**
	 * 
	 */
	@Id
	@Column(name = "CHCHID")
	@GeneratedValue
	private long iD = 0;
	
	@ManyToOne
	private Adresse adresse = null;
	
	@OneToOne
	private Echafaudage echafaudage = null;
	
	public Chantier() {
		super();
	}
	
	public Chantier(Adresse adresse, Echafaudage echaf) {
		
		this();
		setAdresse(adresse);
		setEchafaudage(echaf);
	}

	public Adresse getAdresse() {
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

}
