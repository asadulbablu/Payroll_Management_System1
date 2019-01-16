/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class NetSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int netsalaryid;
    @Column
    private int empid;
    @Transient
    private int joballowcalid;
    @Transient
    private int jobdeductcalid;
    @Transient
    private int jobtitleid;
    @Column
    private double netsalary;
    @Column
    private double basicsalary;
    @Column
    private String empname;
    @Column
    private double totalallowpermonth;
    @Column
    private double totaldeductpermonth;

    public double getTotalallowpermonth() {
        return totalallowpermonth;
    }

    public void setTotalallowpermonth(double totalallowpermonth) {
        this.totalallowpermonth = totalallowpermonth;
    }

    public double getTotaldeductpermonth() {
        return totaldeductpermonth;
    }

    public void setTotaldeductpermonth(double totaldeductpermonth) {
        this.totaldeductpermonth = totaldeductpermonth;
    }
    

    public int getNetsalaryid() {
        return netsalaryid;
    }

    public void setNetsalaryid(int netsalaryid) {
        this.netsalaryid = netsalaryid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getJoballowcalid() {
        return joballowcalid;
    }

    public void setJoballowcalid(int joballowcalid) {
        this.joballowcalid = joballowcalid;
    }

    public int getJobdeductcalid() {
        return jobdeductcalid;
    }

    public void setJobdeductcalid(int jobdeductcalid) {
        this.jobdeductcalid = jobdeductcalid;
    }

    public int getJobtitleid() {
        return jobtitleid;
    }

    public void setJobtitleid(int jobtitleid) {
        this.jobtitleid = jobtitleid;
    }

    public double getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    
    
}
