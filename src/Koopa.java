import java.util.Random;
public class Koopa extends GamePiece {
    private boolean moveHorizontal;
    private int velocity;
    private int steps;
    private Random r;

    public Koopa(int x, int y) {
        super('K',x,y);
        r = new Random();
        moveHorizontal = true;
        velocity = -1;
        steps = r.nextInt(3) + 3;
    }

    public void move() {
        if (steps > 0) {
            if (moveHorizontal) {
                x += velocity;
                if (x <= 0) {
                    x = 0;
                    velocity *= -1;
                } else if (x >= maxX) {
                    x = maxX;
                    velocity *= -1;
                }
            } else {
                y += velocity;
                if (y <= 0) {
                    y = 0;
                    velocity *= -1;
                } else if (y >= maxY) {
                    y = maxY;
                    velocity *= -1;
                }
            }
        } else {
            steps = r.nextInt(3) + 3;
            if (r.nextDouble() > 0.5) {
                moveHorizontal = false;
            }
            else {
                moveHorizontal = true;
            }
        }
    }
}