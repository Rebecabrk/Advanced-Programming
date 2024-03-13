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
public class Concert extends Attraction implements Visitable, Payable{
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;
    
    public Concert(String name, String description){
        super(name, description);
    }
    
    public double getTicketPrice(){
        return 100;
    }
    public Map<LocalDate, TimeInterval> getTimetable(){
        Map<LocalDate, TimeInterval> timeTable = new HashMap<>();
        TimeInterval time = new TimeInterval(LocalTime.of(18,30), LocalTime.of(22,00));
        timeTable.put(LocalDate.of(2024,2,3), time);
        time.setStartAndEnd(LocalTime.of(14,00), LocalTime.of(15,30));
        timeTable.put(LocalDate.of(2024,3,3), time);
        return timeTable;
    }
}
