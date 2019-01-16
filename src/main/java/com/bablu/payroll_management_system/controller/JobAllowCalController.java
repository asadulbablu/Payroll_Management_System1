/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.AllowanceService;
import com.bablu.payroll_management_system.dao.DeductionService;
import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobAllowCalService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.model.AllowCart;
import com.bablu.payroll_management_system.model.JobAllowCal;
import com.bablu.payroll_management_system.model.JobTitle;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobAllowCalController {
    @Autowired
    JobAllowCalService jacs;
    @Autowired
    JobTitleService jts;
    @Autowired
    AllowanceService alls;
    @Autowired
    EmpInfoService eis;
    
    @RequestMapping("/showpayallowcalpage")
    public ModelAndView showpayallowcalpage(HttpSession httpSession) {
        String jallowcallist = jacs.viewJobAllowCal();
        String jtitlelist = jts.viewJobTitle();
        String allowlist = alls.viewAllowance();
        String emplist = eis.viewEmpInfo();
        ModelAndView mv = new ModelAndView("addpayallowcal", "payallowcalObject", new JobAllowCal());
        mv.addObject("jallowcallist", jallowcallist);
        mv.addObject("jtitlelist", jtitlelist);
        mv.addObject("allowlist", allowlist);
        mv.addObject("emplist", emplist);
        mv.addObject("check", "true");
        Gson g = new Gson();

        ArrayList<AllowCart> c = (ArrayList<AllowCart>) httpSession.getAttribute("usercart1");
        if(c.isEmpty()){
         httpSession.setAttribute("cartempty", "true");
         mv.addObject("itemsincart", "null");
         return mv;
        }else {
            String cartgson = g.toJson(c);
            mv.addObject("itemsincart", cartgson);
            System.out.println(cartgson);
            httpSession.setAttribute("grandtotal", getGrandTotal(c));
            httpSession.setAttribute("cartempty", "false");
            return mv;
        }
    }
    public double getGrandTotal(ArrayList<AllowCart> item) {
        double gtotal = 0;
        ListIterator<AllowCart> itr = item.listIterator();
        while (itr.hasNext()) {
            AllowCart ob = (AllowCart) itr.next();
            gtotal = gtotal + ob.getAllowpermonth();
        }
        return gtotal;
    }
    @RequestMapping("/addtoallowance")
    public String addingToAllowance(HttpSession session, @ModelAttribute("payallowcalObject") JobAllowCal jac) {

        
        String flag = "not inserted";
        ArrayList<AllowCart> cartarray = (ArrayList<AllowCart>) session.getAttribute("usercart1");
        
        if (cartarray.isEmpty()) {
            cartarray.add(new AllowCart(jac.getJoballowcalid(),jac.getEmpid(), jac.getAllowanceid(),jac.getAllowancehead(),jac.getJobtitleid(),jac.getBasicsalary(),jac.getPercent(),(jac.getBasicsalary()*jac.getPercent()/100)));
            
            flag = "inserted";
        } else {
            Iterator<AllowCart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                AllowCart d = lit.next();
                if (d.getJoballowcalid()== jac.getJoballowcalid()) {
                    int index = cartarray.indexOf(d);
                    
                    cartarray.remove(index);
                    cartarray.add(index, new AllowCart(jac.getJoballowcalid(),jac.getEmpid(), jac.getAllowanceid(),jac.getAllowancehead(),jac.getJobtitleid(),jac.getBasicsalary(),jac.getPercent(),(jac.getBasicsalary()*jac.getPercent()/100)));
                    session.setAttribute("usercart1", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new AllowCart(jac.getJoballowcalid(),jac.getEmpid(), jac.getAllowanceid(),jac.getAllowancehead(),jac.getJobtitleid(),jac.getBasicsalary(),jac.getPercent(),(jac.getBasicsalary()*jac.getPercent()/100)));
                session.setAttribute("usercart1", cartarray);
            }
        }
 
        return "redirect:/showpayallowcalpage";
    }
    @RequestMapping("/removeallowitem")
    public String removeproductitem(@RequestParam("pid") int allowanceid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<AllowCart> cartitems = (ArrayList<AllowCart>) session.getAttribute("usercart1");
        Iterator<AllowCart> list = (Iterator<AllowCart>) cartitems.iterator();
        while (list.hasNext()) {
            AllowCart c = list.next();
            if (c.getJoballowcalid() == allowanceid) {
                cartitems.remove(cartitems.indexOf(c));
                break;
            }
        }
//        session.setAttribute("grandquantity", getgrandquantity(cartitems));
        session.setAttribute("usercart1", cartitems);
        return "redirect:/showpayallowcalpage";
    }
    @RequestMapping(value = "/addjoballowcalpage", params = "Add")
    public String addjobdeductcalpage(@ModelAttribute("payallowcalObject") JobAllowCal jac, HttpServletRequest request, HttpSession httpSession) {
        ArrayList<AllowCart> c = (ArrayList<AllowCart>) httpSession.getAttribute("usercart1");
        for (AllowCart cart : c) {
            System.out.println(jac.getEmpid());
            jac.setBasicsalary(cart.getBasicsalary());
            jac.setAllowancehead(cart.getAllowancehead());
            jac.setAllowanceid(cart.getAllowanceid());
            jac.setAllowpermonth(cart.getAllowpermonth());
            jac.setEmpid(jac.getEmpid());
            jac.setJobtitleid(cart.getJobtitleid());
            jac.setPercent(cart.getPercent());
            jac.setTotalallowpermonth((double) httpSession.getAttribute("grandtotal"));
            jacs.insertJobAllowCal(jac);
        }
        
        
        ModelAndView mv = new ModelAndView("addpayallowcal");
        
        mv.addObject("joballowcalid", jac.getJoballowcalid());
        httpSession.setAttribute("usercart1", new ArrayList<AllowCart>());
       
        return "redirect:/showpayallowcalpage";
       
    }
}
