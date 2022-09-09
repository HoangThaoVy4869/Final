/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository;

import com.htv.nttv.pojo.Income;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public interface IncomeRepository {
    List<Income> getIncome(Map<String, String> params, int page, String kw);
    boolean addIncome(Income in);
    boolean updateIncome(Income in);
    boolean deleteIncome(int id);
    int countIncome();
    List<Object[]> statsIncome(Date fromDate, Date toDate);
    Income getIncomeById(int id);
}
