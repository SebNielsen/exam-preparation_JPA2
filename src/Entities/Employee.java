/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.*;

/**
 *
 * @author sebastiannielsen
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee extends Person {
    
    private int soSecNr;
    private float wage;
    private String taxClass;

    public Employee() {
    }
    
    public Employee(int soSecNr, float wage, String taxClass){
        this.soSecNr = soSecNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }
    
    public int getSoSecNr() {
        return soSecNr;
    }

    public void setSoSecNr(int soSecNr) {
        this.soSecNr = soSecNr;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }
    
    
    
}
