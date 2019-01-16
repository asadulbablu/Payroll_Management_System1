/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.EmpLoanService;
import com.bablu.payroll_management_system.dao.LoanTypeService;
import com.bablu.payroll_management_system.model.EmpLoan;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpLoanController {
  @Autowired
  EmpLoanService epls;
  @Autowired
  EmpInfoService emps;
  @Autowired
  LoanTypeService lts;
  
  @RequestMapping("/showemploanpage")
    public ModelAndView showemploanpage() {
        String empllist = epls.viewEmpLoan();
        String empslist = emps.viewEmpInfo();
        String lontslist = lts.viewLoanType();
        ModelAndView mv = new ModelAndView("addemploan", "emploanObject", new EmpLoan());
        mv.addObject("empllist", empllist);
        mv.addObject("empslist", empslist);
        mv.addObject("lontslist", lontslist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingemploan", params = "Add")
    public String addemploan(@ModelAttribute("emploanObject") EmpLoan cm) {
      epls.insertEmpLoan(cm);
      return "redirect:/showemploanpage";
    }
    @RequestMapping(value="/addingemploan", params = "Edit")
   public String editemploan(@ModelAttribute("emploanObject") EmpLoan cm) {
        epls.updateEmpLoan(cm.getLoanid(), cm);
              return "redirect:/showemploanpage";
    }
   @RequestMapping("/editemploan")
   public ModelAndView editemploanpage(@RequestParam("getpid") int pid) {
        String empllist = epls.viewEmpLoan();
        String empslist = emps.viewEmpInfo();
        String lontslist = lts.viewLoanType();
        ModelAndView mv = new ModelAndView("addemploan", "emploanObject", epls.viewOneEmpLoan(pid));
        mv.addObject("empllist", empllist);
        mv.addObject("empslist", empslist);
        mv.addObject("lontslist", lontslist);
        mv.addObject("check", "false");
        return mv;
    }
   @RequestMapping("removingemploan/{emploanId}")
    public String removeemploan(@PathVariable("emploanId") int elploanid) {
        epls.deleteEmpLoan(elploanid);
        return "redirect:/showemploanpage";
    }
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "loandate", new CustomDateEditor(format, false));
    }
     @InitBinder
    public void myInitBinder1(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "maturedate", new CustomDateEditor(format, false));
    }
}
