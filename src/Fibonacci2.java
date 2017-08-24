/**
 * Created by tristanday on 4/15/17.
 */
import java.util.Iterator;
public class Fibonacci2 implements Iterator {
    private int n;
    private int i;
    private int f1, f2;
    public Fibonacci2(int n) {
        this.n = n;
        f1 = 1;
        f2 = 1;
    }

    public boolean hasNext() { return i < n;}

    public Integer next() {
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

    public static void main (String[] args) {
        Iterator i = new Fibonacci2(25);
        while(i.hasNext())
            System.out.printf("%d ", i.next());
        System.out.printf("\n");
    }
}
