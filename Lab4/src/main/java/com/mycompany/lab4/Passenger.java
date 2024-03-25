/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author rebec
 */
public class Passenger extends Person implements Comparable<Passenger> {
    Driver driver;

    public Passenger(String name) {
        super(name);
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
    
    @Override
    public int compareTo(Passenger other) {
        return super.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
