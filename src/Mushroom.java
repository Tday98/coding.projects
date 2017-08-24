import java.util.Random;
public class Mushroom extends GamePiece {
    private int turnsLeft;

    public Mushroom(int x, int y, int turnsLeft) {
        super('T',x,y);
        this.turnsLeft = turnsLeft;
    }

    public void setTurnsLeft(int t) {
        turnsLeft = t;
    }

    public void move() {
        if (turnsLeft > 0) {
            turnsLeft--;
        }
        else {
            Random r = new Random();
            x = r.nextInt(maxX);
            y = r.nextInt(maxY);
            turnsLeft = r.nextInt(maxX + maxY);
        }
    }
}