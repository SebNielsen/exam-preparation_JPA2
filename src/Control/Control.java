/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entities.Employee;
import Entities.Grade;
import Entities.Person;
import Entities.PhDStudent;
import Entities.Student;
import Facade.ControlFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author sebastiannielsen
 */
public class Control implements ControlFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exam-JPA2PU");
    EntityManager em = emf.createEntityManager();
    DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public void createPerson(String firstName, String LastName, String birthDate, int age, boolean isMarried) {
        Date birthdate = null;
        try {
            birthdate = dateformat.parse(birthDate);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        Person p = new Person(firstName, LastName, birthdate, age, isMarried);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public void createStudent(String firstName, String LastName, String birthDate, int age, boolean isMarried, int matNr, Date matDate) {
        Date birthdate = null;
           try {
            birthdate = dateformat.parse(birthDate);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        Student s = new Student(matNr, matDate);
        s.setFirstName(firstName);
        s.setLastName(LastName);
        s.setBirthDate(birthdate);
        s.setAge(age);
        s.setIsMarried(isMarried);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    @Override
    public void createEmployee(String firstName, String LastName, String birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass) {
        Date birthdate = null;
           try {
            birthdate = dateformat.parse(birthDate);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        Employee e = new Employee(soSecNr, wage, taxClass);
        e.setFirstName(firstName);
        e.setLastName(LastName);
        e.setBirthDate(birthdate);
        e.setAge(age);
        e.setIsMarried(isMarried);
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    @Override
    public void createPhDStudent(String firstName, String LastName, String birthDate, int age, boolean isMarried, int soSecNr, float wage, String taxClass, String dissSubject) {
        Date birthdate = null;
           try {
            birthdate = dateformat.parse(birthDate);
        } catch (ParseException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        PhDStudent phds= new PhDStudent();
        phds.setFirstName(firstName);
        phds.setLastName(LastName);
        phds.setBirthDate(birthdate);
        phds.setAge(age);
        phds.setIsMarried(isMarried);
        phds.setSoSecNr(soSecNr);
        phds.setWage(wage);
        phds.setTaxClass(taxClass);
        phds.setDissSubject(dissSubject);
        em.getTransaction().begin();
        em.persist(phds);
        em.getTransaction().commit();
    }

    @Override
    public Employee getEmployee(long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Student getStudent(long id) {
        return em.find(Student.class, id);
    }

    @Override
    public PhDStudent getPhDStudent(long id) {
        return em.find(PhDStudent.class, id);
    }

    @Override
    public void removePerson(long personId) {
        Person p = em.find(Person.class, personId);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    @Override
    public void addSupervisorToPerson(long personId, long supervisorId) {
        Person p = em.find(Person.class, personId);
        Person supervisor = em.find(Person.class, supervisorId);
        em.getTransaction().begin();
        p.setSupervisor(supervisor);
        supervisor.addToSupervisorList(p);
        em.persist(p);
        em.persist(supervisor);
        em.getTransaction().commit();
    }
    
    @Override
    public Person getSupervisor(long id) {
        return em.find(Person.class, id).getSupervisor();
    }

    @Override
    public Person getPerson(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public void addGradeToStudent(long studentId, String name, int value) {
        Student s = em.find(Student.class, studentId);
        Grade g = new Grade(name, value);
        s.addGrade(g);
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    @Override
    public List<Person> getSupervisesList(long id) {
        return em.find(Person.class, id).getSupervises();
    }

    
}
