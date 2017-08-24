/**
 * Created by tristanday on 3/3/17.
 */
public class CustomerProgram {

    public static void main (String[] args) {

        Customer.count = 19;
        Customer alice = new Customer();
        Customer bob = new Customer();

        alice.name = "Alice";
        bob.name = "Bob";

        System.out.println(alice.name);
        System.out.println(bob.name);


        System.out.println(alice.count);
    }
}
