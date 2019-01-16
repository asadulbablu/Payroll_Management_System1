/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.LoanPaymentService;
import com.bablu.payroll_management_system.model.LoanPayment;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoanPaymentServiceImpl implements LoanPaymentService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertLoanPayment(LoanPayment pm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        
        s.save(pm);
       
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public String updateLoanPayment(int loanpayid, LoanPayment pm) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(pm);
        t.commit();
        s.close();
        return null;  
    }

    @Override
    public String deleteLoanPayment(int loanpayid) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        LoanPayment pm = (LoanPayment) s.get(LoanPayment.class, loanpayid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewLoanPayment() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<LoanPayment> loanpaylist = s.createQuery("from LoanPayment").list();
        Gson g = new Gson();
        String loanpaygson = g.toJson(loanpaylist);
        t.commit();
        s.close();
        return loanpaygson;
    }

    @Override
    public LoanPayment viewOneLoanPayment(int loanpayid) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        LoanPayment pm = (LoanPayment) s.get(LoanPayment.class, loanpayid);
        t.commit();
        s.close();
        return pm;
    }
}
