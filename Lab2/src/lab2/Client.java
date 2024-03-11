package lab2;
import java.time.LocalTime;

/**
 *
 * @author rebec
 */

public class Client {
    /* Data */
    private ClientTypes type;
    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    
    /* Constructors */

    /**
     *
     */

    public Client(){}
    public Client(String name){
        this.name = name;
    }
    public Client(String name, ClientTypes type){
        this.name = name;
        this.type = type;
    }
    public Client(String name, LocalTime min, LocalTime max){
        this.name = name;
        this.minTime = min;
        this.maxTime = max;
    }
    public Client(String name, ClientTypes type, LocalTime time1, LocalTime time2) {
        this.type = type;
        this.name = name;
        if(time1.compareTo(time2) > 0){
            this.minTime = time2;
            this.maxTime = time1;
        }else if(time1.compareTo(time2) == 0){
            this.minTime = time2;
            this.maxTime = time1;
        }else {
            this.minTime = time1;
            this.maxTime = time2;
        }
    }
    
    /* Setters */
    public void setName(String name){
        this.name = name;
    }
    public void setMinTime(LocalTime time){
        this.minTime = time;
    }
    public void setMaxTime(LocalTime time){
        this.maxTime = time;
    }

    public void setType(ClientTypes type) {
        this.type = type;
    }
    
    /* Getters */
    public String getName(){
        return this.name;
    }
    public LocalTime getMaxTime() {
        return maxTime;
    }
    public LocalTime getMinTime() {
        return minTime;
    }
    public ClientTypes getType() {
        return type;
    }
    
    /* toString */

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return "Client{" + "type=" + type + ", name=" + name + ", minTime=" + minTime + ", maxTime=" + maxTime + '}';
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        return name.equals(other.name);
    }
}
