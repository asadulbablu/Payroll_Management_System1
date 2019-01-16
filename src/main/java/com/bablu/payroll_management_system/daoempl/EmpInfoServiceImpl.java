/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.daoempl;

import com.bablu.payroll_management_system.dao.EmpInfoService;
import com.bablu.payroll_management_system.model.EmpInfo;
import com.google.gson.Gson;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpInfoServiceImpl implements EmpInfoService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertEmpInfo(EmpInfo pm) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateEmpInfo(int emp_id, EmpInfo pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        EmpInfo oneproductobject = (EmpInfo) s.get(EmpInfo.class, emp_id);
        oneproductobject.setEmpname(pm.getEmpname());
        oneproductobject.setGender(pm.getGender());
        oneproductobject.setJoiningdate(pm.getJoiningdate());
        oneproductobject.setTypeid(pm.getTypeid());
        oneproductobject.setDeptid(pm.getDeptid());
        oneproductobject.setPhoneno(pm.getPhoneno());
        s.update(oneproductobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteEmpInfo(int emp_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        EmpInfo pm = (EmpInfo) s.get(EmpInfo.class, emp_id);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewEmpInfo() {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<EmpInfo> productslist = s.createQuery("from EmpInfo").list();
        Gson g = new Gson();
        String productslistgson = g.toJson(productslist);
        t.commit();
        s.close();
        return productslistgson;
    }

    @Override
    public EmpInfo viewOneEmpInfo(int emp_id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        EmpInfo pm = (EmpInfo) s.get(EmpInfo.class, emp_id);
        t.commit();
        s.close();
        return pm;
    }
}
