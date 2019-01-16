/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmpLoan implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanid;
    @Column
    private int empid;
    @Column
    private int loantypeid;
    @Temporal(TemporalType.DATE)
    private Date loandate;
    @Temporal(TemporalType.DATE)
    private Date maturedate;
    @Column
    private double loanamount;

    public double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(double loanamount) {
        this.loanamount = loanamount;
    }

    public int getLoantypeid() {
        return loantypeid;
    }

    public void setLoantypeid(int loantypeid) {
        this.loantypeid = loantypeid;
    }
    

    public int getLoanid() {
        return loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

        public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public Date getMaturedate() {
        return maturedate;
    }

    public void setMaturedate(Date maturedate) {
        this.maturedate = maturedate;
    }
    
}
