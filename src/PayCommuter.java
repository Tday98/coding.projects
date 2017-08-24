/**
 * Created by tristanday on 4/23/17.
 */
public class PayCommuter extends Commuter {
    private final double FARE;
    private boolean paid;

    public PayCommuter(String name, double FARE) {
        super(name);
        this.FARE = FARE;
        this.paid = false;
    }

    public boolean getPaid(){ return this.paid;}

    public double getFARE(){ return this.FARE;}

    public void payFARE(double FARE) {
        if (FARE > getFARE()) {
            this.paid = true;
        } else {
            this.paid = false;
        }
    }

    public void addMiles (int n, double f) {
        if (this.paid == true) {
            super.addMiles(n);
            this.paid = false;
        }
    }

    public String toString() {
        return super.toString() + String.format("Single Ride: %.2f", this.FARE);
    }
}