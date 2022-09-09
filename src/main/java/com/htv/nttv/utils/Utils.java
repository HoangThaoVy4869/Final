/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htv.nttv.utils;

import com.htv.nttv.pojo.Members;
import java.util.Map;

/**
 *
 * @author USER
 */
public class Utils {
    public static int countMembers(Map<Integer, Members> members) {
        int n = 0;
        
        if (members != null)
            for (Members m: members.values())
                n += m.getNumbers();
        return n;
    }
}
