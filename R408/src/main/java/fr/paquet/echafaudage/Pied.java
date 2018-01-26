package fr.paquet.echafaudage;

import javax.persistence.*;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "ELELNA")),
		@AttributeOverride(name = "reference", column = @Column(name = "ELELID")),
		@AttributeOverride(name = "poids", column = @Column(name = "ELELPO")) })
public class Pied extends ElementEchaf {

	/**
	 * @author Nathanaël
	 * 
	 *         Class qui gere les pieds d'echafaudage<br/>
	 */

	public Pied() {
		super();
	}

}
