package fr.paquet.echafaudage.element;

import fr.paquet.echafaudage.Constructeur;
import fr.paquet.echafaudage.TypeEchaf;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-01-03T12:20:54.648+0100")
@StaticMetamodel(TypeElement.class)
public class TypeElement_ {
	public static volatile SingularAttribute<TypeElement, String> ref;
	public static volatile SingularAttribute<TypeElement, String> name;
	public static volatile SingularAttribute<TypeElement, Constructeur> cons;
	public static volatile SingularAttribute<TypeElement, Double> poids;
	public static volatile SingularAttribute<TypeElement, TypeEchaf> tE;
}
