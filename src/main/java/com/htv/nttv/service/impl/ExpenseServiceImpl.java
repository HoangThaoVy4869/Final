/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;

import com.htv.nttv.pojo.Expense;
import com.htv.nttv.respository.ExpenseRespository;
import com.htv.nttv.service.ExpenseService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private  ExpenseRespository expenseRespository;
    
    @Override
    public List<Expense> getExpense(Map<String, String> params, int page, String kw) {
        return this.expenseRespository.getExpense(params, page, kw);   
    }
    
    @Override
    public boolean addExpense(Expense em) {      
        return this.expenseRespository.addExpense(em);
    }

    @Override
    public int countExpense() {
        return this.expenseRespository.countExpense();
    }
    
    @Override
    public Expense geExpenseById(int id){
        return this.expenseRespository.geExpenseById(id);
    }

    @Override
    public boolean updateExpense(Expense em) {
        return this.expenseRespository.updateExpense(em);
    }

    @Override
    public boolean deleteExpense(int id) {
        return this.expenseRespository.deleteExpense(id);
    }

    @Override
    public List<Object[]> statsExpense(Date fromDate, Date toDate) {
        return this.expenseRespository.statsExpense(fromDate, toDate);
    }
    
    @Override
    public List<Object[]> statsExpenseMonth(Date fromDate) {
        return this.expenseRespository.statsExpenseMonth(fromDate);
    }

    
}
