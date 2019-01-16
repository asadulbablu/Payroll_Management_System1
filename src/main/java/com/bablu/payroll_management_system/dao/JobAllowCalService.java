/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.JobAllowCal;
import org.springframework.stereotype.Service;

@Service
public interface JobAllowCalService {
    public String insertJobAllowCal(JobAllowCal cm);

    public Integer updateJobAllowCal(int joballowcalid,JobAllowCal cm);

    public Integer deleteJobAllowCal(int joballowcalid);

    public String viewJobAllowCal();

    public JobAllowCal viewOneJobAllowCal(int joballowcalid);
}
