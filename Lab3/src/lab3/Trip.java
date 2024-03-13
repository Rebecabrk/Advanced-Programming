/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.time.LocalDate;

/**
 *
 * @author rebec
 */
public class Trip {
    private String city;
    private LocalDate start, end;
    private Attraction[] attractions;
    
    public Trip(){}

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
