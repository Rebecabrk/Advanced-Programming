/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author rebec
 */
public class Bolt {
    Map<Driver, Passenger> solutions;
    
    public Bolt(){
        solutions = new HashMap<>();
    }
    
    public void solution(LinkedList<Driver> driversList, TreeSet<Passenger> passengersTree){
        for(Driver d : driversList){
            if(d.getPassenger() == null){
                Map<Destination, Number> route = d.getRoute();
            for(Passenger p : passengersTree){
                if(route.containsKey(p.getDestination())){
                    solutions.put(d, p);
                    passengersTree.remove(p);
                    d.setPassenger(p);
                    break;
                }
            }
            }
        }
        
        for(Map.Entry<Driver, Passenger> a : solutions.entrySet()){
            System.out.println(a.getKey().getName() + " -> " + a.getValue().getName());
        }
    } 
}
