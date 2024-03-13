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
public class TravelPlan {

    private Map<LocalDate, Attraction> travelPlan = new HashMap();
    private Trip trip;

    public TravelPlan(Trip trip) {
        this.trip = trip;
    }

    public void createTravelPlan() {
        for (Attraction a : trip.getAttractions()) {
            if (a instanceof Concert) {
                Map<LocalDate, TimeInterval> concertTimetable = ((Concert) a).getTimetable();
                for (LocalDate date = trip.getStart(); !date.isAfter(trip.getEnd()); date = date.plusDays(1)) {
                    if (concertTimetable.containsKey(date)) {
                        travelPlan.putIfAbsent(date, a);
                        break;
                    }
                }
            } else if (a instanceof Church) {
                Map<LocalDate, TimeInterval> churchTimetable = ((Church) a).getTimetable();
                for (LocalDate date = trip.getStart(); !date.isAfter(trip.getEnd()); date = date.plusDays(1)) {
                    if (churchTimetable.containsKey(date)) {
                        travelPlan.putIfAbsent(date, a);
                        break;
                    }
                }
            } else if (a instanceof Statue) {
                Map<LocalDate, TimeInterval> statueTimetable = ((Statue) a).getTimetable();
                for (LocalDate date = trip.getStart(); !date.isAfter(trip.getEnd()); date = date.plusDays(1)) {
                    if (statueTimetable.containsKey(date)) {
                        travelPlan.putIfAbsent(date, a);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Travel plan for " + trip.getCity() + ": \n");
        for (Map.Entry<LocalDate, Attraction> entry : travelPlan.entrySet()) {
            LocalDate date = entry.getKey();
            Attraction attraction = entry.getValue();
            result.append("On " + date + ": " + attraction.getName() + "\n");
        }
        return result.toString();
    }

}
