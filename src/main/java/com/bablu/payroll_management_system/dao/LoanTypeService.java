/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.LoanType;
import org.springframework.stereotype.Service;

@Service
public interface LoanTypeService {
     public String insertLoanType(LoanType cm);

    public String updateLoanType(LoanType cm);

    public Integer deleteLoanType(int id);

    public String viewLoanType();

    public LoanType viewOneLoanType(int id);
}
