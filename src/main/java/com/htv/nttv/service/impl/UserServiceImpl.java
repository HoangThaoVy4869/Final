/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.UserRepository;
import com.htv.nttv.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addUser(User u) {

        try {
            String pass = u.getPassword();
            u.setPassword(this.PasswordEncoder.encode(pass));
            u.setUserRole(User.USER);
            u.setActive(Boolean.TRUE);
            
            Map r = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
                
            u.setAvatar((String) r.get("secure_url"));
            
            return this.userRepository.addUser(u);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.findByUser(username);
        
        if (u == null) {
            throw new UsernameNotFoundException("Invalid username!!!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User findByUser(String username) {
        return this.userRepository.findByUser(username);
    }

    @Override
    public List<Object[]> getUser(Map<String, String> params, String kw) {
        return this.userRepository.getUser(params, kw);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.userRepository.deleteUser(id);

    }

    @Override
    public boolean updateUser(User u) {
        return this.userRepository.updateUser(u);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }


}
