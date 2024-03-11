/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.util.ArrayList;
import static lab2.ClientTypes.PREMIUM;

/**
 *
 * @author rebec
 */
public class Solution {

    Problem problem;
    Tour[] tours;
    
    public Solution(Problem problem){
        this.problem = problem;
    }
    
//    public void sortClients(){
//        Client[] sortingClients = problem.getClients();
//        /* from smallest minTime to biggest maxTime */
//        for(int i=0; i<sortingClients.length; i++){
//            for(int j=1; j<sortingClients.length; j++){
//                if(sortingClients[i])
//            }
//        }
//    }
/**each truck will get regular clients (its capacity decides how many clients it can visit in a tour)
 * each drone will get premium clients (its duration will decide how many clients it can visit in a tour)
 * @params nothing
 * @returns nothing
 */
    public void greedyAlgorithm() {
        System.out.println("Solution: ");
        ArrayList<Trucks> trucks = new ArrayList();
        ArrayList<Drones> drones = new ArrayList();
        Vehicle[] vehicles = problem.getVehicles();
        for(Vehicle v : vehicles){
            if(v instanceof Trucks){
                trucks.add((Trucks) v);
                //((Trucks) v).getCapacity();
            }else{
                drones.add((Drones) v);
            }
        }
        for(Client c : problem.getClients()){
            if(c.getType() == PREMIUM){
                for(Drones d : drones){
                    if(d.getDuration() > 0){
                        d.setDuration(d.getDuration() - 1);
                        System.out.println("Client: " + c.getName() + " is assigned to drone: " + d.getName());
                        break;
                    }
                }
            }else{
                for(Trucks t : trucks){
                    if(t.getCapacity() > 0){
                        t.setCapacity(t.getCapacity() - 1);
                        System.out.println("Client: " + c.getName() + " is assigned to truck: " + t.getName());
                        break;
                    }
                }
            }
        }
    }
}
