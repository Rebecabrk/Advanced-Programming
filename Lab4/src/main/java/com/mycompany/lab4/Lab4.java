/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author rebec
 */
public class Lab4 {
    
    public static int randomAge(){
        Random rand = new Random();
        return rand.nextInt(80 - 18 + 1) + 18;
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        ArrayList<Person> people =new ArrayList<>(Arrays.asList());

        
        for(int i=0; i<12; i++){
            Person aux = new Driver(faker.name().fullName());
            aux.setAge(randomAge());
            people.add(aux);
        }
        for(int i=0; i<5; i++){
            Person aux = new Passenger(faker.name().fullName());
            aux.setAge(randomAge());
            people.add(aux);
        }
        
        Stream<Person> drivers = people.stream()
                                        .filter(p -> p instanceof Driver);
        LinkedList<Person> driversList = drivers.collect(Collectors.toCollection(LinkedList::new));
        Stream<Person> passengers = people.stream()
                                           .filter(p -> p instanceof Passenger);
        TreeSet<Person> passengersTree = passengers.collect(Collectors.toCollection(TreeSet::new));

        Collections.sort(driversList, Comparator.comparingInt(Person::getAge));

        for (Person d : driversList) {
            Driver aux = (Driver) d;
            System.out.println(aux);
        }
        for (Person p : passengersTree) {
            Passenger aux = (Passenger) p;
            System.out.println(aux);
        }
    }
}
