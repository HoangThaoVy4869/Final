/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Details;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.UserRepository;
import com.htv.nttv.service.ExpenseTeamService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ExpenseTeamController {

    @Autowired
    private ExpenseTeamService expenseTeamService;

    @GetMapping("/expenseTeamList")
    public String expenseTeamList(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("expenseTeam", this.expenseTeamService.getexpenseTeam(params, page));
        return "expenseTeamList";
    }

    @GetMapping("/addExpenseTeam")
    public String listExpenseTeam(Model model) {
        model.addAttribute("details", new Details());
        return "addExpenseTeam";
    }

    @GetMapping("/editExpenseTeam/{id}")
    public String editExpense(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("details", this.expenseTeamService.geExpenseTeamById(id));
        return "updateExpenseTeam";
    }

    @PostMapping("/addExpenseTeam")
    public String addExpenseTeam(@RequestParam Map<String, String> params, HttpSession session, @Valid Details d) {
        User u = (User) session.getAttribute("currentUser");
        if (this.expenseTeamService.addExpenseTeam(d, u) == true) {
            return "redirect:/user/expenseTeamList";
        } else {
            session.setAttribute("errMsg", "Error!!!!!");
        }
        return "addExpenseTeam";
    }

    @PostMapping("/editExpenseTeam/updateExpenseTeam")
    public String updateExpenseTeam(@RequestParam Map<String, String> params, HttpSession session, @Valid Details d) {
        User u = (User) session.getAttribute("currentUser");
        if (this.expenseTeamService.updateExpenseTeam(d, u) == true) {
            return "redirect:/user/expenseTeamList";
        } else {
            session.setAttribute("errMsg", "Error!!!!!");
        }
        return "updateExpenseTeam";
    }
    
    @GetMapping("/deleteExpenseTeam/{id}")
    public String deleteExpenseTeam(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("details", this.expenseTeamService.deleteExpenseTeam(id));
        return "redirect:/user/expenseTeamList";
    }
    
    @GetMapping("/detailsExpenseTeam/{id}")
    public String detailsExpense(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("details", this.expenseTeamService.geExpenseTeamById(id));
        return "detailsExpenseTeam";
    }
    
    @GetMapping("/statsExpenseTeam")
    public String statsExpenseTeam(Model model, @RequestParam(required = false) Map<String, String> params){
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
          
        model.addAttribute("statsExpenseTeam", this.expenseTeamService.statsExpenseTeam(fromDate, toDate));
        return "statsExpenseTeam";
    }
}
