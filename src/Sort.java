import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by tristanday on 4/28/17.
 */
public class Sort {

    public static long bubble(ArrayList<Comparable> E) {
        Comparable temp = 0;
        long time = System.nanoTime();
        for (int i = 0; i < E.size(); i++) {
            for (int j = 1; j < E.size() - i; j++) {
                if (E.get(j-1).compareTo(E.get(j)) == 1) {
                    temp = E.get(j - 1);
                    E.set(j-1, E.get(j));
                    E.set(j, temp);
                }
            }
        }
        return (System.nanoTime() - time);
    }

    public static long selection(ArrayList<Comparable> myList) {
        long time = System.nanoTime();
        Comparable min;
        for (int i = 0; i < myList.size(); i++) {
            int index = i;
            for (int j = i+1; j < myList.size(); j++) {
                min = myList.get(index);
                if (min.compareTo(myList.get(j)) == 1) {
                    index = j;
                }
            }
            min = myList.get(index);
            Comparable oldMin = myList.get(i);
            myList.set(i, min);
            myList.set(index, oldMin);

        }
        return System.nanoTime() - time;
    }

    public static long insertion(ArrayList<Comparable> myList) {
        long time = System.nanoTime();
        Comparable temp;
        for (int i = 1; i < myList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (myList.get(j).compareTo(myList.get(j-1)) == -1) {
                    temp = myList.get(j);
                    myList.set(j, myList.get(j-1));
                    myList.set(j-1, temp);
                }
            }
        }


        return System.nanoTime()- time;
    }

    public static void mergeMerge(ArrayList<Comparable> left, ArrayList<Comparable> right, ArrayList<Comparable> myList) {
        int leftIndex = 0;
        int rightIndex = 0;
        int myIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                myList.set(myIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                myList.set(myIndex, right.get(rightIndex));
                rightIndex++;
            }
            myIndex++;
        }

        ArrayList<Comparable> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            myList.set(myIndex, rest.get(i));
            myIndex++;
        }
    }

    public static ArrayList<Comparable> mergeSort(ArrayList<Comparable> myList) {
        ArrayList<Comparable> lList = new ArrayList<Comparable>();
        ArrayList<Comparable> rList = new ArrayList<Comparable>();

        if (myList.size() == 1) {
            return myList;
        } else {
            for (int i = 0; i < myList.size()/2; i++) {
                lList.add(myList.get(i));
            }
            lList = mergeSort(lList);

            for (int j = myList.size()/2; j < myList.size(); j++) {
                rList.add(myList.get(j));
            }
            rList = mergeSort(rList);

            mergeMerge(lList, rList, myList);
        }
        return myList;
    }
}
