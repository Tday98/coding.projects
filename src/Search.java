import java.util.ArrayList;

/**
 * Created by tristanday on 4/29/17.
 */
public class Search {

    public static int linear(ArrayList<Comparable> myList, Comparable key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).compareTo(key) == 0) {
                return 1;
            }
        }
        return -1;
    }

    public static int binary(ArrayList<Comparable> myList, Comparable key, int first, int last) {
        first = 0;
        last = myList.size() -1;
        Comparable mid;
        int middle;

        while (first <= last) {
            middle = (first + last) / 2;
            mid = myList.get(middle);
            if (mid.compareTo(key) == 0) {
                return 1;
            } else if (key.compareTo(mid) == -1) {
                last = middle - 1;
            } else {
                last = middle + 1;
            }
        }
        return -1;
    }
}
