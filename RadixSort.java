/*
Name: Alex Yuk
File: RadixSortClass
Date: 11/5/2019
 */

import java.util.Arrays;

public class RadixSort extends SortAlg {

    public RadixSort() {
    }

    private void countSort(int list[], int exp) {
        int finalArray[] = new int[list.length];
        int count[] = new int[10];

        // Number of occurrences in count array
        for (int i = 0; i < list.length; i++)
            count[(list[i] / exp) % 10]++;

        // Set count[i] to real position used in finalArray
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the final array
        for (int i = list.length - 1; i >= 0; i--) {
            finalArray[count[(list[i] / exp) % 10] - 1] = list[i];
            // Increment count by -1
            count[(list[i] / exp) % 10]--;
        }

        // Copies finalArray into list
        for (int i = 0; i < list.length; i++)
            list[i] = finalArray[i];
    }

    // Radix Sort
    public void sort(int list[]) {
        int max = list[0];
        for (int i = 1; i < list.length; i++)
            if (list[i] > max)
                max = list[i];

        for (int i = 1; max / i > 0; i *= 10)
            countSort(list, i);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++)
            if(i != arr.length - 1)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] list = {2, 4, 3, 6, 5, 6};
        SortAlg radixSort = new RadixSort();

        radixSort.sort(list);
        printArray(list);
    }
}
