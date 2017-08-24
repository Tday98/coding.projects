/**
 * Created by tristanday on 4/23/17.
 */
public class Vehicle implements Driveable{
    protected String type;
    protected int passengers;
    protected String owner;

    public Vehicle (String type, int passengers, String owner) {
        this.type = type;
        if (passengers < 0) this.passengers = 0;
        else                this.passengers = passengers;
        this.owner = owner;
    }

    public String drive() {
        return "Vroom!";
    }

    public String toString() {
        return String.format("%s's %s can hold %d passengers", owner, type, passengers);
    }
}
