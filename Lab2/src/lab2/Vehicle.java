package lab2;

/**
 *
 * @author rebec
 */
public abstract class Vehicle {
    /* Data */

    /**
     *
     */

    protected String name;
    private Depot depot;
    private Client[] clients;

    /* Constructors */
    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
    }

    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
    public void setClients(Client... clientsLine){
        this.clients = clientsLine;
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public Depot getDepot() {
        return depot;
    }
    
    /* toString */

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicle{name='").append(name).append(", depot=").append(depot.name).append("}"); 
        return sb.toString();
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}
