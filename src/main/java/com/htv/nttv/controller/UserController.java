/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Team;
import com.htv.nttv.pojo.User;
import com.htv.nttv.service.TeamService;
import com.htv.nttv.service.UserGroupService;
import com.htv.nttv.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserGroupService userGroupService;
    
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model,@ModelAttribute(value = "user") User user){
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())){
            if (this.userDetailsService.addUser(user) == true)
                return "redirect:/user/login";
            else
                errMsg = "Da co loi xay ra";
        } else 
            errMsg = "Mat khau k khop";
        
        model.addAttribute("errMsg", errMsg);
        return "register";
    }
        
    
    @GetMapping("/list")
    public String listUser(Model model, @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("user", this.userGroupService.getUser(params, page));
        model.addAttribute("team", new Team());
        return "listUserGroup";
    }
    
}
