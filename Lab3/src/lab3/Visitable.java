/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 *
 * @author rebec
 */
public interface Visitable {

    Map<LocalDate, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        if(date.isEqual(LocalDate.of(2024,2,3))){
            return LocalTime.of(8,0);
        }else if(date.isBefore(LocalDate.of(2024,2,3))){
            return LocalTime.of(12,30);
        }else if(date.isAfter(LocalDate.of(2024,2,3))){
            return LocalTime.of(10,30);
        }
        //return LocalTime.now();
        return null;
    }
}
