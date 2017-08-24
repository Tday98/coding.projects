public class OnlineOrder {

    //TODO: Instance variables
        String orderName;
        double totalCost;
        double tax;
        int numTurkey;
        int numItalian;
        int numVeggie;
        int numBLT;
        public final double TAX_RATE = 0.07;
    //TODO: Class constructor
        public OnlineOrder (String orderName, int numTurkey, int numItalian, int numVeggie, int numBLT) {
            this.orderName = orderName;
            changeOrder(numTurkey,numItalian,numVeggie,numBLT);

        }
        //TODO: changeOrder method
        private void changeOrder(int numTurkey, int numItalian, int numVeggie, int numBLT) {
            if (numTurkey >= 0)
                this.numTurkey = numTurkey;
            else
                this.numTurkey = 0;
            if (numItalian >= 0)
                this.numItalian = numItalian;
            else
                this.numItalian = 0;
            if (numVeggie >= 0)
                this.numVeggie = numVeggie;
            else
                this.numVeggie = 0;
            if (numBLT >= 0)
                this.numBLT = numBLT;
            else
                this.numBLT = 0;

            totalCost = ((this.numTurkey * 4.99) + (this.numItalian * 4.99) + (this.numVeggie * 3.99) + (this.numBLT * 4.99));

            tax = Math.round((getTotalCost()*TAX_RATE)*100);
            tax = tax/100;
        }
        //TODO: getTotalCost accessor method
        public double getTotalCost() {
            return totalCost;
        }
        //TODO: getTax accessor method
        public double getTax() {
            return tax;
        }
        //TODO: toString method
        public String toString() {
            return String.format("%s, your order comes to $%.2f", orderName, getTotalCost()+getTax());
        }

        public static void main(String[] args) {
            //Do not alter this main method at all
            OnlineOrder oo = new OnlineOrder("Spongebob", 3, 2, 0, 0);
            System.out.println(oo.getTotalCost());
            System.out.println(oo.getTax());
            System.out.println(oo.toString());
            oo.changeOrder(1, 5, 2, 1);
            System.out.println(oo.getTotalCost());
            System.out.println(oo.getTax());
            System.out.println(oo.toString());
            oo.changeOrder(-1, -5, 0, 2);
            System.out.println(oo.getTotalCost());
            System.out.println(oo.getTax());
            System.out.println(oo.toString());
            OnlineOrder order = new OnlineOrder("Sarah",0,0,1,1);
            System.out.println(order.toString());
            System.out.println(order.getTax());
        }

    }