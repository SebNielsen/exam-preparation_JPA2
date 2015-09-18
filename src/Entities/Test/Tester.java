/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.Test;

import Control.Control;
import Entities.Person;
import Facade.ControlFacade;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public class Tester {
    
    public static void main(String[] args) {
     test();   
        
    }
    
    public static void test(){
        ControlFacade control = new Control();
        
        control.createStudent("Sebastian", "Nielsen", "1988-9-29", 26, true, 2321, null);
        control.createEmployee("Sofus", "Albertsen", "1985-3-21", 30, true, 34032, 30000, "TaxClass");
        control.addSupervisorToPerson(1l, 2l);
        control.createPhDStudent("Hans", "Hansen", "1982-4-30", 33, true, 23402, 28000, "TaxClass", "Title");
        
        List<Person> supervises = control.getSupervisesList(2l);
        for(Person p : supervises){
            System.out.println(control.getPerson(2l).getFirstName() + " supervises " + p.getFirstName());
        }
        System.out.println("Get Sebastians supervisor");
        System.out.println(control.getStudent(1l).getSupervisor().getFirstName());
        
        
    }
    
    
}
