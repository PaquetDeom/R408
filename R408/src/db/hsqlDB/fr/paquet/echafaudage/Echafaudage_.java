package fr.paquet.echafaudage;

import fr.paquet.echafaudage.element.Element;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-03T12:20:54.626+0100")
@StaticMetamodel(Echafaudage.class)
public class Echafaudage_ {
	public static volatile SingularAttribute<Echafaudage, Long> id;
	public static volatile ListAttribute<Echafaudage, Element> elements;
	public static volatile SingularAttribute<Echafaudage, Constructeur> constructeur;
	public static volatile SingularAttribute<Echafaudage, TypeEchaf> type;
	public static volatile SingularAttribute<Echafaudage, ClasseEchaf> classe;
	public static volatile SingularAttribute<Echafaudage, TypeSol> typeSol;
}
