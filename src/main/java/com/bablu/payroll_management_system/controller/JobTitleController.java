/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.BasicYearService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.model.JobTitle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobTitleController {
    
    @Autowired
    JobTitleService jtldao;
    @Autowired
    BasicYearService byrdao;
    
    @RequestMapping("/showjobtitlepage")
    public ModelAndView showjobtitlepage() {
        String jobtitlelist = jtldao.viewJobTitle();
        String basicyearlist = byrdao.viewBasicYear();
        ModelAndView mv = new ModelAndView("addjobtitle", "newjobtitleObject", new JobTitle());
        mv.addObject("jobtitlelist", jobtitlelist);
        mv.addObject("basicyearlist", basicyearlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingjobtitle", params = "Add")
    public String addjobtitle(@ModelAttribute("newjobtitleObject") JobTitle cm) {
        jtldao.insertJobTitle(cm);
        return "redirect:/showjobtitlepage";
    }
    @RequestMapping(value="/addingjobtitle", params = "Edit")
   public String editjobtitle(@ModelAttribute("newjobtitleObject") JobTitle cm) {
        jtldao.updateJobTitle(cm.getJobtitleid(),cm );
              return "redirect:/showjobtitlepage";
    }
   @RequestMapping("/editjobtitle")
    public ModelAndView editjobtitlepage(@RequestParam("getpid") int pid) {
        String jobtitlelist = jtldao.viewJobTitle();
        String basicyearlist = byrdao.viewBasicYear();
        ModelAndView mv = new ModelAndView("addjobtitle", "newjobtitleObject", jtldao.viewOneJobTitle(pid));
        mv.addObject("jobtitlelist", jobtitlelist);
        mv.addObject("basicyearlist", basicyearlist);
        mv.addObject("check", "false");
        return mv;
    }
     @RequestMapping("removingjobtitle/{jobtitleId}")
    public String removejobtitle(@PathVariable("jobtitleId") int empinfoid) {
        jtldao.deleteJobTitle(empinfoid);
        return "redirect:/showjobtitlepage";
    }
     
}
