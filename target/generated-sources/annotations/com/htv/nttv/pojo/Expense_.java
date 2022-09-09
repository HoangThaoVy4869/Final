package com.htv.nttv.pojo;

import com.htv.nttv.pojo.Category;
import com.htv.nttv.pojo.Transaction;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Expense.class)
public class Expense_ { 

    public static volatile SingularAttribute<Expense, Date> date;
    public static volatile CollectionAttribute<Expense, Transaction> transactionCollection;
    public static volatile SingularAttribute<Expense, String> note;
    public static volatile SingularAttribute<Expense, Long> amount;
    public static volatile SingularAttribute<Expense, String> name;
    public static volatile SingularAttribute<Expense, Integer> id;
    public static volatile SingularAttribute<Expense, Category> categoryId;

}