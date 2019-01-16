/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.JobTitle;
import org.springframework.stereotype.Service;

@Service
public interface JobTitleService {
    public String insertJobTitle(JobTitle cm);

    public Integer updateJobTitle(int jobtitleid,JobTitle cm);

    public Integer deleteJobTitle(int jobtitleid);

    public String viewJobTitle();

    public JobTitle viewOneJobTitle(int jobtitleid);
}
