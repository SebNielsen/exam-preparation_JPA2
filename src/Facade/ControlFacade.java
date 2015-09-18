/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Employee;
import Entities.Person;
import Entities.PhDStudent;
import Entities.Student;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public interface ControlFacade {
    public void createPerson(String firstName, String LastName, String birthDate, int age, boolean isMarried);
    public void createStudent(String firstName, String LastName, String birthDate, int age, boolean isMarried, int matNr, Date matDate);
    public void createEmployee(String firstName, String LastName, String birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass);
    public void createPhDStudent(String firstName, String LastName, String birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass, String dissSubject);
    
    public Person getPerson(long id);
    public Employee getEmployee(long id);
    public Student getStudent(long id);
    public PhDStudent getPhDStudent(long id);
    public List<Person> getSupervisesList(long id);
    public Person getSupervisor(long id);
    
    public void addSupervisorToPerson(long personId, long supervisorId);
    public void addGradeToStudent(long studentId, String name, int value);
    public void removePerson(long personId);
    
    
}
