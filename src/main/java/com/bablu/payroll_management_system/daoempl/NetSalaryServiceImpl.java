/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.NetSalaryService;
import com.bablu.payroll_management_system.model.NetSalary;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NetSalaryServiceImpl implements NetSalaryService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertNetSalary(NetSalary cm) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;  
    }

    @Override
    public String updateNetSalary(NetSalary cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public Integer deleteNetSalary(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        NetSalary cm = (NetSalary) s.get(NetSalary.class, id);
        s.delete(cm);
        t.commit();
        s.close();
        return null;  
    }

    @Override
    public String viewNetSalary() {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<NetSalary> categorieslist = s.createQuery("from NetSalary").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;   
    }

    @Override
    public NetSalary viewOneNetSalary(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        NetSalary cm = (NetSalary) s.get(NetSalary.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm; 
    }
}
