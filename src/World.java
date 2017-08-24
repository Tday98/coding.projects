/**
 * Created by tristanday on 4/24/17.
 */
public class World {

    private Boat[][] map;

    public static final int NORTH = 0;
    public static final int NORTHEAST = 1;
    public static final int EAST = 2;
    public static final int SOUTHEAST = 3;
    public static final int SOUTH = 4;
    public static final int SOUTHWEST = 5;
    public static final int WEST = 6;
    public static final int NORTHWEST = 7;

    public World (int width, int height) {
        if (width < 4) width = 4;
        else if (width > 10) width = 10;
        else width = width;
        if (height < 4) height = 4;
        else if (height > 10) height = 10;
        else height = height;

        this.map = new Boat[width][height];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = null;
            }
        }
    }

    public int getWidth() {return map.length;}

    public int getHeight() {return map[0].length;}

    public Boat getOccupant(Coordinates c) {return map[c.getX()][c.getY()];}

    public boolean isLocationValid (Coordinates c) {
        if (c.getX() >= 0 && c.getX() < getWidth() && c.getY() >= 0 && c.getY() < getHeight()) {
            return true;
        }
        return false;
    }

    public boolean isLocationOccupied (Coordinates c) {
        if (map[c.getX()][c.getY()] == null) return false;
        return true;
    }

    public boolean setOccupant (Boat o, Coordinates c) {
        if (isLocationValid(c) && !isLocationOccupied(c)) {
            map[c.getX()][c.getY()] = o;
            return true;
        }
        return false;
    }

    public Coordinates getAdjacentLocation (Coordinates c, int n) {
        int x = c.getX();
        int y = c.getY();
        if (n == NORTH) {
            y--;
        } else if (n == NORTHEAST) {
            y--;
            x++;
        } else if (n == EAST) {
            x++;
        } else if (n == SOUTHEAST) {
            y++;
            x++;
        } else if (n == SOUTH) {
            y++;
        } else if (n == SOUTHWEST) {
            y++;
            x--;
        } else if (n == WEST) {
            x--;
        } else {
            y--;
            x--;
        }
        Coordinates c2 = new Coordinates(x,y);
        if (isLocationValid(c2)) {
            return c2;
        }
        return null;
    }

    public String drawTeamMap(Boat[] teamBoats, int view) {
        String[][] chart = new String[map.length][map[0].length];
        int i, j, k;
        for (i = 0; i < chart.length; i++) {
            for (j = 0; j < chart[0].length; j++) {
                chart[i][j] = "###";
            }
        }

        if (view == 2 || view == 3) {
            for (i = 0; i < teamBoats.length; i++) {
                int x = teamBoats[i].getLocation().getX();
                int y = teamBoats[i].getLocation().getY();
                int vis = teamBoats[i].getVision();
                for (k = y - vis; k <= y + vis; k++) {
                    for (j = x - vis; j <= x + vis; j++) {
                        Coordinates c = new Coordinates(j, k);
                        if (isLocationValid(c)) {
                            if (!isLocationOccupied(c)) {
                                chart[k][j] = "~~~";
                            } else if (view == 2) {
                                Boat b = (Boat) getOccupant(c);
                                chart[k][j] = b.getDirection() + b.toString();
                            } else if (view == 3) {
                                Boat b = (Boat) getOccupant(c);
                                chart[k][j] = b.getHealth() + b.toString();
                            }
                        }
                    }
                }
            }
        }

        String str = "@";
        for (i = 1; i <= map.length; i++) {
            str += " " + i + " ";
        }
        str += "\n";

        for (i = 0; i < map.length; i++) {
            str += (char)(i + 65) + " ";
            for (j = 0; j < map[i].length; j++) {
                str += chart[i][j];
            }
            str += "\n";
        }
        return str;
    }

    private char getChar(int dir) {
        char c;
        switch (dir) {
            case 0:
                c = '\u2191';
                break;
            case 1:
                c = '\u2197';
                break;
            case 2:
                c = '\u2192';
                break;
            case 3:
                c = '\u2198';
                break;
            case 4:
                c = '\u2193';
                break;
            case 5:
                c = '\u2199';
                break;
            case 6:
                c = '\u2190';
                break;
            default:
                c = '\u2196';
                break;
        }
        return c;
    }
}
