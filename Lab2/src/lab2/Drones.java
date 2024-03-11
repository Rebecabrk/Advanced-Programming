/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author rebec
 */
public class Drones extends Vehicle {
    private int duration;

    public Drones() {
    }

    public Drones(int duration, String name) {
        super(name);
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
}
