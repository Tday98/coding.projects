import java.util.ArrayList;

/**
 * Created by tristanday on 4/26/17.
 */
public class AircraftCarrier extends Boat implements Attacker {
    private boolean hasPlanes;

    public AircraftCarrier(int team, Coordinates location, int direction) {
        super(team, location, direction, 5, 1, 1);
    }

    public String getID() {
        return String.format("A%d", getTeam());
    }

    public String getActions() {
        String out = "";
        out += "Choose any of the following actions for the Aircraft Carrier:\n";
        out += "1. Move\n";
        out += "2. Turn left\n";
        out += "3. Turn right\n";
        out += (hasPlanes ? "4. Launch Planes\n": "");
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
        if (!hasPlanes) {
            return getID() + " has no planes remaining.";
        }
        ArrayList<Boat> b = new ArrayList<Boat>();
        Coordinates c;
        String results = "";
        for (int i = getLocation().getX() - getVision(); i <= getLocation().getX() + getVision(); i++) {
            for (int j = getLocation().getY() - getVision(); j <= getLocation().getY() + getVision(); j++) {
                c = new Coordinates(i,j);
                if (w.isLocationOccupied(c)) {
                    b.add(w.getOccupant(c));
                }
            }
        }
        if (b.size() == 0) {
            return "There are no boats in range currently.";
        }
        while (hasPlanes && b.size() > 0) {
            results += "Air raid!" + b.get(0).takeHit(getStrength()) + "\n";
            b.remove(0);
            if (Math.random() > 0.8) hasPlanes = false;
        }
        if (!hasPlanes) {
            return results + "\nThe planes have been destroyed.";
        }
        return results;
    }
}
