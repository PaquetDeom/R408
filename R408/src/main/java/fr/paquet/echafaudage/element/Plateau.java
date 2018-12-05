package fr.paquet.echafaudage.element;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@XStreamAlias("plateau")
@Entity
@Table(name = "PLATEAU")
@AttributeOverrides({ @AttributeOverride(name = "ref", column = @Column(name = "TYTYID")),
		@AttributeOverride(name = "name", column = @Column(name = "TYTYNA")),
		@AttributeOverride(name = "poids", column = @Column(name = "TYTYPO")) })
public class Plateau extends TypeElement {

	@Column(name = "PLPLSU")
	private double surface = 0.0;
	
	@Column(name = "PLPLLO")
	private double longueur = 0.0;

	public Plateau() {
		super();

	}

	public Plateau(String name, String ref, Constructeur cons, double poids, TypeEchaf tE, double longueur,
			double surface) {
		super(name, ref, cons, poids, tE);
		setLongueur(longueur);
		setSurface(surface);
	}

	public double getLongueur() {
		return longueur;
	}

	private void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getSurface() {
		return surface;
	}

	private void setSurface(double surface) {
		this.surface = surface;
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
