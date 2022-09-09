package com.htv.nttv.pojo;

import com.htv.nttv.pojo.Category;
import com.htv.nttv.pojo.Transaction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Income.class)
public class Income_ { 

    public static volatile SingularAttribute<Income, Date> date;
    public static volatile CollectionAttribute<Income, Transaction> transactionCollection;
    public static volatile SingularAttribute<Income, String> note;
    public static volatile SingularAttribute<Income, Long> amount;
    public static volatile SingularAttribute<Income, String> name;
    public static volatile SingularAttribute<Income, Integer> id;
    public static volatile SingularAttribute<Income, Category> categoryId;

}