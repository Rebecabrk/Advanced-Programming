package lab2;

import java.util.ArrayList;

/**
 *
 * @author rebec
 */
public class Depot {
    /* Data */
    String name;
    Vehicle[] vehicles;

    /* Constructors */

    /**
     *
     */

    public Depot() {
    }

    public Depot(String name) {
        this.name = name;
    }

    public Depot(Vehicle[] vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }

    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }
    }


    /* Getters */
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public String getName() {
        return name;
    }

    /* toString */

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Depot{name='").append(name).append("', vehicles=[");
        if (vehicles != null && vehicles.length > 0) {
            for (int i = 0; i < vehicles.length; i++) {
                sb.append(vehicles[i].getName());
                if (i < vehicles.length - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("No vehicles");
        }
        sb.append("]}");
        return sb.toString();
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) obj;
        return name.equals(other.name);
    }
}
