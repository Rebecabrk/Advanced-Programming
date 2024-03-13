/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3;

import java.time.LocalDate;

/**
 *
 * @author rebec
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trip trip1 = new Trip("Venice", LocalDate.now(), LocalDate.of(2024,3,22));
        TravelPlan travelplan = new TravelPlan(trip1);
        
        Attraction statue = new Statue("Statue San Marco", "These columns are at the southern entrance of St. Mark's Square used to be an entrance for merchant ships coming to Venice. ");
        Attraction church = new Church("Church Of Vivaldi", "Enjoy the classical concerts of the masterful Interpreti Veneziani with musical works by Antonio Vivaldi, Arcangelo Corelli, Giuseppe Tartini, Felix Mendelssohn, Pablo de Sarasate or Niccolo Paganini.");
        Attraction concert = new Concert("Classical Concert", "The Four Seasons Concert by Vivaldi");
 
        trip1.setAttractions(statue, church, concert);
        System.out.println(trip1);
        trip1.visitableAttractions();
        travelplan.createTravelPlan();
        System.out.println(travelplan);
    }
    
}
