/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Members;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("/user")
public class MembersController {
    
    @GetMapping("/listMembers")
    public String members(Model model, HttpSession session){
        Map<Integer, Members> members = (Map<Integer, Members>) session.getAttribute("members");
        if (members != null)
            model.addAttribute("members", members.values());
        else
            model.addAttribute("members", null);
        return "listMembers";
    }
}
