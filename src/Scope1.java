/**
 * Created by tristanday on 3/13/17.
 */
public class Scope1 {
    int x;

    void one (int x) { // OK: Hides the field

        this.x = x;

        //int x;   // cannot have in same scope as parameter
    }

    void two() {
        int x = 10; // OK: hides field x;

        this.x = x;

        while (true) {
           //int x; // cannot have in same scope as other local variable
        }
    }

    public static void main (String[] args) {
        {
            int x = 12;
        }

        {
            int x = 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}
