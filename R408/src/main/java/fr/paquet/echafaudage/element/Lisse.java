package fr.paquet.echafaudage.element;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@XStreamAlias("lisse")
@Entity
@Table(name = "LISSE")
@AttributeOverrides({ @AttributeOverride(name = "ref", column = @Column(name = "TYTYID")),
		@AttributeOverride(name = "name", column = @Column(name = "TYTYNA")),
		@AttributeOverride(name = "poids", column = @Column(name = "TYTYPO")) })
public class Lisse extends TypeElement{
	
	@Column(name = "LILINA")
	private double longueur = 0.0;
	
	public Lisse() {
		super();
	}

	public Lisse(String name, String ref, Constructeur cons, double poids, TypeEchaf tE, double longueur) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPoids() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TypeEchaf getTypeEchaf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPied() {
		// TODO Auto-generated method stub
		return false;
	}

}
