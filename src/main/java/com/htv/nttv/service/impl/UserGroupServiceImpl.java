/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.service.impl;

import com.htv.nttv.pojo.Members;
import com.htv.nttv.pojo.Team;
import com.htv.nttv.pojo.User;
import com.htv.nttv.respository.UserGroupRepository;
import com.htv.nttv.service.UserGroupService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class UserGroupServiceImpl implements UserGroupService{
    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public List<Object[]> getUser(Map<String, String> params, int page) {
        return this.userGroupRepository.getUser(params, page);
    }

    @Override
    public boolean addUserTeam(Map<Integer, Members> members) {
        if (members != null)
            return this.userGroupRepository.addUserTeam(members);
        return false;
    }
}
