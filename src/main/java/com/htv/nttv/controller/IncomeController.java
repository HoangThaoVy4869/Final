/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Income;
import com.htv.nttv.service.IncomeService;
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
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @GetMapping("/incomeList")
    public String index(Model model, @RequestParam Map<String, String> params) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("income", this.incomeService.getIncome(params, page, kw));
        model.addAttribute("counter", this.incomeService.countIncome());
        return "listIncome";
    }
    
    @GetMapping("/income")
    public String list(Model model) {
        model.addAttribute("income", new Income());
        return "addIncome";
    }
    
    @PostMapping("/income")
    public String addIncome(Model model, @ModelAttribute(value = "income") @Valid Income in,
            BindingResult r) {

        if (!r.hasErrors()) {
            if (this.incomeService.addIncome(in) == true) {
                return "redirect:/user/incomeList";
            } else {
                model.addAttribute("errMsg", "Error!!!!!");
            }
        }
        return "addIncome";
    }
    
    @GetMapping("/editIncome/{id}")
    public String editIncome(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("income", this.incomeService.getIncomeById(id));
        return "updateIncome";
    }
    
    @PostMapping("/editIncome/updateIncome")
    public String updateIncome(Model model, @ModelAttribute(value = "income") @Valid Income in, 
            BindingResult r) {

        if (!r.hasErrors()) {
            if (this.incomeService.updateIncome(in) == true) {
                return "redirect:/user/incomeList"; 
            } else {
                model.addAttribute("errMsg", "Error!!!!!");
            }
        }
        return "updateIncome";
    }
    
    @GetMapping("/deleteIncome/{id}")
    public String deleteIncome(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("income", this.incomeService.deleteIncome(id));
        return "redirect:/user/incomeList";
    }
    
    @GetMapping("/detailsIncome/{id}")
    public String detailsIncome(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("income", this.incomeService.getIncomeById(id));
        return "detailsIncome";
    }
    
    @GetMapping("/statsIncome")
    public String statsIncome(Model model, @RequestParam(required = false) Map<String, String> params){
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
          
        model.addAttribute("statsIncome", this.incomeService.statsIncome(fromDate, toDate));
        return "statsIncome";
    }
    
}
