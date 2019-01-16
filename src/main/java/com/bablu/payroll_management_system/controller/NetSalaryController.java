/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobAllowCalService;
import com.bablu.payroll_management_system.dao.JobDeductCalService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.dao.NetSalaryService;
import com.bablu.payroll_management_system.model.EmpInfo;
import com.bablu.payroll_management_system.model.NetSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NetSalaryController {
   @Autowired
    NetSalaryService nss;
   @Autowired
    EmpInfoService eis;
    @Autowired
    JobTitleService jts;
    @Autowired
    JobAllowCalService jacs;
    @Autowired
    JobDeductCalService jdcs;
    
    @RequestMapping("/shownetsalarypage")
    public ModelAndView shownsalarypage() {
        String nsalarylist = nss.viewNetSalary();
        String emplist = eis.viewEmpInfo();
        String jobtitlelist = jts.viewJobTitle();
        String jacallist = jacs.viewJobAllowCal();
        String jdcallist = jdcs.viewJobDeductCal();

        ModelAndView mv = new ModelAndView("addnetsalary", "newnetsalaryObject", new NetSalary());
        mv.addObject("nsalarylist", nsalarylist);
        mv.addObject("emplist", emplist);
        mv.addObject("jobtitlelist", jobtitlelist);
        mv.addObject("jacallist", jacallist);
        mv.addObject("jdcallist", jdcallist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingnetsalary", params = "Add")
    public String addnetsalary(@ModelAttribute("newnetsalaryObject") NetSalary cm) {
       cm.setNetsalary((cm.getBasicsalary()+cm.getTotalallowpermonth())-cm.getTotaldeductpermonth());
       nss.insertNetSalary(cm);
        return "redirect:/shownetsalarypage";
    }
     @RequestMapping(value="/addingnetsalary", params = "Edit")
   public String editnetsalary(@ModelAttribute("newnetsalaryObject") NetSalary cm) {
        cm.setNetsalary((cm.getBasicsalary()+cm.getTotalallowpermonth())-cm.getTotaldeductpermonth());
        nss.updateNetSalary(cm);
              return "redirect:/shownetsalarypage";
    }
   @RequestMapping("/editnetsalarypage")
    public ModelAndView editnetsalarypage(@RequestParam("getpid") int pid) {
        String nsalarylist = nss.viewNetSalary();
        String emplist = eis.viewEmpInfo();
        String jobtitlelist = jts.viewJobTitle();
        String jacallist = jacs.viewJobAllowCal();
        String jdcallist = jdcs.viewJobDeductCal();
        ModelAndView mv = new ModelAndView("addnetsalary", "newnetsalaryObject", nss.viewOneNetSalary(pid));
        mv.addObject("nsalarylist", nsalarylist);
        mv.addObject("emplist", emplist);
        mv.addObject("jobtitlelist", jobtitlelist);
        mv.addObject("jacallist", jacallist);
        mv.addObject("jdcallist", jdcallist);
        mv.addObject("check", "false");
        return mv;
    }
    @RequestMapping("removingnetsalary/{getpid}")
    public String removepayment(@PathVariable("getpid") int nsalaryid) {
        nss.deleteNetSalary(nsalaryid);
        return "redirect:/shownetsalarypage";
    }
}
