/**
 * Created by tristanday on 4/26/17.
 */
public class Destroyer extends Boat implements Attacker{

    public Destroyer (int team, Coordinates c, int direction) {
        super(team, c, direction, 2, 2, 1);
    }

    public String getID() {
        return "D" + getTeam();
    }

    public String getActions() {
        String out = "";
        out += "Choose any of the following actions for the Destroyer:\n";
        out += "1. Move\n";
        out += "2. Turn left\n";
        out += "3. Turn right\n";
        out += "4. Attack\n";
        return out;
    }

    public String act(int[] choice, World w) {
        String out = "";
        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 1) {
                out += move(w) + "\n";
            } else if (choice[i] == 2) {
                out += turn(-1) + "\n";
            } else if (choice[i] == 3){
                out += turn(1) + "\n";
            } else {
                out += attack(w) + "\n";
            }
        }
        return out;
    }

    public String attack(World w) {
        Boat o;
        if(w.isLocationOccupied(w.getAdjacentLocation(getLocation(),getDirection()))) {
            o = w.getOccupant(w.getAdjacentLocation(getLocation(),getDirection()));
            return o.takeHit(getStrength());
        }
        return "There are no boats in range currently";
    }

    public String takeHit(int damage) {
        if (Math.random() > 0.5) {
            return super.takeHit(damage);
        }
        return getID() + " avoids the attack!";
    }

}
