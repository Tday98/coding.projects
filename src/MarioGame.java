import java.util.ArrayList;
public class MarioGame {
    private ArrayList<GamePiece> gamePieces;
    private int height;
    private int width;
    private int score;

    public MarioGame(int h, int w) {
        gamePieces = new ArrayList();
        gamePieces.add(new Mario(0, 0, w, h));
        gamePieces.add(new Koopa(w, h));
        gamePieces.add(new Mushroom(w / 2, h / 2, 10));
        this.height = h;
        this.width = w;
        this.score = 0;
    }

    public void drawBoard() {
        System.out.println("Score: " + this.score);
        boolean empty = true;
        for (int h = 0; h <= height; h++) {
            for (int w = 0 ; w <= width; w++) {
                empty = true;
                for (GamePiece gp : gamePieces) {
                    if (gp.getX() == w && gp.getY() == h && empty) {
                        System.out.print("-" + gp.getDisplay() + "-");
                        empty = false;
                    }
                }
                if (empty) {
                    System.out.print("~~~");
                }
            }
            System.out.print("\n");
        }
        System.out.print("Select W - up; A - left; S - down; D - right: ");
    }

    public void updatePieces() {
        for(int i = 0; i < gamePieces.size(); i++) {
            gamePieces.get(i).move();
        }
        if (gamePieces.get(0).equals(gamePieces.get(2))) {
            this.score++;
            ((Mushroom)(gamePieces.get(2))).setTurnsLeft(0);
            gamePieces.get(2).move();
        }
    }

    public boolean endGame() {
        return (gamePieces.get(0).equals(gamePieces.get(1)));
    }

    public static void main(String[] args) {
        MarioGame g = new MarioGame(8,8);
        do {
            g.drawBoard();
            g.updatePieces();
        } while (!g.endGame());
        g.drawBoard();
    }
}