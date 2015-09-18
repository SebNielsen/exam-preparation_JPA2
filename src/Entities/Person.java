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
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String firstName;
    private String lastName;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    
    private int age;
    private boolean isMarried;
    
    @OneToOne
    private Person supervisor;
    
    @OneToMany (mappedBy = "supervisor")
    private List<Person> supervises = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName, Date birthDate, int age, boolean isMarried) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.isMarried = isMarried;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    public List<Person> getSupervises() {
        return supervises;
    }

    public void addToSupervisorList(Person p) {
        supervises.add(p);
    }
    
    
    
    
}
