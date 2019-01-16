/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.JobTitleService;
import com.bablu.payroll_management_system.model.JobTitle;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertJobTitle(JobTitle cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer updateJobTitle(int jobtitleid, JobTitle cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deleteJobTitle(int jobtitleid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobTitle cm = (JobTitle) s.get(JobTitle.class, jobtitleid);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewJobTitle() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<JobTitle> jobtitlelist = s.createQuery("from JobTitle").list();
        Gson g = new Gson();
        String jobtitlegson = g.toJson(jobtitlelist);
        t.commit();
        s.close();
        return jobtitlegson;
    }

    @Override
    public JobTitle viewOneJobTitle(int jobtitleid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        JobTitle cm = (JobTitle) s.get(JobTitle.class, jobtitleid);
        t.commit();
        s.close();
        Gson g = new Gson();
        String jobtitlegson = g.toJson(cm);
        return cm;
    }

}
