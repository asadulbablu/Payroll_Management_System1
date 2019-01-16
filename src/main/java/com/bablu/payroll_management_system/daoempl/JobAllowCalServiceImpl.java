/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.JobAllowCalService;
import com.bablu.payroll_management_system.model.JobAllowCal;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobAllowCalServiceImpl implements JobAllowCalService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertJobAllowCal(JobAllowCal cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer updateJobAllowCal(int joballowcalid, JobAllowCal cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deleteJobAllowCal(int joballowcalid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobAllowCal cm = (JobAllowCal) s.get(JobAllowCal.class, joballowcalid);
        s.delete(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewJobAllowCal() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<JobAllowCal> joballowlist = s.createQuery("from JobAllowCal").list();
        Gson g = new Gson();
        String joballowcalgson = g.toJson(joballowlist);
        t.commit();
        s.close();
        return joballowcalgson; 
    }

    @Override
    public JobAllowCal viewOneJobAllowCal(int joballowcalid) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobAllowCal cm = (JobAllowCal) s.get(JobAllowCal.class, joballowcalid);
        t.commit();
        s.close();
        Gson g = new Gson();
        String joballowcalgson = g.toJson(cm);
        return cm;
    }
    
}
