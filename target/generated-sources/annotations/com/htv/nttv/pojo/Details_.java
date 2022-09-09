package com.htv.nttv.pojo;

import com.htv.nttv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Details.class)
public class Details_ { 

    public static volatile SingularAttribute<Details, Date> date;
    public static volatile SingularAttribute<Details, String> name;
    public static volatile SingularAttribute<Details, String> description;
    public static volatile SingularAttribute<Details, Integer> id;
    public static volatile SingularAttribute<Details, Long> expense;
    public static volatile SingularAttribute<Details, User> userId;

}