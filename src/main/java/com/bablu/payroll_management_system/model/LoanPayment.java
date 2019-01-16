/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LoanPayment {
    @Id
   private int loanpayid;
    @Column
   private int empid;
    @Column
   private int loanid;
    @Column
   private double loanpayamount;
    @Temporal(TemporalType.DATE)
   private Date loanpaydate;
   @Column
   private double loanamountain;
   @Column
   private double loanamount;

    public double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(double loanamount) {
        this.loanamount = loanamount;
    }

    public double getLoanamountain() {
        return loanamountain;
    }

    public void setLoanamountain(double loanamountain) {
        this.loanamountain = loanamountain;
    }

    public int getLoanpayid() {
        return loanpayid;
    }

    public void setLoanpayid(int loanpayid) {
        this.loanpayid = loanpayid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public double getLoanpayamount() {
        return loanpayamount;
    }

    public void setLoanpayamount(double loanpayamount) {
        this.loanpayamount = loanpayamount;
    }

    public Date getLoanpaydate() {
        return loanpaydate;
    }

    public void setLoanpaydate(Date loanpaydate) {
        this.loanpaydate = loanpaydate;
    }
    
}
