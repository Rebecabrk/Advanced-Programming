/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;


import com.github.javafaker.Faker;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 *
 * @author rebec
 */
public class Lab4 {

    public static void main(String[] args) {
        Faker faker = new Faker();
        
        Driver driver1 = new Driver(faker.name().fullName());
        Driver driver2 = new Driver(faker.name().fullName());
        Driver driver3 = new Driver(faker.name().fullName());

        Passenger pass1 = new Passenger(faker.name().fullName());
        Passenger pass2 = new Passenger(faker.name().fullName());
        Passenger pass3 = new Passenger(faker.name().fullName());

        LinkedList<Driver> driversList = new LinkedList<>();
        driversList.add(driver1);
        driversList.add(driver2);
        driversList.add(driver3);
        
        driver1.setAge(21);
        driver2.setAge(31);
        driver3.setAge(19);

        TreeSet<Passenger> passengersTree = new TreeSet<>();
        passengersTree.add(pass1);
        passengersTree.add(pass2);
        passengersTree.add(pass3);

        Collections.sort(driversList, Comparator.comparingInt(Driver::getAge));
        
        
        

String name = faker.name().fullName(); // Miss Samanta Schmidt

        
        for(Driver d: driversList){
            System.out.println(d);
        }
        for(Passenger p: passengersTree){
            System.out.println(p);
        }
    }

}
