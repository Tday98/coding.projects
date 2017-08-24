import java.util.Random;

/**
 * Created by tristanday on 4/26/17.
 */
public abstract class ScoutBoat extends Boat{

    public ScoutBoat (int team, Coordinates location, int direction, int health, int vision) {
        super(team, location, direction, health, 1, vision);
    }

    public String takeHit(int attack) {
        Random r = new Random();
        if (r.nextInt(101) > 25) {
            return super.takeHit(attack);
        }
        return getID() + " has avoided the attack.";
    }
}
