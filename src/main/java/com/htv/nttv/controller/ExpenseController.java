/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Expense;
import com.htv.nttv.service.ExpenseService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("/user")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expense")
    public String list(Model model) {
        model.addAttribute("expense", new Expense());
        return "addExpense";
    }

    @PostMapping("/expense")
    public String addExpense(Model model, @ModelAttribute(value = "expense") @Valid Expense em,
            BindingResult r) {

        if (!r.hasErrors()) {
            if (this.expenseService.addExpense(em) == true) {
                return "redirect:/home";
            } else {
                model.addAttribute("errMsg", "Error!!!!!");
            }
        }
        return "addExpense";
    }
    
    @GetMapping("/editExpense/{id}")
    public String editExpense(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("expense", this.expenseService.geExpenseById(id));
        return "updateExpense";
    }
    
    @PostMapping("/editExpense/updateExpense")
    public String updateExpense(Model model, @ModelAttribute(value = "expense") @Valid Expense em, 
            BindingResult r) {

        if (!r.hasErrors()) {
            if (this.expenseService.updateExpense(em) == true) {
                return "redirect:/home"; 
            } else {
                model.addAttribute("errMsg", "Error!!!!!");
            }
        }
        return "updateExpense";
    }
    
    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("expense", this.expenseService.deleteExpense(id));
        return "redirect:/home";
    }
    
    @GetMapping("/detailsExpense/{id}")
    public String detailsExpense(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("expense", this.expenseService.geExpenseById(id));
        return "detailsExpense";
    }
    
    @GetMapping("/statsExpense")
    public String statsExpense(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        
        try {
            String d = params.getOrDefault("fromDate", null);
            if (d != null) {
                fromDate = f.parse(d);
            }

            String t = params.getOrDefault("toDate", null);
            if (t != null)
                toDate = f.parse(t);
        
        } catch (ParseException ex){
            ex.printStackTrace();
        }
          
        model.addAttribute("statsExpense", this.expenseService.statsExpense(fromDate, toDate));
        return "statsExpense";
    }
    
    @GetMapping("/statsExpenseMonth")
    public String statsExpenseMonth(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        
        Date fromDate = null, toDate = null;
        try {
            String d = params.getOrDefault("now", null);
            if(d != null)
                fromDate = f.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("statsExpenseMonth", this.expenseService.statsExpenseMonth(fromDate));
        return "statsExpenseMonth";
    }
    
}
