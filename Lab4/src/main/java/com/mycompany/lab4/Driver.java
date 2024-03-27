/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rebec
 */
public class Driver extends Person {
    private Passenger passenger;
    private Map<Destination, Number> route;
    private int numberOfDestinations = 0;

    public Driver(String name) {
        super(name);
        route = new HashMap<>();
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setRoute(Destination dest) {
        if(!route.containsKey(dest)){
        numberOfDestinations++ ;
        route.put(dest, numberOfDestinations);
        }
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Map<Destination, Number> getRoute() {
        return route;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Driver{ name=")
                                    .append(getName())
                                    .append(", age=")
                                    .append(getAge())
                                    .append(", route:\n");
        for(Map.Entry<Destination, Number> dest : route.entrySet()){
            result.append(dest.getValue()).append(". ").append(dest.getKey()).append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
