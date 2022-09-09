/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.User;
import com.htv.nttv.service.CategoryService;
import com.htv.nttv.service.ExpenseService;
import com.htv.nttv.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private UserService userDetailsService;


    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    
    @RequestMapping("/")
    public String home()
    {
        return "home";
    }
    
    @RequestMapping("/home")
    public String index(Model model, @RequestParam Map<String, String> params,
            HttpSession session) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("expense", this.expenseService.getExpense(params, page, kw));
        model.addAttribute("counter", this.expenseService.countExpense());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model,
            @ModelAttribute(value = "user") @Valid User u,
            BindingResult r) {
        String errMsg="";

        if(u.getPassword().equals(u.getConfirmPassword())) {
            if (this.userDetailsService.addUser(u) == true) {
                return "redirect:/login";
            }else
                errMsg = "An error has occurred!!!";
        } else 
            errMsg = "password incorrect!!!";
        
        model.addAttribute("errMsg", errMsg);
        return "register";
    }
}

