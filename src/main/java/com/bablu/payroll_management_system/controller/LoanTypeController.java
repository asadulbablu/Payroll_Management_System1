/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.LoanTypeService;
import com.bablu.payroll_management_system.model.JobType;
import com.bablu.payroll_management_system.model.LoanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoanTypeController {
     @Autowired
    LoanTypeService cat;
     @RequestMapping("/showingloanpage")
    public ModelAndView showloantype() {
        String categorygsonlist = cat.viewLoanType();
        ModelAndView mv = new ModelAndView("addloantype", "addloantypeObject1", new LoanType());
        mv.addObject("loantypemodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingloantype", params = "Addloantype")
    public String addloantype(@ModelAttribute("addloantypeObject1") LoanType cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertLoanType(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingloanpage";
    }
    @RequestMapping(value = "/addingloantype", params = "Editloantype")
    public String editloantype(@ModelAttribute("addloantypeObject1") LoanType cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateLoanType(cm);
        return "redirect:/showingloanpage";
    }
     @RequestMapping("removeloantype/{Id}")
    public String removeloantype(@PathVariable("Id") int categoryId) {
        cat.deleteLoanType(categoryId);
        return "redirect:/showingloanpage";
    }
     @RequestMapping("/editloantypebutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        LoanType onecategory = cat.viewOneLoanType(categoryId);
        String categorygsonlist = cat.viewLoanType();
        ModelAndView mv = new ModelAndView("addloantype", "addloantypeObject1", onecategory);
        mv.addObject("loantypemodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
