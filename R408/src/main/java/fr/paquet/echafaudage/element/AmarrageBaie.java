package fr.paquet.echafaudage.element;

import javax.persistence.*;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;

@XStreamAlias("Amarrage baie")
@Entity
@Table(name = "AMARRAGEBAIE")
@AttributeOverrides({ @AttributeOverride(name = "ref", column = @Column(name = "TYTYID")),
		@AttributeOverride(name = "name", column = @Column(name = "TYTYNA")),
		@AttributeOverride(name = "poids", column = @Column(name = "TYTYPO")) })
public class AmarrageBaie extends TypeElement {

	public AmarrageBaie() {
		super();
	}

	public AmarrageBaie(String name, String ref, Constructeur cons, double poids, TypeEchaf tE) {
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
