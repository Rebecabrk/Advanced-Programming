/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author rebec
 */
public class Person {
    private String name;
    int age;
    Destination destination;
    
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDestination(Destination dest){
        destination = dest;
    }
    public Destination getDestination(){
        return destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
}
