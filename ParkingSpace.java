/**
 * Created by tristanday on 3/24/17.
 */
public class ParkingSpace {
    int spaceNum;
    char floor;
    boolean isCompact;
    boolean isOccupied;

    public ParkingSpace (int spaceNum, char floor, boolean isCompact) {
        this.spaceNum = spaceNum;
        this.floor = floor;
        this.isCompact = isCompact;
        isOccupied = false;
    }

    public int getSpaceNum() {
        return spaceNum;
    }

    public char getFloor() {
        return floor;
    }

    public boolean getCompact() {
        return isCompact;
    }

    public boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean set) {
        isOccupied = set;
    }

    public String toString() {
        char com;
        char occ;

        if (isOccupied == true)
            occ = 'X';
        else
            occ = 'O';
        if (isCompact == true)
            com = 'C';
        else
            com = 'N';

        return floor + "" + spaceNum + " " + "(" + com + " " + occ + ")";
    }

    /*public static void main(String[] args) {
        ParkingSpace S = new ParkingSpace(1, 'A', true);
        System.out.println(S.toString());
    }*/
}
