/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;

import com.htv.nttv.pojo.Incomedetails;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.IncomeTeamRepository;
import com.htv.nttv.service.IncomeTeamService;
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
public class IncomeTeamServiceImpl implements IncomeTeamService{
    
    @Autowired
    private IncomeTeamRepository incomeTeamRepository;

    @Override
    public List<Object[]> getIncomeTeam(Map<String, String> params, int page) {
        return this.incomeTeamRepository.getIncomeTeam(params, page);
    }

    @Override
    public boolean addIncomeTeam(Incomedetails d, User u) {
        return this.incomeTeamRepository.addIncomeTeam(d, u);
    }

    @Override
    public Incomedetails getIncomeTeamById(int id) {
        return this.incomeTeamRepository.getIncomeTeamById(id);
    }

    @Override
    public boolean updateIncomeTeam(Incomedetails d, User u) {
        return this.incomeTeamRepository.updateIncomeTeam(d, u);
    }

    @Override
    public boolean deleteIncomeTeam(int id) {
        return this.incomeTeamRepository.deleteIncomeTeam(id);
    }

    @Override
    public List<Object[]> statsIncomeTeam(Date fromDate, Date toDate) {
        return this.incomeTeamRepository.statsIncomeTeam(fromDate, toDate);
    }
    
}
