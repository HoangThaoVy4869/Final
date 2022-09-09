/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service;

import com.htv.nttv.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface UserService extends UserDetailsService{
    boolean addUser(User u);
    User getUserById(int id);
    boolean deleteUser(int id);
    boolean updateUser(User u);
    List<Object[]> getUser(Map<String, String> params, String kw);
    User findByUser(String username);

}
