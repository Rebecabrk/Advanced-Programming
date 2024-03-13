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
public class Statue extends Attraction implements Visitable {
    
    public Statue(String name, String description){
        super(name, description);
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        Map<LocalDate, TimeInterval> timeTable = new HashMap<>();
        TimeInterval time = new TimeInterval(LocalTime.of(18, 30), LocalTime.of(22, 00));
        timeTable.put(LocalDate.of(2024, 2, 3), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00,00));
        timeTable.put(LocalDate.of(2024, 3, 1), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 2), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 3), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 4), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 5), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 6), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 7), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 8), time);time.setStartAndEnd(LocalTime.of(00, 00), LocalTime.of(00, 00));
        timeTable.put(LocalDate.of(2024, 3, 9), time);
        return timeTable;
    }

}
