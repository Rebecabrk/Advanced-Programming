/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comparatori;

/**
 *
 * @author rebec
 */
public class Pet implements Comparable<Pet>{

    private int age;

    public Pet(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet{" + "age=" + age + '}';
    }
    
    @Override
    public int compareTo(Pet pet){
        return this.age - pet.age;
    }

}
