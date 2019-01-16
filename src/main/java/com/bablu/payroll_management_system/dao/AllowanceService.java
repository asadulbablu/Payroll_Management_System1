/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.Allowance;
import org.springframework.stereotype.Service;

@Service
public interface AllowanceService {
    public String insertAllowance(Allowance cm);

    public String updateAllowance(Allowance cm);

    public Integer deleteAllowance(int id);

    public String viewAllowance();

    public Allowance viewOneAllowance(int id);
}
