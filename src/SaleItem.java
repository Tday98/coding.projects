/**
 * Created by tristanday on 4/21/17.
 */
public class SaleItem extends Item {
    private double discount;

    public SaleItem(String name, double listCost, User owner, double discount) {
        super(name,listCost,owner, true);
        this.discount = discount;
    }

    public String getDiscount() {return String.format("%d%%", Math.round(this.discount*100));}

    public void purchaseItem(User buyer) {
        super.purchaseItem(buyer, getListCost()* (1 - discount));
    }
}
