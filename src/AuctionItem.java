/**
 * Created by tristanday on 4/20/17.
 */
public class AuctionItem extends Item{
    private int daysLeft;
    private double currentBid;
    private User highBidder;

    public AuctionItem(String name, double listCost, User owner, int daysLeft) {
        super(name, listCost, owner, true);
        this.daysLeft = daysLeft;
        this.currentBid = listCost;
        this.highBidder = null;
    }

    public int getDaysLeft() {return this.daysLeft;}

    public double getCurrentBid() {return this.currentBid;}

    public void advanceDay() {
        if (this.getForSale() && getDaysLeft() < 0) {
            this.getOwner().updateBalance(this.currentBid);
            this.highBidder.updateBalance(this.currentBid);
            this.setOwner(highBidder);
            resetAuction(this.currentBid,this.daysLeft);
        } else {
            this.daysLeft--;
        }
    }

    public String makeBid(User b, double bid) {
        if (getForSale() == true && bid > this.currentBid) {
            this.currentBid = bid;
            this.highBidder = b;
            return b.getName();
        }
        return this.highBidder.getName();
    }

    public void resetAuction(double startBid, int numDaysLeft) {
        if (this.highBidder == null) {
            this.daysLeft = numDaysLeft;
            this.currentBid = startBid;
        }
    }

    public String toString() {
        String user;
        if (getOwner() == null) user = "None";
        else user = getOwner().getName();
        return String.format("%s ($%.2f, %s, %d days left)", getName(), getCurrentBid(), user, getDaysLeft());
        }
}
