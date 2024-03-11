package lab2;

/**
 *
 * @author rebec
 */
public class Problem {

    private static int id = 0;
    private Depot[] depots;
    private int numberOfDepots;
    private int capacityOfDepots;
    private Client[] clients;
    private int numberOfClients;
    private int capacityOfClients;

    /**
     *
     */
    public Problem() {
        numberOfDepots = 0;
        numberOfClients = 0;
        capacityOfDepots = 1;
        capacityOfClients = 1;
        depots = new Depot[1];
        clients = new Client[1];
        id++;
    }

    public void setDepots(Depot... depotsLine) {
        for (Depot d : depotsLine) {
            if (isDuplicateDepot(d) == false) {
                numberOfDepots++;
                if (numberOfDepots > capacityOfDepots) {
                    /* Ading another depot will result in overflow */
                    capacityOfDepots = capacityOfDepots * 2;
                    Depot[] newDepots = new Depot[capacityOfDepots];
                    for(int i=0; i<this.depots.length; i++){
                        newDepots[i] = depots[i];
                    }
                    newDepots[numberOfDepots - 1] = d;
                    this.depots = newDepots;
                } else {
                    this.depots[numberOfDepots - 1] = d;
                }
            } else {
                System.out.println("Depot: " + d.getName() + " is already in the array of depots.");
            }
        }
    }

    public void setClients(Client... clientsLine) {
        for (Client c : clientsLine) {
            if (isDuplicateClient(c) == false) {
                numberOfClients++;
                if (numberOfClients > capacityOfClients) {
                    /* Ading another depot will result in overflow */
                    capacityOfClients = capacityOfClients * 2;
                    Client[] newClients = new Client[capacityOfClients];
                    for(int i=0; i<this.clients.length; i++){
                        newClients[i] = clients[i];
                    }
                    newClients[numberOfClients - 1] = c;
                    this.clients = newClients;
                } else {
                    this.clients[numberOfClients - 1] = c;
                }
            } else {
                System.out.println("Client: " + c.getName() + " is already in the array of clients.");
            }
        }
    }

    public Depot[] getDepots() {
        return depots;
    }

    public Client[] getClients() {
        return clients;
    }
    public Vehicle[] getVehicles(){
        int numberOfVehicles = 0;
        for(Depot d : depots){
            if(d.vehicles != null && d.vehicles.length > 0)
            numberOfVehicles += d.vehicles.length;
        }
        Vehicle[] vehicles = new Vehicle[numberOfVehicles];
        int i = 0;
        for(Depot d : depots){
            if(d.vehicles != null && d.vehicles.length > 0)
            for(Vehicle v : d.vehicles){
                vehicles[i] = v;
                i++;
            }
        }
        return vehicles;
    }

    public boolean isDuplicateDepot(Depot d) {
        if (depots != null && depots.length > 0) {
            for (Depot depot : this.depots) {
                if (depot == d) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isDuplicateClient(Client c) {
        for (Client client : this.clients) {
            if (client == c) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Problem ");
        result.append(this.id).append(": Depots=[");
        if (this.depots != null && numberOfDepots > 0) {
            for (int i = 0; i < depots.length; i++) {
                result.append(depots[i].getName());
                if (i < depots.length - 1) {
                    result.append(", ");
                }
            }
        } else {
            result.append("No depots");
        }
        result.append("], ");
        result.append("Clients=[");
        if (this.clients != null && numberOfClients > 0) {
            for (int i = 0; i < clients.length; i++) {
                result.append(clients[i].getName());
                if (i < clients.length - 1) {
                    result.append(", ");
                }
            }
        }else {
            result.append("No clients");
        }
        result.append("]}");
        return result.toString();
    }
}
