/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.BasicYearService;
import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.dao.NetSalaryService;
import com.bablu.payroll_management_system.dao.PaymentService;
import com.bablu.payroll_management_system.dao.PaymentTypeService;
import com.bablu.payroll_management_system.model.Payment;
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
public class PaymentController {
  @Autowired
  PaymentService pays;
  @Autowired
  EmpInfoService emps;
  @Autowired
  PaymentTypeService payts;
  @Autowired
  BasicYearService bys;
  @Autowired
  NetSalaryService nss;
  
  @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "paymentdate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
    @RequestMapping("/showpaymentpage")
    public ModelAndView showpaymentpage() {
        String paymentlist = pays.viewPayment();
        String emplist = emps.viewEmpInfo();
        String paytypelist = payts.viewPaymentType();
        String basicyearlist = bys.viewBasicYear();
        String nslist = nss.viewNetSalary();
        ModelAndView mv = new ModelAndView("addpayment", "paymentObject", new Payment());
        mv.addObject("paymentlist", paymentlist);
        mv.addObject("emplist", emplist);
        mv.addObject("paytypelist", paytypelist);
        mv.addObject("basicyearlist", basicyearlist);
        mv.addObject("nslist", nslist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingpayment", params = "Add")
    public String addpayment(@ModelAttribute("paymentObject") Payment cm) {
        pays.insertPayment(cm);
        return "redirect:/showpaymentpage";
    }
    @RequestMapping(value="/addingpayment", params = "Edit")
   public String editpayment(@ModelAttribute("paymentObject") Payment cm) {
        pays.updatePayment(cm.getPaymentid(), cm);
              return "redirect:/showpaymentpage";
    }
   @RequestMapping("/editpaymentpage")
    public ModelAndView editpaymentpage(@RequestParam("getpid") int pid) {
        String paymentlist = pays.viewPayment();
        String emplist = emps.viewEmpInfo();
        String paytypelist = payts.viewPaymentType();
        String basicyearlist = bys.viewBasicYear();
        String nslist = nss.viewNetSalary();
        ModelAndView mv = new ModelAndView("addpayment", "paymentObject", pays.viewOnePayment(pid));
        mv.addObject("paymentlist", paymentlist);
        mv.addObject("emplist", emplist);
        mv.addObject("paytypelist", paytypelist);
        mv.addObject("basicyearlist", basicyearlist);
        mv.addObject("nslist", nslist);
        mv.addObject("check", "false");
        return mv;
    }
    @RequestMapping("removingpayment/{paymentId}")
    public String removepayment(@PathVariable("paymentId") int paymentid) {
        pays.deletePayment(paymentid);
        return "redirect:/showpaymentpage";
    }
}
