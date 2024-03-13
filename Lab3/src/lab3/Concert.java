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
    private Map<LocalDate, TimeInterval> timetable = new HashMap();
    private double ticketPrice;
    
    public Concert(String name, String description){
        super(name, description);
        TimeInterval time = new TimeInterval(LocalTime.of(19,30), LocalTime.of(22,00));
        timetable.put(LocalDate.of(2024,3,16), time);
        time.setStartAndEnd(LocalTime.of(18,00), LocalTime.of(21,00));
        timetable.put(LocalDate.of(2024,3,15), time);
    }
    
    public double getTicketPrice(){
        return 100;
    }
    
    public Map<LocalDate, TimeInterval> getTimetable(){
        return timetable;
    }
}
