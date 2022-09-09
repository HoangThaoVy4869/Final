/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;


import com.htv.nttv.pojo.User;
import com.htv.nttv.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * @author DELL
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/admin/list")
    @PreAuthorize("hasAuthority('0')")
    public String listUser(Model model, @RequestParam Map<String, String> params) {

        String kw = params.getOrDefault("kw", null);
        model.addAttribute("user", this.userDetailsService.getUser(params, kw));
        return "listUser";
    }
    
    @GetMapping("/admin/deleteUser/{id}")
    @PreAuthorize("hasAuthority('0')")
    public String deleteUser(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("user", this.userDetailsService.deleteUser(id));
        return "redirect:/admin/list";
    }
    
    @GetMapping("/admin/editUser/{id}")
    @PreAuthorize("hasAuthority('0')")
    public String editUser(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("user", this.userDetailsService.getUserById(id));
        return "updateUser";
    }
    
    @PostMapping("/admin/editUser/updateUser")
    @PreAuthorize("hasAuthority('0')")
    public String updateUser(Model model, @ModelAttribute(value = "user") @Valid User u, 
            BindingResult r) {

        
            if (this.userDetailsService.updateUser(u) == true) {
                return "redirect:/admin/list"; 
            } else {
                model.addAttribute("errMsg", "Error!!!!!");
            }
        return "updateUser";
    }
}
