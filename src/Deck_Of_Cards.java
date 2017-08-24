/**
 * Created by tristanday on 2/27/17.
 */
import java.util.Random;
public class Deck_Of_Cards {
    int Cards[];
    Random rand = new Random();
    int size;

    Deck_Of_Cards () {
        Cards = new int[52];
        for (int i = 0; i < Cards.length; i++) {
            Cards[i] = i;
        }
        shuffle();
    }

    void shuffle() {
        size = 52;
    }
    public int Draw() {
        int i = rand.nextInt(size);
        int card = Cards[i];

        Cards[i] = Cards[size-1];
        Cards[size-1] = card;
        size--;

        return card;
}

    public int[] drawToHand (int size) {
        int [] hand = new int[size];
        for (int i = 0; i < size; i++)
            hand[i] = Draw();
        return hand;
    }

    public static String cardToSuit(int card) {
        return Character.toString("HSDC".charAt(card / 13));
    }

    public static String cardToValue(int card) {
        return Character.toString("A23456789TJQK".charAt(card % 13));
    }

    static String cardToName(int card) {
        return cardToSuit(card) + cardToValue(card);
    }

    static String handToString(int[] hand) {
        String result = "";
        for (int i = 0; i < hand.length; i++) {
            result += cardToName(hand[i]) + " ";
        }
        return result.substring(0, result.length()-1);
    }

    static boolean isFlush(int[] hand) {
        for (int i = 0; i < hand.length; i++) {
            if (!cardToSuit(hand[0]).equals(cardToSuit(hand[i])))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {

        Deck_Of_Cards Dec = new Deck_Of_Cards();
        for (int i = 0; i < 52; i++) {
            System.out.printf("#3s", cardToName(Dec.Draw()));
        }
        System.out.print("\n");

        Dec.shuffle();


        String [] players = {"North", "East", "South", "West"};

        for (String player : players) {
            int[] hand = Dec.drawToHand(13);
            System.out.printf("#6s: %s\n", player, handToString(hand));
        }

        final int TRIALS = 100000;
        int count = 0;
        for (int i = 0; i < TRIALS; i++) {
            Dec.shuffle();
            int [] hand = Dec.drawToHand(5);
            if (isFlush(hand)) {
                System.out.printf("flush: %s\n", handToString(hand));
                count++;
            }
        }
        System.out.printf("%d of %d hands were flushes: %.2f%%\n", count, TRIALS, (double) count/TRIALS*100);
    }
}
