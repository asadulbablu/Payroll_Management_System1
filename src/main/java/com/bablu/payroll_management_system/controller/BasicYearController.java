/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.BasicYearService;
import com.bablu.payroll_management_system.model.BasicYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicYearController {
    
    @Autowired
    BasicYearService cat;
    
    @RequestMapping("/showingbasicyearpage")
    public ModelAndView showbasicyear() {
        String categorygsonlist = cat.viewBasicYear();
        ModelAndView mv = new ModelAndView("addbasicyear", "addbasicyearobject1", new BasicYear());
        mv.addObject("basicyearmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingbasicyear", params = "Addbasicyear")
    public String addbasicyear(@ModelAttribute("addbasicyearobject1") BasicYear cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertBasicYear(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingbasicyearpage";
    }
    @RequestMapping(value = "/addingbasicyear", params = "Editbasicyear")
    public String editbasicyear(@ModelAttribute("addbasicyearobject1") BasicYear cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateBasicYear(cm);
        return "redirect:/showingbasicyearpage";
    }
     @RequestMapping("removebasicyear/{Id}")
    public String removebasicyear(@PathVariable("Id") int categoryId) {
        cat.deleteBasicYear(categoryId);
        return "redirect:/showingbasicyearpage";
    }
     @RequestMapping("/editbasicyearbutton")
    public ModelAndView passingonebasicyear(@RequestParam("getcid") int categoryId) {

        BasicYear onecategory = cat.viewOneBasicYear(categoryId);
        String categorygsonlist = cat.viewBasicYear();
        ModelAndView mv = new ModelAndView("addbasicyear", "addbasicyearobject1", onecategory);
        mv.addObject("basicyearmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
