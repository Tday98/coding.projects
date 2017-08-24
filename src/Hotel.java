/**
 * Created by tristanday on 4/10/17.
 */
public class Hotel {
    public String hotelName;
    public Room[] rooms;
    public int totalRooms;

    public Hotel (String hotelName, int numRooms, int numberFloors) {
        this.totalRooms = numRooms;
        this.hotelName = hotelName;
        rooms = new Room[totalRooms];
        int count = 0;
        for (int i = 1; i <= numberFloors; i++) {
            for (int j = 0; j < (numRooms/numberFloors); j++) {
                    if (j == (numRooms/numberFloors)-1)
                        rooms[count] = new Room((i*100 + j), "suite");
                    else if (j > (numRooms/numberFloors)-6)
                        rooms[count] = new Room((i*100 + j), "single king");
                    else
                        rooms[count] = new Room((i*100 + j), "double queen");
                count++;
            }
        }
    }

    public int getTotalRooms2() {return this.rooms.length;}

    public int getTotalRooms() {return this.totalRooms;}

    public String getRoomNumbers() {
        String out = "Room Numbers\n";
        for (Room r : rooms) {
            out += r.getRoomNumber() + "\n";
        }
        return out;
    }

    public int getNumberOccupied() {
        int count = 0;
        for (int x = 0; x < rooms.length; x++) {
            if (rooms[x].getOccupantName() != null) {
                count++;
            }
        }
        return count;
    }

    public double getOccupancyRate() {
        double value = getNumberOccupied();
        double divider = totalRooms;
        double percent = value/divider;
        percent = Math.round(percent * 100);
        percent = percent / 100;
        return percent;
    }

    public boolean rentRoom(String roomType, String personName, int days) {
        for (Room r : rooms) {
            if (r.getRoomType() == roomType) {
                if(r.setOccupant(personName, days))
                return true;
            }
        }
        return false;
    }

    public void advanceDay() {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i].advanceDay();
        }
    }

    public String toString() {
        String out = "";
        out += String.format("%s: %.0f%% occupied", hotelName, getOccupancyRate()*100);
        return out;
    }

    /*public static void main (String[] args) {
        Hotel TheBestHotel = new Hotel("The Best Hotel", 9, 2);
        System.out.println(TheBestHotel.getNumberOccupied());
        System.out.println(TheBestHotel.getTotalRooms());
        System.out.println(TheBestHotel.getOccupancyRate());
        System.out.println(TheBestHotel.getRoomNumbers());

        TheBestHotel.rentRoom("suite", "Tristan Day", 10);
        TheBestHotel.rentRoom("double queen", "Brooklyn Shumate", 5);
        TheBestHotel.rentRoom("single king", "Dallas Swaggerty", 4);

        System.out.println(TheBestHotel.getNumberOccupied());

        System.out.println(TheBestHotel.getOccupancyRate());

        System.out.println(TheBestHotel.toString());

        System.out.println(TheBestHotel.getTotalRooms2());
    }*/

    public static void main(String[] args) {
        Hotel h = new Hotel("CS Hotel", 72, 9);
        h.rentRoom("double queen", "Robyn", 10);
        h.rentRoom("suite", "Sundeep", 5);
        h.rentRoom("single king", "Sean", 2);
        h.rentRoom("suite", "Eehita", 4);
        h.rentRoom("double queen", "Madeline", 6);
        h.rentRoom("single king", "Ben", 5);
        h.rentRoom("double queen", "Colin", 10);
        h.rentRoom("suite", "Jackie", 1);
        System.out.println(h.getTotalRooms());
        System.out.println(h.getNumberOccupied());
        System.out.println(h.getOccupancyRate());
        System.out.println(h.toString());
        h.advanceDay();
        System.out.println(h.getNumberOccupied());
        System.out.println(h.getOccupancyRate());
        h.advanceDay();
        h.advanceDay();
        h.advanceDay();
        h.advanceDay();
        h.advanceDay();
        h.advanceDay();
        System.out.println(h.getOccupancyRate());
    }
}
