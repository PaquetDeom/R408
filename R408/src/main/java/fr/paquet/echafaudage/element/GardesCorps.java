package fr.paquet.echafaudage.element;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@XStreamAlias("gardes corps")
@Entity
@Table(name = "GARDESCORPS")
@AttributeOverrides({ @AttributeOverride(name = "ref", column = @Column(name = "TYTYID")),
		@AttributeOverride(name = "name", column = @Column(name = "TYTYNA")),
		@AttributeOverride(name = "poids", column = @Column(name = "TYTYPO")) })
public class GardesCorps extends TypeElement {
	
	@Column(name = "GAGALO")
	private double longueur = 0.0;
	
	public GardesCorps() {
		super();
	}

	public GardesCorps(String name, String ref, Constructeur cons, double poids, TypeEchaf tE, double longueur) {
		super(name, ref, cons, poids, tE);
		setLongueur(longueur);
	}
	
	public double getLongueur() {
		return longueur;
	}

	private void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
	@Override
	public String getReference() {
		
		return ref;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public Constructeur getConstructeur() {
	
		return cons;
	}

	@Override
	public double getPoids() {
		
		return poids;
	}

	@Override
	public TypeEchaf getTypeEchaf() {
		
		return tE;
	}

	@Override
	public boolean isPied() {
		
		return false;
	}

	

}
