/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.LoanPayment;
import org.springframework.stereotype.Service;

@Service
public interface LoanPaymentService {
    public String insertLoanPayment(LoanPayment pm);

    public String updateLoanPayment(int loanpayid, LoanPayment pm);

    public String deleteLoanPayment(int loanpayid);

    public String viewLoanPayment();

    public LoanPayment viewOneLoanPayment(int loanpayid);
}
