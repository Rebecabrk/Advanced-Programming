/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rebec
 */
public class Church extends Attraction implements Visitable {
    public Church(String name, String description){
        super(name, description);
    }
    
    @Override
    public Map<LocalDate, TimeInterval> getTimetable(){
        Map<LocalDate, TimeInterval> timeTable = new HashMap<>();
        TimeInterval time = new TimeInterval(LocalTime.of(10,30), LocalTime.of(17,00));
        timeTable.put(LocalDate.of(2024,5,1), time);
        time.setStartAndEnd(LocalTime.of(12,00), LocalTime.of(17,30));
        timeTable.put(LocalDate.of(2024,12,25), time);
        return timeTable;
    }
    
}
