/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.JobDeductCalService;
import com.bablu.payroll_management_system.model.JobAllowCal;
import com.bablu.payroll_management_system.model.JobDeductCal;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobdeductCalServiceImpl implements JobDeductCalService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertJobDeductCal(JobDeductCal cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer updateJobDeductCal(int jobdeductcalid, JobDeductCal cm) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;  
    }

    @Override
    public Integer deleteJobDeductCal(int jobdeductcalid) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobDeductCal cm = (JobDeductCal) s.get(JobDeductCal.class, jobdeductcalid);
        s.delete(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewJobDeductCal() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<JobDeductCal> jobdcallist = s.createQuery("from JobDeductCal").list();
        Gson g = new Gson();
        String jobdcalgson = g.toJson(jobdcallist);
        t.commit();
        s.close();
        return jobdcalgson; 
    }

    @Override
    public JobDeductCal viewOneJobDeductCal(int jobdeductcalid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobDeductCal cm = (JobDeductCal) s.get(JobDeductCal.class, jobdeductcalid);
        t.commit();
        s.close();
        Gson g = new Gson();
        String jobdcalgson = g.toJson(cm);
        return cm;
    }
}
