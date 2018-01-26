package fr.paquet.echafaudage;

import javax.persistence.*;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "ELELNA")),
		@AttributeOverride(name = "reference", column = @Column(name = "ELELID")),
		@AttributeOverride(name = "poids", column = @Column(name = "ELELPO")) })
public class Plateforme extends ElementEchaf {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere les plateForme<br/>
	 */

	private double surface = 0;

	public Plateforme() {
		super();
	}

	public Plateforme(double surface) throws Exception {
		super();
		setSurface(surface);
	}

	private void setSurface(double surface) throws Exception {
		this.surface = surface;
	}

	/**
	 * 
	 * @return La surface de la plateforme en m²<br/>
	 */
	public double getSurface() {
		return surface;
	}

}
