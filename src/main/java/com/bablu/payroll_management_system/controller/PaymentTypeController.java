/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.PaymentTypeService;
import com.bablu.payroll_management_system.model.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentTypeController {
     @Autowired
    PaymentTypeService cat;
     
     @RequestMapping("/showingpaymenttypepage")
    public ModelAndView showpaymenttypepage() {
        String categorygsonlist = cat.viewPaymentType();
        ModelAndView mv = new ModelAndView("addpaymenttype", "addpaymenttypeObject1", new PaymentType());
        mv.addObject("paymenttypemodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
}
    @RequestMapping(value = "/addingpaymenttype", params = "Addpaymenttype")
    public String addpaymenttype(@ModelAttribute("addpaymenttypeObject1") PaymentType cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertPaymentType(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingpaymenttypepage";
    }
     @RequestMapping(value = "/addingpaymenttype", params = "Editpaymenttype")
    public String editpaymenttype(@ModelAttribute("addpaymenttypeObject1") PaymentType cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updatePaymentType(cm);
        return "redirect:/showingpaymenttypepage";
    }
@RequestMapping("removepaymenttype/{Id}")
    public String removepaymenttype(@PathVariable("Id") int categoryId) {
        cat.deletePaymentType(categoryId);
        return "redirect:/showingpaymenttypepage";
    }
@RequestMapping("/editpaymenttypebutton")
    public ModelAndView passingonepaymenttype(@RequestParam("getcid") int paymenttypeId) {

        PaymentType onecategory = cat.viewOnePaymentType(paymenttypeId);
        String categorygsonlist = cat.viewPaymentType();
        ModelAndView mv = new ModelAndView("addpaymenttype", "addpaymenttypeObject1", onecategory);
        mv.addObject("paymenttypemodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
