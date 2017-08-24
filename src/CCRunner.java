/**
 * Created by tristanday on 4/19/17.
 */
import java.util.ArrayList;
import java.util.List;
    public class CCRunner {
        public static void main(String[] args) {
            CardCollection c1 = new CardCollection("Alan");
            CardCollection c2 = new CardCollection("Grace");
            Card turing = new Card("Alan Turing","British",1912,1954);
            Card hopper = new Card("Grace Hopper","American",1906,1992);
            Card vonneumann = new Card("John Von Neumann","Hungarian",1903,1957);
            Card shannon = new Card("Claude Shannon","American",1916,2001);
            Card johnson = new Card("Katherine Johnson","American",1918,-1);
            Card lovelace = new Card("Ada Lovelace","British",1815,1852);
            Card cerf = new Card("Vint Cerf","American",1943,-1);
            Card brin = new Card("Sergey Brin","Russian",1973,-1);
            c1.addCard(turing);
            c1.addCard(vonneumann);
            c1.addCard(shannon);
            c1.addCard(johnson);
            c1.addCard(cerf);
            c1.addCard(brin);
            c2.addCard(cerf);
            c2.addCard(lovelace);
            c2.addCard(johnson);
            c2.addCard(vonneumann);
            c2.addCard(hopper);
            System.out.println(c1);
            System.out.println(c2);
            List<Card> dupes = c1.mergeCollections(c2);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println("Duplicates:\n-----------");
            for (Card c : dupes) {
                System.out.println(c);
            }
        }
    }
