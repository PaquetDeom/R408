package fr.paquet.projet;

import fr.paquet.echafaudage.Echafaudage;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-03T12:20:54.651+0100")
@StaticMetamodel(Chantier.class)
public class Chantier_ {
	public static volatile SingularAttribute<Chantier, Long> iD;
	public static volatile SingularAttribute<Chantier, Adresse> adresse;
	public static volatile SingularAttribute<Chantier, Echafaudage> echafaudage;
	public static volatile SingularAttribute<Chantier, Projet> projet;
}
