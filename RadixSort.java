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
        int output[] = new int[list.length]; // output array
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < list.length; i++)
            count[(list[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = list.length - 1; i >= 0; i--) {
            output[count[(list[i] / exp) % 10] - 1] = list[i];
            count[(list[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (int i = 0; i < list.length; i++)
            list[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
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
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 3, 6, 5, 6};
        SortAlg radixSort = new RadixSort();

        radixSort.sort(list);
        printArray(list);
    }
}
