/**
 * Created by tristanday on 4/26/17.
 */
public class Battleship extends Boat implements Attacker {

    public Battleship(int team, Coordinates location, int direction) {
        super(team, location, direction, 4, 3, 1);
    }

    public String getID() {
        return String.format("B%d", getTeam());
    }

    public String getActions() {
        String out = "";
        out += "Choose any of the following actions for the Battleship:\n";
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
            return "Fire cannons!" + o.takeHit(getStrength()) + "\n" + o.takeHit(getStrength());
        }
        return "There are no boats in range currently";
    }
}
