/**
 * Created by tristanday on 3/2/17.
 */
import java.awt.*;
import java.util.Random;
public class CityPlanning {
    int[][] footTraffic;
    Random r = new Random();
    int minRow;
    int maxRow;
    int minCol;
    int maxCol;

    CityPlanning (int length, int width) {
        footTraffic = new int[length][width];
        for (int i = 0; i < footTraffic.length; i++) {
            for (int j = 0; j < footTraffic[i].length; j++) {
                if ((r.nextInt(10) / 10.0) < 0.2) {
                    footTraffic[i][j] = 0;
                } else {
                    footTraffic[i][j] = r.nextInt(100);
                }
            }
        }
    }

    public void printMap () {
        for (int i = 0; i < footTraffic.length; i++) {
            for (int j = 0; j < footTraffic[i].length; j++) {
                if (footTraffic[i][j] < 10) {
                    String formattedNumber = String.format("%02d", footTraffic[i][j]);
                    System.out.print(formattedNumber + " ");
                } else {
                    System.out.print(footTraffic[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    String findBestLocation () {
        String best = "";
        double MAXVALUE = 0;
        for (int i = 0; i < footTraffic.length; i++) {
            for (int j = 0; j < footTraffic[i].length; j++) {
                if (footTraffic[i][j] == 0) {
                    if (MAXVALUE < calculateValue(i, j)) {
                        MAXVALUE = calculateValue(i, j);
                        best = String.format("(%d,%d)",i, j);
                    }
                }
            }
        }
        return best;
    }

    public double calculateValue(int r, int c) {
        double average = 0;
        double counter = 0.0;
        if (r == 0) {
            minRow = 0;
        } else {
            minRow = r - 1;
        }

        if (r > 2) {
            maxRow = r;
        } else {
            maxRow = r + 1;
        }

        if (c == 0) {
            minCol = 0;
        } else {
            minCol = c - 1;
        }

        if (c > 2) {
            maxCol = c;
        } else {
            maxCol = c + 1;
        }

        for (int s = minRow; s < maxRow + 1; s++) {
            for (int d = minCol; d < maxCol + 1; d++) {
                average += footTraffic[s][d];
                counter += 1;
            }
        }
        average = average / (counter - 1);
        return average;
    }

    public static void main (String[] args) {
        int w = 4;
        int l = 4;
        CityPlanning City = new CityPlanning(l,w);

        City.printMap();

        System.out.println(City.findBestLocation());
    }
}
