/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.EmpInfo;
import org.springframework.stereotype.Service;

@Service
public interface EmpInfoService {
    public String insertEmpInfo(EmpInfo pm);

    public String updateEmpInfo(int emp_id, EmpInfo pm);

    public String deleteEmpInfo(int emp_id);

    public String viewEmpInfo();

    public EmpInfo viewOneEmpInfo(int emp_id);
}
