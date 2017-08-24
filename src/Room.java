/**
 * Created by tristanday on 4/10/17.
 */
public class Room {
    private int roomNumber;
    private int daysRented;
    private String roomType;
    private String occupantName;

    public Room (int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.daysRented = 0;
        if (roomType.equals("single king") || roomType.equals("double queen") || roomType.equals("suite")) {
            this.roomType = roomType;
        } else {
            this.roomType = "double queen";
        }
        this.occupantName = null;
    }

    public int getRoomNumber() {return roomNumber;}

    public int getDaysRented() {return daysRented;}

    public String getRoomType() {return roomType;}

    public String getOccupantName() {return occupantName;}

    public boolean setOccupant(String name, int days) {
        if (this.occupantName == null) {
            this.occupantName = name;
            this.daysRented = days;
            return true;
        }
        return false;
    }

    public void advanceDay() {
        if (this.daysRented > 1) {
            this.daysRented--;
        } else {
            this.occupantName = null;
            this.daysRented = 0;
        }
    }

    public String toString() {
        if (this.daysRented > 0)
            return "Room " + roomNumber + ": " + roomType + " - " + "rented";
        else
            return "Room " + roomNumber + ": " + roomType + " - " + "free";
    }

    /*public static void main (String[] args) {
        Room r = new Room(3, "single king");

        System.out.println(r.getDaysRented());
        System.out.println(r.getOccupantName());
        System.out.println(r.getRoomNumber());
        System.out.println(r.getRoomType());

        System.out.println(r.setOccupant("Tristan Day", 5));
        System.out.println(r.getOccupantName());
        System.out.println(r.getDaysRented());

        System.out.println(r.toString());

        r.advanceDay();

        System.out.println(r.getDaysRented());
    }*/

}
