/**
 * Created by tristanday on 4/23/17.
 */
public class BusCommuter extends PayCommuter{
    private String name;
    private final double MONTHLY_RATE;
    private boolean busPass;

    public BusCommuter(String name, double FARE, double MONTHLY_RATE) {
        super(name, FARE);
        this.MONTHLY_RATE = MONTHLY_RATE;
        this.busPass = false;
    }

    public void buyBusPass(double rate) {
        if (rate > MONTHLY_RATE) {
            this.busPass = true;
        }
    }

    public void addMiles(int n) {
        if (super.getPaid() == true || this.busPass == true) {
            super.addMiles(n);
        }
    }

    public String toString() {
        return super.toString() + String.format(" Monthly pass: %.2f", this.MONTHLY_RATE);
    }
}
