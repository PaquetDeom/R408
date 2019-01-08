package fr.paquet.echafaudage.element;

import fr.paquet.echafaudage.Echafaudage;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-03T12:20:54.634+0100")
@StaticMetamodel(Element.class)
public class Element_ {
	public static volatile SingularAttribute<Element, Long> id;
	public static volatile SingularAttribute<Element, Integer> position;
	public static volatile SingularAttribute<Element, InstanciationElement> inst;
	public static volatile SingularAttribute<Element, Echafaudage> echafaudage;
}
