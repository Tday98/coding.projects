/**
 * Created by tristanday on 4/20/17.
 */
public class User {
    private String name;
    private double accountBalance;

    public User (String name) {
        this.name = name;
        this.accountBalance = 0;
    }

    public String getName() {return this.name;}

    public double getAccountBalance() {return this.accountBalance;}

    public double updateBalance(double cost) {
        this.accountBalance += cost;
        return this.accountBalance;
    }

    public String toString() {
        return String.format("%s's balance is $%.2f", this.name, this.accountBalance);
    }
}
