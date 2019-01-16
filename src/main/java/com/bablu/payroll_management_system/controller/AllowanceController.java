/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.AllowanceService;
import com.bablu.payroll_management_system.model.Allowance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AllowanceController {

   @Autowired
   AllowanceService cat;
   @RequestMapping("/showingallowancepage")
    public ModelAndView showallowance() {
        String categorygsonlist = cat.viewAllowance();
        ModelAndView mv = new ModelAndView("addallowance", "addallowanceobject1", new Allowance());
        mv.addObject("allowancemodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingallowance", params = "Addallowance")
    public String addallowance(@ModelAttribute("addallowanceobject1") Allowance cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertAllowance(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingallowancepage";
    }
     @RequestMapping(value = "/addingallowance", params = "Editallowance")
    public String editallowance(@ModelAttribute("addallowanceobject1") Allowance cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateAllowance(cm);
        return "redirect:/showingallowancepage";
    }
     @RequestMapping("removeallowance/{Id}")
    public String removeallowance(@PathVariable("Id") int categoryId) {
        cat.deleteAllowance(categoryId);
        return "redirect:/showingallowancepage";
    }
    @RequestMapping("/editallowancebutton")
    public ModelAndView passingoneallowance(@RequestParam("getcid") int categoryId) {

        Allowance onecategory = cat.viewOneAllowance(categoryId);
        String categorygsonlist = cat.viewAllowance();
        ModelAndView mv = new ModelAndView("addallowance", "addallowanceobject1", onecategory);
        mv.addObject("allowancemodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
