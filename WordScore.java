import java.util.Scanner;

/** @Tristan Day
 */

public class WordScore {

    int scrabbleScore;
    double graphScore;
    String word;

    /** @param word int to record scrabble word
     */
    WordScore(String word) {
        this.word = word.toLowerCase();
        this.scrabbleScore = getScrabbleScore();
        this.graphScore = getGraphScore();
    }

    /** @param tile char to return value for
     *   @return point value for specific tile
     */
    public int getTileScore(char tile) {
        switch(tile) {
            case 'a':case 'e':case 'i':case 'l':case 'n':case 'o':case 'r':case 's':case 't':case 'u':
                return 1;
            case 'd':case 'g':
                return 2;
            case 'b':case 'c':case 'm':case 'p':
                return 3;
            case 'f':case 'h':case 'v':case 'w':case 'y':
                return 4;
            case 'k':
                return 5;
            case 'j':case 'x':
                return 8;
            case 'q':case 'z':
                return 10;
            default:
                return -1;
        }
    }

    /** @return int word score value as described in project instructions
     */
    public int getScrabbleScore() {
        /** TODO: Defnition for getScrabbleScore
         */
        int total = 0;
        Character x;
        for (int i = 0; i < word.length(); i++) {
            x = word.charAt(i);
            total += getTileScore(x);
        }
        return total;
    }

    /** @return double graph score value as described in project instructions
     */
    public double getGraphScore() {
        /** TODO: Definition for getGraphScore
         */
        double total = 0;
        for (int i = 0; i < word.length()-1; i++) {
            total += Math.abs(word.charAt(i) - word.charAt(i+1));
        }
        return total / (word.length()-1);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        WordScore ws;
        while (read.hasNextLine()) {
            ws = new WordScore(read.nextLine());
            System.out.println(ws.getScrabbleScore() + " " + ws.getGraphScore());
        }
    }
}