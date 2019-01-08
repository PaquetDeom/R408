package fr.paquet.projet;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-03T12:20:54.654+0100")
@StaticMetamodel(Projet.class)
public class Projet_ {
	public static volatile SingularAttribute<Projet, Long> id;
	public static volatile SingularAttribute<Projet, String> titre;
	public static volatile SingularAttribute<Projet, Client> client;
	public static volatile SingularAttribute<Projet, Chantier> chantier;
	public static volatile SingularAttribute<Projet, Responsable> resp;
	public static volatile SingularAttribute<Projet, String> url;
}
