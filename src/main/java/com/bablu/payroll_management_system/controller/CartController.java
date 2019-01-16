/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.controller;

import com.bablu.payroll_management_system.dao.AllowanceService;
import com.bablu.payroll_management_system.dao.DeductionService;
import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.dao.JobDeductCalService;
import com.bablu.payroll_management_system.dao.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {
    @Autowired
    JobDeductCalService jdcs;
    @Autowired
    EmpInfoService eis;
    @Autowired
    DeductionService as;
    @Autowired
    JobTitleService jts;
    
}
