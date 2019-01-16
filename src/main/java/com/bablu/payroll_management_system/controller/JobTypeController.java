/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.JobTypeService;
import com.bablu.payroll_management_system.model.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobTypeController {
     @Autowired
    JobTypeService cat;

    @RequestMapping("/showingjobtypepage")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewJobType();
        ModelAndView mv = new ModelAndView("addjobtype", "addCategoryObject1", new JobType());
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingjobtype", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCategoryObject1") JobType cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertJobType(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingjobtypepage";
    }

    @RequestMapping(value = "/addingjobtype", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1") JobType cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateJobType(cm);
        return "redirect:/showingjobtypepage";
    }

    @RequestMapping("removejobtype/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteJobType(categoryId);
        return "redirect:/showingjobtypepage";
    }

    @RequestMapping("/editjobtypebutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        JobType onecategory = cat.viewOneJobType(categoryId);
        String categorygsonlist = cat.viewJobType();
        ModelAndView mv = new ModelAndView("addjobtype", "addCategoryObject1", onecategory);
        mv.addObject("categorymodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
