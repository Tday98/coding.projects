/**
 * Created by tristanday on 4/15/17.
 */
public class Fibonacci1 {

    private int n;
    private int i = 0;
    private int f1;
    private int f2;

    public Fibonacci1(int n) {
        this.n = n;
        f1 = 1;
        f2 = 1;
    }

    public boolean hasNext() {
        return (i < n);
    }

    public int next() {
        if (i == 0 || i == 1) {
            i++;
            return 1;
        }

        if (f2 >= f1) {
            f1 = f1 + f2;
            i++;
            return f1;
        } else {
            f2 = f1 + f2;
            i++;
            return f2;
        }
    }

    public static void main(String[] args) {
        Fibonacci1 f = new Fibonacci1(25);
        while (f.hasNext())
            System.out.printf("%d ", f.next());
        System.out.print("\n");
    }
}
