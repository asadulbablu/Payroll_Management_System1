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


public class Cart {
    int jobdeductcalid;
   int empid;
   int deductionid;
   String deductionhead;
   int jobtitleid;
   double basicsalary;
    int percent;
   double deductpermonth;

    public Cart(int jobdeductcalid, int empid, int deductionid, String deductionhead, int jobtitleid, double basicsalary, int percent, double deductpermonth) {
        this.jobdeductcalid = jobdeductcalid;
        this.empid = empid;
        this.deductionid = deductionid;
        this.deductionhead = deductionhead;
        this.jobtitleid = jobtitleid;
        this.basicsalary = basicsalary;
        this.percent = percent;
        this.deductpermonth = deductpermonth;
    }

    public int getJobdeductcalid() {
        return jobdeductcalid;
    }

    public void setJobdeductcalid(int jobdeductcalid) {
        this.jobdeductcalid = jobdeductcalid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getDeductionid() {
        return deductionid;
    }

    public void setDeductionid(int deductionid) {
        this.deductionid = deductionid;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
    }

    public int getJobtitleid() {
        return jobtitleid;
    }

    public void setJobtitleid(int jobtitleid) {
        this.jobtitleid = jobtitleid;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public double getDeductpermonth() {
        return deductpermonth;
    }

    public void setDeductpermonth(double deductpermonth) {
        this.deductpermonth = deductpermonth;
    }

    
    @Override
    public String toString() {
        return "Cart{" + "empid=" + empid + ", deductionid=" + deductionid + ", deductionhead=" + deductionhead + ", jobtitleid=" + jobtitleid + ", basicsalary=" + basicsalary + ", percent=" + percent +  ", deductpermonth=" + deductpermonth + ", jobdeductcalid=" + jobdeductcalid +'}';
    }
  

}
