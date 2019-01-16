package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.Userservice;
import com.bablu.payroll_management_system.model.AllowCart;
import com.bablu.payroll_management_system.model.Cart;
import com.bablu.payroll_management_system.model.User;
import com.bablu.payroll_management_system.model.UserRole;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    Userservice user;

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String showIndex() {
//        return "index";
//    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcome() {
        return "welcome";
    }

    @RequestMapping(value = "/loginsuccess")
    public String loginsuccess(HttpSession session) {
        System.out.println("success..........");

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        User us = user.viewUser(userid);
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String page = "";
        String role = "ROLE_USER";
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(role)) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("usercart", new ArrayList<Cart>());
                session.setAttribute("usercart1", new ArrayList<AllowCart>());
                page= "redirect:/welcome";
            }
            else{
            page= "redirect:/";
            }
        }
        return page;
    }
}
