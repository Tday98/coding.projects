public class BubbleSort {

    public static int[] sort(int[] list) {
        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j-1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = {5, 4, 7, 1, 8, 3, 3, 5};
        int[] sorted = BubbleSort.sort(list);
        for (int j = 0; j < sorted.length; j++) {
            System.out.println(sorted[j]);
        }
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] < sorted[i - 1]) {
                System.out.println("Not sorted.");
                return;
            }
        }
        System.out.println("Sorted!");
    }
}