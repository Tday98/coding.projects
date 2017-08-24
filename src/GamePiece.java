public abstract class GamePiece {

    private char display;
    public static int maxX;
    public static int maxY;
    protected int x;
    protected int y;

    public GamePiece(char d, int x, int y, int maxX, int maxY) {
        this.display = d;
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public GamePiece(char d, int x, int y) {
        this.display = d;
        this.x = x;
        this.y = y;
    }

    public int getX()   {return x;}

    public int getY()   {return y;}

    public char getDisplay() {return display;}

    public abstract void move();

    public boolean equals(GamePiece other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
}
