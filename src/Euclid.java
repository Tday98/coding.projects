/**
 * Created by tristanday on 4/12/17.
 */
public class Euclid {

    public static int gcd (int a, int b) {
        if (a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    public static double geometric (int n) {
        if (n == 0) {
            return 1;
        }
            return 1.0 / Math.pow(2.0, n) + geometric(n-1);
    }

    public static double basel (int n) {
        if (n == 1) {
            return 1;
        }
        return 1.0 / Math.pow(n, 2.0) + basel(n-1);
    }

    public static String scrambler (String s) {
        if (s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            return s.substring(1) + s.substring(0,1);
        } else {
            return s.substring(s.length()-1) + scrambler(s.substring(1, s.length()/2)) + scrambler(s.substring(s.length()/2, s.length()-1)) + s.substring(0,1);
        }
    }

    public static void main (String[] args) {
        System.out.println(gcd(100,80));
        System.out.println(geometric(4));
        System.out.println(basel(10));
        System.out.println(scrambler("computers"));
        System.out.println(scrambler("spmorteuc"));
    }
}
