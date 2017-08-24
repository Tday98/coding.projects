/**
 * Created by tristanday on 3/2/17.
 */
public class BloodBank {

    double[][] donations;

    public BloodBank(double[][] donationData) {
        donations = donationData;
    }

    public int findTopDonor() {
        double max = 0.0;
        int counter = 0;
        int maxCounter = 0;
        for (int i = 0; i < donations.length; i++) {
            for (int j = 0; j < donations[i].length; j++) {
                counter++;
                if (donations[i][j] > max) {
                    max = donations[i][j];
                    maxCounter = counter;
                }
            }
        }
        return maxCounter;
    }

    public int findTopState() {
        int maxState = 0;
        double maxDonation = 0.0;
        int counter = 0;

        for (int i = 0; i < donations.length; i++) {
            int sum = 0;
            for (int j = 0; j < donations[i].length; j++) {
                sum += donations[i][j];
            }
            if (sum > maxDonation) {
                maxDonation = sum;
                maxState = counter;
            }
            counter++;
        }
        return maxState;
    }

    public void makeDonation(double amt, int row, int col) {
        donations[row][col] = amt;
    }
}