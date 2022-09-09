/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository;

import com.htv.nttv.pojo.Expense;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public interface ExpenseRespository {
    List<Expense> getExpense(Map<String, String> params, int page, String kw);
    boolean addExpense(Expense em);
    boolean updateExpense(Expense em);
    boolean deleteExpense(int id);
    int countExpense();
    List<Object[]> statsExpense(Date fromDate, Date toDate);
    Expense geExpenseById(int id);
    List<Object[]> statsExpenseMonth(Date fromDate);
}
