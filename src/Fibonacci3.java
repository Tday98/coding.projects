/**
 * Created by tristanday on 4/15/17.
 */
import java.util.Iterator;

public class Fibonacci3 implements Iterator, Iterable {
    private int n;
    private int i;
    private int f1, f2;

    public Fibonacci3(int n) {
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

    public Iterator iterator() {return this;}

    public static void main (String[] args) {
        Iterator i = new Fibonacci3(25);
        while(i.hasNext())
            System.out.printf("%d ", i.next());
        System.out.printf("\n");

        Iterable i2 = new Fibonacci3(30);
        for (Object i1 : i2)
            System.out.printf("%d ", (Integer) i1);
        System.out.print("\n");
    }
}
