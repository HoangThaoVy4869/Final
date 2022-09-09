/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.respository;

import com.htv.nttv.pojo.Team;
import com.htv.nttv.pojo.UserTeam;
import java.util.List;
import java.util.Map;
/**
 *
 * @author USER
 */
public interface TeamRespository {
    List<Team> getTeam(Map<String, String> params, int page);
    boolean addTeam(Team t);
    public Team getTeamById(int id);
//    boolean joinTeam(UserTeam ut);
}
