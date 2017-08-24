public class Register {
    public double getTotal (Priceable[] cart) {
        double total = 0.0;
        for (int i = 0; i < cart.length; i++) {
            total += cart[i].getPrice();
        }
        return total;
    }

    public static void main(String[] args) {
        Priceable[] mycart = new Priceable[3];
        mycart[0] = new Bananas(5);
        mycart[1] = new Eggs(1, false);
        mycart[2] = new Water(4);

        Register r = new Register();
        System.out.println(r.getTotal(mycart));
    }
}