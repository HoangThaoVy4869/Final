/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service;

import com.htv.nttv.pojo.Details;
import com.htv.nttv.pojo.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public interface ExpenseTeamService {
    List<Object[]> getexpenseTeam(Map<String, String> params, int page);
    boolean addExpenseTeam(Details d, User u);
    Details geExpenseTeamById(int id);
    boolean updateExpenseTeam(Details d, User u);
    boolean deleteExpenseTeam(int id);
    List<Object[]> statsExpenseTeam (Date fromDate, Date toDate);
}
