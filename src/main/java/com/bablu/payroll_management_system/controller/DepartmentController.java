/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.DepartmentService;
import com.bablu.payroll_management_system.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author User
 */
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService cat;

    @RequestMapping("/showingdepartmentpage")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewDepartment();
        ModelAndView mv = new ModelAndView("adddepartment", "addCategoryObject1", new Department());
        mv.addObject("departmentmodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }

    @RequestMapping(value = "/addingcategory", params = "Addcategory")
    public String addcategory(@ModelAttribute("addCategoryObject1") Department cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertDepartment(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showingdepartmentpage";
    }

    @RequestMapping(value = "/addingcategory", params = "EditCategory")
    public String editcategory(@ModelAttribute("addCategoryObject1") Department cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateDepartment(cm);
        return "redirect:/showingdepartmentpage";
    }

    @RequestMapping("removedepartment/{Id}")
    public String removecategory(@PathVariable("Id") int categoryId) {
        cat.deleteDepartment(categoryId);
        return "redirect:/showingdepartmentpage";
    }

    @RequestMapping("/editdeptbutton")
    public ModelAndView passingonecategory(@RequestParam("getcid") int categoryId) {

        Department onecategory = cat.viewOneDepartment(categoryId);
        String categorygsonlist = cat.viewDepartment();
        ModelAndView mv = new ModelAndView("adddepartment", "addCategoryObject1", onecategory);
        mv.addObject("departmentmodelobject", categorygsonlist);
        mv.addObject("check", "false");
        return mv;
    }
}
