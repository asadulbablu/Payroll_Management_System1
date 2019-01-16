/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.BasicYear;
import org.springframework.stereotype.Service;

@Service
public interface BasicYearService {
    public String insertBasicYear(BasicYear cm);

    public String updateBasicYear(BasicYear cm);

    public Integer deleteBasicYear(int id);

    public String viewBasicYear();

    public BasicYear viewOneBasicYear(int id);
}
