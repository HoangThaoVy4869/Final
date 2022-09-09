package com.htv.nttv.pojo;

import com.htv.nttv.pojo.Expense;
import com.htv.nttv.pojo.Income;
import com.htv.nttv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-05T01:57:23")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Income> incomeId;
    public static volatile SingularAttribute<Transaction, Expense> expenseId;
    public static volatile SingularAttribute<Transaction, Integer> id;
    public static volatile SingularAttribute<Transaction, User> userId;

}