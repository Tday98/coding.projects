/**
 * Created by tristanday on 4/12/17.
 */
public class Factorial {

    public static long factorial (long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main (String[] args) {
        /*for (int i = 0; i <= 10; i++) {
            System.out.printf("%3d! = %d\n", i, factorial(i));
        }*/
        int x = 5;
        System.out.printf("%3d! = %d\n", x, factorial(x));
    }
}
