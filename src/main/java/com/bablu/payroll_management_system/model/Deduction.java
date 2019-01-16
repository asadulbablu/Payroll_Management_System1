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
public class Deduction implements Serializable{
    @Id
   private int deductionid;
    @Column
   private String deductionhead;

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
}
