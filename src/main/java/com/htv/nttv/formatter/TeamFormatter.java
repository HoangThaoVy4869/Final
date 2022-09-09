/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.formatter;

import com.htv.nttv.pojo.Team;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author USER
 */
public class TeamFormatter implements Formatter<Team>{
    @Override
    public String print(Team obj, Locale locale) {
        return String.valueOf(obj.getId());
    }

    @Override
    public Team parse(String id, Locale locale) throws ParseException {
        Team t = new Team();
        t.setId(Integer.parseInt(id));
        
        return t;
    }
}
