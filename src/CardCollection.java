import java.util.List;
import java.util.ArrayList;

/**
 * Created by tristanday on 4/19/17.
 */
public class CardCollection {
    private String owner;
    private List<Card> myCollection;

    public CardCollection(String owner) {
        this.owner = owner;
        this.myCollection = new ArrayList<Card>(10);
    }

    public boolean addCard(Card c) {
        if (this.myCollection.size() < 1) {
            this.myCollection.add(0,c);
            return true;
        }
        int p = 0;
        while (p < this.myCollection.size()) {
            if (this.myCollection.get(p).compareTo(c) < 0) {
                this.myCollection.add(p,c);
                return true;
            }
            p++;
            if (p == this.myCollection.size()) {
                this.myCollection.add(c);
                return true;
            }
        }
        return false;
    }

    public void removeCard(int i) {
        myCollection.remove(i);
    }

    public int getSize() {
        return myCollection.size();
    }

    public List<Card> mergeCollections(CardCollection cc) {
        List<Card> duplicates = new ArrayList<Card>(10);
        for (int i = 0; i < cc.myCollection.size();) {
            if (!addCard(cc.myCollection.get(i))) {
                duplicates.add(cc.myCollection.get(i));
            }
            cc.myCollection.remove(i);
        }
        return (duplicates);
    }

    public String toString() {
        String out = "";
        int i = 0;
        out += String.format("%2s \n-----\n", this.owner);
        while (i < myCollection.size()){
            out += String.format("%2s \n", this.myCollection.get(i).toString());
            i++;
        }
        return out;
    }

    public static void main(String[] args) {
        int i = 0;
        CardCollection cc = new CardCollection("Tristan");
        Card turing = new Card("Alan Turing","British",1912,1954);
        System.out.println(cc.addCard(turing));
        System.out.println(cc);
    }
}