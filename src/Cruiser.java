/**
 * Created by tristanday on 4/26/17.
 */
public class Cruiser extends ScoutBoat {

    public Cruiser (int team, Coordinates location, int direction) {
        super(team, location, direction, 3, 3);
    }

    public String getID() {
        return String.format("C%d", getTeam());
    }

    public String getActions() {
        String out = "";
        out += "Choose any of the following actions for the Cruiser:\n";
        out += "1. Move\n";
        out += "2. Turn left\n";
        out += "3. Turn right\n";
        return out;
    }

    public String act (int[] choice, World w) {
        String out = "";
        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 1) {
                out += move(w) + "\n";
            } else if (choice[i] == 2) {
                out += turn(-1) + "\n";
            } else {
                out += turn(1) + "\n";
            }
        }
        return out;
    }
}
