/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.dao;

import com.bablu.payroll_management_system.model.JobDeductCal;
import org.springframework.stereotype.Service;

@Service
public interface JobDeductCalService {
    public String insertJobDeductCal(JobDeductCal cm);

    public Integer updateJobDeductCal(int jobdeductcalid,JobDeductCal cm);

    public Integer deleteJobDeductCal(int jobdeductcalid);

    public String viewJobDeductCal();

    public JobDeductCal viewOneJobDeductCal(int jobdeductcalid);
}
