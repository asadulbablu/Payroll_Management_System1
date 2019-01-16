/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.PaymentType;
import org.springframework.stereotype.Service;

@Service
public interface PaymentTypeService {
  public String insertPaymentType(PaymentType cm);

    public String updatePaymentType(PaymentType cm);

    public Integer deletePaymentType(int id);

    public String viewPaymentType();

    public PaymentType viewOnePaymentType(int id);  
}
