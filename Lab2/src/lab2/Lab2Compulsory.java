package lab2;

import java.time.LocalTime;
import static lab2.ClientTypes.PREMIUM;
import static lab2.ClientTypes.REGULAR;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author rebec
 */


public class Lab2Compulsory {
    
    /**
     *
     * @return random LocalTimes
     */
    public static LocalTime generateRandomTime() {
        LocalTime morning = LocalTime.of(8, 30);
        LocalTime evening = LocalTime.of(22, 0);

        long randomSecondsOfDay = ThreadLocalRandom.current().nextLong(
            morning.toSecondOfDay(),
            evening.toSecondOfDay()
        );

        return LocalTime.ofSecondOfDay(randomSecondsOfDay);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Creating a problem */
        Problem problem1 = new Problem();
        Solution solution = new Solution(problem1);
        
        /* Creating depots for problem1 */
        Depot depot1 = new Depot("FirstDepot");
        Depot depot2 = new Depot("SecondDepot");
        
        /* Adding depot to problem1 */
        problem1.setDepots(depot1, depot2, depot1);
        
        /* Creating a client */
        Client client1 = new Client("Rebeca", PREMIUM, generateRandomTime(), generateRandomTime());
        Client client2 = new Client("Hannah", REGULAR, generateRandomTime(), generateRandomTime());
        Client client3 = new Client("Friend", REGULAR, generateRandomTime(), generateRandomTime());
        Client client4 = new Client("AnotherFriend", PREMIUM, generateRandomTime(), generateRandomTime());
        problem1.setClients(client1, client2, client3, client4);
        Vehicle truck1 = new Trucks(1, "TruckOne");
        Vehicle drone1 = new Drones(5, "DroneOne");
        Vehicle truck2 = new Trucks(2, "TruckTwo");
        
        depot1.setVehicles(truck1, drone1, truck2);
        
        System.out.println(problem1);
        for(Vehicle v : problem1.getVehicles()){
            System.out.print(v.getName() + " ");
        }
        System.out.println();
        solution.greedyAlgorithm();
    }
    
}
