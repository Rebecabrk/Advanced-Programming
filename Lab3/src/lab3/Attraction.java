/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author rebec
 */
public abstract class Attraction implements Comparable<Attraction> {
    private String name;
    private String description;

    public Attraction() {}

    public Attraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Attraction{" + "name=" + name + ", description=" + description + '}';
    }

    @Override
    public int compareTo(Attraction o){
        return this.name.compareTo(o.name);
    }

}
