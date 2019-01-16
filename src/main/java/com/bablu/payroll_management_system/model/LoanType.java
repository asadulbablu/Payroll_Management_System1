/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bablu.payroll_management_system.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanType implements Serializable{
    @Id
    private int loantypeid;
    @Column
    private String loandescription;
    
    public int getLoantypeid() {
        return loantypeid;
    }

    public void setLoantypeid(int loantypeid) {
        this.loantypeid = loantypeid;
    }
    
        public String getLoandescription() {
        return loandescription;
    }

    public void setLoandescription(String loandescription) {
        this.loandescription = loandescription;
    }
}
