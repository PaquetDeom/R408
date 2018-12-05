package fr.paquet.echafaudage.element;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@XStreamAlias("consolePareGravois")
@Entity
@Table(name = "CONSOLEPAREGRAVOIS")
@AttributeOverrides({ @AttributeOverride(name = "ref", column = @Column(name = "TYTYID")),
		@AttributeOverride(name = "name", column = @Column(name = "TYTYNA")),
		@AttributeOverride(name = "poids", column = @Column(name = "TYTYPO")) })
public class ConsolePareGravois extends TypeElement {

	public ConsolePareGravois() {
		super();
	}

	public ConsolePareGravois(String name, String ref, Constructeur cons, double poids, TypeEchaf tE) {
		super(name, ref, cons, poids, tE);
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
