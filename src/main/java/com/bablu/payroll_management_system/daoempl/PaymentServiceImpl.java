/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.PaymentService;
import com.bablu.payroll_management_system.model.Payment;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentServiceImpl implements PaymentService{
  @Autowired
  SessionFactory sessionFactory; 

    @Override
    public String insertPayment(Payment cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public String updatePayment(int payid, Payment cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deletePayment(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment cm = (Payment) s.get(Payment.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null; 
    }

    @Override
    public String viewPayment() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> paymentlist = s.createQuery("from Payment").list();
        Gson g = new Gson();
        String paymentgson = g.toJson(paymentlist);
        t.commit();
        s.close();
        return paymentgson;
    }

    @Override
    public Payment viewOnePayment(int id) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment cm = (Payment) s.get(Payment.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String paymentgson = g.toJson(cm);
        return cm;   
    }
}
