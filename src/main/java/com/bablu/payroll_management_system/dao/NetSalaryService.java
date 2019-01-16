/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.NetSalary;
import org.springframework.stereotype.Service;

@Service
public interface NetSalaryService {
    public String insertNetSalary(NetSalary cm);

    public String updateNetSalary(NetSalary cm);

    public Integer deleteNetSalary(int id);

    public String viewNetSalary();

    public NetSalary viewOneNetSalary(int id);
}
