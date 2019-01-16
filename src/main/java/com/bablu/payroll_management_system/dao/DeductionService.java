/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.Deduction;
import org.springframework.stereotype.Service;

@Service
public interface DeductionService {
    public String insertDeduction(Deduction cm);

    public String updateDeduction(Deduction cm);

    public Integer deleteDeduction(int id);

    public String viewDeduction();

    public Deduction viewOneDeduction(int id);
}
