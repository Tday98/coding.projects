import java.lang.Comparable;

/**
 * Created by tristanday on 4/18/17.
 */
public class Card implements Comparable<Card>{
     private String name;
     private String nationality;
     private int yearBorn;
     private int yearDied;

     public Card (String name, String nationality, int yearBorn, int yearDied) {
         this.name = name;
         this.nationality = nationality;
         this.yearBorn = yearBorn;
         this.yearDied = yearDied;
     }

    public int compareTo (Card c) {
         if (this.equals(c)) {
             return 0;
         } else if (this.name.charAt(0) > c.name.charAt(0)) {
            return -1;
         } else {
             return 1;
         }
    }

    public String toString() {
         String out = "";
         out += String.format("%s (%d-%d) - %s", this.name, this.yearBorn, this.yearDied, this.nationality);
         return out;
    }

    public static void main (String[] args) {
        Card shannon = new Card("Claude Shannon","American",1916,2001);
        Card brin = new Card("Sergey Brin","Russian",1973,-1);
        System.out.println(shannon.toString());
        System.out.println(brin.compareTo(shannon));
    }
}