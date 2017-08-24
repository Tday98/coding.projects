import java.util.ArrayList;
import java.util.Random;
public class Analysis extends Sort{
    public static void main(String[] args) {
        ArrayList<Comparable> myData = randomData(10,20);
        printData(myData);
        System.out.println(insertion(myData));
        printData(myData);
    }
    public static ArrayList<Comparable> randomData(int size, int maxValue) {
        ArrayList<Comparable> myList = new ArrayList<Comparable>();
        Random r = new Random();
        for (int x = 0; x < size; x++) {
            myList.add(r.nextInt() % maxValue);
        }
        return myList;
    }
    public static void printData(ArrayList<Comparable> myList) {
        System.out.print("[");
        for (Object o : myList) {
            System.out.print(o + " ");
        }
        System.out.println("]");
    }


}