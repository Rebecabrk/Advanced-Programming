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
public class Trip {

    private String city;
    private LocalDate start, end;
    private Attraction[] attractions;

    public Trip() {
    }

    public Trip(String city) {
        this.city = city;
    }

    public Trip(String city, LocalDate start, LocalDate end) {
        this.city = city;
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getCity() {
        return city;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setAttractions(Attraction... attractions) {
        this.attractions = attractions;
    }

    public void visitableAttractions() {
        Map<Attraction, LocalTime> order = new HashMap();
        Attraction[] visitable = new Attraction[attractions.length];
        int i = 0;
        for (Attraction a : attractions) {
            if (!(a instanceof Concert) && a != null) {
                visitable[i] = a;
                i++;
            }
        }
        for (i = 0; i < visitable.length - 2; i++) {
            for (int j = i + 1; j < visitable.length - 1; j++) {
                LocalTime time1 = ((Visitable) visitable[i]).getOpeningHour(start);
                LocalTime time2 = ((Visitable) visitable[j]).getOpeningHour(start);
                if (time1.isAfter(time2)) {
                    Attraction aux = visitable[i];
                    visitable[i] = visitable[j];
                    visitable[j] = aux;
                } else if (time1.isAfter(time2)) {

                } else {
                    /* comparam numele atractiilor */
                    String name1 = visitable[i].getName();
                    String name2 = visitable[j].getName();

                    if (name1.compareTo(name2) > 0) {
                        Attraction aux = visitable[i];
                        visitable[i] = visitable[j];
                        visitable[j] = aux;
                    }
                }
            }
        }
        System.out.println("Visitable (and not payable) attractions from " + city + ":");
        for (Attraction a : visitable) {
            if (a != null) {
                System.out.println(a.getName() + " " + ((Visitable) a).getOpeningHour(start));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Trip in ")
                .append(city)
                .append(" from ")
                .append(start)
                .append(" until ")
                .append(end).append(". The attractions are: ");
        if (this.attractions != null && attractions.length > 0) {
            for (int i = 0; i < attractions.length; i++) {
                result.append(attractions[i].getName());
                if (i < attractions.length - 1) {
                    result.append(", ");
                }
            }
        } else {
            result.append("No attractions");
        }
        result.append(".");
        return result.toString();
    }

}
