/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntv.nttv.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author USER
 */
@Component
public class LogoutHandler implements LogoutSuccessHandler{
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        request.getSession().removeAttribute("currentUser");
        
        response.sendRedirect("/ExpenseManager/");
    }
}
