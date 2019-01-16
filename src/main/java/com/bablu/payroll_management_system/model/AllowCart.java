/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

/**
 *
 * @author C6
 */
public class AllowCart {
   int joballowcalid;
   int empid;
   int allowanceid;
   String allowancehead;
   int jobtitleid;
   double basicsalary;
    int percent;
   double allowpermonth;

    public AllowCart(int joballowcalid, int empid, int allowanceid, String allowancehead, int jobtitleid, double basicsalary, int percent, double allowpermonth) {
        this.joballowcalid = joballowcalid;
        this.empid = empid;
        this.allowanceid = allowanceid;
        this.allowancehead = allowancehead;
        this.jobtitleid = jobtitleid;
        this.basicsalary = basicsalary;
        this.percent = percent;
        this.allowpermonth = allowpermonth;
    }

    public int getJoballowcalid() {
        return joballowcalid;
    }

    public void setJoballowcalid(int joballowcalid) {
        this.joballowcalid = joballowcalid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getAllowanceid() {
        return allowanceid;
    }

    public void setAllowanceid(int allowanceid) {
        this.allowanceid = allowanceid;
    }

    public String getAllowancehead() {
        return allowancehead;
    }

    public void setAllowancehead(String allowancehead) {
        this.allowancehead = allowancehead;
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

    public double getAllowpermonth() {
        return allowpermonth;
    }

    public void setAllowpermonth(double allowpermonth) {
        this.allowpermonth = allowpermonth;
    }

    @Override
    public String toString() {
        return "AllowCart{" + "joballowcalid=" + joballowcalid + ", empid=" + empid + ", allowanceid=" + allowanceid + ", allowancehead=" + allowancehead + ", jobtitleid=" + jobtitleid + ", basicsalary=" + basicsalary + ", percent=" + percent + ", allowpermonth=" + allowpermonth + '}';
    }
   
}
