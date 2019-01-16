/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.EmpLoanService;
import com.bablu.payroll_management_system.model.EmpLoan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import java.util.List;

@Repository
public class EmpLoanServiceImpl implements EmpLoanService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertEmpLoan(EmpLoan cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
     }

    @Override
    public Integer updateEmpLoan(int emploanid, EmpLoan cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deleteEmpLoan(int emploanid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        EmpLoan cm = (EmpLoan) s.get(EmpLoan.class, emploanid);
        s.delete(cm);
        t.commit();
        s.close();

        return null; 
    }

    @Override
    public String viewEmpLoan() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<EmpLoan> emploanlist = s.createQuery("from EmpLoan").list();
        Gson g = new Gson();
        String emploangson = g.toJson(emploanlist);
        t.commit();
        s.close();
        return emploangson;
    }

    @Override
    public EmpLoan viewOneEmpLoan(int emploanid) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        EmpLoan cm = (EmpLoan) s.get(EmpLoan.class, emploanid);
        t.commit();
        s.close();
        Gson g = new Gson();
        String emploangson = g.toJson(cm);
        return cm;
    }
}
