/**
 * Created by tristanday on 4/23/17.
 */
public class Automobile extends Vehicle {
    private int numOfWheels;

    public Automobile(String type, String owner, int passengers, int numOfWheels) {
        super(type, passengers, owner);
        this.numOfWheels = (numOfWheels < 3)?3:numOfWheels;
    }

    public String honkHorn() {
        return "Beep!";
    }

    public String toString() {
        return super.toString() + String.format(" and has %d wheels",numOfWheels);
    }
}
