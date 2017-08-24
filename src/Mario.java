import java.util.Scanner;
public class Mario extends GamePiece {
    private Scanner s;

    public Mario(int x, int y, int maxX, int maxY) {
        super('M',x,y,maxX,maxY);
        s = new Scanner(System.in);
    }

    public void move() {
        String direction = s.next();
        char dir = direction.charAt(0);
        switch(dir) {
            case 'w':case 'W':
                if (y > 0) y--;
                break;
            case 'a':case 'A':
                if (x > 0) x--;
                break;
            case 's':case 'S':
                if (y < maxY) y++;
                break;
            case 'd':case 'D':
                if (x < maxX) x++;
                break;
            default:
                break;
        }
    }
}
