/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.LoanTypeService;
import com.bablu.payroll_management_system.model.Deduction;
import com.bablu.payroll_management_system.model.LoanType;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoanTypeServiceImpl implements LoanTypeService{
   @Autowired
   SessionFactory sessionFactory; 

    @Override
    public String insertLoanType(LoanType cm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateLoanType(LoanType cm) {
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
    public Integer deleteLoanType(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        LoanType cm = (LoanType) s.get(LoanType.class, id);
        s.delete(cm);
        t.commit();
        s.close();
        return null;  
    }

    @Override
    public String viewLoanType() {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<LoanType> categorieslist = s.createQuery("from LoanType").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson; 
    }

    @Override
    public LoanType viewOneLoanType(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        LoanType cm = (LoanType) s.get(LoanType.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;  
    }
}
