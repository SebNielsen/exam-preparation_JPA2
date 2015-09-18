package Entities;

import Entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-17T14:16:51")
@StaticMetamodel(Supervisor.class)
public class Supervisor_ { 

    public static volatile ListAttribute<Supervisor, Person> supervises;
    public static volatile SingularAttribute<Supervisor, Person> person;
    public static volatile SingularAttribute<Supervisor, Long> id;

}