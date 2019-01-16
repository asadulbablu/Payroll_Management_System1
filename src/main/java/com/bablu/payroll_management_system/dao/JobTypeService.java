/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.JobType;
import org.springframework.stereotype.Service;

@Service
public interface JobTypeService {
     public String insertJobType(JobType cm);

    public String updateJobType(JobType cm);

    public Integer deleteJobType(int id);

    public String viewJobType();

    public JobType viewOneJobType(int id);
}
