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

@Entity
public class JobDeductCal {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jobdeductcalid;
    @Column
    private int jobtitleid;
    @Column
    private int deductionid;
    @Column
    private double deductpermonth;
    @Column
    private double basicsalary;
    @Column
    private int percent;
    @Column
    private int empid;
    @Column
    private String deductionhead;
    @Column
    private double totaldeductpermonth;

    public double getTotaldeductpermonth() {
        return totaldeductpermonth;
    }

    public void setTotaldeductpermonth(double totaldeductpermonth) {
        this.totaldeductpermonth = totaldeductpermonth;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
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

    public int getDeductionid() {
        return deductionid;
    }

    public void setDeductionid(int deductionid) {
        this.deductionid = deductionid;
    }

    public double getDeductpermonth() {
        return deductpermonth;
    }

    public void setDeductpermonth(double deductpermonth) {
        this.deductpermonth = deductpermonth;
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

}
