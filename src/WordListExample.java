/**
 * Created by tristanday on 2/15/17.
 */
public class WordListExample {

    final int MAX_LENGTH = 50;
    int[] computeHistogram (String[] words) {
        int[] a = new int[MAX_LENGTH];

        for (int i = 0; i < words.length; i ++) {
            String w = words[i];
            int n = w.length();
            a[n]++;
        }
        return a;
    }

    void printHistogram (int[] lg) {
        for (int i = 0; i < lg.length; i++) {
            if (lg[i] != 0) {
                System.out.printf("number of words of length %d is %d\n", i, lg[i]);
            }
        }
    }

    public static void main (String[] args) {

        WordListExample wl = new WordListExample();
        wl.printHistogram(wl.computeHistogram(args));

    }
}
