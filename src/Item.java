/**
 * Created by tristanday on 4/20/17.
 */
public class Item {
    private String name;
    private double listCost;
    private User owner;
    private boolean forSale;

    public Item (String name, double listCost, User owner, boolean forSale) {
        this.name = name;
        this.listCost = listCost;
        this.owner = owner;
        this.forSale = forSale;
    }

    public String getName() {return name;}

    public double getListCost() {return listCost;}

    public User getOwner() {return owner;}

    public boolean getForSale() {return forSale;}

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setListCost(double listCost) {
        this.listCost = ((Math.round(listCost * 100))/100.0);
    }

    public void toggleForSale() {
        if (this.forSale == true) {this.forSale = false;}
            else {this.forSale = true;}
    }

    public void purchaseItem(User buyer, double listCost) {
        buyer.updateBalance(-listCost);
        this.owner.updateBalance(listCost);
        this.setOwner(buyer);
        this.toggleForSale();
    }

    public String toString() {
        return String.format("%s ($%.2f - %s)", this.name, this.listCost, owner.getName());
    }
}
