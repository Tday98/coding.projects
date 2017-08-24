import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tristanday on 4/26/17.
 */
public class Submarine extends ScoutBoat implements Attacker{
    private int numOfTorpedoes;

    public Submarine(int team, Coordinates location, int direction, int numOfTorpedoes) {
        super(team, location, direction, 3, 2);
        this.numOfTorpedoes = numOfTorpedoes;
    }

    public String getID() {
        return String.format("S%d", getTeam());
    }

    public String getActions() {
        String out = "";
        out += "Choose any of the following actions for the Submarine:\n";
        out += "1. Move\n";
        out += "2. Turn left\n";
        out += "3. Turn right\n";
        out += "4. Submerge\n";
        out += (numOfTorpedoes > 0 ? "5. Fire Torpedoes\n": "");
        return out;
    }

    public String act (int [] choice, World w) {
        String out = "";
        for (int i = 0; i < choice.length; i++) {
            if (choice[i] == 1) {
                out += move(w) + "\n";
            } else if (choice[i] == 2) {
                out += turn(-1) + "\n";
            } else if (choice[i] == 3){
                out += turn(1) + "\n";
            } else if (choice[i] == 4) {
                out += submerge(w) + "\n";
            } else {
                out += attack(w) + "\n";
            }
        }
        return out;
    }

    public String attack (World w) {
        Boat o;
        Random r = new Random();
        if (numOfTorpedoes == 0) {
            return getID() + " has no torpedoes remaining.";
        }
        numOfTorpedoes--;
        if (w.isLocationOccupied(w.getAdjacentLocation(getLocation(), getDirection()))) {
            o = w.getOccupant(w.getAdjacentLocation(getLocation(), getDirection()));
            return "Fire Torpedoes!\n" + o.takeHit(r.nextInt(o.getHealth() - 1) + 1);
        } else if (w.isLocationOccupied(w.getAdjacentLocation(w.getAdjacentLocation(getLocation(), getDirection()), getDirection()))) {
            o = w.getOccupant(w.getAdjacentLocation(w.getAdjacentLocation(getLocation(), getDirection()), getDirection()));
            return "Fire Torpedoes!\n" + o.takeHit(r.nextInt(o.getHealth() - 1) + 1);
        } else {
            return "There are no torpedoes remaining";
        }
    }

    public String submerge(World w) {
        int free = 0;
        Coordinates c;
        for (int i = getLocation().getX() - getVision(); i <= getLocation().getX() + getVision(); i++) {
            for (int j = getLocation().getY() - getVision(); j <= getLocation().getY() + getVision(); j++) {
                c = new Coordinates(i,j);
                if (w.isLocationValid(c)) {
                    if (!w.isLocationOccupied(c)) {
                        free++;
                    }
                }
            }
        }
        Random r = new Random();
        free = r.nextInt(free);
        for (int i = getLocation().getX() - getVision(); i <= getLocation().getX() + getVision(); i++) {
            for (int j = getLocation().getY() - getVision(); j <= getLocation().getY() + getVision(); j++) {
                c = new Coordinates(i,j);
                if (w.isLocationValid(c)) {
                    if (!w.isLocationOccupied(c)) {
                        Coordinates temp = getLocation();
                        setLocation(c);
                        w.setOccupant(null, temp);
                        w.setOccupant(this, getLocation());
                        return getID() + " moves from " + temp.toString() + " to " + getLocation().toString() + ".";
                    }
                    free--;
                }
            }
        }
        return "No open locations";
    }
}
