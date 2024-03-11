package lab2;

/**
 *
 * @author rebec
 */
public class Trucks extends Vehicle {
    private int capacity;
    
    public Trucks(){}
    public Trucks(int capacity){
        this.capacity = capacity;
    }
    public Trucks(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
