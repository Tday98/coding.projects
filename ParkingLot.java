/**
 * Created by tristanday on 3/24/17.
 */
public class ParkingLot {
    ParkingSpace[] parkingLot;
    int numSpaces;
    int numFloors;

    ParkingLot(int numSpaces, int numFloors) {
        this.parkingLot = new ParkingSpace[numSpaces*numFloors];
        int i = 0;
        for (int x = 0; x < numFloors; x++) {
            for (int j = 0; j < numSpaces; j++) {
                if (j < 4) {
                    parkingLot[i] = new ParkingSpace(j, (char)(x+65), true);
                } else {
                    parkingLot[i] = new ParkingSpace(j, (char)(x+65), false);
                }
                i++;
            }
        }
    }

    public ParkingSpace enterLot(boolean c) {
        for (int i = 0; i < parkingLot.length; i++) {
            if (c == true) {
                if (!parkingLot[i].getOccupied()) {
                    parkingLot[i].setOccupied(true);
                    return parkingLot[i];
                }
            } else {
                if (!parkingLot[i].getOccupied()) {
                    if (parkingLot[i].getCompact() != true) {
                        parkingLot[i].setOccupied(true);
                        return parkingLot[i];
                    }
                }
            }
        }
        return null;
    }

    public void leaveLot (ParkingSpace ps) {
        parkingLot[(ps.getFloor() - 65) + ps.getFloor()].setOccupied(false);
    }

    public static void main (String[] args) {
        ParkingLot ps = new ParkingLot(20, 20);

    }
}
