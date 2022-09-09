/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service;

import com.htv.nttv.pojo.Incomedetails;
import com.htv.nttv.pojo.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public interface IncomeTeamService {
    List<Object[]> getIncomeTeam(Map<String, String> params, int page);
    boolean addIncomeTeam(Incomedetails d, User u);
    Incomedetails getIncomeTeamById(int id);
    boolean updateIncomeTeam(Incomedetails d, User u);
    boolean deleteIncomeTeam(int id);
    List<Object[]> statsIncomeTeam (Date fromDate, Date toDate);

}
