/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository;

import com.htv.nttv.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    boolean addUser(User u);
    User getUserById(int id);
    boolean deleteUser(int id);
    boolean updateUser(User u);
    User findByUser(String username);
    List<Object[]> getUser(Map<String, String> params, String kw);
}
