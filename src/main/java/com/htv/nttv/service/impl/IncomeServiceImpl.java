/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;

import com.htv.nttv.pojo.Income;
import com.htv.nttv.respository.IncomeRepository;
import com.htv.nttv.service.IncomeService;
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
public class IncomeServiceImpl implements IncomeService{
    @Autowired
    private  IncomeRepository incomeRespository;
    
    @Override
     public List<Income> getIncome(Map<String, String> params, int page, String kw) {
        return this.incomeRespository.getIncome(params, page, kw);   
    }
    
    @Override
    public boolean addIncome(Income in) {      
        return this.incomeRespository.addIncome(in);
    }

    @Override
    public int countIncome() {
        return this.incomeRespository.countIncome();
    }
    
    @Override
    public Income getIncomeById(int id){
        return this.incomeRespository.getIncomeById(id);
    }

    @Override
    public boolean updateIncome(Income in) {
        return this.incomeRespository.updateIncome(in);
    }

    @Override
    public boolean deleteIncome(int id) {
        return this.incomeRespository.deleteIncome(id);
    }

    @Override
    public List<Object[]> statsIncome(Date fromDate, Date toDate) {
        return this.incomeRespository.statsIncome(fromDate, toDate);
    }
}
