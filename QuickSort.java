/*
Name: Alex Yuk
File: QuickSort Class
Date: 11/5/2019
 */

public class QuickSort extends SortAlg {

    public QuickSort() {
    }

    public void sort(int[] list) {
        sort(list, 0, list.length - 1);
    }

    private int split(int[] list, int min, int max) {
        int pivot = list[max];
        int i = (min - 1);
        for (int j = min; j < max; j++) {
            if (list[j] < pivot) {
                int temp = list[++i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        int temp = list[i + 1];
        list[i + 1] = list[max];
        list[max] = temp;

        return i + 1;
    }

    private void sort(int list[], int min, int max) {
        if (min < max) {
            int index = split(list, min, max);
            sort(list, min, index - 1);
            sort(list, index + 1, max);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 3, 6, 5};
        SortAlg quickSort = new QuickSort();

        quickSort.sort(list);
        printArray(list);
    }
}
