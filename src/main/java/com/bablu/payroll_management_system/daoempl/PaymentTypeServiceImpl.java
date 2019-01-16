/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.PaymentTypeService;
import com.bablu.payroll_management_system.model.JobType;
import com.bablu.payroll_management_system.model.PaymentType;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentTypeServiceImpl implements  PaymentTypeService{
@Autowired
   SessionFactory sessionFactory;

    @Override
    public String insertPaymentType(PaymentType cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updatePaymentType(PaymentType cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public Integer deletePaymentType(int id) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        PaymentType cm = (PaymentType) s.get(PaymentType.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewPaymentType() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<PaymentType> categorieslist = s.createQuery("from PaymentType").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public PaymentType viewOnePaymentType(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        PaymentType cm = (PaymentType) s.get(PaymentType.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }
}
