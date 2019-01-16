/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.Department;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public interface DepartmentService {
    public String insertDepartment(Department cm);

    public String updateDepartment(Department cm);

    public Integer deleteDepartment(int id);

    public String viewDepartment();

    public Department viewOneDepartment(int id);
}
