/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.DeductionService;
import com.bablu.payroll_management_system.model.Deduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeductionController {
    
    @Autowired
    DeductionService cat;
     @RequestMapping("/showingdeductionpage")
    public ModelAndView showdeduction() {
        String categorygsonlist = cat.viewDeduction();
        ModelAndView mv = new ModelAndView("adddeduction", "adddeductionbject1", new Deduction());
        mv.addObject("deductionmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingdeduction", params = "Adddeduction")
    public String adddeduction(@ModelAttribute("adddeductionbject1") Deduction cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertDeduction(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingdeductionpage";
    }
    @RequestMapping(value = "/addingdeduction", params = "Editdeduction")
    public String editdeduction(@ModelAttribute("adddeductionbject1") Deduction cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateDeduction(cm);
        return "redirect:/showingdeductionpage";
    }
    @RequestMapping("removededuction/{Id}")
    public String removededuction(@PathVariable("Id") int categoryId) {
        cat.deleteDeduction(categoryId);
        return "redirect:/showingdeductionpage";
    }
     @RequestMapping("/editdeductionbutton")
    public ModelAndView passingonededuction(@RequestParam("getcid") int categoryId) {

        Deduction onecategory = cat.viewOneDeduction(categoryId);
        String categorygsonlist = cat.viewDeduction();
        ModelAndView mv = new ModelAndView("adddeduction", "adddeductionbject1", onecategory);
        mv.addObject("deductionmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
