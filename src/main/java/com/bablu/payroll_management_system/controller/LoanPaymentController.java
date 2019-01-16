/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.EmpLoanService;
import com.bablu.payroll_management_system.dao.LoanPaymentService;
import com.bablu.payroll_management_system.dao.LoanTypeService;
import com.bablu.payroll_management_system.model.LoanPayment;
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
public class LoanPaymentController {
    @Autowired
    LoanPaymentService lps;
    @Autowired
    EmpInfoService emps;
    @Autowired
    EmpLoanService lts;
    
    @RequestMapping("/showloanpaypage")
    public ModelAndView showloanpaymentpage() {
        String loanpaymentlist = lps.viewLoanPayment();
        String empIlist = emps.viewEmpInfo();
        String emploantlist = lts.viewEmpLoan();
        ModelAndView mv = new ModelAndView("addloanpay", "loanpayObject", new LoanPayment());
        mv.addObject("loanpaymentlist", loanpaymentlist);
        mv.addObject("empIlist", empIlist);
        mv.addObject("emploantlist", emploantlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingloanpay", params = "Add")
    public String addloanpay(@ModelAttribute("loanpayObject") LoanPayment cm) {
        cm.setLoanamountain(cm.getLoanamount()-cm.getLoanpayamount());
        lps.insertLoanPayment(cm);
        return "redirect:/showloanpaypage";
    }
    @RequestMapping(value="/addingloanpay", params = "Edit")
   public String editloanpay(@ModelAttribute("loanpayObject") LoanPayment cm) {
        cm.setLoanamountain(cm.getLoanamount()-cm.getLoanpayamount());
       lps.updateLoanPayment(cm.getLoanid(), cm);
              return "redirect:/showloanpaypage";
    }
   @RequestMapping("/editloanpay")
    public ModelAndView editloanpay(@RequestParam("getpid") int pid) {
        String loanpaymentlist = lps.viewLoanPayment();
        String empIlist = emps.viewEmpInfo();
        String emploantlist = lts.viewEmpLoan();
        ModelAndView mv = new ModelAndView("addloanpay", "loanpayObject", lps.viewOneLoanPayment(pid));
        mv.addObject("loanpaymentlist", loanpaymentlist);
        mv.addObject("empIlist", empIlist);
        mv.addObject("emploantlist", emploantlist);
        mv.addObject("check", "false");
        return mv;
    }
    @RequestMapping("removingloanpay/{loanpayId}")
    public String removeloanpay(@PathVariable("loanpayId") int loanpayid) {
        lps.deleteLoanPayment(loanpayid);
        return "redirect:/showloanpaypage";
    }
    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "loanpaydate", new CustomDateEditor(format, false));
    }
}
