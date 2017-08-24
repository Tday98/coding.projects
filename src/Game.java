import java.util.Scanner;
public class Game
{
    public static void main(String[] args) {
        World ocean = new World(10,10);
        // declare one set of Boats for each team
        Boat[] teamOne = new Boat[5];
        Boat[] teamTwo = new Boat[5];
        setTeam(teamOne, ocean, 1);
        setTeam(teamTwo, ocean, 2);
        System.out.println(ocean.drawTeamMap(teamOne,1));
        // begin game loop
        while (takeTurn(teamOne, ocean) && takeTurn(teamTwo, ocean));
        System.out.println("GAME OVER!");
    }
    public static int getRandomDirection() {return (int) (Math.random() * 8);}
    public static Coordinates getRandomCoordinates(World w) {
        int xPos, yPos;
        do {
            xPos = (int)(Math.random() * w.getWidth());
            yPos = (int)(Math.random() * w.getHeight());
        } while (w.isLocationOccupied(new Coordinates(xPos, yPos)));
        return new Coordinates(xPos, yPos);
    }
    public static void setTeam(Boat[] b, World w, int t) {
        b[0] = new Submarine(t,
                getRandomCoordinates(w),getRandomDirection(),(int)(Math.random()*5));
        w.setOccupant(b[0],b[0].getLocation());
        b[1] = new Cruiser(t, getRandomCoordinates(w),getRandomDirection());
        w.setOccupant(b[1],b[1].getLocation());
        b[2] = new AircraftCarrier(t, getRandomCoordinates(w),getRandomDirection());
        w.setOccupant(b[2],b[2].getLocation());
        b[3] = new Destroyer(t, getRandomCoordinates(w),getRandomDirection());
        w.setOccupant(b[3],b[3].getLocation());
        b[4] = new Battleship(t, getRandomCoordinates(w),getRandomDirection());
        w.setOccupant(b[4],b[4].getLocation());
    }
    public static boolean takeTurn(Boat[] b, World w) {
        Scanner s = new Scanner(System.in);
        int n = 0;
        int[] choices = new int[2];
        // if all Boats on this team are defeated, return false
        while (n < b.length && b[n].getHealth() <= 0) n++;
        if (n == b.length) return false;
        while (n < b.length) {
            // ask if the user wants to see the map or move a Boat
            if (b[n].getHealth() > 0) {
                System.out.println("1. View map\n2. Take action with " + b[n] + "\n");
                choices[0] = s.nextInt();
                // if see the map, give the map display choices
                if (choices[0] == 1) {
                    System.out.println("1. Direction\n2. Health\n");
                    choices[0] = s.nextInt();
                    System.out.println(w.drawTeamMap(b,choices[0]+1));
                }
                // if move a boat, give the next Boat a turn
                else {
                    // perform Boat action
                    System.out.println(b[n].getActions());
                    choices[0] = s.nextInt();
                    if (b[n] instanceof Cruiser || b[n] instanceof Destroyer) {
                        choices[1] = s.nextInt();
                    }
                    System.out.println(b[n].act(choices,w));
// advance Boat counter
                    n++;
                }
            }
            else
                n++;
        }
        System.out.println(w.drawTeamMap(b,1));
        return true;
    }
}