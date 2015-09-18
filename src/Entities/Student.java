/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author sebastiannielsen
 */
@Entity
public class Student extends Person {
    private int matNr;
    
    @Temporal(TemporalType.DATE)
    private Date matDate;
    
    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();
    
    public Student(){
        
    }
    
    public Student(int matNr, Date matDate){
        this.matNr = matNr;
        this.matDate = matDate;
    }

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public Date getMatDate() {
        return matDate;
    }

    public void setMatDate(Date matDate) {
        this.matDate = matDate;
    }
    
    public void addGrade(Grade g){
        grades.add(g);
    }
    
    
    
    
}
