/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.AllowanceService;
import com.bablu.payroll_management_system.dao.DeductionService;
import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobDeductCalService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.model.Cart;
import com.bablu.payroll_management_system.model.JobDeductCal;
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
public class JobdeductCalController {
    @Autowired
    JobDeductCalService jdcs;
    @Autowired
    JobTitleService jts;
    @Autowired
    DeductionService ds;
    @Autowired
    EmpInfoService eis;
 
    @RequestMapping("/showpaydeductcalpage")
    public ModelAndView showprescriptionlistpage(HttpSession httpSession) {
        
        String jdeductcallist = jdcs.viewJobDeductCal();
        String jtitlelist = jts.viewJobTitle();
        String deductionlist = ds.viewDeduction();
        String emplist = eis.viewEmpInfo();
        ModelAndView mv = new ModelAndView("addpaydeductcal", "paydeductcalObject", new JobDeductCal());
        mv.addObject("jdeductcallist", jdeductcallist);
        mv.addObject("jtitlelist", jtitlelist);
        mv.addObject("deductionlist", deductionlist);
        mv.addObject("emplist", emplist);
        mv.addObject("check", "true");
        Gson g = new Gson();

        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
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
     @RequestMapping("/addtocart")
    public String addingToCart(HttpSession session, @ModelAttribute("paydeductcalObject") JobDeductCal jdc) {

        
        String flag = "not inserted";
        ArrayList<Cart> cartarray = (ArrayList<Cart>) session.getAttribute("usercart");
        
        if (cartarray.isEmpty()) {
            cartarray.add(new Cart(jdc.getJobdeductcalid(),jdc.getEmpid(), jdc.getDeductionid(),jdc.getDeductionhead(),jdc.getJobtitleid(),jdc.getBasicsalary(),jdc.getPercent(),(jdc.getBasicsalary()*jdc.getPercent()/100)));
            
            flag = "inserted";
        } else {
            Iterator<Cart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                Cart d = lit.next();
                if (d.getJobdeductcalid()== jdc.getJobdeductcalid()) {
                    int index = cartarray.indexOf(d);
                    
                    cartarray.remove(index);
                    cartarray.add(index, new Cart(jdc.getJobdeductcalid(),jdc.getEmpid(), jdc.getDeductionid(),jdc.getDeductionhead(),jdc.getJobtitleid(),jdc.getBasicsalary(),jdc.getPercent(),(jdc.getBasicsalary()*jdc.getPercent())/100));
                    session.setAttribute("usercart", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new Cart(jdc.getJobdeductcalid(),jdc.getEmpid(), jdc.getDeductionid(),jdc.getDeductionhead(),jdc.getJobtitleid(),jdc.getBasicsalary(),jdc.getPercent(),(jdc.getBasicsalary()*jdc.getPercent())/100));
                session.setAttribute("usercart", cartarray);
            }
        }
        
//        UserCartDetails usercart = new UserCartDetails();
//        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
//        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
//        usercart.setProductsincart(cartarray.toString());
//        cdao.insertCartwithProducts(usercart);
        return "redirect:/showpaydeductcalpage";
    }
    public double getGrandTotal(ArrayList<Cart> item) {
        double gtotal = 0;
        ListIterator<Cart> itr = item.listIterator();
        while (itr.hasNext()) {
            Cart ob = (Cart) itr.next();
            gtotal = gtotal + ob.getDeductpermonth();
        }
        return gtotal;
    }
    @RequestMapping("/removeproductitem")
    public String removeproductitem(@RequestParam("pid") int deductionid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<Cart> cartitems = (ArrayList<Cart>) session.getAttribute("usercart");
        Iterator<Cart> list = (Iterator<Cart>) cartitems.iterator();
        while (list.hasNext()) {
            Cart c = list.next();
            if (c.getDeductionid() == deductionid) {
                cartitems.remove(cartitems.indexOf(c));
                break;
            }
        }
//        session.setAttribute("grandquantity", getgrandquantity(cartitems));
        session.setAttribute("usercart", cartitems);
        return "redirect:/showpaydeductcalpage";
    }
    @RequestMapping(value = "/addjobdeductcalpage", params = "Add")
    public String addjobdeductcalpage(@ModelAttribute("paydeductcalObject") JobDeductCal jdc, HttpServletRequest request, HttpSession httpSession) {
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        for (Cart cart : c) {
            System.out.println(jdc.getEmpid());
            jdc.setBasicsalary(cart.getBasicsalary());
            jdc.setDeductionhead(cart.getDeductionhead());
            jdc.setDeductionid(cart.getDeductionid());
            jdc.setDeductpermonth(cart.getDeductpermonth());
            jdc.setEmpid(jdc.getEmpid());
            jdc.setJobtitleid(cart.getJobtitleid());
            jdc.setPercent(cart.getPercent());
            jdc.setTotaldeductpermonth((double) httpSession.getAttribute("grandtotal"));
            jdcs.insertJobDeductCal(jdc);
        }
        
        
        ModelAndView mv = new ModelAndView("addpaydeductcal");
        
        mv.addObject("jobdeductcalid", jdc.getJobdeductcalid());
        httpSession.setAttribute("usercart", new ArrayList<Cart>());
       
        return "redirect:/showpaydeductcalpage";
       
    }
}
