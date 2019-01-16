/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.google.gson.Gson;
import com.bablu.payroll_management_system.dao.DepartmentService;
import com.bablu.payroll_management_system.dao.DepartmentService;
import com.bablu.payroll_management_system.model.Department;
import com.bablu.payroll_management_system.model.Department;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertDepartment(Department cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateDepartment(Department cm) {
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
    public Integer deleteDepartment(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Department cm = (Department) s.get(Department.class, id);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewDepartment() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Department> departmentlist = s.createQuery("from Department").list();
        Gson g = new Gson();
        String departmentlistgson = g.toJson(departmentlist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return departmentlistgson;
    }

    @Override
    public Department viewOneDepartment(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Department cm = (Department) s.get(Department.class, id);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(cm);
        return cm;
    }

    
}
