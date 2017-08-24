/**
 * Created by tristanday on 2/25/17.
 */
//import java.util.Scanner;
public class WordList {
    int count;
    String[] words;

    public WordList() {
        count = 0;
        words = new String[2];
    }

    public int findWord(String s) {
        for (int i = 0; i < count; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public int addWord(String s) {
        if (findWord(s) != -1) {
            return count;
        }
        if (words.length == count) {
                String [] newWords = new String[words.length * 2];
                for (int i = 0; i < words.length; i++) {
                    newWords[i] = words[i];
                }
                words = newWords;
        }
        words[count] = s;
        count++;
        return count;
    }

    public void removeWord (String s) {
        if (findWord(s) != -1) {
            for (int i = findWord(s); i < count - 1; i++) {
                words[i] = words[i+1];
            }
            words[count-1] = "";
            count--;
            return;
        } else {
            return;
        }
    }

    public boolean equals(WordList wordlist) {
        if (count != wordlist.count) {
            return false;
        } else {
            for (int i = 0; i < count; i++) {
                if (findWord(words[i]) == -1) {
                    return false;
                }
            }
            return true;
        }
    }

    public String toString() {
        String list = "There are " + count + " words in the word list: \n";
        for (int i = 0; i < count; i++) {
            list += words[i];
            list += "\n";
        }
        return list;
    }

    public static void main (String[] args) {
        WordList wordlist = new WordList();
        /*Scanner s = new Scanner(System.in);
        wordlist.addWord(s.nextLine());
        System.out.println(wordlist.findWord(s.nextLine()));
        wordlist.addWord(s.nextLine());
        System.out.println(wordlist.findWord(s.nextLine()));
        wordlist.addWord(s.nextLine());

        wordlist.removeWord(s.nextLine());

        System.out.println(wordlist.toString());*/

        System.out.println(wordlist.addWord("hello"));

        System.out.println(wordlist.addWord("goodbye"));

        System.out.println(wordlist.toString());

        wordlist.removeWord("goodbye");

        System.out.println(wordlist.toString());

        System.out.println(wordlist.findWord("hello"));

        WordList two = new WordList();

        System.out.println(two.addWord("hello"));

        System.out.println(wordlist.equals(two));



    }
}
