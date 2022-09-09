/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Incomedetails;
import com.htv.nttv.pojo.User;
import com.htv.nttv.service.IncomeTeamService;
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
public class IncomeTeamController {
    @Autowired
    private IncomeTeamService incomeTeamService;

    @GetMapping("/incomeTeamList")
    public String incomeTeamList(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("incomeTeam", this.incomeTeamService.getIncomeTeam(params, page));
        return "incomeTeamList";
    }
    
    @GetMapping("/addIncomeTeam")
    public String listIncomeTeam(Model model) {
        model.addAttribute("Incomedetails", new Incomedetails());
        return "addIncomeTeam";
    }

    @GetMapping("/editIncomeTeam/{id}")
    public String editIncomeTeam(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("Incomedetails", this.incomeTeamService.getIncomeTeamById(id));
        return "updateIncomeTeam";
    }

    @PostMapping("/addIncomeTeam")
    public String addIncomeTeam(@RequestParam Map<String, String> params, HttpSession session, @Valid Incomedetails d) {
        User u = (User) session.getAttribute("currentUser");
        if (this.incomeTeamService.addIncomeTeam(d, u) == true) {
            return "redirect:/user/incomeTeamList";
        } else {
            session.setAttribute("errMsg", "Error!!!!!");
        }
        return "addIncomeTeam";
    }

    @PostMapping("/editIncomeTeam/updateIncomeTeam")
    public String updateIncomeTeam(@RequestParam Map<String, String> params, HttpSession session, @Valid Incomedetails d) {
        User u = (User) session.getAttribute("currentUser");
        if (this.incomeTeamService.updateIncomeTeam(d, u) == true) {
            return "redirect:/user/incomeTeamList";
        } else {
            session.setAttribute("errMsg", "Error!!!!!");
        }
        return "updateIncomeTeam";
    }
    
    @GetMapping("/deleteIncomeTeam/{id}")
    public String deleteIncomeTeam(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("Incomedetails", this.incomeTeamService.deleteIncomeTeam(id));
        return "redirect:/user/incomeTeamList";
    }
    
    @GetMapping("/detailsIncomeTeam/{id}")
    public String detailsIncomeTeam(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("Incomedetails", this.incomeTeamService.getIncomeTeamById(id));
        return "detailsIncomeTeam";
    }
    
    @GetMapping("/statsIncomeTeam")
    public String statsIncomeTeam(Model model, @RequestParam(required = false) Map<String, String> params){
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
          
        model.addAttribute("statsIncomeTeam", this.incomeTeamService.statsIncomeTeam(fromDate, toDate));
        return "statsIncomeTeam";
    }
    
}
