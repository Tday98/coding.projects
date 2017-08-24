/**
 * Created by tristanday on 4/23/17.
 */
public abstract class Boat {
    private int team;
    private Coordinates location;
    private int direction;
    private int health;
    private int strength;
    private int vision;

    public Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
        this.team = team;
        this.location = location;
        this.direction = direction;
        this.health = health;
        this.strength = strength;
        this.vision = vision;
    }

    public int getTeam() {return this.team;}

    public Coordinates getLocation() {return this.location;}

    public int getDirection() {
        return direction;
    }

    public int getHealth() {return this.health;}

    public int getStrength() {return this.strength;}

    public int getVision() {return this.vision;}

    public abstract String getID();

    public abstract String act(int[] n, World w);

    public abstract String getActions();

    public String move(World w) {
        if (w.getAdjacentLocation(location, direction) == null) {
            return getID() + " cannot move off the map.";
        }
        if (w.isLocationOccupied(w.getAdjacentLocation(location, direction))) {
            return getID() + " cannot move to " + w.getAdjacentLocation(location, direction).toString() + " as it is occupied";
        }
        Coordinates temp = location;
        location = w.getAdjacentLocation(location, direction);
        w.setOccupant(null,temp);
        w.setOccupant(this, location);
        return getID() + "moves from " + temp.toString() + " to " + location.toString() + ".";
    }

    public String turn (int n) {
        String str = getID() + " turned ";
        if (n == 1) str += "right, now facing ";
        else str += "left, now facing ";
        direction += n;
        if (direction == -1) direction = 7;
        else if (direction == 8) direction = 0;
        if (direction == 0) str += "N";
        else if (direction == 1) str += "NE";
        else if (direction == 2) str += "E";
        else if (direction == 3) str += "SE";
        else if (direction == 4) str += "S";
        else if (direction == 5) str += "SW";
        else if (direction == 6) str += "W";
        else str += "NW";
        return str;
    }

    public String takeHit(int hit) {
        this.health -= hit;
        if (this.health <= 0) {
            health = 0;
            return getID() + " has been sunk!";
        } else {
            return getID() + " takes " + hit + " damage.";
        }
    }

    public void setLocation(Coordinates c) {
        this.location = c;
    }

    public String toString() {
        return getID();
    }
}
