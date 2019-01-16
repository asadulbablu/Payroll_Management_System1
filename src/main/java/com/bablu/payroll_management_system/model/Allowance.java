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
public class Allowance implements Serializable{
    @Id
    private int allowanceid;
    @Column
    private String allowancehead;

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
}
