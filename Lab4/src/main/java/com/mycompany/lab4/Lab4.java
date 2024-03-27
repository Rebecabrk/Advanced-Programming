/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab4;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
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
    
    public static int randomNumber(){
        Random rand = new Random();
        return rand.nextInt(8-3+1) + 3;
    }
    
    public static Destination randomDestination(){
        Destination[] destinations = Destination.values();
        Random rand = new Random();
        return destinations[rand.nextInt(destinations.length)];
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        ArrayList<Person> people =new ArrayList<>();

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
        
        LinkedList<Driver> drivers = people.stream()
            .filter(Driver.class::isInstance)
            .map(Driver.class::cast)
            .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = people.stream()
            .filter(Passenger.class::isInstance)
            .map(Passenger.class::cast)
            .collect(Collectors.toCollection(TreeSet::new));
        
        Collections.sort(drivers, Comparator.comparingInt(Person::getAge));

        for (Driver d : drivers) {
            int i = randomNumber();
            for(;i>0;i--){
                d.setRoute(randomDestination());
            }
            System.out.println(d);
        }
        for (Passenger p : passengers) {
            p.setDestination(randomDestination());
            System.out.println(p);
        }
        System.out.println("\nSolution: ");
        Bolt bolt = new Bolt();
        bolt.solution(drivers, passengers);
    }
}
