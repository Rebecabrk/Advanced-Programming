/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.time.LocalTime;

/**
 *
 * @author rebec
 */
public class TimeInterval {
    private LocalTime start, end;

    public TimeInterval() {
    }

    public TimeInterval(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setStartAndEnd(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    
    
}
