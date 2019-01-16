/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class JobAllowCal implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int joballowcalid;
    @Column
    private int empid;
    @Column
    private int jobtitleid;
    @Column
    private double basicsalary;
    @Column
    private int allowanceid;
    @Column
    private String allowancehead;
    @Column
    private int percent;
    @Column
    private double allowpermonth;
    @Column
    private double totalallowpermonth;

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

    public double getTotalallowpermonth() {
        return totalallowpermonth;
    }

    public void setTotalallowpermonth(double totalallowpermonth) {
        this.totalallowpermonth = totalallowpermonth;
    }
    
}
