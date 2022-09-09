/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.controller;

import com.htv.nttv.pojo.Members;
import com.htv.nttv.service.UserGroupService;
import com.htv.nttv.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
public class ApiMembersController {
    
    @Autowired
    private UserGroupService userGroupService;
    
    @PostMapping("/api/members")
    public int addToTeam(@RequestBody Members params, HttpSession session){
        Map<Integer, Members> members = (Map<Integer, Members>) session.getAttribute("members");
        if(members == null)
            members = new HashMap<>();
        int userId = params.getUserId();
        if (members.containsKey(userId) == true){
            Members m = members.get(userId);
            //members.remove(m);
        } else {
            members.put(userId, params);
        }
        session.setAttribute("members", members);
        
        return Utils.countMembers(members);
    }
    
    @DeleteMapping("/api/members/{userId}")
    public int deleteMembers(@PathVariable(value = "userId") int userId, HttpSession session){
        Map<Integer, Members> members = (Map<Integer, Members>) session.getAttribute("members");
        if(members != null && members.containsKey(userId)){
            members.remove(userId);
            
            session.setAttribute("members", members);
        }
        return Utils.countMembers(members);
    }
    
    @PostMapping("/api/addUser")
    public HttpStatus addUserTeam(HttpSession session){
        if (this.userGroupService.addUserTeam((Map<Integer, Members>) session.getAttribute("members"))){
            session.removeAttribute("members");
            return HttpStatus.OK;
        }
        else
            return HttpStatus.BAD_REQUEST;
    }
}
