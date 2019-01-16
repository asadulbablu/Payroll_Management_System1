/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.EmpLoan;
import org.springframework.stereotype.Service;

@Service
public interface EmpLoanService {
    public String insertEmpLoan(EmpLoan cm);

    public Integer updateEmpLoan(int emploanid, EmpLoan cm);

    public Integer deleteEmpLoan(int emploanid);

    public String viewEmpLoan();

    public EmpLoan viewOneEmpLoan(int emploanid);
}
