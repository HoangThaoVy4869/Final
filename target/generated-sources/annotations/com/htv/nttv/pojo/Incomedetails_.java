package com.htv.nttv.pojo;

import com.htv.nttv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Incomedetails.class)
public class Incomedetails_ { 

    public static volatile SingularAttribute<Incomedetails, Long> income;
    public static volatile SingularAttribute<Incomedetails, Date> date;
    public static volatile SingularAttribute<Incomedetails, String> name;
    public static volatile SingularAttribute<Incomedetails, String> description;
    public static volatile SingularAttribute<Incomedetails, Integer> id;
    public static volatile SingularAttribute<Incomedetails, User> userId;

}