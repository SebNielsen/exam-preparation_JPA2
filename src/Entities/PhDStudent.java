/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author sebastiannielsen
 */
@Entity
public class PhDStudent extends Employee {
    private String dissSubject;

    public PhDStudent() {
    
    }

    public String getDissSubject() {
        return dissSubject;
    }

    public void setDissSubject(String dissSubject) {
        this.dissSubject = dissSubject;
    }
    
}
