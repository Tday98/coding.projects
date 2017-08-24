/**
 * Created by tristanday on 4/23/17.
 */
public class SportsCar extends Automobile {
    public SportsCar(String type, String owner) {
        super(type,owner,2,4);
    }

    public String drive() {
        return "VROOOOOOOOOOOOOOM!";
    }
}