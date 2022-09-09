/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;

import com.htv.nttv.pojo.Details;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.ExpenseTeamRepository;
import com.htv.nttv.service.ExpenseTeamService;
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
public class ExpenseTeamServiceImpl implements ExpenseTeamService{

    @Autowired
    private  ExpenseTeamRepository expenseTeamRepository;
    
    @Override
    public List<Object[]> getexpenseTeam(Map<String, String> params, int page) {
        return this.expenseTeamRepository.getexpenseTeam(params, page);
    }

    @Override
    public boolean addExpenseTeam(Details d, User u) {
        return this.expenseTeamRepository.addExpenseTeam(d, u);
    }

    @Override
    public Details geExpenseTeamById(int id) {
        return this.expenseTeamRepository.geExpenseTeamById(id);
    }

    @Override
    public boolean updateExpenseTeam(Details d, User u) {
        return this.expenseTeamRepository.updateExpenseTeam(d, u);
    }
    
    @Override
    public boolean deleteExpenseTeam(int id) {
        return this.expenseTeamRepository.deleteExpenseTeam(id);
    }

    @Override
    public List<Object[]> statsExpenseTeam(Date fromDate, Date toDate) {
        return this.expenseTeamRepository.statsExpenseTeam(fromDate, toDate);
    }
}
